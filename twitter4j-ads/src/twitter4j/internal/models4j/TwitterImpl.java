/*
 * Copyright (C) 2007 Yusuke Yamamoto
 * Copyright (C) 2011 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter4j.internal.models4j;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.json.TwitterUploadMediaResponseImpl;
import twitter4j.internal.util.z_T4JInternalStringUtil;
import twitter4j.util.TwitterAdUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * A java representation of the <a href="https://dev.twitter.com/docs/api">Twitter REST API</a><br>
 * This class is thread safe and can be cached/re-used and used concurrently.<br>
 * Currently this class is not carefully designed to be extended. It is suggested to extend this class only for mock testing purpose.<br>
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public class TwitterImpl extends TwitterBaseImpl implements Twitter {
    private static final long serialVersionUID = -1486360080128882436L;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    //TODO: move these to a constant file along with other hardcoded strings
    public static final String COMMAND = "command";
    public static final String MEDIA_ID = "media_id";
    public static final String SEGMENT_INDEX = "segment_index";
    public static final String MEDIA = "media";
    public static final String MEDIA_TYPE = "media_type";
    public static final String MEDIA_CATEGORY = "media_category";
    public static final String PARAM_ADDITIONAL_OWNERS = "additional_owners";
    public static final String TOTAL_BYTES = "total_bytes";
    public static final String INIT = "INIT";
    public static final String APPEND = "APPEND";
    public static final String FINALIZE = "FINALIZE";
    public static final String STATUS = "STATUS";

    private final String IMPLICIT_PARAMS_STR;
    private final HttpParameter[] IMPLICIT_PARAMS;
    private final HttpParameter INCLUDE_MY_RETWEET;
    private final HttpParameter TWEET_MODE;
    long WAIT_INTERVAL_TRANSCODING = TimeUnit.SECONDS.toMillis(5);

    private static final Map<Configuration, HttpParameter[]> implicitParamsMap = new ConcurrentHashMap<>();
    private static final Map<Configuration, String> implicitParamsStrMap = new ConcurrentHashMap<>();

    /*package*/
    public TwitterImpl(Configuration conf, Authorization auth) {
        super(conf, auth);
        INCLUDE_MY_RETWEET = new HttpParameter("include_my_retweet", conf.isIncludeMyRetweetEnabled());
        TWEET_MODE = new HttpParameter("tweet_mode", conf.getTweetMode());

        HttpParameter[] implicitParams = implicitParamsMap.get(conf);
        String implicitParamsStr = implicitParamsStrMap.get(conf);
        if (implicitParams == null) {
            String includeEntities = conf.isIncludeEntitiesEnabled() ? "1" : "0";
            String includeRTs = conf.isIncludeRTsEnabled() ? "1" : "0";
            boolean contributorsEnabled = conf.getContributingTo() != -1L;
            implicitParamsStr = "include_entities=" + includeEntities + "&include_rts=" + includeRTs +
                                (contributorsEnabled ? "&contributingto=" + conf.getContributingTo() : "");
            implicitParamsStrMap.put(conf, implicitParamsStr);

            List<HttpParameter> params = new ArrayList<HttpParameter>();
            params.add(new HttpParameter("include_entities", includeEntities));
            params.add(new HttpParameter("include_rts", includeRTs));
            if (contributorsEnabled) {
                params.add(new HttpParameter("contributingto", conf.getContributingTo()));
            }
            implicitParams = params.toArray(new HttpParameter[params.size()]);
            implicitParamsMap.put(conf, implicitParams);
        }
        IMPLICIT_PARAMS = implicitParams;
        IMPLICIT_PARAMS_STR = implicitParamsStr;
    }

    /**
     * {@inheritDoc}
     */
    public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
        return factory.createStatusList(get(conf.getRestBaseURL() + "statuses/retweets_of_me.json", new HttpParameter[]{TWEET_MODE}));
    }

    /**
     * {@inheritDoc}
     */
    public ResponseList<Status> getRetweetsOfMe(Paging paging) throws TwitterException {
        return factory.createStatusList(get(conf.getRestBaseURL() + "statuses/retweets_of_me.json",
                                            mergeParameters(paging.asPostParameterArray(), new HttpParameter[]{TWEET_MODE})));
    }

    public ResponseList<Status> getScopedTimeLine(long userId, Paging paging) throws TwitterException {
        return factory.createStatusList(get(conf.getRestBaseURL() + "statuses/scoped_timeline.json", mergeParameters(
                mergeParameters(new HttpParameter[]{new HttpParameter("user_id", userId)}, paging.asPostParameterArray()),
                new HttpParameter[]{TWEET_MODE})));
    }

    /* Tweets Resources */

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseList<Status> getRetweets(long statusId) throws TwitterException {
        return factory
                .createStatusList(get(conf.getRestBaseURL() + "statuses/retweets/" + statusId + ".json?count=100", new HttpParameter[]{TWEET_MODE}));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status showStatus(long id) throws TwitterException {
        return factory.createStatus(get(conf.getRestBaseURL() + "statuses/show/" + id + ".json",
                                        mergeParameters(new HttpParameter[]{INCLUDE_MY_RETWEET}, new HttpParameter[]{TWEET_MODE})));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status destroyStatus(long statusId) throws TwitterException {
        return factory.createStatus(post(conf.getRestBaseURL() + "statuses/destroy/" + statusId + ".json", new HttpParameter[]{TWEET_MODE}));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status updateStatus(String status) throws TwitterException {
        return factory.createStatus(post(conf.getRestBaseURL() + "statuses/update.json",
                                         mergeParameters(new HttpParameter[]{new HttpParameter("status", status)}, new HttpParameter[]{TWEET_MODE})));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status updateStatus(StatusUpdate status) throws TwitterException {
        String url = conf.getRestBaseURL() + (status.isWithMedia() ? "statuses/update_with_media.json" : "statuses/update.json");
        return factory.createStatus(post(url, mergeParameters(status.asHttpParameterArray(), new HttpParameter[]{TWEET_MODE})));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status retweetStatus(long statusId) throws TwitterException {
        return factory.createStatus(post(conf.getRestBaseURL() + "statuses/retweet/" + statusId + ".json", new HttpParameter[]{TWEET_MODE}));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseList<Status> lookupStatuses(long[] statusIds) throws TwitterException {
        if (statusIds == null || statusIds.length > 100) {
            throw new TwitterException("Illegal argument: Status Ids cannot be null, and maximum upto 100 tweets per request");
        }
        return factory.createStatusList(
                get(conf.getRestBaseURL() + "statuses/lookup.json?id=" + z_T4JInternalStringUtil.join(statusIds), new HttpParameter[]{TWEET_MODE}));
    }

    @Override
    public String uploadMediaInChunks(String filePath, long fileSize, String mediaType, String mediaCategory, int maxChunkSize,
                                      long maxWaitTimeTranscoding, String accountUserId) throws TwitterException {
        String mediaId = initializeChunkUpload(fileSize, mediaType, mediaCategory, accountUserId);
        uploadVideoInChunks(mediaId, filePath, fileSize, maxChunkSize);
        finalizeChunkUpload(mediaId);
        //only when specifying media category, the process is made async otherwise no need to wait.
        if (StringUtils.isNotBlank(mediaCategory)) {
            waitForVideoTranscoding(mediaId, maxWaitTimeTranscoding);
        }
        return mediaId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountSettings getAccountSettings() throws TwitterException {
        return factory.createAccountSettings(get(conf.getRestBaseURL() + "account/settings.json"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User verifyCredentials() throws TwitterException {
        return super.fillInIDAndScreenName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountSettings updateAccountSettings(Integer trend_locationWoeid, Boolean sleep_timeEnabled, String start_sleepTime, String end_sleepTime,
                                                 String time_zone, String lang) throws TwitterException {
        List<HttpParameter> profile = new ArrayList<HttpParameter>(6);
        if (trend_locationWoeid != null) {
            profile.add(new HttpParameter("trend_location_woeid", trend_locationWoeid));
        }
        if (sleep_timeEnabled != null) {
            profile.add(new HttpParameter("sleep_time_enabled", sleep_timeEnabled.toString()));
        }
        if (start_sleepTime != null) {
            profile.add(new HttpParameter("start_sleep_time", start_sleepTime));
        }
        if (end_sleepTime != null) {
            profile.add(new HttpParameter("end_sleep_time", end_sleepTime));
        }
        if (time_zone != null) {
            profile.add(new HttpParameter("time_zone", time_zone));
        }
        if (lang != null) {
            profile.add(new HttpParameter("lang", lang));
        }
        return factory
                .createAccountSettings(post(conf.getRestBaseURL() + "account/settings.json", profile.toArray(new HttpParameter[profile.size()])));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateProfile(String name, String url, String location, String description) throws TwitterException {
        List<HttpParameter> profile = new ArrayList<HttpParameter>(4);
        addParameterToList(profile, "name", name);
        addParameterToList(profile, "url", url);
        addParameterToList(profile, "location", location);
        addParameterToList(profile, "description", description);
        return factory.createUser(post(conf.getRestBaseURL() + "account/update_profile.json", profile.toArray(new HttpParameter[profile.size()])));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateProfileBackgroundImage(File image, boolean tile) throws TwitterException {
        checkFileValidity(image);
        return factory.createUser(post(conf.getRestBaseURL() + "account/update_profile_background_image.json",
                                       new HttpParameter[]{new HttpParameter("image", image), new HttpParameter("tile", tile)}));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateProfileBackgroundImage(InputStream image, boolean tile) throws TwitterException {
        return factory.createUser(post(conf.getRestBaseURL() + "account/update_profile_background_image.json",
                                       new HttpParameter[]{new HttpParameter("image", "image", image), new HttpParameter("tile", tile)}));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateProfileColors(String profileBackgroundColor, String profileTextColor, String profileLinkColor, String profileSidebarFillColor,
                                    String profileSidebarBorderColor) throws TwitterException {
        List<HttpParameter> colors = new ArrayList<HttpParameter>(6);
        addParameterToList(colors, "profile_background_color", profileBackgroundColor);
        addParameterToList(colors, "profile_text_color", profileTextColor);
        addParameterToList(colors, "profile_link_color", profileLinkColor);
        addParameterToList(colors, "profile_sidebar_fill_color", profileSidebarFillColor);
        addParameterToList(colors, "profile_sidebar_border_color", profileSidebarBorderColor);
        return factory
                .createUser(post(conf.getRestBaseURL() + "account/update_profile_colors.json", colors.toArray(new HttpParameter[colors.size()])));
    }

    private void addParameterToList(List<HttpParameter> colors, String paramName, String color) {
        if (color != null) {
            colors.add(new HttpParameter(paramName, color));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateProfileImage(File image) throws TwitterException {
        checkFileValidity(image);
        return factory.createUser(
                post(conf.getRestBaseURL() + "account/update_profile_image.json", new HttpParameter[]{new HttpParameter("image", image)}));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User updateProfileImage(InputStream image) throws TwitterException {
        return factory.createUser(
                post(conf.getRestBaseURL() + "account/update_profile_image.json", new HttpParameter[]{new HttpParameter("image", "image", image)}));
    }

    /**
     * Check the existence, and the type of the specified file.
     *
     * @param image image to be uploaded
     * @throws TwitterException when the specified file is not found (FileNotFoundException will be nested)
     *                          , or when the specified file object is not representing a file(IOException will be nested).
     */
    private void checkFileValidity(File image) throws TwitterException {
        if (!image.exists()) {
            //noinspection ThrowableInstanceNeverThrown
            throw new TwitterException(new FileNotFoundException(image + " is not found."));
        }
        if (!image.isFile()) {
            //noinspection ThrowableInstanceNeverThrown
            throw new TwitterException(new IOException(image + " is not a file."));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PagableResponseList<User> getBlocksList() throws TwitterException {
        return getBlocksList(-1L);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PagableResponseList<User> getBlocksList(long cursor) throws TwitterException {
        return factory.createPagableUserList(get(conf.getRestBaseURL() + "blocks/list.json?cursor=" + cursor));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User createBlock(long userId) throws TwitterException {
        return factory.createUser(post(conf.getRestBaseURL() + "blocks/create.json?user_id=" + userId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User createBlock(String screenName) throws TwitterException {
        return factory.createUser(post(conf.getRestBaseURL() + "blocks/create.json?screen_name=" + screenName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User destroyBlock(long userId) throws TwitterException {
        return factory.createUser(post(conf.getRestBaseURL() + "blocks/destroy.json?user_id=" + userId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User destroyBlock(String screen_name) throws TwitterException {
        return factory.createUser(post(conf.getRestBaseURL() + "blocks/destroy.json?screen_name=" + screen_name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseList<User> lookupUsers(long[] ids) throws TwitterException {
        return factory.createUserList(get(conf.getRestBaseURL() + "users/lookup.json",
                                          new HttpParameter[]{new HttpParameter("user_id", z_T4JInternalStringUtil.join(ids))}));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseList<User> lookupUsers(String[] screenNames) throws TwitterException {
        return factory.createUserList(get(conf.getRestBaseURL() + "users/lookup.json",
                                          new HttpParameter[]{new HttpParameter("screen_name", z_T4JInternalStringUtil.join(screenNames))}));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User showUser(long userId) throws TwitterException {
        return factory.createUser(get(conf.getRestBaseURL() + "users/show.json?user_id=" + userId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User showUser(String screenName) throws TwitterException {
        return factory.createUser(get(conf.getRestBaseURL() + "users/show.json?screen_name=" + screenName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseList<User> searchUsers(String query, int page) throws TwitterException {
        return factory.createUserList(get(conf.getRestBaseURL() + "users/search.json",
                                          new HttpParameter[]{new HttpParameter("q", query), new HttpParameter("per_page", 20),
                                                              new HttpParameter("page", page)}));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseList<User> getContributees(long userId) throws TwitterException {
        return factory.createUserList(get(conf.getRestBaseURL() + "users/contributees.json?user_id=" + userId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseList<User> getContributees(String screenName) throws TwitterException {
        return factory.createUserList(get(conf.getRestBaseURL() + "users/contributees.json?screen_name=" + screenName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseList<User> getContributors(long userId) throws TwitterException {
        return factory.createUserList(get(conf.getRestBaseURL() + "users/contributors.json?user_id=" + userId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseList<User> getContributors(String screenName) throws TwitterException {
        return factory.createUserList(get(conf.getRestBaseURL() + "users/contributors.json?screen_name=" + screenName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeProfileBanner() throws TwitterException {
        post(conf.getRestBaseURL() + "account/remove_profile_banner.json");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateProfileBanner(File image) throws TwitterException {
        checkFileValidity(image);
        post(conf.getRestBaseURL() + "account/update_profile_banner.json", new HttpParameter[]{new HttpParameter("banner", image)});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateProfileBanner(InputStream image) throws TwitterException {
        post(conf.getRestBaseURL() + "account/update_profile_banner.json", new HttpParameter[]{new HttpParameter("banner", "banner", image)});
    }

    @Override
    public RelatedResults getRelatedResults(long statusId) throws TwitterException {
        return factory.createRelatedResults(get("https://api.twitter.com/1/related_results/show.json?id=" + Long.toString(statusId)));
    }


    /**
     * upload status :- [pending] -> [in_progress] -> [succeeded | failed]
     *
     * @see <a href="https://dev.twitter.com/rest/reference/get/media/upload-status"> Upload Status</a>
     */
    private void waitForVideoTranscoding(String mediaId, long maxWaitTime) throws TwitterException {
        long totalWaitTime = 0;
        String url = getMediaUploadUrl();
        HttpParameter[] parameters = createChunkedUploadStatusParams(mediaId);

        while (totalWaitTime < maxWaitTime) {
            TwitterAdUtil.reallySleep(WAIT_INTERVAL_TRANSCODING);
            totalWaitTime += WAIT_INTERVAL_TRANSCODING;
            Media media = checkVideoUploadStatus(url, parameters);
            if (media.isStatePending()) {
                continue;
            }
            if (media.isStateSucceeded()) {
                return;
            } else if (!media.isStateInProgress()) {
                throw new TwitterException("Video transcoding error. Error code: " + media.getState());
            }
        }
    }

    private HttpParameter[] createChunkedUploadStatusParams(String mediaId) {
        HttpParameter[] parameters = new HttpParameter[2];
        parameters[0] = new HttpParameter(COMMAND, STATUS);
        parameters[1] = new HttpParameter(MEDIA_ID, mediaId);
        return parameters;
    }

    private void uploadVideoInChunks(String mediaId, String filePath, Long fileSize, int chunkSize) throws TwitterException {
        try (InputStream inputStream = new FileInputStream(new File(filePath))) {
            long totalBytesRead = 0l;
            for (int segmentIndex = 0; totalBytesRead < fileSize; segmentIndex++) {
                chunkSize = chunkSize < (int) (fileSize - totalBytesRead) ? chunkSize : (int) (fileSize - totalBytesRead);
                byte[] chunk = new byte[chunkSize];
                int bytesRead = inputStream.read(chunk);
                if (bytesRead == -1) {
                    throw new IOException("EOF reached..");
                }
                post(getMediaUploadUrl(), createAppendParams(mediaId, segmentIndex, chunk));
                totalBytesRead += bytesRead;
            }
        } catch (Exception e) {
            throw new TwitterException(e);
        }
    }

    private HttpParameter[] createAppendParams(String mediaId, int segmentIndex, byte[] chunk) {
        HttpParameter[] parameters = new HttpParameter[4];
        parameters[0] = new HttpParameter(COMMAND, APPEND);
        parameters[1] = new HttpParameter(MEDIA_ID, mediaId);
        parameters[2] = new HttpParameter(SEGMENT_INDEX, segmentIndex);
        parameters[3] = new HttpParameter(MEDIA, "", new ByteArrayInputStream(chunk));
        return parameters;
    }

    private String initializeChunkUpload(long fileSizeInBytes, String mediaType, String mediaCategory, String accountUserId) throws TwitterException {
        List<HttpParameter> parameters = new ArrayList<>();
        parameters.add(new HttpParameter(COMMAND, INIT));
        parameters.add(new HttpParameter(MEDIA_TYPE, mediaType));
        if (StringUtils.isNotBlank(mediaCategory)) {
            parameters.add(new HttpParameter(MEDIA_CATEGORY, mediaCategory));
        }
        parameters.add(new HttpParameter(PARAM_ADDITIONAL_OWNERS, accountUserId));
        parameters.add(new HttpParameter(TOTAL_BYTES, fileSizeInBytes));
        HttpResponse response = post(getMediaUploadUrl(), parameters.toArray(new HttpParameter[parameters.size()]));
        return new TwitterUploadMediaResponseImpl(response, conf).getMediaIdString();
    }

    private void finalizeChunkUpload(String mediaId) throws TwitterException {
        List<HttpParameter> parameters = new ArrayList<>();
        parameters.add(new HttpParameter(COMMAND, FINALIZE));
        parameters.add(new HttpParameter(MEDIA_ID, mediaId));
        post(getMediaUploadUrl(), parameters.toArray(new HttpParameter[parameters.size()]));
    }

    private String getMediaUploadUrl() {return conf.getMediaUploadBaseUrl() + "media/upload.json";}

    @Override
    String getImplicitParamsStr() {
        return IMPLICIT_PARAMS_STR;
    }

    @Override
    HttpParameter[] getImplicitParams() {
        return IMPLICIT_PARAMS;
    }

    @Override
    public String toString() {
        return "TwitterImpl{" +
               "INCLUDE_MY_RETWEET=" + INCLUDE_MY_RETWEET +
               '}';
    }
}
