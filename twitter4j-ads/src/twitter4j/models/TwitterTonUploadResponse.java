package twitter4j.models;

/**
 * User: abhishekanand
 * Date: 30/01/15
 * Time: 11:19 PM
 */
public class TwitterTonUploadResponse {
    public static final String ACCOUNT_ID = "accountId";
    public static final String EXPIRES_TIME = "expiresTime";


    public TwitterTonUploadResponse(String location, Integer minimumChunkSize, Integer maximumChunkSize, Integer bytesUploaded,
                                    Integer sentContentLength) {
        this.location = location;
        this.minimumChunkSize = minimumChunkSize;
        this.maximumChunkSize = maximumChunkSize;
        this.bytesUploaded = bytesUploaded;
        this.sentContentLength = sentContentLength;
    }

    public TwitterTonUploadResponse(String location){
        this(location, null, null, null, null);
    }

    private String location;
    private Integer minimumChunkSize;
    private Integer maximumChunkSize;
    private Long accountId;
    private Long uploadedTime;
    private Long connectionExpiresTime;
    private Integer bytesUploaded;
    private Integer sentContentLength;

    public Integer getSentContentLength() {
        return sentContentLength;
    }

    public void setSentContentLength(Integer sentContentLength) {
        this.sentContentLength = sentContentLength;
    }

    public Integer getBytesUploaded() {
        return bytesUploaded;
    }

    public void setBytesUploaded(Integer bytesUploaded) {
        this.bytesUploaded = bytesUploaded;
    }

    public Long getConnectionExpiresTime() {
        return connectionExpiresTime;
    }

    public void setConnectionExpiresTime(Long connectionExpiresTime) {
        this.connectionExpiresTime = connectionExpiresTime;
    }

    public Long getUploadedTime() {
        return uploadedTime;
    }

    public void setUploadedTime(Long uploadedTime) {
        this.uploadedTime = uploadedTime;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getMaximumChunkSize() {
        return maximumChunkSize;
    }

    public void setMaximumChunkSize(Integer maximumChunkSize) {
        this.maximumChunkSize = maximumChunkSize;
    }

    public Integer getMinimumChunkSize() {
        return minimumChunkSize;
    }

    public void setMinimumChunkSize(Integer minimumChunkSize) {
        this.minimumChunkSize = minimumChunkSize;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
