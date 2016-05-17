package twitter4j.models.video;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 18/04/16 8:48 PM.
 */
public class VideoContentType {


    @SerializedName("video_type")
    private String videoType;

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }
}
