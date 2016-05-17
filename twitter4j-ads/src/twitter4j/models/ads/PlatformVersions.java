package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: poly
 * Date: 11/02/14
 * Time: 11:53 AM
 */
public class PlatformVersions extends TwitterEntity{

    @SerializedName("name")
    private String name;

    @SerializedName("targeting_value")
    private String targetingValue;

    @SerializedName("targeting_type")
    private String targetingType;

    @SerializedName("number")
    private String number;

    @SerializedName("platform")
    private String platform;

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
}
