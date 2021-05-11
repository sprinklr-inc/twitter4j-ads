package twitter4jads.models.ads.sort;

/**
 * User: abhay
 * Date: 5/2/16
 * Time: 2:42 PM
 */
public enum FundingInstrumentSortByField implements SortBy {
    // Ascending
    CREATED_AT_ASC("created_at-asc"),
    UPDATED_AT_ASC("updated_at-asc"),
    DELETED_ASC("deleteda-asc"),
    FUNDED_AMOUNT_LOCAL_MICRO_ASC("funded_amount_local_micro-asc"),
    START_TIME_ASC("start_time-asc"),
    END_TIME_ASC("end_time-asc"),

    // Descending
    CREATED_AT_DESC("created_at-desc"),
    UPDATED_AT_DESC("updated_at-desc"),
    DELETED_DESC("deleted-desc"),
    FUNDED_AMOUNT_LOCAL_MICRO_DESC("funded_amount_local_micro-desc"),
    START_TIME_DESC("start_time-desc"),
    END_TIME_DESC("end_time-desc");

    private final String field;

    FundingInstrumentSortByField(String field) {
        this.field = field;
    }

    @Override
    public String getField() {
        return field;
    }
}
