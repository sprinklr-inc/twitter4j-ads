package twitter4jads.models.ads.sort;

/**
 * User: abhay
 * Date: 5/2/16
 * Time: 2:42 PM
 */
public enum AccountsSortByField implements SortBy {

    // Ascending
    CREATED_AT_ASC("created_at-asc"),
    UPDATED_AT_ASC("updated_at-asc"),
    DELETED_ASC("deleted-asc"),
    NAME_ASC("name-asc"),

    // Descending
    CREATED_AT_DESC("created_at-desc"),
    UPDATED_AT_DESC("updated_at-desc"),
    DELETED_DESC("deleted-desc"),
    NAME_DESC("name-desc"),;

    private final String field;

    AccountsSortByField(String field) {
        this.field = field;
    }

    @Override
    public String getField() {
        return field;
    }
}
