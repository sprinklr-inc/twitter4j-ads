package twitter4jads;

import com.google.gson.annotations.SerializedName;

/**
 * User: mayankbhargava
 *
 * @date 12/01/19
 * @time 6:06 PM
 */
public class ErrorResponse {

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
