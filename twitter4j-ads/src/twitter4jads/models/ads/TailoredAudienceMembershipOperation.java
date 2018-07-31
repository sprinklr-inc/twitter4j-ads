package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2017 Sprinklr, Inc. All rights reserved.
 * Author: Daryl Odnert
 * Date: 26-May-2017
 */
public class TailoredAudienceMembershipOperation {
    @SerializedName("operation_type")
    String operationType;

    @SerializedName("params")
    TailoredAudienceMembershipParams params;

    public TailoredAudienceMembershipOperation() { }

    public TailoredAudienceMembershipOperation(String operationType, TailoredAudienceMembershipParams params) {
        this.operationType = operationType;
        this.params = params;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public TailoredAudienceMembershipParams getParams() {
        return params;
    }

    public void setParams(TailoredAudienceMembershipParams params) {
        this.params = params;
    }
}
