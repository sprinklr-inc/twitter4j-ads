package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * @author akashMaurya
 * @Date 01/05/16.
 */
public class NewSegment {
    @SerializedName("segment_name")
    private String segmentName;

    @SerializedName("segment_value")
    private String segmentValue;

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getSegmentValue() {
        return segmentValue;
    }

    public void setSegmentValue(String segmentValue) {
        this.segmentValue = segmentValue;
    }
}
