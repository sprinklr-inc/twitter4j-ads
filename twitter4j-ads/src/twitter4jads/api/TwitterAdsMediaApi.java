package twitter4jads.api;

import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.media.*;

/**
 * User: abhishekanand
 * Date: 16/05/16 12:25 PM.
 */
public interface TwitterAdsMediaApi {

    /**
     * @param accountId The identifier for the leveraged account.
     * @param sortBy    Sorts by supported attribute in ascending or descending order.
     * @return
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterAccountMedia> getAccountMediaForAccount(String accountId, String sortBy) throws TwitterException;

    /**
     * @param accountId      The identifier for the leveraged account.
     * @param accountMediaId A reference to the account media you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterAccountMedia> getAccountMediaById(String accountId, String accountMediaId) throws TwitterException;

    /**
     * @param accountId    The identifier for the leveraged account.
     * @param fetchDeleted Include deleted results in your request.
     * @return
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterAccountMediaCreative> getMediaCreativesForAccount(String accountId, Boolean fetchDeleted)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param mediaKey  A reference to the media library object you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    /*
    to fetch video/gif/image by id
     */
    BaseAdsResponse<TwitterLibraryMedia> getMediaCreativeByKeyFromLibrary(String accountId, String mediaKey) throws TwitterException;


    /**
     * @param accountId The identifier for the leveraged account.
     * @param count     Specifies the number of records to try and retrieve per distinct request.
     * @param cursor    Specifies a cursor to get the next page of results
     * @param mediaType Scope the response to just the desired media type.
     * @param q         An optional query to scope resource by name, title, file_name, and description fields.
     * @return
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterLibraryMedia> getMediaFromLibraryForAccount(String accountId, Integer count, String cursor,
                                                                                   TwitterMediaLibraryType mediaType, String q)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param mediaKey  A reference to the media library object you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterAccountMediaCreative> deleteMediaCreative(String accountId, String mediaKey) throws TwitterException;

    /**
     * @param accountId      The identifier for the leveraged account.
     * @param lineItemId     A reference to the line item you are operating with in the request.
     * @param accountMediaId A reference to the account media entity you are operating with in the request.
     * @param landingUrl     The URL of the website to direct a user to
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterAccountMediaCreative> createAccountMediaCreative(String accountId, String lineItemId, String accountMediaId,
                                                                            String landingUrl) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param mediaKey    The media ID being used to create promoted video.
     * @param title       Title of video creative being created.
     * @param description Description of video creative being created.
     * @return Twitter Library Media
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/videos">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/videos</a>
     */
    TwitterLibraryMedia createAndGetLibraryMedia(String accountId, String mediaKey, TwitterMediaLibraryCategory mediaCategory, String name, String title, String description,
                                                 String posterImageMediaId, String fileName) throws TwitterException;

    /**
     * @param accountId      The identifier for the leveraged account.
     * @param mediaKey       A reference to the media library object you are operating with in the request.
     * @param name           The name for the media library object. Maximum length: 100.
     * @param title          The title (headline) that appears under the video when Tweeted.
     * @param description    The description that appears under the video when Tweeted.
     * @param posterMediaKey Specify a poster image for the video using the media_key of an uploaded image.
     * @param fileName       The file name for the media library object.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterLibraryMedia> updateLibraryMediaByKey(String accountId, String mediaKey, String name, String title,
                                                                 String description, String posterMediaKey, String fileName)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param mediaKey  A reference to the media library object you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    TwitterLibraryMedia waitForProcessingAndGetMedia(String accountId, String mediaKey) throws TwitterException;

    /**
     * @param accoundId The identifier for the leveraged account.
     * @param mediaKey  A reference to the media library object you are operating with in the request.
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterLibraryMedia> deleteLibraryMediaByKey(String accoundId, String mediaKey) throws TwitterException;
}
