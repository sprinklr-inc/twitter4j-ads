package twitter4j.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 13/11/17
 * Time: 9:14 PM
 */
public class TwitterVideoDmCard extends AbstractTwitterDMCard {

    @SerializedName("video_url")
    private String videoUrl;

    @SerializedName("video_owner_id")
    private String videoOwnerId;

    @SerializedName("video_content_id")
    private String videoContentId;

    @SerializedName("video_hls_url")
    private String videoHlsUrl;

    @SerializedName("video_poster_url")
    private String videoPosterUrl;

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
}
