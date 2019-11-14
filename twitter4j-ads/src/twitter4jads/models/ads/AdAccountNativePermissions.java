package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * User: rahul Parihar
 * Date: 03/06/19
 */


public class AdAccountNativePermissions extends TwitterEntity {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("permissions")
    private List<String> permissions;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}