package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 06/10/14
 * Time: 10:42 PM
 */
public class TwitterBidInfo {

    @SerializedName("mid_bid")
    private String midBid;

    @SerializedName("raw_mid_bid")
    private String rawMidBid;

    @SerializedName("bid_range")
    private String[] bidRange;

    @SerializedName("raw_bid_range")
    private Double[] rawBidRange;


    public String getMidBid() {
        return midBid;
    }

    public void setMidBid(String midBid) {
        this.midBid = midBid;
    }

    public String getRawMidBid() {
        return rawMidBid;
    }

    public void setRawMidBid(String rawMidBid) {
        this.rawMidBid = rawMidBid;
    }

    public String[] getBidRange() {
        return bidRange;
    }

    public void setBidRange(String[] bidRange) {
        this.bidRange = bidRange;
    }

    public Double[] getRawBidRange() {
        return rawBidRange;
    }

    public void setRawBidRange(Double[] rawBidRange) {
        this.rawBidRange = rawBidRange;
    }
}
