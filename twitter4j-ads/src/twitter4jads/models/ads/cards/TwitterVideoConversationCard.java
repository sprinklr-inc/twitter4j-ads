package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * User: prashant
 * Date: 08/09/16.
 * Time: 1:41 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterVideoConversationCard extends AbstractConversationCard {

    @Deprecated
    @SerializedName("video_url")
    private String videoUrl;

    @SerializedName("media_url")
    private String mediaUrl;

    @SerializedName("content_duration_seconds")
    private String duration;

    @Deprecated
    @SerializedName("video_poster_url")
    private String thumbnailUrl;

    @SerializedName("poster_media_url")
    private String posterMediaUrl;

    @SerializedName("poster_media_key")
    private String posterMediaKey;

    @Deprecated
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

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getPosterMediaUrl() {
        return posterMediaUrl;
    }

    public void setPosterMediaUrl(String posterMediaUrl) {
        this.posterMediaUrl = posterMediaUrl;
    }

    public String getPosterMediaKey() {
        return posterMediaKey;
    }

    public void setPosterMediaKey(String posterMediaKey) {
        this.posterMediaKey = posterMediaKey;
    }
}
