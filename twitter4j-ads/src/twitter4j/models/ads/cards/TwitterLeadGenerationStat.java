package twitter4j.models.ads.cards;

import com.google.gson.annotations.SerializedName;

/**
 * @author meghanajain
 */
public class TwitterLeadGenerationStat {
    @SerializedName("id")
    private String id;

    @SerializedName("start_time")
    private String startTime;

    @SerializedName("end_time")
    private String endTime;

    @SerializedName("granularity")
    private String granularity;

    @SerializedName("billed_per_card_response")
    private int[] billedPerCardResponse;

    @SerializedName("promotion_card_responses")
    private int[] promotionCardResponses;

    @SerializedName("billed_charge_local_micro")
    private int[] billedChargeLocalMicro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public int[] getBilledPerCardResponse() {
        return billedPerCardResponse;
    }

    public void setBilledPerCardResponse(int[] billedPerCardResponse) {
        this.billedPerCardResponse = billedPerCardResponse;
    }

    public int[] getPromotionCardResponses() {
        return promotionCardResponses;
    }

    public void setPromotionCardResponses(int[] promotionCardResponses) {
        this.promotionCardResponses = promotionCardResponses;
    }

    public int[] getBilledChargeLocalMicro() {
        return billedChargeLocalMicro;
    }

    public void setBilledChargeLocalMicro(int[] billedChargeLocalMicro) {
        this.billedChargeLocalMicro = billedChargeLocalMicro;
    }
}
