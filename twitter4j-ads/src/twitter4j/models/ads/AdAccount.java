package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by rootachoksi on 31/01/14.
 */

public class AdAccount extends TwitterEntity {

    @SerializedName("name")
    private String name;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("deleted")
    private Boolean deleted;

    @SerializedName("currency")
    private String currency;

    @SerializedName("timezone")
    private String timezone;

    @SerializedName("timezone_switch_at")
    private Date timezoneSwitchAt;

    @SerializedName("salt")
    private String salt;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Date getTimezoneSwitchAt() {
        return timezoneSwitchAt;
    }

    public void setTimezoneSwitchAt(Date timezoneSwitchAt) {
        this.timezoneSwitchAt = timezoneSwitchAt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
