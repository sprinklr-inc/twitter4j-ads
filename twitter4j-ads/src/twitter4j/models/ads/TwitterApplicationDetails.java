package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User:  dheeraj
 * Date:  09/09/15.
 */
public class TwitterApplicationDetails {
    @SerializedName("app_store_identifier")
    private String appIdentifier;

    @SerializedName("os_type")
    private String osType;

    public String getAppIdentifier() {
        return appIdentifier;
    }

    public void setAppIdentifier(String appIdentifier) {
        this.appIdentifier = appIdentifier;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }
}
