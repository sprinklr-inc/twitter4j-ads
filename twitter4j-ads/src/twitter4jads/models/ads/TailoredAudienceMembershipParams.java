package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2017 Sprinklr, Inc. All rights reserved.
 * Author: Daryl Odnert
 * Date: 26-May-2017
 */
public class TailoredAudienceMembershipParams {
    @SerializedName("membership_type")
    String membershipType;

    @SerializedName("advertiser_account_id")
    String advertiserAccountId;

    @SerializedName("user_identifier")
    String userIdentifier;

    @SerializedName("user_identifier_type")
    String userIdentifierType;

    @SerializedName("audience_names")
    String audienceNames;

    @SerializedName("effective_at")
    String effectiveAt;

    @SerializedName("expires_at")
    String expiresAt;

    public String getAdvertiserAccountId() {
        return advertiserAccountId;
    }

    public void setAdvertiserAccountId(String advertiserAccountId) {
        this.advertiserAccountId = advertiserAccountId;
    }

    public String getAudienceNames() {
        return audienceNames;
    }

    public void setAudienceNames(String audienceNames) {
        this.audienceNames = audienceNames;
    }

    public String getEffectiveAt() {
        return effectiveAt;
    }

    public void setEffectiveAt(String effectiveAt) {
        this.effectiveAt = effectiveAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getUserIdentifierType() {
        return userIdentifierType;
    }

    public void setUserIdentifierType(String userIdentifierType) {
        this.userIdentifierType = userIdentifierType;
    }
}
