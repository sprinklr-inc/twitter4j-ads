package twitter4jads.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * User: prashant
 * Date: 08/09/16.
 * Time: 1:32 AM
 */
public abstract class AbstractConversationCard extends AbstractTwitterCard {
    @SerializedName("title")
    private String title;

    @SerializedName("first_cta")
    private String firstCta;

    @SerializedName("first_cta_tweet")
    private String firstCtaTweet;

    @SerializedName("second_cta")
    private String secondCta;

    @SerializedName("second_cta_tweet")
    private String secondCtaTweet;

    @SerializedName("thank_you_text")
    private String thankText;

    @SerializedName("thank_you_url")
    private String thankUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstCta() {
        return firstCta;
    }

    public void setFirstCta(String firstCta) {
        this.firstCta = firstCta;
    }

    public String getFirstCtaTweet() {
        return firstCtaTweet;
    }

    public void setFirstCtaTweet(String firstCtaTweet) {
        this.firstCtaTweet = firstCtaTweet;
    }

    public String getSecondCta() {
        return secondCta;
    }

    public void setSecondCta(String secondCta) {
        this.secondCta = secondCta;
    }

    public String getSecondCtaTweet() {
        return secondCtaTweet;
    }

    public void setSecondCtaTweet(String secondCtaTweet) {
        this.secondCtaTweet = secondCtaTweet;
    }

    public String getThankText() {
        return thankText;
    }

    public void setThankText(String thankText) {
        this.thankText = thankText;
    }

    public String getThankUrl() {
        return thankUrl;
    }

    public void setThankUrl(String thankUrl) {
        this.thankUrl = thankUrl;
    }
}
