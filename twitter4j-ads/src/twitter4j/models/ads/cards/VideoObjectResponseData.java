package twitter4j.models.ads.cards;

import com.google.api.client.util.DateTime;
import com.google.gson.annotations.SerializedName;
import twitter4j.models.ads.TwitterEntity;

import java.util.List;

/**
 * User: prashant
 * Date: 28/08/15
 */
public class VideoObjectResponseData extends TwitterEntity {

    @SerializedName("tweeted")
    private boolean tweeted;

    @SerializedName("ready_to_tweet")
    private boolean readyToTweet;

    @SerializedName("duration")
    private String duration;

    @SerializedName("reasons_not_servable")
    private List<TwitterVideoErrors> reasonsNotServable;

    @SerializedName("description")
    private String description;

    @SerializedName("preview_url")
    private String previewUrl;

    @SerializedName("created_at")
    private DateTime createdAt;

    @SerializedName("updated_at")
    private DateTime updatedAt;

    @SerializedName("title")
    private String title;

    @SerializedName("deleted")
    private boolean deleted;

    public boolean isTweeted() {
        return tweeted;
    }

    public void setTweeted(boolean tweeted) {
        this.tweeted = tweeted;
    }

    public boolean isReadyToTweet() {
        return readyToTweet;
    }

    public void setReadyToTweet(boolean readyToTweet) {
        this.readyToTweet = readyToTweet;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<TwitterVideoErrors> getReasonsNotServable() {
        return reasonsNotServable;
    }

    public void setReasonsNotServable(List<TwitterVideoErrors> reasonsNotServable) {
        this.reasonsNotServable = reasonsNotServable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
