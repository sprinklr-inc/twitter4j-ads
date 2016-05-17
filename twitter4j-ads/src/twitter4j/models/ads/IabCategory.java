package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User:  dheeraj
 * Date:  04/09/15.
 */
public class IabCategory extends TwitterEntity {

    @SerializedName("id")
    private String id;

    @SerializedName("parent_id")
    private String parentId;

    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
