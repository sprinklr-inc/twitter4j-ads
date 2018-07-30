package twitter4jads.models.ads;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Copyright (c) 2016-2017 Sprinklr, Inc. All rights reserved.
 * Created with Intellij IDEA.
 * User: ratneshjd
 * Date: 12/01/17
 * Time: 4:21 PM
 */

public class TailoredAudiencePermission extends TwitterEntity {
    public static final String GRANTED_ACCOUNT_ID = "granted_account_id";
    public static final String PERMISSION_LEVEL = "permission_level";
    public static final String DELETED = "deleted";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";

    @SerializedName(GRANTED_ACCOUNT_ID)
    private String grantedAccountId;
    @SerializedName(PERMISSION_LEVEL)
    private TailoredAudiencePermissionLevel permissionLevel;
    @SerializedName(DELETED)
    private Boolean deleted;
    @SerializedName(CREATED_AT)
    private Date timeCreated;
    @SerializedName(UPDATED_AT)
    private Date timeUpdated;

    public TailoredAudiencePermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(TailoredAudiencePermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public String getGrantedAccountId() {

        return grantedAccountId;
    }

    public void setGrantedAccountId(String grantedAccountId) {
        this.grantedAccountId = grantedAccountId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
