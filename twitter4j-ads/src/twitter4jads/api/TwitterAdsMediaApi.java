package twitter4jads.api;

import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.media.TwitterAccountMedia;
import twitter4jads.models.media.TwitterAccountMediaCreative;
import twitter4jads.models.media.TwitterLibraryMedia;
import twitter4jads.models.media.TwitterMediaLibraryType;
import twitter4jads.models.video.TwitterCreativeType;

/**
 * User: abhishekanand
 * Date: 16/05/16 12:25 PM.
 */
public interface TwitterAdsMediaApi {

    BaseAdsListResponseIterable<TwitterAccountMedia> getAccountMediaForAccount(String accountId) throws TwitterException;

    BaseAdsResponse<TwitterAccountMedia> getAccountMediaById(String accountId, String accountMediaId) throws TwitterException;

    BaseAdsListResponseIterable<TwitterAccountMediaCreative> getMediaCreativesForAccount(String accountId, Boolean fetchDeleted)
        throws TwitterException;

    /*
    to fetch video/gif/image by id
     */
    BaseAdsResponse<TwitterLibraryMedia> getMediaCreativeByIdFromLibrary(String accountId, String mediaId) throws TwitterException;


    BaseAdsListResponseIterable<TwitterLibraryMedia> getMediaFromLibraryForAccount(String accountId, Integer count, String cursor,
                                                                                   TwitterMediaLibraryType mediaType, Boolean totalCount)
        throws TwitterException;

    BaseAdsResponse<TwitterAccountMediaCreative> deleteMediaCreative(String accountId, String mediaId) throws TwitterException;

    BaseAdsResponse<TwitterAccountMedia> createAccountMedia(String accountId, String mediaId, String videoId,
                                                            TwitterCreativeType twitterCreativeType) throws TwitterException;

    BaseAdsResponse<TwitterAccountMediaCreative> createAccountMediaCreative(String accountId, String lineItemId, String accountMediaId,
                                                                            String landingUrl) throws TwitterException;
}
