package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author meghanajain
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterImageAppDownloadCard extends AbstractAppCard {

    @Deprecated
    @SerializedName("wide_app_image")
    private String wideAppImage;

    @SerializedName("media_url")
    private String mediaUrl;

    @SerializedName("wide_app_image_data")
    private String wideAppImageData;

    public String getWideAppImage() {
        return wideAppImage;
    }

    public void setWideAppImage(String wideAppImage) {
        this.wideAppImage = wideAppImage;
    }

    public String getWideAppImageData() {
        return wideAppImageData;
    }

    public void setWideAppImageData(String wideAppImageData) {
        this.wideAppImageData = wideAppImageData;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
