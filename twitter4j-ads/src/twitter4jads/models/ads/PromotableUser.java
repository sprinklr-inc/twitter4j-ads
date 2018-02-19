package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * User: poly
 * Date: 30/01/14
 * Time: 11:52 AM
 */
public class PromotableUser extends TwitterEntity {

    @SerializedName("account_id")
    private String accountId;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("promotable_user_type")
    private String promotableUserType;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("deleted")
    private Boolean deleted;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPromotableUserType() {
        return promotableUserType;
    }

    public void setPromotableUserType(String promotableUserType) {
        this.promotableUserType = promotableUserType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
