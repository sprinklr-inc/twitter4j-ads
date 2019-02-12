package twitter4jads.models.media;

/**
 * Media category and their respective codes for media library
 * User: mayankbhargava
 *
 * @date 30/11/18
 * @time 12:17 PM
 */
public enum TwitterMediaLibraryCategory {

    AMPLIFY_VIDEO(13),
    TWEET_VIDEO(7),
    TWEET_IMAGE(3),
    TWEET_GIF(16);

    private int code;

    TwitterMediaLibraryCategory(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
