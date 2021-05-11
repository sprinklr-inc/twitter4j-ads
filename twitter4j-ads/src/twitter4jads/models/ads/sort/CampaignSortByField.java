package twitter4jads.models.ads.sort;

/**
 * User: abhay
 * Date: 5/2/16
 * Time: 2:41 PM
 */
public enum CampaignSortByField implements SortBy {

    // Ascending
    CREATED_AT_ASC("created_at-asc"),
    UPDATED_AT_ASC("updated_at-asc"),
    DELETED_ASC("deleted-asc"),
    START_TIME_ASC("start_time-asc"),
    END_TIME_ASC("end_time-asc"),
    NAME_ASC("name-asc"),
    DAILY_BUDGET_AMOUNT_LOCAL_MICRO_ASC("daily_budget_amount_local_micro-asc"),
    TOTAL_BUDGET_AMOUNT_LOCAL_MICRO_ASC("total_budget_amount_local_micro-asc"),
    STANDARD_DELIVERY_ASC("standard_delivery-asc"),

    // Descending
    CREATED_AT_DESC("created_at-desc"),
    UPDATED_AT_DESC("updated_at-desc"),
    DELETED_DESC("deleted-desc"),
    START_TIME_DESC("start_time-desc"),
    END_TIME_DESC("end_time-desc"),
    NAME_DESC("name-desc"),
    DAILY_BUDGET_AMOUNT_LOCAL_MICRO_DESC("daily_budget_amount_local_micro-desc"),
    TOTAL_BUDGET_AMOUNT_LOCAL_MICRO_DESC("total_budget_amount_local_micro-desc"),
    STANDARD_DELIVERY_DESC("standard_delivery-desc");

    private final String field;

    CampaignSortByField(String field) {
        this.field = field;
    }

    @Override
    public String getField() {
        return field;
    }
}
