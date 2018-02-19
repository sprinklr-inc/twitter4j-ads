package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: poly
 * Date: 15/02/14
 * Time: 4:03 PM
 */
public class TwitterReachEstimate {

    @SerializedName("count")
    private long count;

    @SerializedName("infinite_bid_count")
    private long infiniteBidCount;

    public long getCount() {
        return count;
    }

    public void setCount(long data) {
        this.count = data;
    }

    public long getInfiniteBidCount() {
        return infiniteBidCount;
    }

    public void setInfiniteBidCount(long infiniteBidCount) {
        this.infiniteBidCount = infiniteBidCount;
    }
}
