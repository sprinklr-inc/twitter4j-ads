package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhay
 * Date: 4/20/16
 * Time: 11:49 PM
 */
public class JobDetails {

    @SerializedName("url")
    private String url;

    @SerializedName("id")
    private String jobId;

    @SerializedName("status")
    private TwitterAsyncQueryStatus status;

    @SerializedName("expires_at")
    private String expiresAt;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public TwitterAsyncQueryStatus getStatus() {
        return status;
    }

    public void setStatus(TwitterAsyncQueryStatus status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }
}
