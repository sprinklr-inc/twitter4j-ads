package twitter4j.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * User:  dheeraj
 * Date:  09/11/17.
 */
public abstract class AbstractTwitterDMCard extends AbstractTwitterCard {

    @SerializedName("recipient_user_id")
    private Long recipientUserId;

    @SerializedName("first_cta")
    private String firstCta;

    @SerializedName("first_cta_welcome_message_id")
    private Long firstWelcomeMessageId;

    @SerializedName("second_cta")
    private String secondCta;

    @SerializedName("second_cta_welcome_message_id")
    private Long secondWelcomeMessageId;

    @SerializedName("third_cta")
    private String thirdCta;

    @SerializedName("third_cta_welcome_message_id")
    private Long thirdWelcomeMessageId;

    @SerializedName("fourth_cta")
    private String fourthCta;

    @SerializedName("fourth_cta_welcome_message_id")
    private Long fourthWelcomeMessageId;

    public Long getRecipientUserId() {
        return recipientUserId;
    }

    public void setRecipientUserId(Long recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    public String getFirstCta() {
        return firstCta;
    }

    public void setFirstCta(String firstCta) {
        this.firstCta = firstCta;
    }

    public Long getFirstWelcomeMessageId() {
        return firstWelcomeMessageId;
    }

    public void setFirstWelcomeMessageId(Long firstWelcomeMessageId) {
        this.firstWelcomeMessageId = firstWelcomeMessageId;
    }

    public String getSecondCta() {
        return secondCta;
    }

    public void setSecondCta(String secondCta) {
        this.secondCta = secondCta;
    }

    public Long getSecondWelcomeMessageId() {
        return secondWelcomeMessageId;
    }

    public void setSecondWelcomeMessageId(Long secondWelcomeMessageId) {
        this.secondWelcomeMessageId = secondWelcomeMessageId;
    }

    public String getThirdCta() {
        return thirdCta;
    }

    public void setThirdCta(String thirdCta) {
        this.thirdCta = thirdCta;
    }

    public Long getThirdWelcomeMessageId() {
        return thirdWelcomeMessageId;
    }

    public void setThirdWelcomeMessageId(Long thirdWelcomeMessageId) {
        this.thirdWelcomeMessageId = thirdWelcomeMessageId;
    }

    public String getFourthCta() {
        return fourthCta;
    }

    public void setFourthCta(String fourthCta) {
        this.fourthCta = fourthCta;
    }

    public Long getFourthWelcomeMessageId() {
        return fourthWelcomeMessageId;
    }

    public void setFourthWelcomeMessageId(Long fourthWelcomeMessageId) {
        this.fourthWelcomeMessageId = fourthWelcomeMessageId;
    }
}
