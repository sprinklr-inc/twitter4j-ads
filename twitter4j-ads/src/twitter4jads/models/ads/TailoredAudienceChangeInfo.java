package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 26/11/14
 * Time: 3:44 PM
 */
public class TailoredAudienceChangeInfo extends TwitterEntity{

    @SerializedName("input_file_path")
    private String inputFilePath;

    @SerializedName("tailored_audience_id")
    private String tailoredAudienceId;

    @SerializedName("state")
    private TailoredAudienceUpdationState tailoredAudienceUpdationState;

    @SerializedName("operation")
    private TailoredAudienceOperation tailoredAudienceOperation;


    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getTailoredAudienceId() {
        return tailoredAudienceId;
    }

    public void setTailoredAudienceId(String tailoredAudienceId) {
        this.tailoredAudienceId = tailoredAudienceId;
    }

    public TailoredAudienceUpdationState getTailoredAudienceUpdationState() {
        return tailoredAudienceUpdationState;
    }

    public void setTailoredAudienceUpdationState(TailoredAudienceUpdationState tailoredAudienceUpdationState) {
        this.tailoredAudienceUpdationState = tailoredAudienceUpdationState;
    }

    public TailoredAudienceOperation getTailoredAudienceOperation() {
        return tailoredAudienceOperation;
    }

    public void setTailoredAudienceOperation(TailoredAudienceOperation tailoredAudienceOperation) {
        this.tailoredAudienceOperation = tailoredAudienceOperation;
    }
}
