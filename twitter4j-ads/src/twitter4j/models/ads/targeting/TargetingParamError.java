package twitter4j.models.ads.targeting;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 17/06/16 3:00 PM.
 */
public class TargetingParamError {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;

    @SerializedName("parameter")
    private String parameter;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
