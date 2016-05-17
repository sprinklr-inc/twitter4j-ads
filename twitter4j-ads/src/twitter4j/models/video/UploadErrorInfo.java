package twitter4j.models.video;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 19/04/16 12:05 AM.
 */
public class UploadErrorInfo {
/*
Upload error info for video upload
 */

    @SerializedName("code")
    private Integer code;

    @SerializedName("name")
    private String name;


    @SerializedName("message")
    private String message;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
