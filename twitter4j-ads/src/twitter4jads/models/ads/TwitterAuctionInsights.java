package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhay
 * Date: 2/5/17
 * Time: 7:35 PM
 */
public class TwitterAuctionInsights {

    private static final String ID = "id";
    private static final String METRICS = "metrics";

    @SerializedName(ID)
    private String id;

    @SerializedName(METRICS)
    private TwitterAuctionStatistics metrics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TwitterAuctionStatistics getMetrics() {
        return metrics;
    }

    public void setMetrics(TwitterAuctionStatistics metrics) {
        this.metrics = metrics;
    }

    @Override
    public String toString() {
        return "TwitterAuctionInsights{" +
               "metrics=" + metrics +
               ", id='" + id + '\'' +
               '}';
    }
}
