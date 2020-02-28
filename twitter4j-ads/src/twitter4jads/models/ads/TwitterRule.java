package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TwitterRule implements Serializable {

    @SerializedName("id")
    private Long id;

    @SerializedName("id_str")
    private String idString;

    @SerializedName("tag")
    private String tag;
}
