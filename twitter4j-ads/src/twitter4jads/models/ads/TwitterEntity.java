package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: poly
 * Date: 29/01/14
 * Time: 11:51 AM
 */
public class TwitterEntity {

    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TwitterEntity{" +
               "id='" + id + '\'' +
               '}';
    }
}
