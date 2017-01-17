package twitter4j.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * User: prashant
 * Date: 08/09/16.
 * Time: 1:41 AM
 */
public class TwitterVideoConversationCard extends AbstractConversationCard {

    @SerializedName("video")
    private String videoUrl;

    @SerializedName("content_duration_seconds")
    private String duration;

    @SerializedName("video_poster_url")
    private String thumbnailUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
