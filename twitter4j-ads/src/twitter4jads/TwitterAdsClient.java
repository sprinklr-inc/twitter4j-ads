package twitter4jads;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import twitter4jads.auth.Authorization;
import twitter4jads.auth.OAuthSupport;
import twitter4jads.conf.Configuration;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.http.HttpResponse;
import twitter4jads.internal.models4j.*;
import twitter4jads.models.AudienceUploadDetails;
import twitter4jads.models.TwitterTonUploadResponse;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.ads.cards.TwitterVideoErrors;
import twitter4jads.models.media.TwitterMediaType;
import twitter4jads.models.video.TwitterVideo;
import twitter4jads.util.TwitterAdUtil;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static twitter4jads.TwitterAdsConstants.*;
import static twitter4jads.util.TwitterAdUtil.constructBaseAdsResponse;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 7:07 PM
 */
public class TwitterAdsClient extends TwitterImpl implements OAuthSupport {

    public static final String ADS_API_URL = "https://ads-api.twitter.com/";
    public static final Gson GSON_INSTANCE = new Gson();

    private static final Map<String, String> requestHeaders;

    static {
        requestHeaders = new HashMap<>();
        requestHeaders.put("X-Twitter-Client-Version", Version.getVersion());
        requestHeaders.put("X-Twitter-Client-URL", "http://twitter4jads.org/en/twitter4jads-" + Version.getVersion() + ".xml");
        requestHeaders.put("X-Twitter-Client", "Twitter4J");
        requestHeaders.put("User-Agent", "twitter4jads http://twitter4jads.org/ /" + Version.getVersion());
        requestHeaders.put("Accept-Encoding", "gzip");
    }

    public static TwitterAdsClient getInstance(Configuration conf, Authorization auth) {
        return new TwitterAdsClient(conf, auth);
    }

    public TwitterAdsClient(Configuration conf, Authorization auth) {
        super(conf, auth);
    }

    private String getImplicitParamsStr() {
        return StringUtils.EMPTY;
    }


    public String getBaseAdsAPIUrl() {
        return ADS_API_URL;//conf.getAdsAPIURL();
    }

    public <T> BaseAdsListResponseIterable<T> executeHttpListRequest(String baseUrl, List<HttpParameter> params, Type type) throws TwitterException {
        return executeHttpListRequest(baseUrl, params, type, false);
    }

    public <T> BaseAdsListResponseIterable<T> executeHttpListRequest(String baseUrl, List<HttpParameter> params, Type type,
                                                                     boolean isCostBasedRateLimit) throws TwitterException {
        HttpResponse httpResponse;
        if (params != null) {
            httpResponse = get(baseUrl, params.toArray(new HttpParameter[params.size()]));
        } else {
            httpResponse = get(baseUrl);
        }
        BaseAdsListResponseIterable<T> response;
        try {
            response = constructBaseAdsListResponse(baseUrl, httpResponse, params, type, isCostBasedRateLimit);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse response.", e);
        }
        return response;
    }

    public <T> BaseAdsListResponseIterable<T> constructBaseAdsListResponse(String baseUrl, HttpResponse httpResponse, List<HttpParameter> params,
                                                                           Type type, boolean isCostBasedRateLimit)
            throws TwitterException, IOException {
        return new BaseAdsListResponseIterable<>(this, baseUrl, params, type, httpResponse, isCostBasedRateLimit);
    }

    public TwitterVideo uploadAndCreateVideoObject(String videoUrl, String accountId) throws TwitterException {
        try {
            String videoSizeInBytes = getMediaSizeInBytes(videoUrl);
            String mediaId = initiateMediaUpload(videoSizeInBytes, null, TwitterMediaType.VIDEO);// todo this is done deliberately, fix it in future
            uploadMedia(videoUrl, mediaId, videoSizeInBytes);
            finalizeUpload(mediaId);
            waitForVideoTranscoding(mediaId, MAX_WAIT_TIME_TRANSCODING);
            String videoId = createVideoObject(mediaId, accountId);
            return waitForVideoProcessing(accountId, videoId, MAX_WAIT_TIME);
        } catch (Exception e) {
            throw new TwitterException("Error Occurred while uploading Promoted Video", e);
        }
    }

