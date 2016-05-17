package twitter4j.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * @author meghanajain
 */
public class TwitterImageAppDownloadCard extends AbstractAppCard{

    @SerializedName("wide_app_image")
    private String wideAppImage;

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
}
