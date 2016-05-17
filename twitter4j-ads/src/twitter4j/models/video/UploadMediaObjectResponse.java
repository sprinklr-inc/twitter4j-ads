package twitter4j.models.video;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhishekanand
 * Date: 18/04/16 8:43 PM.
 */
public class UploadMediaObjectResponse {


    @SerializedName("media_id_string")
    private String mediaIdString;

    @SerializedName("media_id")
    private Long mediaId;


    @SerializedName("size")
    private Long size;

    @SerializedName("expires_after_secs")
    private Long expiresAfterSec;

    @SerializedName("video")
    private VideoContentType videoContentType;

    @SerializedName("processing_info")
    private UploadMediaProcessingInfo uploadMediaProcessingInfo;


    public String getMediaIdString() {
        return mediaIdString;
    }

    public void setMediaIdString(String mediaIdString) {
        this.mediaIdString = mediaIdString;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getExpiresAfterSec() {
        return expiresAfterSec;
    }

    public void setExpiresAfterSec(Long expiresAfterSec) {
        this.expiresAfterSec = expiresAfterSec;
    }

    public VideoContentType getVideoContentType() {
        return videoContentType;
    }

    public void setVideoContentType(VideoContentType videoContentType) {
        this.videoContentType = videoContentType;
    }

    public UploadMediaProcessingInfo getUploadMediaProcessingInfo() {
        return uploadMediaProcessingInfo;
    }

    public void setUploadMediaProcessingInfo(UploadMediaProcessingInfo uploadMediaProcessingInfo) {
        this.uploadMediaProcessingInfo = uploadMediaProcessingInfo;
    }
}
