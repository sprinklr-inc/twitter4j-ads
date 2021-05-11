package twitter4jads.models.ads.audience;

import java.util.HashSet;
import java.util.Set;

/**
 * Builder for TailoredAudienceUserDetails
 * User: mayankbhargava
 *
 * @date 26/11/18
 * @time 3:04 AM
 * @see TailoredAudienceUserDetails
 */
public class TailoredAudienceUserDetailsBuilder {

    private Set<String> emails = new HashSet<>();
    private Set<String> phoneNumbers = new HashSet<>();
    private Set<String> deviceIds = new HashSet<>();
    private Set<String> twitterHandles = new HashSet<>();
    private Set<String> twitterIds = new HashSet<>();

    public TailoredAudienceUserDetailsBuilder() {
    }

    public TailoredAudienceUserDetailsBuilder addEmail(String hashedEmail) {
        emails.add(hashedEmail);
        return this;
    }

    public TailoredAudienceUserDetailsBuilder addPhoneNumber(String hashedPhoneNumber) {
        phoneNumbers.add(hashedPhoneNumber);
        return this;
    }

    public TailoredAudienceUserDetailsBuilder addDeviceId(String hashedDeviceId) {
        deviceIds.add(hashedDeviceId);
        return this;
    }

    public TailoredAudienceUserDetailsBuilder addTwitterHandle(String hashedTwitterHandle) {
        twitterHandles.add(hashedTwitterHandle);
        return this;
    }

    public TailoredAudienceUserDetailsBuilder addTwitterId(String hashedTwitterId) {
        twitterIds.add(hashedTwitterId);
        return this;
    }

    public TailoredAudienceUserDetails build() {
        TailoredAudienceUserDetails tailoredAudienceUserDetails = new TailoredAudienceUserDetails();
        if (!emails.isEmpty()) {
            tailoredAudienceUserDetails.setEmails(emails);
        }
        if (!phoneNumbers.isEmpty()) {
            tailoredAudienceUserDetails.setPhoneNumbers(phoneNumbers);
        }
        if (!deviceIds.isEmpty()) {
            tailoredAudienceUserDetails.setDeviceIds(deviceIds);
        }
        if (!twitterHandles.isEmpty()) {
            tailoredAudienceUserDetails.setTwitterHandles(twitterHandles);
        }
        if (!twitterIds.isEmpty()) {
            tailoredAudienceUserDetails.setTwitterIds(twitterIds);
        }
        return tailoredAudienceUserDetails;
    }
}