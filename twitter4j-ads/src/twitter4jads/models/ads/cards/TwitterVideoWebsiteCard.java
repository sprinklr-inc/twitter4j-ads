package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * User:  abhishekanand
 * Date:  28/08/17
 * Time:  11:31 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterVideoWebsiteCard extends AbstractTwitterCard {

    @SerializedName("title")
    private String title;

    @Deprecated
    @SerializedName("video_content_id")
    private String videoId;

    @SerializedName("media_key")
    private String mediaKey;

    @SerializedName("website_url")
    private String websiteUrl;

    @Deprecated
    @SerializedName("video_url")
    private String videoUrl;

    @SerializedName("media_url")
    private String mediaUrl;

    @Deprecated
    @SerializedName("video_hls_url")
    private String videoHlsUrl;

    @Deprecated
    @SerializedName("video_poster_url")
    private String videoPosterUrl;

    @SerializedName("poster_media_url")
    private String posterMediaUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoHlsUrl() {
        return videoHlsUrl;
    }

    @SuppressWarnings("unused")
    public void setVideoHlsUrl(String videoHlsUrl) {
        this.videoHlsUrl = videoHlsUrl;
    }

    public String getVideoPosterUrl() {
        return videoPosterUrl;
    }

    @SuppressWarnings("unused")
    public void setVideoPosterUrl(String videoPosterUrl) {
        this.videoPosterUrl = videoPosterUrl;
    }

    public String getMediaKey() {
        return mediaKey;
    }

    public void setMediaKey(String mediaKey) {
        this.mediaKey = mediaKey;
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
}
