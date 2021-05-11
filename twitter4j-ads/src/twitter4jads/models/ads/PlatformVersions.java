package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * User: poly
 * Date: 11/02/14
 * Time: 11:53 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformVersions extends TwitterEntity{

    @SerializedName("name")
    private String name;

    @SerializedName("targeting_value")
    private String targetingValue;

    @SerializedName("targeting_type")
    private String targetingType;

    @SerializedName("number")
    private String number;

    @Deprecated
    @SerializedName("platform")
    private String platform;

    @SerializedName("os_type")
    private String osType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetingValue() {
        return targetingValue;
    }

    public void setTargetingValue(String targetingValue) {
        this.targetingValue = targetingValue;
    }

    public String getTargetingType() {
        return targetingType;
    }

    public void setTargetingType(String targetingType) {
        this.targetingType = targetingType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }
}
