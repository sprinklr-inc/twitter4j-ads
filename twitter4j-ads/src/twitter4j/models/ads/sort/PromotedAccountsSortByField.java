package twitter4j.models.ads.sort;

/**
 * User: abhay
 * Date: 5/2/16
 * Time: 2:43 PM
 */
public enum PromotedAccountsSortByField implements SortBy {
    // Ascending
    CREATED_AT_ASC("created_at-asc"),
    UPDATED_AT_ASC("updated_at-asc"),
    DELETED_ASC("deleted-asc"),
    PAUSED_ASC("paused-asc"),

    // Descending
    CREATED_AT_DESC("created_at-desc"),
    UPDATED_AT_DESC("updated_at-desc"),
    DELETED_DESC("deleted-desc"),
    PAUSED_DESC("paused-desc");

    private final String field;

    PromotedAccountsSortByField(String field) {
        this.field = field;
    }

    @Override
    public String getField() {
        return field;
    }
}
