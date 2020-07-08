package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * @author sunxiang
 * @date 2020/7/7 14:19
 */
public class AudienceSummary {

    @SerializedName("audience_size")
    private TwitterRange audienceSize;

    public TwitterRange getAudienceSize() {
        return audienceSize;
    }

    public void setAudienceSize(TwitterRange audienceSize) {
        this.audienceSize = audienceSize;
    }
}
