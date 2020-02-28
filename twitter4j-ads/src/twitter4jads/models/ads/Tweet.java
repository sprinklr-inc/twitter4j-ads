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

    @SerializedName("contributors")
    private String contributors;
}
