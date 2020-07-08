package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author niketkhandelwal
 */

public class Tweet implements Serializable {

    @SerializedName("id")
    private Long id;

    @SerializedName("id_str")
    private String idStr;

    @SerializedName("tweet_id")
    private String tweetId;

    @SerializedName("coordinates")
    private String coordinates;

    @SerializedName("retweeted")
    private Boolean retweeted;

    @SerializedName("source")
    private String source;

    @SerializedName("favorite_count")
    private Long favouriteCount;

    @SerializedName("in_reply_to_status_id")
    private Long inReplyToStatusId;

    @SerializedName("in_reply_to_status_id_str")
    private String inReplyToStatusIdString;

    @SerializedName("in_reply_to_user_id")
    private Long inReplyToUserId;

    @SerializedName("in_reply_to_user_id_str")
    private String inReplyToUserIdString;

    @SerializedName("in_reply_to_screen_name")
    private String inReplyToScreenName;

    @SerializedName("truncated")
    private Boolean truncated;

    @SerializedName("retweet_count")
    private Long retweetCount;

    @SerializedName("possibly_sensitive")
    private Boolean possiblySensitive;

    @SerializedName("nullcast")
    private Boolean nullcast;

    @SerializedName("created_at")
    private String createdAtString;

    @SerializedName("scheduled_at")
    private String scheduledAtString;

    @SerializedName("scheduled_status")
    private String scheduledStsatus;

    @SerializedName("tweet_type")
    private TwitterTweetType tweetType;

    @SerializedName("favorited")
    private Boolean favorited;

    @SerializedName("full_text")
    private String fullText;

    @SerializedName("lang")
    private String lang;

    @SerializedName("user")
    private TwitterUser user;

    @SerializedName("geo")
    private String geo;

    @SerializedName("place")
    private String place;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(Long favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public Long getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(Long inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public String getInReplyToStatusIdString() {
        return inReplyToStatusIdString;
    }

    public void setInReplyToStatusIdString(String inReplyToStatusIdString) {
        this.inReplyToStatusIdString = inReplyToStatusIdString;
    }

    public Long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(Long inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public String getInReplyToUserIdString() {
        return inReplyToUserIdString;
    }

    public void setInReplyToUserIdString(String inReplyToUserIdString) {
        this.inReplyToUserIdString = inReplyToUserIdString;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public Boolean getTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    public Long getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Long retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Boolean getPossiblySensitive() {
        return possiblySensitive;
    }

    public void setPossiblySensitive(Boolean possiblySensitive) {
        this.possiblySensitive = possiblySensitive;
    }

    public Boolean getNullcast() {
        return nullcast;
    }

    public void setNullcast(Boolean nullcast) {
        this.nullcast = nullcast;
    }

    public String getCreatedAtString() {
        return createdAtString;
    }

    public void setCreatedAtString(String createdAtString) {
        this.createdAtString = createdAtString;
    }

    public String getScheduledAtString() {
        return scheduledAtString;
    }

    public void setScheduledAtString(String scheduledAtString) {
        this.scheduledAtString = scheduledAtString;
    }

    public String getScheduledStsatus() {
        return scheduledStsatus;
    }

    public void setScheduledStsatus(String scheduledStsatus) {
        this.scheduledStsatus = scheduledStsatus;
    }

    public TwitterTweetType getTweetType() {
        return tweetType;
    }

    public void setTweetType(TwitterTweetType tweetType) {
        this.tweetType = tweetType;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public TwitterUser getUser() {
        return user;
    }

    public void setUser(TwitterUser user) {
        this.user = user;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    @SerializedName("contributors")
    private String contributors;
}
