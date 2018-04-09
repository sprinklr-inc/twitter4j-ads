package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by rootachoksi on 30/01/14.
 */
public class PromotedTweets extends TwitterEntity {

    @SerializedName("tweet_id")
    private String tweetId;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("deleted")
    private Boolean deleted;

    @SerializedName("paused")
    private Boolean paused;

    @SerializedName("line_item_id")
    private String lineItemId;

    @SerializedName("approval_status")
    private String approvalStatus;

    @SerializedName("entity_status")
    private String entityStatus;

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
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

    public Boolean getPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public String getEntityStatus() {
        return entityStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus;
    }
}
