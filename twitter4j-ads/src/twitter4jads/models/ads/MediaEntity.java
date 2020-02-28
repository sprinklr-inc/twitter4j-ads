package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author niketkhandelwal
 */
public class MediaEntity {

    @SerializedName("id")
    private Long id;

    @SerializedName("id_str")
    private String idString;

    @SerializedName("url")
    private String url;

    @SerializedName("expanded_url")
    private String expandedUrl;

    @SerializedName("display_url")
    private String displayUrl;

    @SerializedName("media_url")
    private String mediaUrl;

    @SerializedName("media_url_https")
    private String mediaUrlHttps;

    @SerializedName("indices")
    private List<Integer> indices;

    @SerializedName("sizes")
    private Map<String, Size> sizes;

    @SerializedName("source_status_id")
    private Long sourceStatusId;

    @SerializedName("source_status_id_str")
    private Long sourceStatusIdString;

    @SerializedName("type")
    private String type;

    public static class Size implements Serializable {

        @SerializedName("h")
        private Integer height;

        @SerializedName("w")
        private Integer width;

        @SerializedName("resize")
        private String resize;
    }
}
