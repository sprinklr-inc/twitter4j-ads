package twitter4j.models.ads.sort;

/**
 * User: abhay
 * Date: 5/2/16
 * Time: 2:43 PM
 */
public enum LineItemsSortByField implements SortBy {
    // Ascending
    CREATED_AT_ASC("created_at-asc"),
    UPDATED_AT_ASC("updated_at-asc"),
    DELETED_ASC("deleted-asc"),
    BID_AMOUNT_LOCAL_MICRO_ASC("bid_amount_local_micro-asc"),

    // Descending
    CREATED_AT("created_at-desc"),
    UPDATED_AT("updated_at-desc"),
    DELETED("deleted-desc"),
    BID_AMOUNT_LOCAL_MICRO("bid_amount_local_micro-desc");

    private final String field;

    LineItemsSortByField(String field) {
        this.field = field;
    }

    @Override
    public String getField() {
        return field;
    }
}
