package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;


/**
 * Created by rootachoksi on 29/01/14.
 */

public class BiddingRules {

    @SerializedName("minimum_cpe_bid_local_micro")
    private long minimumCpeBidMicro;

    @SerializedName("currency")
    private String currency;

    @SerializedName("maximum_cpe_bid_local_micro")
    private long maximumCpeBidMicro;

    public long getMaximumCpeBidMicro() {
        return maximumCpeBidMicro;
    }

    public void setMaximumCpeBidMicro(long maximumCpeBidMicro) {
        this.maximumCpeBidMicro = maximumCpeBidMicro;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getMinimumCpeBidMicro() {
        return minimumCpeBidMicro;
    }

    public void setMinimumCpeBidMicro(long minimumCpeBidMicro) {
        this.minimumCpeBidMicro = minimumCpeBidMicro;
    }
}
