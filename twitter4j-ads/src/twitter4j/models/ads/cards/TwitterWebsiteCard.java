package twitter4j.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * @author meghanajain
 */
public class TwitterWebsiteCard extends AbstractTwitterCard {

    @SerializedName("website_title")
    private String websiteTitle;

    @SerializedName("website_url")
    private String websiteUrl;

    @SerializedName("image")
    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }
}
