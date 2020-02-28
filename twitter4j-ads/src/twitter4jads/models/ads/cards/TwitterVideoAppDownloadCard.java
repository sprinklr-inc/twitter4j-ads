package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * User: prashant
 * Date: 27/08/15
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterVideoAppDownloadCard extends AbstractAppCard {

    @Deprecated
    @SerializedName("video_content_id")
    private String channelVideoId;

    @Deprecated
    @SerializedName("video_url")
    private String channelVideoUrl;

    @SerializedName("media_url")
    private String mediaUrl;

    @SerializedName("content_duration_seconds")
    private String channelVideoLength;

    @Deprecated
    @SerializedName("image_media_id")
    private String channelImageId;

    @Deprecated
    @SerializedName("video_poster_url")
    private String posterVideoUrl;

    @SerializedName("poster_media_url")
    private String posterMediaUrl;

    @SerializedName("poster_media_key")
    private String posterMediaKey;

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
