package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * User: prashant
 * Date: 27/08/15
 */
public class TwitterVideoAppDownloadCard extends AbstractAppCard {
    @SerializedName("video_content_id")
    private String channelVideoId;

    @SerializedName("video_url")
    private String channelVideoUrl;

    @SerializedName("content_duration_seconds")
    private String channelVideoLength;

    @SerializedName("image_media_id")
    private String channelImageId;

    public String getChannelVideoId() {
        return channelVideoId;
    }

    public void setChannelVideoId(String channelVideoId) {
        this.channelVideoId = channelVideoId;
    }

    public String getChannelVideoUrl() {
        return channelVideoUrl;
    }

    public void setChannelVideoUrl(String channelVideoUrl) {
        this.channelVideoUrl = channelVideoUrl;
    }

    public String getChannelVideoLength() {
        return channelVideoLength;
    }

    public void setChannelVideoLength(String channelVideoLength) {
        this.channelVideoLength = channelVideoLength;
    }

    public String getChannelImageId() {
        return channelImageId;
    }

    public void setChannelImageId(String channelImageId) {
        this.channelImageId = channelImageId;
    }

    public String getPosterVideoUrl() {
        return posterVideoUrl;
    }

    public void setPosterVideoUrl(String posterVideoUrl) {
        this.posterVideoUrl = posterVideoUrl;
    }

    @SerializedName("video_poster_url")
    private String posterVideoUrl;
}
