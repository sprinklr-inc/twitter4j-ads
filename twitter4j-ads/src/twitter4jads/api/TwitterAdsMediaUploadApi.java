package twitter4jads.api;

import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.media.TwitterLibraryMedia;
import twitter4jads.models.media.TwitterMediaType;
import twitter4jads.models.video.TwitterVideo;

import java.util.List;
import java.util.Set;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:40 AM
 */
public interface TwitterAdsMediaUploadApi {

    String uploadMediaAndGetMediaId(String mediaUrl, Set<String> accountUserIds, TwitterMediaType twitterMediaType, String name)
            throws TwitterException;

    TwitterVideo createVideoForAccount(String accountId, String mediaId, String title, String description, String posterImageId)
            throws TwitterException;

    BaseAdsResponse<TwitterVideo> getVideoByIdForAccount(String accountId, String videoMediaId, Boolean withDeleted) throws TwitterException;

    BaseAdsResponse<TwitterVideo> updateVideoDetails(String accountId, String videoMediaId, String title, String description, String posterImageId)
            throws TwitterException;

    BaseAdsResponse<TwitterLibraryMedia> updateName(String accountId, String videoMediaId, String title, String mediaType) throws TwitterException;

    BaseAdsResponse<TwitterVideo> deleteVideo(String accountId, String videoMediaId) throws TwitterException;

    BaseAdsListResponseIterable<TwitterVideo> getVideosForAccount(String accountId, List<String> videoIds, Boolean withDeleted)
            throws TwitterException;

    TwitterVideo waitForMediaProcessingAndGetVideo(String accountId, String channelVideoId) throws TwitterException;

}
