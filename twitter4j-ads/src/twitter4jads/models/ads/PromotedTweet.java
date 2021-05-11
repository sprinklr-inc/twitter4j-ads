package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;
import twitter4jads.internal.models4j.GeoLocation;
import twitter4jads.internal.models4j.HashtagEntity;
import twitter4jads.internal.models4j.MediaEntity;
import twitter4jads.internal.models4j.Place;
import twitter4jads.internal.models4j.RateLimitStatus;
import twitter4jads.internal.models4j.Status;
import twitter4jads.internal.models4j.TweetScope;
import twitter4jads.internal.models4j.URLEntity;
import twitter4jads.internal.models4j.User;
import twitter4jads.internal.models4j.UserMentionEntity;
import twitter4jads.internal.org.json.JSONObject;

import java.util.Date;

/**
 * User: prashant
 * Date: 19/05/16.
 * Time: 9:54 PM
 */
public class PromotedTweet implements Status {

    @SerializedName("id")
    private Long id;

    @SerializedName("id_str")
    private String idStr;

    @SerializedName("text")
    private String text;

    @SerializedName("source")
    private String source;

    @SerializedName("truncated")
    private boolean truncated;

    @SerializedName("lang")
    private String language;

    @Override
    public Date getCreatedAt() {
        return null;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public String getUnEscapedText() {
        return null;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public boolean isTruncated() {
        return truncated;
    }

    @Override
    public long getInReplyToStatusId() {
        return 0;
    }

    @Override
    public long getInReplyToUserId() {
        return 0;
    }

    @Override
    public String getInReplyToScreenName() {
        return null;
    }

    @Override
    public GeoLocation getGeoLocation() {
        return null;
    }

    @Override
    public Place getPlace() {
        return null;
    }

    @Override
    public boolean isFavorited() {
        return false;
    }

    @Override
    public String getIdStr() {
        return idStr;
    }

    @Override
    public String getInReplyToUserIdStr() {
        return null;
    }

    @Override
    public String getInReplyToStatusIdStr() {
        return null;
    }

    @Override
    public TweetScope getScopes() {
        return null;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public boolean isRetweet() {
        return false;
    }

    @Override
    public Status getRetweetedStatus() {
        return null;
    }

    @Override
    public Status getQuotedStatus() {
        return null;
    }

    @Override
    public long getQuotedStatusId() {
        return 0;
    }

    @Override
    public String getQuotedStatusIdStr() {
        return null;
    }

    @Override
    public String getFullText() {
        return text;
    }

    @Override
    public String[] getDisplayTextRange() {
        return null;
    }

    @Override
    public Status getExtendedTweet() {
        return null;
    }


    @Override
    public long[] getContributors() {
        return new long[0];
    }

    @Override
    public long getRetweetCount() {
        return 0;
    }

    @Override
    public long getFavoriteCount() {
        return 0;
    }

    @Override
    public boolean isRetweetedByMe() {
        return false;
    }

    @Override
    public long getCurrentUserRetweetId() {
        return 0;
    }

    @Override
    public boolean isPossiblySensitive() {
        return false;
    }

    @Override
    public String[] getPlaceIds() {
        return new String[0];
    }

    @Override
    public void setHierarchicalMessage(Boolean hierarchicalMessage) {
        //do nothing
    }

    @Override
    public Boolean getHierarchicalMessage() {
        return null;
    }

    @Override
    public String getHierarchicalMessageId() {
        return null;
    }

    @Override
    public void setHierarchicalMessageId(String statusId) {
        //do nothing
    }

    @Override
    public int compareTo(Status otherStatus) {
        return 0;
    }

    @Override
    public UserMentionEntity[] getUserMentionEntities() {
        return new UserMentionEntity[0];
    }

    @Override
    public URLEntity[] getURLEntities() {
        return new URLEntity[0];
    }

    @Override
    public HashtagEntity[] getHashtagEntities() {
        return new HashtagEntity[0];
    }

    @Override
    public MediaEntity[] getMediaEntities() {
        return new MediaEntity[0];
    }

    @Override
    public MediaEntity[] getExtendedMediaEntities() {
        return new MediaEntity[0];
    }

    @Override
    public JSONObject getJSONObject() {
        return null;
    }

    @Override
    public String getRawJSON() {
        return null;
    }

    @Override
    public RateLimitStatus getRateLimitStatus() {
        return null;
    }

    @Override
    public int getAccessLevel() {
        return 0;
    }

    @Override
    public String getCardUri() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
