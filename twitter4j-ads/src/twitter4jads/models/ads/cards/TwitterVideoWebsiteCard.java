package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * User:  abhishekanand
 * Date:  28/08/17
 * Time:  11:31 AM
 */
public class TwitterVideoWebsiteCard extends AbstractTwitterCard {

    @SerializedName("title")
    private String title;

    @SerializedName("video_content_id")
    private String videoId;

    @SerializedName("website_url")
    private String websiteUrl;

    @SerializedName("video_url")
    private String videoUrl;

    @SerializedName("video_hls_url")
    private String videoHlsUrl;

    @SerializedName("video_poster_url")
    private String videoPosterUrl;

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
}
