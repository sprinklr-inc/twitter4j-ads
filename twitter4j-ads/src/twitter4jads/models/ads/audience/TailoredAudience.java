package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;
import twitter4jads.models.ads.audience.TailoredAudiencePermissionLevel;
import twitter4jads.models.ads.audience.TailoredAudienceType;

import java.util.Date;
import java.util.List;

/**
 * User: abhishekanand
 * Date: 10/10/14
 * Time: 10:51 PM
 */
public class TailoredAudience extends TwitterEntity {

    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";
    public static final String NAME = "name";
    public static final String TARGETING_TYPE = "targeting_type";
    public static final String AUDIENCE_TYPE = "audience_type";
    public static final String AUDIENCE_SIZE = "audience_size";
    public static final String TARGETABLE = "targetable";
    public static final String TARGETABLE_TYPES = "targetable_types";
    public static final String REASONS_NOT_TARGETABLE = "reasons_not_targetable";
    public static final String DELETED = "deleted";
    public static final String PARTNER_SOURCE = "partner_source";
    public static final String PERMISSION_LEVEL = "permission_level";
    public static final String IS_OWNER = "is_owner";

    @SerializedName(CREATED_AT)
    private Date createdAt;

    @SerializedName(UPDATED_AT)
    private Date updatedAt;

    @SerializedName(NAME)
    private String name;

    @SerializedName(TARGETING_TYPE)
    private TargetingType targetingType;

    @SerializedName(AUDIENCE_TYPE)
    private TailoredAudienceType tailoredAudienceType;

    @SerializedName(AUDIENCE_SIZE)
    private String audienceSize;

    @SerializedName(TARGETABLE)
    private Boolean isTargetable;

    @SerializedName(TARGETABLE_TYPES)
    private List<TailoredAudienceType> targetableTypes;

    @SerializedName(REASONS_NOT_TARGETABLE)
    private List<String> reasonsNotTargetable;

    @SerializedName(DELETED)
    private Boolean deleted;

    @SerializedName(PARTNER_SOURCE)
    private String partnerSource;

    @SerializedName(PERMISSION_LEVEL)
    private TailoredAudiencePermissionLevel permissionLevel;

    @SerializedName(IS_OWNER)
    private Boolean isOwner;

    public TailoredAudiencePermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(TailoredAudiencePermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public Boolean getOwner() {
        return isOwner;
    }

    public void setOwner(Boolean owner) {
        isOwner = owner;
    }

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
