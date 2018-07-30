/*
 * Copyright 2007 Yusuke Yamamoto
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

package twitter4jads.internal.json;

import org.apache.commons.lang3.StringUtils;
import twitter4jads.conf.Configuration;
import twitter4jads.internal.http.HttpResponse;
import twitter4jads.internal.logging.Logger;
import twitter4jads.internal.models4j.*;
import twitter4jads.internal.org.json.JSONArray;
import twitter4jads.internal.org.json.JSONException;
import twitter4jads.internal.org.json.JSONObject;

import java.util.Arrays;
import java.util.Date;

import static twitter4jads.internal.json.z_T4JInternalParseUtil.*;

/**
 * A data class representing one single status of a user.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class StatusJSONImpl extends TwitterResponseImpl implements Status, java.io.Serializable, JSONResponse {
    private static final Logger logger = Logger.getLogger(StatusJSONImpl.class);
    private static final long serialVersionUID = 7548618898682727465L;

    private Date createdAt;
    private long id;
    private String idStr;
    private String inReplyToUserIdStr;
    private String inReplyToStatusIdStr;
    private String text;
    private String actualText;
    private String fullText;
    private String[] displayTextRange;
    private String source;
    private boolean isTruncated;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private boolean isFavorited;
    private String inReplyToScreenName;
    private GeoLocation geoLocation = null;
    private Place place = null;
    private long retweetCount;
    private long favoriteCount;
    private boolean isPossiblySensitive;

    private long[] contributorsIDs;

    private Status retweetedStatus;
    private Status quotedStatus;
    private Status extendedTweet;
    private long quotedStatusId;
    private String quotedStatusIdStr;
    private UserMentionEntity[] userMentionEntities;
    private URLEntity[] urlEntities;
    private HashtagEntity[] hashtagEntities;
    private MediaEntity[] mediaEntities;
    private MediaEntity[] extendedMediaEntities;
    private long currentUserRetweetId = -1L;
    private String[] placeIds;
    private TweetScope scopes;
    private String language;

    private Boolean hierarchicalMessage = false;

    /*package*/StatusJSONImpl(HttpResponse res, Configuration conf) throws TwitterException {
        super(res);
        init(getJSONObject());
        if (conf.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, getJSONObject());
        }
    }

    /*package*/StatusJSONImpl(JSONObject json, Configuration conf) throws TwitterException {
        super(json);
        init(json);
        if (conf.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(this, json);
        }
    }

    public StatusJSONImpl(JSONObject json) throws TwitterException {
        super(json);
        init(json);
    }

    /* Only for serialization purposes. */
    /*package*/ StatusJSONImpl() {

    }

    private void init(JSONObject json) throws TwitterException {
        id = getLong("id", json);
        idStr = getRawString("id_str", json);
        source = getUnescapedString("source", json);
        createdAt = getDate("created_at", json);
        isTruncated = getBoolean("truncated", json);
        inReplyToStatusId = getLong("in_reply_to_status_id", json);
        inReplyToStatusIdStr = getRawString("in_reply_to_status_id_str", json);
        quotedStatusId = getLong("quoted_status_id", json);
        quotedStatusIdStr = getRawString("quoted_status_id_str", json);
        inReplyToUserId = getLong("in_reply_to_user_id", json);
        inReplyToUserIdStr = getRawString("in_reply_to_user_id_str", json);
        isFavorited = getBoolean("favorited", json);
        inReplyToScreenName = getUnescapedString("in_reply_to_screen_name", json);
        retweetCount = getLong("retweet_count", json);
        favoriteCount = getLong("favorite_count", json);
        isPossiblySensitive = getBoolean("possibly_sensitive", json);
        try {
            if (!json.isNull("user")) {
                user = new UserJSONImpl(json.getJSONObject("user"));
            }
            geoLocation = z_T4JInternalJSONImplFactory.createGeoLocation(json);
            if (!json.isNull("place")) {
                place = new PlaceJSONImpl(json.getJSONObject("place"));
            }

            if (!json.isNull("retweeted_status")) {
                retweetedStatus = new StatusJSONImpl(json.getJSONObject("retweeted_status"));
            }

            if (!json.isNull("quoted_status")) {
                quotedStatus = new StatusJSONImpl(json.getJSONObject("quoted_status"));
            }

            if (!json.isNull("contributors")) {
                JSONArray contributorsArray = json.getJSONArray("contributors");
                contributorsIDs = new long[contributorsArray.length()];
                for (int i = 0; i < contributorsArray.length(); i++) {
                    contributorsIDs[i] = Long.parseLong(contributorsArray.getString(i));
                }
            } else {
                contributorsIDs = new long[0];
            }
            language = getRawString("lang", json);
            if (!json.isNull("scopes")) {
                JSONObject scopes = json.getJSONObject("scopes");
                if (!scopes.isNull("place_ids")) {
                    JSONArray placeIdArray = scopes.getJSONArray("place_ids");
                    int len = placeIdArray.length();
                    placeIds = new String[len];
                    for (int i = 0; i < len; i++) {
                        placeIds[i] = placeIdArray.getString(i);
                    }
                }
            }
            if (!json.isNull("entities")) {
                JSONObject entities = json.getJSONObject("entities");
                int len;
                if (!entities.isNull("user_mentions")) {
                    JSONArray userMentionsArray = entities.getJSONArray("user_mentions");
                    len = userMentionsArray.length();
                    userMentionEntities = new UserMentionEntity[len];
                    for (int i = 0; i < len; i++) {
                        userMentionEntities[i] = new UserMentionEntityJSONImpl(userMentionsArray.getJSONObject(i));
                    }
                }
                if (!entities.isNull("urls")) {
                    JSONArray urlsArray = entities.getJSONArray("urls");
                    len = urlsArray.length();
                    urlEntities = new URLEntity[len];
                    for (int i = 0; i < len; i++) {
                        urlEntities[i] = new URLEntityJSONImpl(urlsArray.getJSONObject(i));
                    }
                }

                if (!entities.isNull("hashtags")) {
                    JSONArray hashtagsArray = entities.getJSONArray("hashtags");
                    len = hashtagsArray.length();
                    hashtagEntities = new HashtagEntity[len];
                    for (int i = 0; i < len; i++) {
                        hashtagEntities[i] = new HashtagEntityJSONImpl(hashtagsArray.getJSONObject(i));
                    }
                }

                if (!entities.isNull("media")) {
                    JSONArray mediaArray = entities.getJSONArray("media");
                    len = mediaArray.length();
                    mediaEntities = new MediaEntity[len];
                    for (int i = 0; i < len; i++) {
                        mediaEntities[i] = new MediaEntityJSONImpl(mediaArray.getJSONObject(i));
                    }
                }
            }

            if (!json.isNull("extended_entities")) {
                JSONObject entities = json.getJSONObject("extended_entities");
                int len;
                if (!entities.isNull("media")) {
                    JSONArray mediaArray = entities.getJSONArray("media");
                    len = mediaArray.length();
                    extendedMediaEntities = new MediaEntity[len];
                    for (int i = 0; i < len; i++) {
                        extendedMediaEntities[i] = new MediaEntityJSONImpl(mediaArray.getJSONObject(i));
                    }
                }
            }

            if (!json.isNull("display_text_range")) {
                JSONArray displayTextRangeArray = json.getJSONArray("display_text_range");
                int len = displayTextRangeArray.length();
                displayTextRange = new String[len];
                for (int i = 0; i < len; i++) {
                    displayTextRange[i] = displayTextRangeArray.getString(i);
                }
            }

            userMentionEntities = userMentionEntities == null ? new UserMentionEntity[0] : userMentionEntities;
            urlEntities = urlEntities == null ? new URLEntity[0] : urlEntities;
            hashtagEntities = hashtagEntities == null ? new HashtagEntity[0] : hashtagEntities;
            mediaEntities = mediaEntities == null ? new MediaEntity[0] : mediaEntities;
            extendedMediaEntities = extendedMediaEntities == null ? mediaEntities : extendedMediaEntities;

            fullText = getRawString("full_text", json);
            actualText = getRawString("text", json);

            if (fullText != null) {
                actualText = fullText;
            }

            if (!json.isNull("current_user_retweet")) {
                currentUserRetweetId = json.getJSONObject("current_user_retweet").getLong("id");
            }

            if (!json.isNull("extended_tweet")) {
                extendedTweet = new StatusJSONImpl(json.getJSONObject("extended_tweet"));
                String extendedTweetText = StringUtils.isNotEmpty(extendedTweet.getFullText()) ? extendedTweet.getFullText() : extendedTweet.getText();
                if (extendedTweet != null && StringUtils.isNotEmpty(extendedTweetText)) {
                    actualText = extendedTweet.getFullText();
                    userMentionEntities = extendedTweet.getUserMentionEntities();
                    urlEntities = extendedTweet.getURLEntities();
                    hashtagEntities = extendedTweet.getHashtagEntities();
                    mediaEntities = extendedTweet.getMediaEntities();
                    extendedMediaEntities = extendedTweet.getExtendedMediaEntities();
                }

            }

            text = HTMLEntity.unescapeAndSlideEntityIncdices(actualText, userMentionEntities, urlEntities, hashtagEntities, mediaEntities);

        } catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }

    @Override
    public int compareTo(Status that) {
        long delta = this.id - that.getId();
        if (delta < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (delta > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) delta;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getCreatedAt() {
        return this.createdAt;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getFullText() {
        return fullText;
    }

    @Override
    public String[] getDisplayTextRange() {
        return displayTextRange;
    }

    @Override
    public Status getExtendedTweet() {
        return extendedTweet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        return this.actualText;
    }

    @Override
    public String getUnEscapedText() {
        return this.text;
    }

    @Override
    public String getLanguage() {
        return this.language;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSource() {
        return this.source;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTruncated() {
        return isTruncated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getInReplyToUserId() {
        return inReplyToUserId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Place getPlace() {
        return place;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long[] getContributors() {
        return contributorsIDs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFavorited() {
        return isFavorited;
    }


    private User user = null;

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser() {
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRetweet() {
        return retweetedStatus != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status getRetweetedStatus() {
        return retweetedStatus;
    }

    @Override
    public Status getQuotedStatus() {
        return quotedStatus;
    }

    @Override
    public long getQuotedStatusId() {
        return quotedStatusId;
    }

    @Override
    public String getQuotedStatusIdStr() {
        return quotedStatusIdStr;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getRetweetCount() {
        return retweetCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getFavoriteCount() {
        return favoriteCount;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRetweetedByMe() {
        return currentUserRetweetId != -1L;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getCurrentUserRetweetId() {
        return currentUserRetweetId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPossiblySensitive() {
        return isPossiblySensitive;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserMentionEntity[] getUserMentionEntities() {
        return userMentionEntities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public URLEntity[] getURLEntities() {
        return urlEntities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashtagEntity[] getHashtagEntities() {
        return hashtagEntities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MediaEntity[] getMediaEntities() {
        return mediaEntities;
    }

    @Override
    public MediaEntity[] getExtendedMediaEntities() {
        return extendedMediaEntities;
    }

    public String[] getPlaceIds() {
        return placeIds;
    }

    public void setPlaceIds(String[] placeIds) {
        this.placeIds = placeIds;
    }

    public static ResponseList<Status> createStatusList(HttpResponse res, Configuration conf) throws TwitterException {
        try {
            if (conf.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            JSONArray list = res.asJSONArray();
            int size = list.length();
            ResponseList<Status> statuses = new ResponseListImpl<Status>(size, res);
            for (int i = 0; i < size; i++) {
                JSONObject json = list.getJSONObject(i);
                Status status = new StatusJSONImpl(json);
                if (conf.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(status, json);
                }
                statuses.add(status);
            }
            if (conf.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(statuses, list);
            }
            return statuses;
        } catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }

    public static ResponseList<Status> parseStatuses(Configuration conf, JSONArray list) throws JSONException, TwitterException {
        if (conf.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
        }
        int size = list.length();
        ResponseList<Status> statuses = new ResponseListImpl<Status>(size, null);
        for (int i = 0; i < size; i++) {
            JSONObject json = list.getJSONObject(i);
            Status status = new StatusJSONImpl(json);
            if (conf.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(status, json);
            }
            statuses.add(status);
        }
        if (conf.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(statuses, list);
        }
        return statuses;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj instanceof Status && ((Status) obj).getId() == this.id;
    }

    @Override
    public String getIdStr() {
        return idStr;
    }

    @Override
    public String getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    @Override
    public String getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    public TweetScope getScopes() {
        return scopes;
    }

    public void setScopes(TweetScope scopes) {
        this.scopes = scopes;
    }

    @Override
    public Boolean getHierarchicalMessage() {
        return hierarchicalMessage;
    }

    @Override
    public void setHierarchicalMessage(Boolean hierarchicalMessage) {
        this.hierarchicalMessage = hierarchicalMessage;
    }

    @Override
    public String toString() {
        return "StatusJSONImpl{" +
               "createdAt=" + createdAt +
               ", id=" + id +
               ", idStr='" + idStr + '\'' +
               ", inReplyToUserIdStr='" + inReplyToUserIdStr + '\'' +
               ", inReplyToStatusIdStr='" + inReplyToStatusIdStr + '\'' +
               ", text='" + text + '\'' +
               ", actualText='" + actualText + '\'' +
               ", fullText='" + fullText + '\'' +
               ", displayTextRange=" + Arrays.toString(displayTextRange) +
               ", source='" + source + '\'' +
               ", isTruncated=" + isTruncated +
               ", inReplyToStatusId=" + inReplyToStatusId +
               ", inReplyToUserId=" + inReplyToUserId +
               ", isFavorited=" + isFavorited +
               ", inReplyToScreenName='" + inReplyToScreenName + '\'' +
               ", geoLocation=" + geoLocation +
               ", place=" + place +
               ", retweetCount=" + retweetCount +
               ", favoriteCount=" + favoriteCount +
               ", isPossiblySensitive=" + isPossiblySensitive +
               ", contributorsIDs=" + Arrays.toString(contributorsIDs) +
               ", retweetedStatus=" + retweetedStatus +
               ", quotedStatus=" + quotedStatus +
               ", extendedTweet=" + extendedTweet +
               ", quotedStatusId=" + quotedStatusId +
               ", quotedStatusIdStr='" + quotedStatusIdStr + '\'' +
               ", userMentionEntities=" + Arrays.toString(userMentionEntities) +
               ", urlEntities=" + Arrays.toString(urlEntities) +
               ", hashtagEntities=" + Arrays.toString(hashtagEntities) +
               ", mediaEntities=" + Arrays.toString(mediaEntities) +
               ", extendedMediaEntities=" + Arrays.toString(extendedMediaEntities) +
               ", currentUserRetweetId=" + currentUserRetweetId +
               ", placeIds=" + Arrays.toString(placeIds) +
               ", scopes=" + scopes +
               ", language='" + language + '\'' +
               ", hierarchicalMessage=" + hierarchicalMessage +
               ", user=" + user +
               '}';
    }
}
