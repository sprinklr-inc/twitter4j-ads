package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * @author akashMaurya
 * @Date 07/06/16.
 */
public class NewTwitterReachEstimate {

    @SerializedName("impressions")
    private TwitterRange impressions;

    @SerializedName("count")
    private TwitterRange count;

    @SerializedName("infinite_bid_count")
    private TwitterRange infiniteBidCount;

    @SerializedName("engagements")
    private TwitterRange engagements;

    @SerializedName("estimated_daily_spend_local_micro")
    private TwitterRange estimatedDailySpendLocalMicro;

    public TwitterRange getImpressions() {
        return impressions;
    }

    public void setImpressions(TwitterRange impressions) {
        this.impressions = impressions;
    }

    public TwitterRange getCount() {
        return count;
    }

    public void setCount(TwitterRange count) {
        this.count = count;
    }

    public TwitterRange getInfiniteBidCount() {
        return infiniteBidCount;
    }

    public void setInfiniteBidCount(TwitterRange infiniteBidCount) {
        this.infiniteBidCount = infiniteBidCount;
    }

    public TwitterRange getEngagements() {
        return engagements;
    }

    public void setEngagements(TwitterRange engagements) {
        this.engagements = engagements;
    }

    public TwitterRange getEstimatedDailySpendLocalMicro() {
        return estimatedDailySpendLocalMicro;
    }

    public void setEstimatedDailySpendLocalMicro(TwitterRange estimatedDailySpendLocalMicro) {
        this.estimatedDailySpendLocalMicro = estimatedDailySpendLocalMicro;
    }
}
