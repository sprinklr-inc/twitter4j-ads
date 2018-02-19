package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: poly
 * Date: 11/02/14
 * Time: 11:54 AM
 */
public class Devices extends TwitterEntity{

    @SerializedName("name")
    private String name;

    @SerializedName("targeting_value")
    private String targetingValue;

    @SerializedName("targeting_type")
    private String targetingType;

    @SerializedName("manufacturer")
    private String manufacturer;

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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
