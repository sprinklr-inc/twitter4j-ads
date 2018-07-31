package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abhishekanand on 11/03/15.
 */
public class TwitterBehavior extends TwitterEntity {

    @SerializedName("audience_size")
    private int audienceSize;

    @SerializedName("name")
    private String name;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("partner_source")
    private String partnerSource;

    @SerializedName("behavior_taxonomy_id")
    private String behaviorTaxonomyId;

    @SerializedName("targetable_types")
    private String[] targetableTypes;

    public int getAudienceSize() {
        return audienceSize;
    }

    public void setAudienceSize(int audienceSize) {
        this.audienceSize = audienceSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartnerSource() {
        return partnerSource;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setPartnerSource(String partnerSource) {
        this.partnerSource = partnerSource;
    }

    public String getBehaviorTaxonomyId() {
        return behaviorTaxonomyId;
    }

    public void setBehaviorTaxonomyId(String behaviorTaxonomyId) {
        this.behaviorTaxonomyId = behaviorTaxonomyId;
    }

    public String[] getTargetableTypes() {
        return targetableTypes;
    }

    public void setTargetableTypes(String[] targetableTypes) {
        this.targetableTypes = targetableTypes;
    }
}
