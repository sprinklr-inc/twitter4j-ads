package twitter4jads.models.ads.audience;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.util.Set;

/**
 * Twitter V4 Audience API user info
 * Denotes information for individual user
 * Add only hashed information
 * It is advisable to use TailoredAudienceUserDetailsBuilder
 * User: mayankbhargava
 *
 * @date 25/11/18
 * @time 10:28 PM
 */
public class TailoredAudienceUserDetails {

    @SerializedName("email")
    private Set<String> emails;

    @SerializedName("phone_number")
    private Set<String> phoneNumbers;

    @SerializedName("device_id")    //IDFA/AdID/Android ID
    private Set<String> deviceIds;

    @SerializedName("handle")
    private Set<String> twitterHandles;

    @SerializedName("twitter_id")
    private Set<String> twitterIds;

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<String> getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(Set<String> deviceIds) {
        this.deviceIds = deviceIds;
    }

    public Set<String> getTwitterHandles() {
        return twitterHandles;
    }

    public void setTwitterHandles(Set<String> twitterHandles) {
        this.twitterHandles = twitterHandles;
    }

    public Set<String> getTwitterIds() {
        return twitterIds;
    }

    public void setTwitterIds(Set<String> twitterIds) {
        this.twitterIds = twitterIds;
    }

    public boolean isEmpty() {
        return !(!emails.isEmpty() || !twitterIds.isEmpty() || !twitterHandles.isEmpty() || !phoneNumbers.isEmpty() || !deviceIds.isEmpty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TailoredAudienceUserDetails that = (TailoredAudienceUserDetails) o;
        return Objects.equals(emails, that.emails) &&
                Objects.equals(phoneNumbers, that.phoneNumbers) &&
                Objects.equals(deviceIds, that.deviceIds) &&
                Objects.equals(twitterHandles, that.twitterHandles) &&
                Objects.equals(twitterIds, that.twitterIds);
    }

    @Override
    public int hashCode() {

        return Objects.hash(emails, phoneNumbers, deviceIds, twitterHandles, twitterIds);
    }
}
