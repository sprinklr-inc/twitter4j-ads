package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

public class TwitterPoliticalAgreement {

    @SerializedName("id")
    private String id;

    @SerializedName("msa_url")
    private String msaUrl;

    @SerializedName("agreement_type")
    private TwitterAgreementType agreementType;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("servable_market")
    private String servableMarket;

    @SerializedName("deleted")
    private boolean deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsaUrl() {
        return msaUrl;
    }

    public void setMsaUrl(String msaUrl) {
        this.msaUrl = msaUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getServableMarket() {
        return servableMarket;
    }

    public void setServableMarket(String servableMarket) {
        this.servableMarket = servableMarket;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public TwitterAgreementType getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(TwitterAgreementType agreementType) {
        this.agreementType = agreementType;
    }
}
