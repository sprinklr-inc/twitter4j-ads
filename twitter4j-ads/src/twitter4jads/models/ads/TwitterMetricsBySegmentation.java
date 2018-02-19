package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * @author akashMaurya
 * @Date 20/04/16.
 */
public class TwitterMetricsBySegmentation {

    public static final String SEGMENT = "segment";
    public static final String METRICS = "metrics";

    @SerializedName(SEGMENT)
    private NewSegment segment;

    @SerializedName(METRICS)
    private NewTwitterAdStatistics metrics;

    public NewSegment getSegment() {
        return segment;
    }

    public void setSegment(NewSegment segment) {
        this.segment = segment;
    }

    public NewTwitterAdStatistics getMetrics() {
        return metrics;
    }

    public void setMetrics(NewTwitterAdStatistics metrics) {
        this.metrics = metrics;
    }
}
