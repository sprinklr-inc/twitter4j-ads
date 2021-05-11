package twitter4jads.impl;

import com.google.gson.annotations.SerializedName;

/**
 * Twitter V4 Audience API operation payload structure
 * User: mayankbhargava
 *
 * @date 25/11/18
 * @time 10:19 PM
 */
class NewAdsAudienceApiOperation {

    @SerializedName("operation_type")
    private String operationType;

    @SerializedName("params")
    private NewAdsAudienceApiParams params;

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public NewAdsAudienceApiParams getParams() {
        return params;
    }

    public void setParams(NewAdsAudienceApiParams params) {
        this.params = params;
    }
}
