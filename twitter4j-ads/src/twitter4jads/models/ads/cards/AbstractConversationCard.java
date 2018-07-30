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
    private String firstHashtag;

    @SerializedName("first_cta_tweet")
    private String firstTweet;

    @SerializedName("second_cta")
    private String secondHashtag;

    @SerializedName("second_cta_tweet")
    private String secondTweet;

    @SerializedName("third_cta")
    private String thirdHashtag;

    @SerializedName("third_cta_tweet")
    private String thirdTweet;

    @SerializedName("fourth_cta")
    private String fourthHashtag;

    @SerializedName("fourth_cta_tweet")
    private String fourthTweet;

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

    public String getFirstHashtag() {
        return firstHashtag;
    }

    public void setFirstHashtag(String firstHashtag) {
        this.firstHashtag = firstHashtag;
    }

    public String getFirstTweet() {
        return firstTweet;
    }

    public void setFirstTweet(String firstTweet) {
        this.firstTweet = firstTweet;
    }

    public String getSecondHashtag() {
        return secondHashtag;
    }

    public void setSecondHashtag(String secondHashtag) {
        this.secondHashtag = secondHashtag;
    }

    public String getSecondTweet() {
        return secondTweet;
    }

    public void setSecondTweet(String secondTweet) {
        this.secondTweet = secondTweet;
    }

    public String getThirdHashtag() {
        return thirdHashtag;
    }

    public void setThirdHashtag(String thirdHashtag) {
        this.thirdHashtag = thirdHashtag;
    }

    public String getThirdTweet() {
        return thirdTweet;
    }

    public void setThirdTweet(String thirdTweet) {
        this.thirdTweet = thirdTweet;
    }

    public String getFourthHashtag() {
        return fourthHashtag;
    }

    public void setFourthHashtag(String fourthHashtag) {
        this.fourthHashtag = fourthHashtag;
    }

    public String getFourthTweet() {
        return fourthTweet;
    }

    public void setFourthTweet(String fourthTweet) {
        this.fourthTweet = fourthTweet;
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
