package twitter4jads.models.media;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 16/05/16 2:00 PM.
 */
public class TwitterAccountMediaCreative {

    @SerializedName("line_item_id")
    private String lineItemId;

    @SerializedName("landing_url")
    private String landingUrl;

    @SerializedName("serving_status")
    private String servingStatus;


    @SerializedName("id")
    private String id;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("account_media_id")
    private String accountMediaId;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("approval_status")
    private String approvalStatus;

    @SerializedName("deleted")
    private boolean deleted;


    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public String getLandingUrl() {
        return landingUrl;
    }

    public void setLandingUrl(String landingUrl) {
        this.landingUrl = landingUrl;
    }

    public String getServingStatus() {
        return servingStatus;
    }

    public void setServingStatus(String servingStatus) {
        this.servingStatus = servingStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAccountMediaId() {
        return accountMediaId;
    }

    public void setAccountMediaId(String accountMediaId) {
        this.accountMediaId = accountMediaId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
