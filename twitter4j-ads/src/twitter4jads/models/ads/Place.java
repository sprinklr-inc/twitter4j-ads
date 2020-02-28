package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author niketkhandelwal
 */
public class Place implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("url")
    private String url;

    @SerializedName("place_type")
    private String placeType;

    @SerializedName("name")
    private String name;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("country")
    private String country;

    @SerializedName("bounding_box")
    private BoundingBox boundingBox;

    @SerializedName("attributes")
    private Object attributes;

    public static class BoundingBox implements Serializable {

        @SerializedName("coordinates")
        private List<List<List<Double>>> coordinates;

        @SerializedName("type")
        private String type;
    }
}
