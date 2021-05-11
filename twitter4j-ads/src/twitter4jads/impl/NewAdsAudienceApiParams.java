package twitter4jads.impl;

import com.google.gson.annotations.SerializedName;
import twitter4jads.models.ads.audience.TailoredAudienceUserDetails;

import java.util.Set;

/**
 * Twitter V4 Audience API params structure
 * User: mayankbhargava
 *
 * @date 25/11/18
 * @time 10:03 PM
 */
class NewAdsAudienceApiParams {

    @SerializedName("users")
    private Set<TailoredAudienceUserDetails> tailoredAudienceUserDetails;

    @SerializedName("effective_at")
    private String effectiveAt;     //in ISO 8601

    @SerializedName("expire_at")
    private String expireAt;        //in ISO 8601

    public Set<TailoredAudienceUserDetails> getTailoredAudienceUserDetails() {
        return tailoredAudienceUserDetails;
    }

    public void setTailoredAudienceUserDetails(Set<TailoredAudienceUserDetails> tailoredAudienceUserDetails) {
        this.tailoredAudienceUserDetails = tailoredAudienceUserDetails;
    }

    public String getEffectiveAt() {
        return effectiveAt;
    }

    public void setEffectiveAt(String effectiveAt) {
        this.effectiveAt = effectiveAt;
    }

    public String getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
    }
}
