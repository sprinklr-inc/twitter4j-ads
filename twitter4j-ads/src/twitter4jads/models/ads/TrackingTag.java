package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * @author devashish.yadav
 * @date 06/04/18
 */
public class TrackingTag {

    @SerializedName("tracking_partner")
    private String trackingPartner;

    @SerializedName("tracking_tag")
    private String trackingTag;

    public String getTrackingPartner() {
        return trackingPartner;
    }

    public void setTrackingPartner(String trackingPartner) {
        this.trackingPartner = trackingPartner;
    }

    public String getTrackingTag() {
        return trackingTag;
    }

    public void setTrackingTag(String trackingTag) {
        this.trackingTag = trackingTag;
    }
}
