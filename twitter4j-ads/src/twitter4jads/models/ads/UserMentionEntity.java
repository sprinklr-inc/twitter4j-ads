package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author niketkhandelwal
 */
public class UserMentionEntity implements Serializable {

    @SerializedName("id")
    private Long id;

    @SerializedName("id_str")
    private String idString;

    @SerializedName("indices")
    private List<Integer> indices;

    @SerializedName("name")
    private String name;

    @SerializedName("screen_name")
    private String screenName;
}