    public <T> BaseAdsResponse<T> executeHttpRequest(String baseUrl, HttpParameter[] params, Type type, HttpVerb httpVerb) throws TwitterException {
        HttpResponse httpResponse;
        String stringResponse;
        BaseAdsResponse<T> response = null;
        switch (httpVerb) {
            case GET:
                try {
                    httpResponse = get(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case PUT:
                try {
                    httpResponse = put(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case POST:
                try {
                    httpResponse = postRequest(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case DELETE:
                try {
                    httpResponse = delete(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
        }
        return response;
    }

    public HttpResponse postRequest(String url, HttpParameter[] params) throws TwitterException {
        return post(url, params);
    }

    public HttpResponse getRequest(String url, HttpParameter[] params) throws TwitterException {
        return get(url, params);
    }

    public HttpResponse getRequest(String url) throws TwitterException {
        return get(url);
    }

    public HttpResponse getWithoutMergeOfParams(String url, HttpParameter[] params) throws TwitterException {
        return getWithoutMergingImplicitParams(url, params);
    }

    public HttpResponse putRequest(String url, HttpParameter[] params) throws TwitterException {
        return put(url, params);
    }

    public TwitterTonUploadResponse executeHttpRequestForTon(String baseUrl, HttpParameter[] params, HttpVerb httpVerb,
                                                             Map<String, String> customHeaders) throws TwitterException {
        HttpResponse httpResponse;
        AudienceUploadDetails response = null;
        //noinspection EnumSwitchStatementWhichMissesCases
        switch (httpVerb) {
            case PUT:
                httpResponse = putWithCustomHeaders(baseUrl, params, customHeaders, true);
                response = getResponseFromHeaders(httpResponse);

                break;
            case POST:
                httpResponse = postWithCustomHeaders(baseUrl, params, customHeaders, true);
                response = getResponseFromHeaders(httpResponse);
                break;
        }
        return response;
    }

    public <T> T executeRequest(String baseUrl, HttpParameter[] params, Type typeToken, HttpVerb httpVerb) throws TwitterException {
        HttpResponse httpResponse;
        String stringResponse;
        T response = null;
        switch (httpVerb) {
            case GET:
                try {
                    httpResponse = getRequest(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case PUT:
                try {
                    httpResponse = put(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case POST:
                try {
                    httpResponse = postRequest(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case DELETE:
                try {
                    httpResponse = delete(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
        }
        return response;
    }

    public Configuration getConf() {
        return super.getConfiguration();
    }

    // ------------------------------------------- Private Methods -------------------------------------------------

    private <T> T constructHTTPRequestResponse(String response, Type typeToken) throws IOException {
        return GSON_INSTANCE.fromJson(response, typeToken);

    }

    public HttpResponse get(String url) throws TwitterException {
        ensureAuthorizationEnabled();

        if (!conf.isMBeanEnabled()) {
            return http.get(url, null, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.get(url, null, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    public HttpResponse get(String url, HttpParameter... params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.get(url, params, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.get(url, params, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    public HttpResponse post(String url, HttpParameter... params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.post(url, params, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.post(url, params, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    private boolean isOk(HttpResponse response) {
        return response != null && response.getStatusCode() < 300;
    }

    protected HttpResponse put(String url, HttpParameter[] params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.put(url, params, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.put(url, params, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse delete(String url) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.delete(url, null, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.delete(url, null, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse delete(String url, HttpParameter[] params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.delete(url, params, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.delete(url, params, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse getWithoutMergingImplicitParams(String url, HttpParameter[] params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.get(url, params, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.get(url, params, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    private String getMediaSizeInBytes(String mediaUrl) throws TwitterException, IOException {
        URLConnection urlConnection = new URL(mediaUrl).openConnection();
        return urlConnection.getHeaderField("Content-Length");
    }

    private String initiateMediaUpload(String mediaSizeInBytes, String accountUserId, TwitterMediaType twitterMediaType) throws TwitterException {
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

        String url = conf.getMediaUploadBaseUrl() + UPLOAD_MEDIA_URL + UPLOAD_JSON;
        HttpParameter[] parameters = createInitiateMediaUploadParams(mediaSizeInBytes, accountUserId, twitterMediaType);
        return mediaUploadInitOrFinalize(url, parameters).getMediaIdString();
    }

    private HttpParameter[] createInitiateMediaUploadParams(String mediaSizeInBytes, String accountUserId, TwitterMediaType twitterMediaType) {
        if (StringUtils.isBlank(mediaSizeInBytes)) {
            throw new TwitterRuntimeException(null, new TwitterException("mediaSizeInBytes cannot be blank or null."));
        }

        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_COMMAND, "INIT"));
        params.add(new HttpParameter(PARAM_TOTAL_BYTES, mediaSizeInBytes));

        if (twitterMediaType == TwitterMediaType.VIDEO) {
            params.add(new HttpParameter(PARAM_MEDIA_TYPE, "video/mp4"));
            params.add(new HttpParameter(PARAM_MEDIA_CATEGORY, "amplify_video"));
        } else {
            params.add(new HttpParameter(PARAM_MEDIA_TYPE, "image/jpeg"));
        }
        if (StringUtils.isNotBlank(accountUserId)) {
            params.add(new HttpParameter(PARAM_ADDITIONAL_OWNERS, accountUserId));
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
        String url = conf.getMediaUploadBaseUrl() + "media/upload.json";

        List<HttpParameter> params = createAppendChunkParams(mediaId, chunk, segmentIndex);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);

        HttpResponse response = postRequest(url, parameters);
        int responseCode = response.getStatusCode();
        if (responseCode < SUCCESSFULL_CALL_BEGIN_CODE || responseCode > SUCCESSFULL_CALL_END_CODE) {
            throw new TwitterException(response.asString());
        }

    }

    private AudienceUploadDetails getResponseFromHeaders(HttpResponse httpResponse) {
        Integer minChunkSize = null;
        Integer maxChunkSize = null;
        String location = httpResponse.getResponseHeader("location");
        Integer bytesSuccessfullyUploaded = getBytesUploadedFromHeader(httpResponse);
        String minimumChunkSizeFromHeader = httpResponse.getResponseHeader("x-ton-min-chunk-size");
        if (minimumChunkSizeFromHeader != null) {
            minChunkSize = Integer.valueOf(minimumChunkSizeFromHeader);

        }
        String maximumChunkSizeFromHeader = httpResponse.getResponseHeader("x-ton-max-chunk-size");
        if (maximumChunkSizeFromHeader != null) {
            maxChunkSize = Integer.valueOf(maximumChunkSizeFromHeader);

        }
        return new AudienceUploadDetails(location, minChunkSize, maxChunkSize, bytesSuccessfullyUploaded, null);
    }

    private Integer getBytesUploadedFromHeader(HttpResponse httpResponse) {
        String range;
        String rangeFromHeader = httpResponse.getResponseHeader("range");
        if (rangeFromHeader != null) {
            int i = rangeFromHeader.indexOf("-");
            if (i > 0) {
                range = rangeFromHeader.substring(i + 1, rangeFromHeader.length());
                return Integer.valueOf(range);
            }
        }
        return null;
    }

    private List<HttpParameter> createAppendChunkParams(String mediaId, String chunk, int segment_index) {
        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_COMMAND, "APPEND"));
        params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));
        params.add(new HttpParameter(PARAM_MEDIA_DATA, chunk));
        params.add(new HttpParameter(PARAM_SEGMENT_INDEX, segment_index));

        return params;
    }

    private void finalizeUpload(String mediaId) throws TwitterException {
        String url = conf.getMediaUploadBaseUrl() + "media/upload.json";
        HttpParameter[] parameters = createFinalizeMediaUploadParams(mediaId);
        mediaUploadInitOrFinalize(url, parameters);
    }

    private HttpParameter[] createFinalizeMediaUploadParams(String mediaId) {
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_COMMAND, "FINALIZE"));
        params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));
        return params.toArray(new HttpParameter[params.size()]);
    }

    private String createVideoObject(String mediaId, String accountId) throws TwitterException {
        String url = getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PREFIX_VIDEOS;
        //TODO add video title and description (optional)
        List<HttpParameter> params = createVideoObjectParams(mediaId);
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterVideo>>() {
        }.getType();
        BaseAdsResponse<TwitterVideo> response = executeHttpRequest(url, parameters, type, HttpVerb.POST);
        return response.getData().getId();
    }

    private List<HttpParameter> createVideoObjectParams(String mediaId) {
        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(PARAM_VIDEO_MEDIA_ID, mediaId));
        params.add(new HttpParameter(PARAM_COMMAND, "FINALIZE"));
        return params;
    }

    public TwitterVideo waitForVideoProcessing(String accountId, String videoId, long maxWaitTime) throws TwitterException {
        Long totalWaitTime = 0L;
        String url = getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PREFIX_VIDEOS + SLASH + videoId;

        Type type = new TypeToken<BaseAdsResponse<TwitterVideo>>() {
        }.getType();
        while (totalWaitTime < maxWaitTime) {
            BaseAdsResponse<TwitterVideo> response = executeHttpRequest(url, null, type, HttpVerb.GET);

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
}

