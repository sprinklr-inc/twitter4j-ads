package twitter4jads.models.ads;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import twitter4jads.models.LocationType;
import twitter4jads.models.ads.audience.TailoredAudienceType;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * User: poly
 * Date: 30/01/14
 * Time: 11:51 AM
 */
public class TargetingCriteria extends TwitterEntity {

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

    @SerializedName("operator_type")
    private String operatorType;

    @SerializedName("targeting_value")
    public JsonElement targetingValue;

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

    @SerializedName("country_code")
    private String country_code;

    public String getCountryCode() {
        return country_code;
    }

    public void setCountryCode(String country_code) {
        this.country_code = country_code;
    }

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

    @SuppressWarnings("unused")
    public void setTvMarketLocale(String tvMarketLocale) {
        this.tvMarketLocale = tvMarketLocale;
    }

    public Integer getEstimatedUsers() {
        return estimatedUsers;
    }

    public TailoredAudienceType getTailoredAudienceType() {
        return tailoredAudienceType;
    }

    @SuppressWarnings("unused")
    public void setTailoredAudienceType(TailoredAudienceType tailoredAudienceType) {
        this.tailoredAudienceType = tailoredAudienceType;
    }

    @SuppressWarnings("unused")
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

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getTargetingValue() {
        if (targetingValue == null || !targetingValue.isJsonPrimitive()) {
            return null;
        }
        return targetingValue.getAsString();
    }

    public void setTargetingValue(JsonElement targetingValue) {
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

    @SuppressWarnings("unused")
    public void setTailoredAudienceExpansion(boolean tailoredAudienceExpansion) {
        this.tailoredAudienceExpansion = tailoredAudienceExpansion;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    @SuppressWarnings("unused")
    public String[] getIabCategories() {
        return iabCategories;
    }

    @SuppressWarnings("unused")
    public void setIabCategories(String[] iabCategories) {
        this.iabCategories = iabCategories;
    }

    @SuppressWarnings("unused")
    public List<TwitterApplicationDetails> getAppList() {
        return appList;
    }

    @SuppressWarnings("unused")
    public void setAppList(List<TwitterApplicationDetails> appList) {
        this.appList = appList;
    }

    public TargetingCriteria() {
    }

    public TargetingCriteria(String targetingValue, TargetingType targetingType) {
        this.targetingValue = new JsonPrimitive(targetingValue);
        this.targetingType = targetingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TargetingCriteria)) {
            return false;
        }

        final TargetingCriteria that = (TargetingCriteria) o;
        return targetingValue != null ? targetingValue.equals(that.targetingValue)
                : that.targetingValue == null && targetingType == that.targetingType;
    }

    @Override
    public int hashCode() {
        int result = targetingValue != null ? targetingValue.hashCode() : 0;
        result = 31 * result + (targetingType != null ? targetingType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TargetingCriteria{" +
                "accountId='" + accountId + '\'' +
                ", id='" + getId() + '\'' +
                ", createdAt=" + createdAt +
                ", lineItemId='" + lineItemId + '\'' +
                ", updatedAt=" + updatedAt +
                ", deleted='" + deleted + '\'' +
                ", name='" + name + '\'' +
                ", operatorType='" + operatorType + '\'' +
                ", targetingValue=" + targetingValue +
                ", targetingType=" + targetingType +
                ", locationType=" + locationType +
                ", estimatedUsers=" + estimatedUsers +
                ", genre='" + genre + '\'' +
                ", showCount=" + showCount +
                ", tailoredAudienceType=" + tailoredAudienceType +
                ", tailoredAudienceExpansion=" + tailoredAudienceExpansion +
                ", tvMarketLocale='" + tvMarketLocale + '\'' +
                ", iabCategories=" + Arrays.toString(iabCategories) +
                ", eventType='" + eventType + '\'' +
                ", appList=" + appList +
                '}';
    }
}
