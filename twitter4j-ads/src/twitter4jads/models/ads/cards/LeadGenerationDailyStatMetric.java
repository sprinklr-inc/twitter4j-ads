package twitter4jads.models.ads.cards;

/**
 * @author meghanajain
 */
public enum LeadGenerationDailyStatMetric {
    BILLED_PER_CARD_RESPONSE("billed_per_card_response"),
    PROMOTION_CARD_RESPONSES("promotion_card_responses"),
    SPENT("billed_charge_local_micro");

    private final String metric;

    LeadGenerationDailyStatMetric(String metric) {
        this.metric = metric;
    }

    public String getMetric() {
        return metric;
    }
}
