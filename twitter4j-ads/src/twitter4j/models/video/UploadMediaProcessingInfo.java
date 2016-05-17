package twitter4j.models.video;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 18/04/16 8:50 PM.
 */
public class UploadMediaProcessingInfo {

    @SerializedName("state")
    private String state;

    @SerializedName("check_after_secs")
    private Long checkAfterSeconds;

    @SerializedName("progress_percent")
    private Integer progressPercentage;


    @SerializedName("error")
    private UploadErrorInfo uploadErrorInfo;

    public Integer getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(Integer progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCheckAfterSeconds() {
        return checkAfterSeconds;
    }

    public void setCheckAfterSeconds(Long checkAfterSeconds) {
        this.checkAfterSeconds = checkAfterSeconds;
    }


    public UploadErrorInfo getUploadErrorInfo() {
        return uploadErrorInfo;
    }

    public void setUploadErrorInfo(UploadErrorInfo uploadErrorInfo) {
        this.uploadErrorInfo = uploadErrorInfo;
    }
}
