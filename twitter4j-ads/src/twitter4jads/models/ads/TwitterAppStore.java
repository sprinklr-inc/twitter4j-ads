package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 04/05/15 6:31 PM.
 */
public class TwitterAppStore extends TwitterEntity {

    public static final String NAME = "name";
    public static final String OS_TYPE = "os_type";
    public static final String TARGETING_TYPE = "targeting_type";
    public static final String TARGETING_VALUE = "targeting_value";

    @SerializedName(NAME)
    private String name;

    @SerializedName(OS_TYPE)
    private TwitterOSType osType;

    @SerializedName(TARGETING_TYPE)
    private TargetingType targetingType;

    @SerializedName(TARGETING_VALUE)
    private String targetingValue;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TwitterOSType getOsType() {
        return osType;
    }

    public void setOsType(TwitterOSType osType) {
        this.osType = osType;
    }

    public TargetingType getTargetingType() {
        return targetingType;
    }

    public void setTargetingType(TargetingType targetingType) {
        this.targetingType = targetingType;
    }

    public String getTargetingValue() {
        return targetingValue;
    }

    public void setTargetingValue(String targetingValue) {
        this.targetingValue = targetingValue;
    }
}
