package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CurrentUserRetweet implements Serializable {

    @SerializedName("id")
    private Long id;

    @SerializedName("id_str")
    private String idString;
}
