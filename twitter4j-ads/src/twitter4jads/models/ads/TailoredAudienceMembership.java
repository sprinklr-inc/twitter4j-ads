package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2017 Sprinklr, Inc. All rights reserved.
 * Author: Daryl Odnert
 * Date: 25-May-2017
 */
public class TailoredAudienceMembership {
    @SerializedName("success_count")
    private Long successCount;

    public Long getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Long successCount) {
        this.successCount = successCount;
    }
}
