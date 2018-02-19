package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;
import twitter4jads.models.LocationType;

import java.io.Serializable;

/**
 * User: poly
 * Date: 30/01/14
 * Time: 11:51 AM
 */
public class TargetingLocation implements Serializable, Comparable<TargetingLocation> {

    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("targeting_value")
    private String targetingValue;

    @SerializedName("targeting_type")
    private TargetingType targetingType;

    @SerializedName("location_type")
    private LocationType locationType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public TargetingType getTargetingType() {
        return targetingType;
    }

    public void setTargetingType(TargetingType targetingType) {
        this.targetingType = targetingType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    @Override
    public int compareTo(TargetingLocation o) {
        if (StringUtils.isBlank(name)) {
            return -1;
        }
        if (o == null) {
            return 1;
        }
        return this.name.compareTo(o.getName());
    }
}
