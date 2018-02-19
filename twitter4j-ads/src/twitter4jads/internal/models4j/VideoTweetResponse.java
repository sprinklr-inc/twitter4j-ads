package twitter4jads.internal.models4j;

/**
 * Created by vedsurtani on 03/04/15.
 */
public class VideoTweetResponse {
    private String accountId;
    private Long createdAt;
    private String videoUuid;
    private String tweetId;
    private boolean nullCase;
    private String posterUuid;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getVideoUuid() {
        return videoUuid;
    }

    public void setVideoUuid(String videoUuid) {
        this.videoUuid = videoUuid;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public boolean isNullCase() {
        return nullCase;
    }

    public void setNullCase(boolean nullCase) {
        this.nullCase = nullCase;
    }

    public String getPosterUuid() {
        return posterUuid;
    }

    public void setPosterUuid(String posterUuid) {
        this.posterUuid = posterUuid;
    }
}
