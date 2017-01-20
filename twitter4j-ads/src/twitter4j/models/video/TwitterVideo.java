package twitter4j.models.video;

import com.google.gson.annotations.SerializedName;
import twitter4j.models.ads.TwitterEntity;
import twitter4j.models.ads.cards.TwitterVideoErrors;

import java.util.List;

/**
 * User: abhishekanand
 * Date: 19/04/16 1:09 PM.
 */
public class TwitterVideo extends TwitterEntity {

    @SerializedName("tweeted")
    private boolean tweeted;

    @SerializedName("ready_to_tweet")
    private boolean readyToTweet;

    @SerializedName("duration")
    private Long duration;

    @SerializedName("reasons_not_servable")
    private List<TwitterVideoErrors> reasonsNotServable;

    @SerializedName("description")
    private String description;

    @SerializedName("preview_url")
    private String previewUrl;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("title")
    private String title;

    @SerializedName("updated_at")
    private String updatedAt;

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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
