package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * User:  dheeraj
 * Date:  09/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterImageDMCard extends AbstractTwitterDMCard {

    @Deprecated
    @SerializedName("image")
    private String imageUrl;

    @SerializedName("media_url")
    private String mediaUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
