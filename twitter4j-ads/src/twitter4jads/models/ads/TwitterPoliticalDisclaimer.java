package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TwitterPoliticalDisclaimer {

    @SerializedName("id")
    private String id;

    @SerializedName("sponsorship_type")
    private TwitterSponsorshipType sponsorshipType;

    @SerializedName("disclaimer_type")
    private TwitterAgreementType disclaimerType;

    @SerializedName("paid_for_by")
    private String paidForBy;

    @SerializedName("paid_for_by_website")
    private String paidForByWebsite;

    @SerializedName("authorized_by")
    private String authorizedBy;

    @SerializedName("campaign_id")
    private String campaignId;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("deleted")
    private boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    public String getPaidForBy() {
        return paidForBy;
    }

    public void setPaidForBy(String paidForBy) {
        this.paidForBy = paidForBy;
    }

    public String getPaidForByWebsite() {
        return paidForByWebsite;
    }

    public void setPaidForByWebsite(String paidForByWebsite) {
        this.paidForByWebsite = paidForByWebsite;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public TwitterSponsorshipType getSponsorshipType() {
        return sponsorshipType;
    }

    public void setSponsorshipType(TwitterSponsorshipType sponsorshipType) {
        this.sponsorshipType = sponsorshipType;
    }

    public TwitterAgreementType getDisclaimerType() {
        return disclaimerType;
    }

    public void setDisclaimerType(TwitterAgreementType disclaimerType) {
        this.disclaimerType = disclaimerType;
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

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }
}