package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author meghanajain
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterWebsiteCard extends AbstractTwitterCard {

    @SerializedName("website_title")
    private String websiteTitle;

    @SerializedName("website_url")
    private String websiteUrl;

    @Deprecated
    @SerializedName("image")
    private String imageUrl;

    @SerializedName("media_url")
    private String mediaUrl;

    @SerializedName("media_key")
    private String mediaKey;

    @SerializedName("image_data")
    private String imageData;

    public String getWebsiteTitle() {
        return websiteTitle;
    }

    public void setWebsiteTitle(String websiteTitle) {
        this.websiteTitle = websiteTitle;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaKey() {
        return mediaKey;
    }

    public void setMediaKey(String mediaKey) {
        this.mediaKey = mediaKey;
    }
}
