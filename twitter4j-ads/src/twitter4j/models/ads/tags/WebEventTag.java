package twitter4j.models.ads.tags;

import com.google.gson.annotations.SerializedName;
import twitter4j.models.ads.TwitterEntity;

/**
 * User: poly
 * Date: 27/06/14
 * Time: 4:27 PM
 */
public class WebEventTag extends TwitterEntity {
    @SerializedName("retargeting_enabled")
    private boolean retargetingEnabled;

    @SerializedName("click_window")
    private int clickWindow;

    @SerializedName("type")
    private WebEventTagType type;

    @SerializedName("view_through_window")
    private int viewThroughWindow;

    @SerializedName("name")
    private String name;

    @SerializedName("embed_code")
    private String embedCode;

    public boolean getRetargetingEnabled() {
        return retargetingEnabled;
    }

    public void setRetargetingEnabled(boolean retargetingEnabled) {
        this.retargetingEnabled = retargetingEnabled;
    }

    public int getClickWindow() {
        return clickWindow;
    }

    public void setClickWindow(int clickWindow) {
        this.clickWindow = clickWindow;
    }

    public WebEventTagType getType() {
        return type;
    }

    public void setType(WebEventTagType type) {
        this.type = type;
    }

    public int getViewThroughWindow() {
        return viewThroughWindow;
    }

    public void setViewThroughWindow(int viewThroughWindow) {
        this.viewThroughWindow = viewThroughWindow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmbedCode() {
        return embedCode;
    }

    public void setEmbedCode(String embedCode) {
        this.embedCode = embedCode;
    }
}
