package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * Date: 12/06/14
 * Time: 9:48 PM
 */
public class TwitterMobileAppCard extends AbstractAppCard {

    @SerializedName("custom_icon")
    private String customIcon;

    @SerializedName("custom_icon_data")
    private String customIconData;

    @SerializedName("custom_app_description")
    private String customAppDescription;

    public String getCustomIcon() {
        return customIcon;
    }

    public void setCustomIcon(String customIcon) {
        this.customIcon = customIcon;
    }

    public String getCustomIconData() {
        return customIconData;
    }

    public void setCustomIconData(String customIconData) {
        this.customIconData = customIconData;
    }

    public String getCustomAppDescription() {
        return customAppDescription;
    }

    public void setCustomAppDescription(String customAppDescription) {
        this.customAppDescription = customAppDescription;
    }
}
