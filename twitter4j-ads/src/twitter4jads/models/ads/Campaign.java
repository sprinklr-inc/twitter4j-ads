package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * User: poly
 * Date: 29/01/14
 * Time: 11:55 AM
 */

public class Campaign extends TwitterEntity implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("created_at")
    private Date createTimeInUTC;

    @SerializedName("end_time")
    private Date endTimeInUTC;

    @SerializedName("updated_at")
    private Date updateTimeInUTC;

    @SerializedName("account_id")
    private String accountId;

    @SerializedName("deleted")
    private Boolean deleted;

    @SerializedName("entity_status")
    private String entityStatus;

    @SerializedName("servable")
    private Boolean servable;

    @SerializedName("reasons_not_servable")
    private List<String> reasonsNotServable;

    @SerializedName("total_budget_amount_local_micro")
    private Long totalBudgetInMicro;

    @SerializedName("currency")
    private String currency;

    @SerializedName("daily_budget_amount_local_micro")
    private Long dailyBudgetInMicro;

    @SerializedName("funding_instrument_id")
    private String fundingInstrumentId;

    @SerializedName("start_time")
    private Date startTimeInUTC;

    @SerializedName("standard_delivery")
    private Boolean standardDelivery;

    @SerializedName("frequency_cap")
    private Integer frequencyCap;

    @SerializedName("duration_in_days")
    private Integer durationInDays;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTimeInUTC;
    }

    public void setCreateTime(Date createTimeInUTC) {
        this.createTimeInUTC = createTimeInUTC;
    }

    public Date getEndTime() {
        return endTimeInUTC;
    }

    public void setEndTime(Date endTimeInUTC) {
        this.endTimeInUTC = endTimeInUTC;
    }

    public Date getUpdateTime() {
        return updateTimeInUTC;
    }

    public void setUpdateTime(Date updateTimeInUTC) {
        this.updateTimeInUTC = updateTimeInUTC;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getServable() {
        return servable;
    }

    public void setServable(Boolean servable) {
        this.servable = servable;
    }

    public List<String> getReasonsNotServable() {
        return reasonsNotServable;
    }

    public void setReasonsNotServable(List<String> reasonsNotServable) {
        this.reasonsNotServable = reasonsNotServable;
    }

    public Long getTotalBudgetInMicro() {
        return totalBudgetInMicro;
    }

    public void setTotalBudgetInMicro(Long totalBudgetInMicro) {
        this.totalBudgetInMicro = totalBudgetInMicro;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getDailyBudgetInMicro() {
        return dailyBudgetInMicro;
    }

    public void setDailyBudgetInMicro(Long dailyBudgetInMicro) {
        this.dailyBudgetInMicro = dailyBudgetInMicro;
    }

    public String getFundingInstrumentId() {
        return fundingInstrumentId;
    }

    public void setFundingInstrumentId(String fundingInstrumentId) {
        this.fundingInstrumentId = fundingInstrumentId;
    }

    public Date getStartTime() {
        return startTimeInUTC;
    }

    public void setStartTime(Date startTimeInUTC) {
        this.startTimeInUTC = startTimeInUTC;
    }

    public Boolean getStandardDelivery() {
        return standardDelivery;
    }

    public void setStandardDelivery(Boolean standardDelivery) {
        this.standardDelivery = standardDelivery;
    }

    public Integer getFrequencyCap() {
        return frequencyCap;
    }

    public void setFrequencyCap(Integer frequencyCap) {
        this.frequencyCap = frequencyCap;
    }

    public Integer getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Integer durationInDays) {
        this.durationInDays = durationInDays;
    }

    public String getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus;
    }
}
