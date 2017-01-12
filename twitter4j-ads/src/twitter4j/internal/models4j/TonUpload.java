package twitter4j.internal.models4j;

/**
 * Created by vedsurtani on 01/04/15.
 */
public class TonUpload {

    public enum MediaType{
        IMAGE,VIDEO,AUDIENCE
    }

    private MediaType mediaType;
    private String mediaUrl;
    private Long totalContentLength;
    private String contentType;
    public TonUpload() {

    }
    public TonUpload(MediaType mediaType, String mediaUrl) {
        this.mediaType = mediaType;
        this.mediaUrl = mediaUrl;
    }


    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public Long getTotalContentLength() {
        return totalContentLength;
    }

    public void setTotalContentLength(Long totalContentLength) {
        this.totalContentLength = totalContentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}

