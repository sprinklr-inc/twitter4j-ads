package twitter4jads.models.ads.preview;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 02/05/16 2:59 PM.
 */
public class TwitterPreviewInfo {

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
