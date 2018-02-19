package twitter4jads.models.ads.sort;

/**
 * User: abhay
 * Date: 5/2/16
 * Time: 2:44 PM
 */
public enum AppEventTagsSortByField implements SortBy {
    // Ascending
    CREATED_AT_ASC("created_at-asc"),
    UPDATED_AT_ASC("updated_at-asc"),
    DELETED_ASC("deleted-asc"),
    POST_VIEW_ATTRIBUTION_WINDOW_ASC("post_view_attribution_window-asc"),
    POST_ENGAGEMENT_ATTRIBUTION_WINDOW_ASC("post_engagement_attribution_window-asc"),
    ASSISTED_CONVERSION_ASC("assisted_conversion-asc"),
    PROVIDER_APP_EVENT_NAME_ASC("provider_app_event_name-asc"),

    // Descending
    CREATED_AT_DESC("created_at-desc"),
    UPDATED_AT_DESC("updated_at-desc"),
    DELETED_DESC("deleted-desc"),
    POST_VIEW_ATTRIBUTION_WINDOW_DESC("post_view_attribution_window-desc"),
    POST_ENGAGEMENT_ATTRIBUTION_WINDOW_DESC("post_engagement_attribution_window-desc"),
    ASSISTED_CONVERSION_DESC("assisted_conversion-desc"),
    PROVIDER_APP_EVENT_NAME_DESC("provider_app_event_name-desc");

    private final String field;

    AppEventTagsSortByField(String field) {
        this.field = field;
    }

    @Override
    public String getField() {
        return field;
    }
}
