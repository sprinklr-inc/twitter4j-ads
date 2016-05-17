package twitter4j.api;

import com.google.common.base.Optional;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.cards.*;

import java.util.List;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 8:09 PM
 */
public interface TwitterAdsCardsApi {

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    Lead Generation Card identifier to fetch.
     * @return retrieved card details
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/lead_gen/%3Acard_id">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/lead_gen/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterLeadGenerationCard> getLeadGenerationCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Lead Generation Card Ids to fetch. If not provided returns all the Lead Generation Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Lead Generation Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of one or more Lead Generation Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/lead_gen">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/lead_gen</a>
     */
    BaseAdsListResponseIterable<TwitterLeadGenerationCard> getAllLeadGenerationCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                     Optional<Integer> count) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    The identifier of the card to be deleted.
     * @return details of the deleted card with deleted true, if successful
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/lead_gen/%3Acard_id">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/lead_gen/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterLeadGenerationCard> deleteLeadGenerationCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Image App Download Card identifiers to scope the request to. If not provided returns all the Image App Download Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Image App Download Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return details of one or more Image App Download Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/image_app_download">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/image_app_download</a>
     */
    BaseAdsListResponseIterable<TwitterImageAppDownloadCard> getAllImageAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                         Optional<Integer> count) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Video App Download Card identifiers to fetch. If not provided returns all the Video App Download Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of Video App Download Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return details of one or more Video App Download Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/video_app_download">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/video_app_download</a>
     */
    BaseAdsListResponseIterable<TwitterVideoAppDownloadCard> getAllVideoAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                         Optional<Integer> count) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    The identifier of the card to be deleted.
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/website/%3Acard_id">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/website/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterWebsiteCard> deleteWebsiteCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) Website Card identifiers to fetch. If not provided returns all the Website Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of website cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of one or more Website Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/website">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/website</a>
     */
    BaseAdsListResponseIterable<TwitterWebsiteCard> getAllWebsiteCards(String accountId, List<String> cardIds, boolean withDeleted, Optional<Integer> count)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    Website Card identifier to fetch.
     * @return retrieved card details
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/website/%3Acard_id">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/website/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterWebsiteCard> getWebsiteCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardIds     (optional) App Download Card identifiers to fetch. If not provided returns all the App Download Cards.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Specifies the number of App Download Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of ome or all App Download Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/app_download">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/app_download</a>
     */
    BaseAdsListResponseIterable<TwitterMobileAppCard> getAllAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                             Optional<Integer> count) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    App Download Card identifier to fetch.
     * @return retrieved card details
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/app_download/%3Acard_id">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/cards/app_download/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterMobileAppCard> getAppDownloadCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    The identifier of the App Download Card to be deleted.
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/app_download/%3Acard_id">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/app_download/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterMobileAppCard> deleteAppDownloadCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    The identifier of the Video App Download Card to be deleted.
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/video_app_download/%3Aid">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/video_app_download/%3Aid</a>
     */
    BaseAdsResponse<TwitterVideoAppDownloadCard> deleteVideoAppDownloadCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param cardId    The identifier of the Image App Download Card to be deleted.
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/image_app_download/%3Acard_id">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/cards/image_app_download/%3Acard_id</a>
     */
    BaseAdsResponse<TwitterImageAppDownloadCard> deleteImageAppDownloadCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param imageTonLocation The TON server location of image file to be used.
     * @return response of posting the video card image file
     * @throws TwitterException
     */
    String postVideoCardImage(String imageTonLocation) throws TwitterException;

    // ---  Stats  ---
    /**
     * @param accountId   The identifier for the leveraged account.
     * @param cardId      Lead Generation Card identifier to fetch stats for.
     * @param startTime   The time to collect stats from.
     * @param endTime     The time to collect stats until.
     * @param granularity (optional) The granularity such as DAY or HOUR as String.
     * @param metric      (optional) Specifies the number of App Download Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @param withDeleted (optional) Specifies the number of App Download Cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of ome or all App Download Cards associated with the account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/1/get/stats/accounts/%3Aaccount_id">https://dev.twitter.com/ads/reference/1/get/stats/accounts/%3Aaccount_id</a>
     */
    BaseAdsResponse<TwitterLeadGenerationStat> getTwitterLeadGenerationStat(String accountId, String cardId, String startTime, Optional<String> endTime,
                                                                            Optional<String> granularity, Optional<String> metric, Optional<Boolean> withDeleted)
            throws TwitterException;
}
