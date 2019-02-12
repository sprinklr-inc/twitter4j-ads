package twitter4jads.models.ads.audience;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Set;

/**
 * Represents one atomic operation structure for audience update. If successfully completed, errors shall be empty.
 * User: mayankbhargava
 *
 * @date 12/12/18
 * @time 6:35 PM
 */
public class TailoredAudienceOperation {

    private String effectiveFrom;
    private String expireAt;
    private TailoredAudienceOperationType operationType;
    private Set<TailoredAudienceUserDetails> users;
    private List<String> errors = Lists.newArrayList();
    private List<String> operationErrors = Lists.newArrayList();

    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public String getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
    }

    public TailoredAudienceOperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(TailoredAudienceOperationType operationType) {
        this.operationType = operationType;
    }

    public Set<TailoredAudienceUserDetails> getUsers() {
        return users;
    }

    public void setUsers(Set<TailoredAudienceUserDetails> users) {
        this.users = users;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getOperationErrors() {
        return operationErrors;
    }

    public void setOperationErrors(List<String> operationErrors) {
        this.operationErrors = operationErrors;
    }
}

