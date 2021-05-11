package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * User: abhishekanand
 * Date: 13/11/17
 * Time: 9:14 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterVideoDMCard extends AbstractTwitterDMCard {

    @Deprecated
    @SerializedName("video_url")
    private String videoUrl;

    @SerializedName("media_url")
    private String mediaUrl;

    @SerializedName("video_owner_id")
    private String videoOwnerId;

    @Deprecated
    @SerializedName("video_content_id")
    private String videoContentId;

    @Deprecated
    @SerializedName("video_hls_url")
    private String videoHlsUrl;

    @Deprecated
    @SerializedName("video_poster_url")
    private String videoPosterUrl;

    @SerializedName("poster_media_url")
    private String posterMediaUrl;

    @SerializedName("poster_media_key")
    private String posterMediaKey;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoOwnerId() {
        return videoOwnerId;
    }

    public void setVideoOwnerId(String videoOwnerId) {
        this.videoOwnerId = videoOwnerId;
    }

    public String getVideoContentId() {
        return videoContentId;
    }

    public void setVideoContentId(String videoContentId) {
        this.videoContentId = videoContentId;
    }

    public String getVideoHlsUrl() {
        return videoHlsUrl;
    }

    public void setVideoHlsUrl(String videoHlsUrl) {
        this.videoHlsUrl = videoHlsUrl;
    }

    public String getVideoPosterUrl() {
        return videoPosterUrl;
    }

    public void setVideoPosterUrl(String videoPosterUrl) {
        this.videoPosterUrl = videoPosterUrl;
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
