package twitter4j.models.ads.cards;

import com.google.gson.annotations.SerializedName;


/**
 * @author meghanajain
 */

public class AbstractAppCard extends AbstractTwitterCard {
    @SerializedName("iphone_app_id")
    private String iphoneAppId;

    @SerializedName("ipad_app_id")
    private String ipadAppId;

    @SerializedName("googleplay_app_id")
    private String googleplayAppId;

    @SerializedName("iphone_deep_link")
    private String iphoneDeepLink;

    @SerializedName("ipad_deep_link")
    private String ipadDeepLink;

    @SerializedName("googleplay_deep_link")
    private String googleplayDeepLink;

    @SerializedName("app_country_code")
    private String appCountryCode;

    @SerializedName("app_cta")
    private String appCta;

    public String getIphoneAppId() {
        return iphoneAppId;
    }

    public void setIphoneAppId(String iphoneAppId) {
        this.iphoneAppId = iphoneAppId;
    }

    public String getIpadAppId() {
        return ipadAppId;
    }

    public void setIpadAppId(String ipadAppId) {
        this.ipadAppId = ipadAppId;
    }

    public String getGoogleplayAppId() {
        return googleplayAppId;
    }

    public void setGoogleplayAppId(String googleplayAppId) {
        this.googleplayAppId = googleplayAppId;
    }

    public String getIphoneDeepLink() {
        return iphoneDeepLink;
    }

    public void setIphoneDeepLink(String iphoneDeepLink) {
        this.iphoneDeepLink = iphoneDeepLink;
    }

    public String getIpadDeepLink() {
        return ipadDeepLink;
    }

    public void setIpadDeepLink(String ipadDeepLink) {
        this.ipadDeepLink = ipadDeepLink;
    }

    public String getGoogleplayDeepLink() {
        return googleplayDeepLink;
    }

    public void setGoogleplayDeepLink(String googleplayDeepLink) {
        this.googleplayDeepLink = googleplayDeepLink;
    }

    public String getAppCountryCode() {
        return appCountryCode;
    }

    public void setAppCountryCode(String appCountryCode) {
        this.appCountryCode = appCountryCode;
    }

    public String getAppCta() {
        return appCta;
    }

    public void setAppCta(String appCta) {
        this.appCta = appCta;
    }
}
