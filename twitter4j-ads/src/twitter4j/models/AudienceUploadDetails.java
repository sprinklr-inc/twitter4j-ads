package twitter4j.models;

import twitter4j.models.ads.TailoredAudienceDataType;

/**
 * User: abhishekanand
 * Date: 10/10/14
 * Time: 11:58 PM
 */
public class AudienceUploadDetails extends TwitterTonUploadResponse {
    public static final String ACCOUNT_ID = "accountId";
    public static final String EXPIRES_TIME = "expiresTime";

    private TailoredAudienceDataType tailoredAudienceDataType;
    private Integer dataCount;


    public AudienceUploadDetails(String location, Integer minChunkSize, Integer maxChunkSize, Integer bytesUploaded, Integer sentContentLength) {
        super(location, minChunkSize, maxChunkSize, bytesUploaded, sentContentLength);
    }

    public TailoredAudienceDataType getTailoredAudienceDataType() {
        return tailoredAudienceDataType;
    }

    public void setTailoredAudienceDataType(TailoredAudienceDataType tailoredAudienceDataType) {
        this.tailoredAudienceDataType = tailoredAudienceDataType;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }


}
