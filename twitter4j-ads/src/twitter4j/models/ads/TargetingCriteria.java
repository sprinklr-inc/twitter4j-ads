package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;
import twitter4j.models.LocationType;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: poly
 * Date: 30/01/14
 * Time: 11:51 AM
 */
public class TargetingCriteria extends TwitterEntity {

    public TargetingCriteria() {
    }

    public TargetingCriteria(String targetingValue, TargetingType targetingType) {
        this.targetingValue = targetingValue;
        this.targetingType = targetingType;
    }

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("account_id")
    private String accountId;

    @SerializedName("line_item_id")
    private String lineItemId;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("deleted")
    private String deleted;

    @SerializedName("name")
    private String name;

    @SerializedName("targeting_value")
    private Object targetingValue;

    @SerializedName("targeting_type")
    private TargetingType targetingType;

    @SerializedName("location_type")
    private LocationType locationType;

    @SerializedName("estimated_users")
    private Integer estimatedUsers;

    @SerializedName("genre")
    private String genre;

    @SerializedName("show_count")
    private Integer showCount;

    @SerializedName("tailored_audience_type")
    private TailoredAudienceType tailoredAudienceType;

    @SerializedName("tailored_audience_expansion")
    private boolean tailoredAudienceExpansion;

    @SerializedName("locale")
    private String tvMarketLocale;

    @SerializedName("iab_categories")
    private String[] iabCategories;

    @SerializedName("event_type")
    private String eventType;

    @SerializedName("app_lists")
    private List<TwitterApplicationDetails> appList;    //this is the list of apps that are excluded from third party targeting for twitter

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getShowCount() {
        return showCount;
    }

    public void setShowCount(Integer showCount) {
        this.showCount = showCount;
    }

    public String getTvMarketLocale() {
        return tvMarketLocale;
    }

    public void setTvMarketLocale(String tvMarketLocale) {
        this.tvMarketLocale = tvMarketLocale;
    }

    public Integer getEstimatedUsers() {
        return estimatedUsers;
    }

    public TailoredAudienceType getTailoredAudienceType() {
        return tailoredAudienceType;
    }

    public void setTailoredAudienceType(TailoredAudienceType tailoredAudienceType) {
        this.tailoredAudienceType = tailoredAudienceType;
    }

    public void setEstimatedUsers(Integer estimatedUsers) {
        this.estimatedUsers = estimatedUsers;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetingValue() {
        if (this.targetingValue == null) {
            return null;
        }
        if (targetingValue instanceof String) {
            return ((String) targetingValue);
        }

        if (targetingValue instanceof Map) {
            Map targetingMap = (Map) targetingValue;
            Object id = targetingMap.get("id");
            if (id != null) {
                return id.toString();
            }
        }
        if (targetingValue instanceof Double) {
            Double doubleValue = (Double) targetingValue;
            return Integer.toString(doubleValue.intValue());
        }

        if (targetingValue instanceof Long) {
            Long longValue = (Long) targetingValue;
            return Integer.toString(longValue.intValue());
        }
        return null;
    }

    public void setTargetingValue(Object targetingValue) {
        this.targetingValue = targetingValue;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public TargetingType getTargetingType() {
        return targetingType;
    }

    public void setTargetingType(TargetingType targetingType) {
        this.targetingType = targetingType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isTailoredAudienceExpansion() {
        return tailoredAudienceExpansion;
    }

    public void setTailoredAudienceExpansion(boolean tailoredAudienceExpansion) {
        this.tailoredAudienceExpansion = tailoredAudienceExpansion;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public String[] getIabCategories() {
        return iabCategories;
    }

    public void setIabCategories(String[] iabCategories) {
        this.iabCategories = iabCategories;
    }

    public List<TwitterApplicationDetails> getAppList() {
        return appList;
    }

    public void setAppList(List<TwitterApplicationDetails> appList) {
        this.appList = appList;
    }
}
