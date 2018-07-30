package twitter4jads.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.TwitterAdsClient;
import twitter4jads.api.TwitterAdsMediaUploadApi;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.http.HttpResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.internal.models4j.TwitterInvalidParameterException;
import twitter4jads.internal.models4j.TwitterRuntimeException;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.ads.cards.TwitterVideoErrors;
import twitter4jads.models.media.TwitterLibraryMedia;
import twitter4jads.models.media.TwitterMediaType;
import twitter4jads.models.video.TwitterVideo;
import twitter4jads.models.video.UploadMediaObjectResponse;
import twitter4jads.util.TwitterAdUtil;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static twitter4jads.TwitterAdsConstants.*;
import static twitter4jads.internal.models4j.TwitterImpl.PARAM_ADDITIONAL_OWNERS;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:41 AM
 */
public class TwitterAdsMediaUploadApiImpl implements TwitterAdsMediaUploadApi {

    private static final Map<Long, Long> VIDEO_SIZE_PROCESSING_WAIT_TIME_MAP;

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsMediaUploadApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    static {
        final Map<Long, Long> videoSizeProcessingWaitTimeMap = Maps.newHashMap();
        videoSizeProcessingWaitTimeMap.put(FIFTY_MIB, MAX_WAIT_INTERVAL_FIFTY_MIB);
        videoSizeProcessingWaitTimeMap.put(ONE_HUNDRED_FIFTY_MIB, MAX_WAIT_INTERVAL_ONE_HUNDRED_FIFTY_MIB);
        videoSizeProcessingWaitTimeMap.put(FIVE_HUNDRED_MIB, MAX_WAIT_INTERVAL_FIVE_HUNDRED_MIB);

        VIDEO_SIZE_PROCESSING_WAIT_TIME_MAP = Collections.unmodifiableMap(videoSizeProcessingWaitTimeMap);
    }

    @Override
    public String uploadMediaAndGetMediaId(String mediaUrl, Set<String> accountUserIds, TwitterMediaType twitterMediaType, String name)
            throws TwitterException {
        final UploadMediaObjectResponse responseFromFinalize = uploadAndGetMediaId(mediaUrl, accountUserIds, twitterMediaType, name);
        final String mediaIdString = responseFromFinalize.getMediaIdString();
        final Long videoSize = responseFromFinalize.getSize();

        //as per documentation if media process info is null then the video is ready
        if (responseFromFinalize.getUploadMediaProcessingInfo() == null) {
            return mediaIdString;
        }

        if (responseFromFinalize.getUploadMediaProcessingInfo().getUploadErrorInfo() != null) {
            throw new TwitterException(responseFromFinalize.getUploadMediaProcessingInfo().getUploadErrorInfo().getMessage());
        }

        final String state = responseFromFinalize.getUploadMediaProcessingInfo().getState();
        final Integer progressPercentage = responseFromFinalize.getUploadMediaProcessingInfo().getProgressPercentage();
        if ((TwitterAdUtil.isNotNullOrEmpty(state) && state.equalsIgnoreCase("succeeded")) ||
                (progressPercentage != null && progressPercentage == 100)) {
            return mediaIdString;
        }

        return waitForVideoProcessingAndReturnId(mediaIdString, responseFromFinalize, videoSize);
    }

    @Override
    public TwitterVideo createVideoForAccount(String accountId, String mediaId, String title, String description, String posterImageId)
            throws TwitterException {
        final BaseAdsResponse<TwitterVideo> videoBaseAdsResponse = createVideo(accountId, mediaId, title, description, posterImageId);
        if (videoBaseAdsResponse.getData() == null) {
            throw new TwitterException("Could not upload video to Ad Account, please retry");
        }

        final TwitterVideo video = videoBaseAdsResponse.getData();
        return waitForVideoProcessing(accountId, video.getId(), TimeUnit.MINUTES.toMillis(10));
    }

