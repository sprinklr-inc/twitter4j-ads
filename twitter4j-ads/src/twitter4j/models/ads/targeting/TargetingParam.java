package twitter4j.models.ads.targeting;

import com.google.gson.annotations.SerializedName;
import twitter4j.models.ads.TargetingType;

/**
 * User: abhishekanand
 * Date: 16/06/16 7:12 PM.
 */
public class TargetingParam {


    @SerializedName("targeting_type")
    private TargetingType targetingType;

    @SerializedName("line_item_id")
    private String lineItemId;

    @SerializedName("targeting_value")
    private String targetingValue;

    @SerializedName("negated")
    private boolean negated;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("account_id")
    private String accountId;

    @SerializedName("location_type")
    private String locationType;

    @SerializedName("deleted")
    private boolean deleted;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("operator_type")
    private String operatorType;

    @SerializedName("targeting_criterion_id")
    private String targetingCriterionId;


    public String getTargetingCriterionId() {
        return targetingCriterionId;
    }

    public void setTargetingCriterionId(String targetingCriterionId) {
        this.targetingCriterionId = targetingCriterionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TargetingType getTargetingType() {
        return targetingType;
    }

    public void setTargetingType(TargetingType targetingType) {
        this.targetingType = targetingType;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public String getTargetingValue() {
        return targetingValue;
    }

    public void setTargetingValue(String targetingValue) {
        this.targetingValue = targetingValue;
    }

    public boolean isNegated() {
        return negated;
    }

    public void setNegated(boolean negated) {
        this.negated = negated;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }
}
