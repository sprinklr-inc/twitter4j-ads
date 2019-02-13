package twitter4jads.api;

import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.media.TwitterAccountMedia;
import twitter4jads.models.media.TwitterAccountMediaCreative;
import twitter4jads.models.media.TwitterLibraryMedia;
import twitter4jads.models.media.TwitterMediaLibraryCategory;
import twitter4jads.models.media.TwitterMediaLibraryType;
import twitter4jads.models.video.TwitterCreativeType;

/**
 * User: abhishekanand
 * Date: 16/05/16 12:25 PM.
 */
public interface TwitterAdsMediaApi {

    BaseAdsListResponseIterable<TwitterAccountMedia> getAccountMediaForAccount(String accountId, String sortBy) throws TwitterException;

    BaseAdsResponse<TwitterAccountMedia> getAccountMediaById(String accountId, String accountMediaId) throws TwitterException;

    BaseAdsListResponseIterable<TwitterAccountMediaCreative> getMediaCreativesForAccount(String accountId, Boolean fetchDeleted)
            throws TwitterException;

    /*
    to fetch video/gif/image by id
     */
    BaseAdsResponse<TwitterLibraryMedia> getMediaCreativeByKeyFromLibrary(String accountId, String mediaKey) throws TwitterException;


    BaseAdsListResponseIterable<TwitterLibraryMedia> getMediaFromLibraryForAccount(String accountId, Integer count, String cursor,
                                                                                   TwitterMediaLibraryType mediaType)
            throws TwitterException;

    BaseAdsResponse<TwitterAccountMediaCreative> deleteMediaCreative(String accountId, String mediaId) throws TwitterException;

    /**
     * @param accountId           The identifier for the leveraged account.
     * @param mediaId             The media ID to be used.
     * @param videoKey            The video Key to be used.
     * @param twitterCreativeType Creative type of media.
     * @return response of transforming media in account to promoted video
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/account_media">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/account_media</a>
     */
    BaseAdsResponse<TwitterAccountMedia> createAccountMedia(String accountId, String mediaId, String videoKey,
                                                            TwitterCreativeType twitterCreativeType) throws TwitterException;

    BaseAdsResponse<TwitterAccountMediaCreative> createAccountMediaCreative(String accountId, String lineItemId, String accountMediaId,
                                                                            String landingUrl) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param mediaId     The media ID being used to create promoted video.
     * @param title       Title of video creative being created.
     * @param description Description of video creative being created.
     * @return Twitter Library Media
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/videos">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/videos</a>
     */
    TwitterLibraryMedia createAndGetLibraryMedia(String accountId, String mediaId, TwitterMediaLibraryCategory mediaCategory, String name, String title, String description,
                                                 String posterImageMediaId, String fileName) throws TwitterException;

    BaseAdsResponse<TwitterLibraryMedia> updateLibraryMediaByKey(String accountId, String mediaKey, String name, String title,
                                                                 String description, String posterImageKey, String fileName)
            throws TwitterException;

    TwitterLibraryMedia waitForProcessingAndGetMedia(String accountId, String mediaKey) throws TwitterException;

    BaseAdsResponse<TwitterLibraryMedia> deleteLibraryMediaByKey(String accoundId, String mediaKey) throws TwitterException;
}
