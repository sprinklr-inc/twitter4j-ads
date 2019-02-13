package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * User: prashant
 * Date: 08/09/16.
 * Time: 1:41 AM
 */
public class TwitterVideoConversationCard extends AbstractConversationCard {

    @SerializedName("video_url")
    private String videoUrl;

    @SerializedName("content_duration_seconds")
    private String duration;

    @SerializedName("video_poster_url")
    private String thumbnailUrl;

    @SerializedName("video_content_id")
    private String videoId;

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

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
