package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 10/02/17 4:11 PM.
 */
public class LineItemAppResponse {

    @SerializedName("line_item_id")
    private String lineItemId;

    @SerializedName("id")
    private String id;

    @SerializedName("app_store_identifier")
    private String appStoreIdentifier;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("os_type")
    private String osType;

    @SerializedName("deleted")
    private boolean deleted;


    public String getAppStoreIdentifier() {
        return appStoreIdentifier;
    }

    public void setAppStoreIdentifier(String appStoreIdentifier) {
        this.appStoreIdentifier = appStoreIdentifier;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