    @Override
    public BaseAdsResponse<TwitterVideo> getVideoByIdForAccount(String accountId, String videoMediaId, Boolean withDeleted) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(videoMediaId, "Video Media Id");

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + VIDEOS + "/" + videoMediaId;
        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));
        params.add(new HttpParameter(PARAM_ID, videoMediaId));

        if (withDeleted != null) {
            params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        }

        final Type type = new TypeToken<BaseAdsResponse<TwitterVideo>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TwitterVideo> updateVideoDetails(String accountId, String videoMediaId, String title, String description,
                                                            String posterImageId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(videoMediaId, "Video Media Id");
        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + VIDEOS + "/" + videoMediaId;
        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));

        if (TwitterAdUtil.isNotNullOrEmpty(title)) {
            params.add(new HttpParameter(PARAM_TITLE, title));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(description)) {
            params.add(new HttpParameter(PARAM_DESCRIPTION, description));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(posterImageId)) {
            params.add(new HttpParameter(PARAM_POSTER_IMAGE_ID, posterImageId));
        }

        final Type type = new TypeToken<BaseAdsResponse<TwitterVideo>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterLibraryMedia> updateName(String accountId, String mediaId, String title, String mediaType) throws TwitterException {
        TwitterAdUtil.ensureNotNull(mediaId, "Video Media Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(mediaType, "Media Type");
        TwitterAdUtil.ensureNotNull(title, "Media Name");

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_MEDIA_LIBRARY;
        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_NAME, title));
        params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));
        params.add(new HttpParameter(PARAM_MEDIA_CATEGORY, mediaType));

        final Type type = new TypeToken<BaseAdsResponse<TwitterLibraryMedia>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TwitterVideo> deleteVideo(String accountId, String videoMediaId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(videoMediaId, "Video Media Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + VIDEOS + "/" + videoMediaId;
        final Type type = new TypeToken<BaseAdsResponse<TwitterVideo>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterVideo> getVideosForAccount(String accountId, List<String> videoIds, Boolean withDeleted)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + VIDEOS;
        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));

        if (TwitterAdUtil.isNotEmpty(videoIds)) {
            params.add(new HttpParameter(PARAM_VIDEO_IDS, TwitterAdUtil.getCsv(videoIds)));
        }
        if (withDeleted != null) {
            params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        }

        final Type type = new TypeToken<BaseAdsListResponse<TwitterVideo>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public TwitterVideo waitForMediaProcessingAndGetVideo(String accountId, String channelVideoId) throws TwitterException {
        return waitForVideoProcessing(accountId, channelVideoId, TimeUnit.MINUTES.toMillis(4));
    }

    // ------------------------------------------------------------------- PRIVATE METHODS ----------------------------------------------------------

    private UploadMediaObjectResponse uploadAndGetMediaId(String mediaUrl, Set<String> accountUserIds, TwitterMediaType twitterMediaType, String name)
            throws TwitterException {
        try {
            String mediaSizeInBytes = getMediaSizeInBytes(mediaUrl);
            String mediaId = initiateMediaUpload(mediaSizeInBytes, accountUserIds, twitterMediaType, name);
            uploadMedia(mediaUrl, mediaId, mediaSizeInBytes);
            return finalizeMediaUpload(mediaId);
        } catch (Exception e) {
            if (e instanceof TwitterException) {
                throw (TwitterException) e;
            }
            throw new TwitterException("Error Occurred while uploading Media", e);
        }
    }

    private String getMediaSizeInBytes(String mediaUrl) throws TwitterException, IOException {
        try {
            URLConnection urlConnection = new URL(mediaUrl).openConnection();
            return urlConnection.getHeaderField("Content-Length");
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid media url");
        }
    }

    private String initiateMediaUpload(String mediaSizeInBytes, Set<String> accountUserIds, TwitterMediaType twitterMediaType, String name)
            throws TwitterException {
        if (StringUtils.isBlank(mediaSizeInBytes)) {
            throw new TwitterInvalidParameterException("Media could not be uploaded as connection could not be established");
        }

        Long mediaSizeInBytesLong;
        try {
            mediaSizeInBytesLong = Long.valueOf(mediaSizeInBytes);
        } catch (NumberFormatException eX) {
            throw new TwitterException("Media could not be uploaded as connection could not be established");
        }

        if (twitterMediaType == TwitterMediaType.IMAGE && mediaSizeInBytesLong > MAX_IMAGE_SIZE_FOR_TWITTER_IN_BYTES) {
            throw new TwitterInvalidParameterException("Image should be less than 5 MB in size");
        }
        if (twitterMediaType == TwitterMediaType.VIDEO && mediaSizeInBytesLong > MAX_VIDEO_SIZE_IN_BYTES) {
            throw new TwitterInvalidParameterException("Video should be less than 500 MB in size");
        }

        final String url = twitterAdsClient.getMediaUploadBaseUrl() + UPLOAD_MEDIA_URL + UPLOAD_JSON;
        final HttpParameter[] parameters = createInitiateMediaUploadParams(mediaSizeInBytes, accountUserIds, twitterMediaType);
        return twitterAdsClient.mediaUploadInitOrFinalize(url, parameters).getMediaIdString();
    }

    private UploadMediaObjectResponse finalizeMediaUpload(String mediaId) throws TwitterException {
        final String url = twitterAdsClient.getMediaUploadBaseUrl() + UPLOAD_MEDIA_URL + UPLOAD_JSON;
        final HttpParameter[] parameters = createFinalizeMediaUploadParams(mediaId);
        final Type type = new TypeToken<UploadMediaObjectResponse>() {
        }.getType();

        return twitterAdsClient.executeRequest(url, parameters, type, HttpVerb.POST);
    }

    private HttpParameter[] createInitiateMediaUploadParams(String mediaSizeInBytes, Set<String> accountUserIds, TwitterMediaType twitterMediaType) {
        if (StringUtils.isBlank(mediaSizeInBytes)) {
            throw new TwitterRuntimeException(null, new TwitterException("mediaSizeInBytes cannot be blank or null."));
        }

        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_COMMAND, "INIT"));
        params.add(new HttpParameter(PARAM_TOTAL_BYTES, mediaSizeInBytes));

        switch (twitterMediaType) {
            case VIDEO:
                /*
                Only one attributable user can be specified per video.
                Only the attributable user will be able to use the video in a Tweet.
                If additional owners are also listed, they will be ignored.
                */
                params.add(new HttpParameter(PARAM_MEDIA_TYPE, "video/mp4"));
                params.add(new HttpParameter(PARAM_MEDIA_CATEGORY, "amplify_video"));
                if (TwitterAdUtil.isNotEmpty(accountUserIds) && accountUserIds.size() == 1) {
                    final String accountUserId = accountUserIds.iterator().next();
                    params.add(new HttpParameter(PARAM_ATTRIBUTABLE_USER_ID, accountUserId));
                }
                break;
            case IMAGE:
                params.add(new HttpParameter(PARAM_MEDIA_TYPE, "image/jpeg"));
                break;
            case DM_IMAGE:
                params.add(new HttpParameter(PARAM_MEDIA_TYPE, "image/jpeg"));
                params.add(new HttpParameter(PARAM_MEDIA_CATEGORY, "dm_image"));
                params.add(new HttpParameter(PARAM_SHARED, true));
                break;
            case DM_VIDEO:
                params.add(new HttpParameter(PARAM_MEDIA_TYPE, "video/mp4"));
                params.add(new HttpParameter(PARAM_MEDIA_CATEGORY, "dm_video"));
                params.add(new HttpParameter(PARAM_SHARED, true));
                break;
            case DM_GIF:
                params.add(new HttpParameter(PARAM_MEDIA_TYPE, "video/gif")); //check this
                params.add(new HttpParameter(PARAM_MEDIA_CATEGORY, "dm_image"));
                params.add(new HttpParameter(PARAM_SHARED, true));
                break;
            default:
                break;
        }

        if (TwitterAdUtil.isNotEmpty(accountUserIds)) {
            params.add(new HttpParameter(PARAM_ADDITIONAL_OWNERS, TwitterAdUtil.getCsv(accountUserIds)));
        }

        return params.toArray(new HttpParameter[params.size()]);
    }

    private void uploadMedia(String mediaUrl, String mediaId, String mediaSizeInBytes) throws TwitterException, IOException {
        int segmentIndex = 0;
        Long bytesLeftToUpload = Long.valueOf(mediaSizeInBytes);
        InputStream inputStream = null;
        BufferedInputStream bis = null;
        try {
            inputStream = new URL(mediaUrl).openStream();
            bis = new BufferedInputStream(inputStream);

            while (bytesLeftToUpload > 0) {
                int totalBytesRead = 0;
                byte[] chunkToUpload = new byte[2 * TWO_MIB];

                while (totalBytesRead < TWO_MIB) {
                    byte[] chunk = new byte[TWO_MIB];
                    int bytesRead = bis.read(chunk);
                    if (bytesRead == -1) {
                        break;
                    } else {
                        chunk = Arrays.copyOf(chunk, bytesRead);
                        for (int i = 0; i < bytesRead; i++) {
                            chunkToUpload[totalBytesRead++] = chunk[i];
                        }
                    }
                }

                if (totalBytesRead > 0) {
                    chunkToUpload = Arrays.copyOf(chunkToUpload, totalBytesRead);
                    String base64Encoding = DatatypeConverter.printBase64Binary(chunkToUpload);
                    appendChunk(mediaId, base64Encoding, segmentIndex);
                    bytesLeftToUpload -= totalBytesRead;
                    segmentIndex += 1;
                } else {
                    break;
                }
            }
        } finally {
            if (inputStream != null) {
                IOUtils.closeQuietly(bis);
            }
        }
    }

    private void appendChunk(String mediaId, String chunk, int segmentIndex) throws TwitterException {
        String url = twitterAdsClient.getMediaUploadBaseUrl() + "media/upload.json";

        List<HttpParameter> params = createAppendChunkParams(mediaId, chunk, segmentIndex);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);

        HttpResponse response = twitterAdsClient.postRequest(url, parameters);
        int responseCode = response.getStatusCode();
        if (responseCode < SUCCESSFULL_CALL_BEGIN_CODE || responseCode > SUCCESSFULL_CALL_END_CODE) {
            throw new TwitterException(response.asString());
        }

    }

    private List<HttpParameter> createAppendChunkParams(String mediaId, String chunk, int segment_index) {
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_COMMAND, "APPEND"));
        params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));
        params.add(new HttpParameter(PARAM_MEDIA_DATA, chunk));
        params.add(new HttpParameter(PARAM_SEGMENT_INDEX, segment_index));

        return params;
    }

    private HttpParameter[] createFinalizeMediaUploadParams(String mediaId) {
        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_COMMAND, "FINALIZE"));
        params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));

        return params.toArray(new HttpParameter[params.size()]);
    }

    private String createVideoObject(String mediaId, String accountId) throws TwitterException {
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PREFIX_VIDEOS;
        List<HttpParameter> params = createVideoObjectParams(mediaId);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterVideo>>() {
        }.getType();
        BaseAdsResponse<TwitterVideo> response =
                twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
        return response.getData().getId();
    }

    private List<HttpParameter> createVideoObjectParams(String mediaId) {
        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_VIDEO_MEDIA_ID, mediaId));
        params.add(new HttpParameter(PARAM_COMMAND, "FINALIZE"));

        return params;
    }

    private TwitterVideo waitForVideoProcessing(String accountId, String videoId, long maxWaitTime) throws TwitterException {
        Long totalWaitTime = 0L;
        String url =
                twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_3 + accountId + PREFIX_VIDEOS + SLASH + videoId;

        Type type = new TypeToken<BaseAdsResponse<TwitterVideo>>() {
        }.getType();
        while (totalWaitTime < maxWaitTime) {
            BaseAdsResponse<TwitterVideo> response = twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
            TwitterVideo video = response.getData();
            boolean readyToTweet = video.isReadyToTweet();

            TwitterVideoErrors status = null;
            if (video.getReasonsNotServable() != null && video.getReasonsNotServable().size() > 0) {
                status = video.getReasonsNotServable().get(0);
            }
            if (readyToTweet) {
                return video;
            } else if (TwitterVideoErrors.PROCESSING.equals(status)) {
                TwitterAdUtil.reallySleep(WAIT_INTERVAL);
                totalWaitTime += WAIT_INTERVAL;
            } else {
                throw new TwitterException("Video processing error. Error code: " + (status != null ? status.getLabel() : StringUtils.EMPTY));
            }
        }
        return null;
    }

    private String waitForVideoProcessingAndReturnId(String mediaIdString, UploadMediaObjectResponse statusResponse, Long videoSize)
            throws TwitterException {
        if (statusResponse == null) {
            statusResponse = getUploadStatus(mediaIdString);
        }

        Long timeToWait = 0L;
        Long checkAfterSeconds = statusResponse.getUploadMediaProcessingInfo().getCheckAfterSeconds();
        Long maxWaitTime = decideMaxWaitTime(videoSize);
        while (timeToWait < maxWaitTime) {
            TwitterAdUtil.reallySleep(checkAfterSeconds * 1000);
            timeToWait = timeToWait + checkAfterSeconds;

            statusResponse = getUploadStatus(mediaIdString);
            if (statusResponse == null) {
                throw new TwitterException("Could not upload Video successfully, please select a different video");
            }
            //as per documentation if media process info is null then the video is ready
            if (statusResponse.getUploadMediaProcessingInfo() == null) {
                return mediaIdString;
            }
            if (statusResponse.getUploadMediaProcessingInfo().getUploadErrorInfo() != null) {
                throw new TwitterException(statusResponse.getUploadMediaProcessingInfo().getUploadErrorInfo().getMessage());
            }

            String state = statusResponse.getUploadMediaProcessingInfo().getState();
            Integer progressPercentage = statusResponse.getUploadMediaProcessingInfo().getProgressPercentage();
            if ((TwitterAdUtil.isNotNullOrEmpty(state) && state.equalsIgnoreCase("succeeded")) ||
                    (progressPercentage != null && progressPercentage == 100)) {
                return mediaIdString;
            }
        }

        if (statusResponse.getUploadMediaProcessingInfo().getProgressPercentage() != null &&
                statusResponse.getUploadMediaProcessingInfo().getProgressPercentage() < 100 &&
                statusResponse.getUploadMediaProcessingInfo().getState() != null &&
                statusResponse.getUploadMediaProcessingInfo().getState().equalsIgnoreCase("in_progress")) {
            throw new TwitterException(
                    "Please retry playing the ad, or upload a new video, there is problem at Twitter's end in processing the " + "video");
        }
        throw new TwitterException(statusResponse.getUploadMediaProcessingInfo().getUploadErrorInfo().getMessage());
    }

    private Long decideMaxWaitTime(Long videoSize) {
        Long maxWaitTime = VIDEO_SIZE_PROCESSING_WAIT_TIME_MAP.get(getVideoSizeGroup(videoSize));
        if (maxWaitTime == null) {
            maxWaitTime = MAX_WAIT_INTERVAL_ONE_HUNDRED_FIFTY_MIB;
        }

        return maxWaitTime;
    }

    private Long getVideoSizeGroup(Long videoSize) {
        if (videoSize == null) {
            return ONE_HUNDRED_FIFTY_MIB;
        }

        if (videoSize <= FIFTY_MIB) {
            return FIFTY_MIB;
        } else if (videoSize <= ONE_HUNDRED_FIFTY_MIB) {
            return ONE_HUNDRED_FIFTY_MIB;
        } else {
            return FIVE_HUNDRED_MIB;
        }
    }

    private UploadMediaObjectResponse getUploadStatus(String mediaId) throws TwitterException {
        final String url = twitterAdsClient.getMediaUploadBaseUrl() + "media/upload.json";

        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_COMMAND, "STATUS"));
        params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));

        Type type = new TypeToken<UploadMediaObjectResponse>() {
        }.getType();

        return twitterAdsClient.executeRequest(url, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.GET);
    }

    private BaseAdsResponse<TwitterVideo> createVideo(String accountId, String mediaId, String title, String description, String posterImageId)
            throws TwitterException {
        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + VIDEOS;
        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));
        params.add(new HttpParameter(PARAM_VIDEO_MEDIA_ID, mediaId));
        if (TwitterAdUtil.isNotNullOrEmpty(title)) {
            params.add(new HttpParameter(PARAM_TITLE, title));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(description)) {
            params.add(new HttpParameter(PARAM_DESCRIPTION, description));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(posterImageId)) {
            params.add(new HttpParameter(PARAM_POSTER_IMAGE_ID, posterImageId));
        }

        final Type type = new TypeToken<BaseAdsResponse<TwitterVideo>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }
}
