package twitter4jads.models.ads.targeting;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 16/06/16 7:14 PM.
 */
public class TargetingParamRequest {

    @SerializedName("params")
    private TargetingParam targetingParam;

    @SerializedName("operation_type")
    private String operation;


    public TargetingParam getTargetingParam() {
        return targetingParam;
    }

    public void setTargetingParam(TargetingParam targetingParam) {
        this.targetingParam = targetingParam;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
