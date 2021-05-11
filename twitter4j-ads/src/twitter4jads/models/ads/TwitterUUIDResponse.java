package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 08/02/15
 * Time: 2:57 AM
 */
public class TwitterUUIDResponse {


    @SerializedName("uuid")
    private String uUID;


    public String getuUID() {
        return uUID;
    }

    public void setuUID(String uUID) {
        this.uUID = uUID;
    }
}
