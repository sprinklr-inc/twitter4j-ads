package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * User: prashant
 * Date: 08/09/16.
 * Time: 1:38 AM
 */
public class TwitterImageConversationCard extends AbstractConversationCard {

    @SerializedName("image")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
