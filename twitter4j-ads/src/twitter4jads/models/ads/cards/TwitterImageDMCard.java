package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * User:  dheeraj
 * Date:  09/11/17.
 */
public class TwitterImageDMCard extends AbstractTwitterDMCard {

    @SerializedName("image")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
