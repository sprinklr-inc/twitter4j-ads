package twitter4j.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * @author meghanajain
 */
public class TwitterLeadGenerationCard extends AbstractTwitterCard {
    @SerializedName("image")
    private String image;

    @SerializedName("image_data")
    private String imageData;

    @SerializedName("title")
    private String title;

    @SerializedName("cta")
    private String cta;

    @SerializedName("fallback_url")
    private String fallbackUrl;

    @SerializedName("privacy_policy_url")
    private String privacyPolicyUrl;

    @SerializedName("submit_url")
    private String submitUrl;

    @SerializedName("submit_method")
    private String submitMethod;

    @SerializedName("custom_key_screen_name")
    private String customKeyScreenName;

    @SerializedName("custom_key_name")
    private String customKeyName;

    @SerializedName("customKeyEmail")
    private String customKeyEmail;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCta() {
        return cta;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public String getFallbackUrl() {
        return fallbackUrl;
    }

    public void setFallbackUrl(String fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
    }

    public String getPrivacyPolicyUrl() {
        return privacyPolicyUrl;
    }

    public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
        this.privacyPolicyUrl = privacyPolicyUrl;
    }

    public String getSubmitUrl() {
        return submitUrl;
    }

    public void setSubmitUrl(String submitUrl) {
        this.submitUrl = submitUrl;
    }

    public String getSubmitMethod() {
        return submitMethod;
    }

    public void setSubmitMethod(String submitMethod) {
        this.submitMethod = submitMethod;
    }

    public String getCustomKeyScreenName() {
        return customKeyScreenName;
    }

    public void setCustomKeyScreenName(String customKeyScreenName) {
        this.customKeyScreenName = customKeyScreenName;
    }

    public String getCustomKeyName() {
        return customKeyName;
    }

    public void setCustomKeyName(String customKeyName) {
        this.customKeyName = customKeyName;
    }

    public String getCustomKeyEmail() {
        return customKeyEmail;
    }

    public void setCustomKeyEmail(String customKeyEmail) {
        this.customKeyEmail = customKeyEmail;
    }

    }
