package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User:  vinit
 * Date:  09/07/18
 * Time:  2:47 PM
 */
public class Conversations extends TwitterEntity {

    @SerializedName("name")
    private String name;

    @SerializedName("targeting_value")
    private String targetingValue;

    @SerializedName("targeting_type")
    private String targetingType;

    @SerializedName("conversation_type")
    private String conversationType;

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

    public String getConversationType() {
        return conversationType;
    }

    public void setConversationType(String conversationType) {
        this.conversationType = conversationType;
    }
}
