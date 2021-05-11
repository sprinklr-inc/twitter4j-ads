package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * User: abhishekanand
 * Date: 02/08/17 8:27 PM.
 */
public class ScheduledTweet {

    @SerializedName("id")
    private String id;

    @SerializedName("id_str")
    private String idString;

    @SerializedName("completed_at")
    private String completedAt;

    @SerializedName("text")
    private String text;

    @SerializedName("user_id")
    private Long userId;

    @SerializedName("scheduled_status")
    private String scheduledStatus;

    @SerializedName("media_ids")
    private List<Long> mediaIds;

    @SerializedName("media_keys")
    private List<String> mediaKeys;

    @SerializedName("nullcast")
    private boolean nullCast;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("scheduled_at")
    private String scheduledAt;

    @SerializedName("card_uri")
    private String cardUrl;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("tweet_id")
    private String tweetId;

    //populated externally
    @SerializedName("ad_account_id")
    private String adAccountId;


    public String getCardUrl() {
        return cardUrl;
    }

    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }


    public boolean isNullCast() {
        return nullCast;
    }

    public void setNullCast(boolean nullCast) {
        this.nullCast = nullCast;
    }

    public String getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(String scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public String getScheduledStatus() {
        return scheduledStatus;
    }

    public void setScheduledStatus(String scheduledStatus) {
        this.scheduledStatus = scheduledStatus;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Long> getMediaIds() {
        return mediaIds;
    }

    public void setMediaIds(List<Long> mediaIds) {
        this.mediaIds = mediaIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAdAccountId() {
        return adAccountId;
    }

    public void setAdAccountId(String adAccountId) {
        this.adAccountId = adAccountId;
    }

    public List<String> getMediaKeys() {
        return mediaKeys;
    }

    public void setMediaKeys(List<String> mediaKeys) {
        this.mediaKeys = mediaKeys;
    }
}
