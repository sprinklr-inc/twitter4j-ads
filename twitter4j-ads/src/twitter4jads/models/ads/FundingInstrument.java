package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

/**
 * User: rootachoksi
 * Date: 29/01/14
 */
public class FundingInstrument extends TwitterEntity implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("account_id")
    private String accountId;

    @SerializedName("description")
    private String description;

    @SerializedName("currency")
    private String currency;

    @SerializedName("type")
    private String type;

    @SerializedName("entity_status")
    private String entityStatus;

    @SerializedName("deleted")
    private boolean deleted;

    @SerializedName("credit_limit_local_micro")
    private long creditLimitMicro;

    @SerializedName("funded_amount_local_micro")
    private long fundedAmountMicro;

    @SerializedName("credit_remaining_local_micro")
    private long creditRemainingLocalMicro;

    @SerializedName("start_time")
    private Date startTime;

    private Double creditRemaining;

    @SerializedName("end_time")
    private Date endTime;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("updated_at")
    private Date updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEntityStatus() {
        return entityStatus;
    }

    @SuppressWarnings("unused")
    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public long getCreditLimitMicro() {
        return creditLimitMicro;
    }

    @SuppressWarnings("unused")
    public void setCreditLimitMicro(long creditLimitMicro) {
        this.creditLimitMicro = creditLimitMicro;
    }

    public long getFundedAmountMicro() {
        return fundedAmountMicro;
    }

    @SuppressWarnings("unused")
    public void setFundedAmountMicro(long fundedAmountMicro) {
        this.fundedAmountMicro = fundedAmountMicro;
    }

    public long getCreditRemainingLocalMicro() {
        return creditRemainingLocalMicro;
    }

    @SuppressWarnings("unused")
    public void setCreditRemainingLocalMicro(long creditRemainingLocalMicro) {
        this.creditRemainingLocalMicro = creditRemainingLocalMicro;
    }

    public Double getCreditRemaining() {
        return creditRemaining;
    }

    public void setCreditRemaining(Double creditRemaining) {
        this.creditRemaining = creditRemaining;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
}
