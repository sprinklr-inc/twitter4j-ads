package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author niketkhandelwal
 */
public class UrlEntity implements Serializable {

    @SerializedName("url")
    private String url;

    @SerializedName("display_url")
    private String displayUrl;

    @SerializedName("expanded_url")
    private String expandedUrl;

    @SerializedName("indices")
    private List<Integer> indices;
}
