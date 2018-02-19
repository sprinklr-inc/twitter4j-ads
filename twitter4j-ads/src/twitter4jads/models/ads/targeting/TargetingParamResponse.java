package twitter4jads.models.ads.targeting;

import com.google.gson.annotations.SerializedName;
import twitter4jads.models.ads.TargetingCriteria;

import java.util.List;

/**
 * User: abhishekanand
 * Date: 17/06/16 2:59 PM.
 */
public class TargetingParamResponse {

    @SerializedName("request")
    private List<TargetingParamRequest> paramRequestList;

    @SerializedName("data")
    private List<TargetingCriteria> targetingCriterias;

    @SerializedName("operation_errors")
    private List<TargetingParamError> errorsList;

    public List<TargetingParamRequest> getParamRequestList() {
        return paramRequestList;
    }

    public void setParamRequestList(List<TargetingParamRequest> paramRequestList) {
        this.paramRequestList = paramRequestList;
    }

    public List<TargetingParamError> getErrorsList() {
        return errorsList;
    }

    public void setErrorsList(List<TargetingParamError> errorsList) {
        this.errorsList = errorsList;
    }

    public List<TargetingCriteria> getTargetingCriterias() {
        return targetingCriterias;
    }

    public void setTargetingCriterias(List<TargetingCriteria> targetingCriterias) {
        this.targetingCriterias = targetingCriterias;
    }
}
