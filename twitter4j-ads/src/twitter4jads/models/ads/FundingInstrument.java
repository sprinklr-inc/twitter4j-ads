package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rootachoksi on 29/01/14.
 */
public class FundingInstrument extends TwitterEntity implements Serializable {

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("end_time")
    private Date endTime;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("deleted")
    private boolean deleted;

    @SerializedName("type")
    private String type;

    @SerializedName("account_id")
    private String accountId;

    @SerializedName("credit_limit_local_micro")
    private long creditLimitMicro;

    @SerializedName("cancelled")
    private boolean cancelled;

    @SerializedName("funded_amount_local_micro")
    private long fundedAmountMicro;

    @SerializedName("currency")
    private String currency;

    @SerializedName("description")
    private String description;

    @SerializedName("name")
    private String name;

    @SerializedName("start_time")
    private Date startTime;

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCreditLimitMicro() {
        return creditLimitMicro;
    }

    public void setCreditLimitMicro(long creditLimitMicro) {
        this.creditLimitMicro = creditLimitMicro;
    }

    public long getFundedAmountMicro() {
        return fundedAmountMicro;
    }

    public void setFundedAmountMicro(long fundedAmountMicro) {
        this.fundedAmountMicro = fundedAmountMicro;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
