package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishek.chatrath
 * Date: 15/06/16.
 * Time: 8:07 PM
 */
public class TwitterCreativePreview {

    @SerializedName("platform")
    private String platform;

    @SerializedName("preview")
    private String preview;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

}
