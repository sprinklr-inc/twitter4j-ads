package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * User: abhishekanand
 * Date: 10/10/14
 * Time: 10:51 PM
 */
public class TailoredAudience extends TwitterEntity {

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("name")
    private String name;

    @SerializedName("targeting_type")
    private TargetingType targetingType;

    @SerializedName("audience_type")
    private TailoredAudienceType tailoredAudienceType;

    @SerializedName("audience_size")
    private String audienceSize;

    @SerializedName("targetable")
    private Boolean isTargetable;

    @SerializedName("targetable_types")
    private List<TailoredAudienceType> targetableTypes;

    @SerializedName("reasons_not_targetable")
    private List<String> reasonsNotTargetable;

    @SerializedName("list_type")
    private TailoredAudienceDataType tailoredAudienceDataType;

    @SerializedName("deleted")
    private Boolean deleted;

    @SerializedName("partner_source")
    private String partnerSource;

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public String getPartnerSource() {
        return partnerSource;
    }

    public void setPartnerSource(String partnerSource) {
        this.partnerSource = partnerSource;
    }

    public Boolean getTargetable() {
        return isTargetable;
    }

    public void setTargetable(Boolean targetable) {
        isTargetable = targetable;
    }

    public List<TailoredAudienceType> getTargetableTypes() {
        return targetableTypes;
    }

    public void setTargetableTypes(List<TailoredAudienceType> targetableTypes) {
        this.targetableTypes = targetableTypes;
    }

    public List<String> getReasonsNotTargetable() {
        return reasonsNotTargetable;
    }

    public void setReasonsNotTargetable(List<String> reasonsNotTargetable) {
        this.reasonsNotTargetable = reasonsNotTargetable;
    }

    public TailoredAudienceDataType getTailoredAudienceDataType() {
        return tailoredAudienceDataType;
    }

    public void setTailoredAudienceDataType(TailoredAudienceDataType tailoredAudienceDataType) {
        this.tailoredAudienceDataType = tailoredAudienceDataType;
    }

    public TailoredAudienceType getTailoredAudienceType() {
        return tailoredAudienceType;
    }

    public void setTailoredAudienceType(TailoredAudienceType tailoredAudienceType) {
        this.tailoredAudienceType = tailoredAudienceType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public TargetingType getTargetingType() {
        return targetingType;
    }

    public void setTargetingType(TargetingType targetingType) {
        this.targetingType = targetingType;
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


    public String getAudienceSize() {
        return audienceSize;
    }

    public void setAudienceSize(String audienceSize) {
        this.audienceSize = audienceSize;
    }
}
