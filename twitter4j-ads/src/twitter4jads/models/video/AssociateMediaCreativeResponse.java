package twitter4jads.models.video;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 19/04/16 7:05 PM.
 */
public class AssociateMediaCreativeResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("landing_url")
    private String landingUrl;

    @SerializedName("approval_status")
    private String approvalStatus;

    @SerializedName("account_media_id")
    private String accountMediaId;

    @SerializedName("deleted")
    private boolean deleted;

    @SerializedName("line_item_id")
    private String lineItemId;

    @SerializedName("serving_status")
    private String servingStatus;


    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLandingUrl() {
        return landingUrl;
    }

    public void setLandingUrl(String landingUrl) {
        this.landingUrl = landingUrl;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getAccountMediaId() {
        return accountMediaId;
    }

    public void setAccountMediaId(String accountMediaId) {
        this.accountMediaId = accountMediaId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public String getServingStatus() {
        return servingStatus;
    }

    public void setServingStatus(String servingStatus) {
        this.servingStatus = servingStatus;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
