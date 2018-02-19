package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;
import twitter4jads.models.ads.TwitterEntity;

import java.util.Date;

/**
 * User: poly
 * Date: 13/06/14
 * Time: 3:50 PM
 */

public abstract class AbstractTwitterCard extends TwitterEntity {

    @SerializedName("name")
    private String name;

    @SerializedName("account_id")
    private String accountId;

    @SerializedName("card_type")
    private TwitterCardType twitterCardType;

    @SerializedName("preview_url")
    private String previewUrl;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("deleted")
    private boolean deleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public TwitterCardType getTwitterCardType() {
        return twitterCardType;
    }

    public void setTwitterCardType(TwitterCardType twitterCardType) {
        this.twitterCardType = twitterCardType;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
