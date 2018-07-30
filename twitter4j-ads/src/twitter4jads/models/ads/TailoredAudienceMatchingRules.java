package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2016-2017 Sprinklr, Inc. All rights reserved.
 * Created with Intellij IDEA.
 * User: ratneshjd
 * Date: 03/04/17
 * Time: 11:51 AM
 */
public class TailoredAudienceMatchingRules extends TwitterEntity {

    public static final String TAILORED_AUDIENCE_ID = "tailored_audience_id";
    public static final String WEBSITE_TAG_ID = "website_tag_id";
    public static final String RULE_TYPE = "rule_type";
    private static final String RULE_VALUE = "rule_value";
    private static final String DELETED = "deleted";


    @SerializedName(TAILORED_AUDIENCE_ID)
    private String tailoredAudienceId;

    @SerializedName(WEBSITE_TAG_ID)
    private String websiteTagId;

    @SerializedName(RULE_TYPE)
    private TailoredAudienceMatchingRuleType ruleType;

    @SerializedName(RULE_VALUE)
    private String ruleValue;

    @SerializedName(DELETED)
    private Boolean deleted;

    public String getTailoredAudienceId() {
        return tailoredAudienceId;
    }

    public void setTailoredAudienceId(String tailoredAudienceId) {
        this.tailoredAudienceId = tailoredAudienceId;
    }

    public String getWebsiteTagId() {
        return websiteTagId;
    }

    public void setWebsiteTagId(String websiteTagId) {
        this.websiteTagId = websiteTagId;
    }

    public TailoredAudienceMatchingRuleType getRuleType() {
        return ruleType;
    }

    public void setRuleType(TailoredAudienceMatchingRuleType ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public enum TailoredAudienceMatchingRuleType {
        CONTAINS,
        EXACT,
        MATCH_ALL
    }

}
