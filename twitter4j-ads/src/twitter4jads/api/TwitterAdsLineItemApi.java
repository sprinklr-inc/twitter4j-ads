package twitter4jads.api;

import com.google.common.base.Optional;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.*;
import twitter4jads.models.ads.sort.LineItemsSortByField;
import twitter4jads.models.ads.sort.PromotedAccountsSortByField;
import twitter4jads.models.media.TwitterMediaCallToAction;
import twitter4jads.models.video.AssociateMediaCreativeResponse;
import twitter4jads.models.video.TwitterCallToActionType;

import java.util.Collection;
import java.util.List;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 8:00 PM
 */
public interface TwitterAdsLineItemApi {

    /**
     * @param accountId            The identifier for the leveraged account.
     * @param campaignIds          (optional) Scope the response to just the desired campaigns by specifying a Collection of identifiers. Up to 50 ids may be provided.
     * @param lineItemIds          (optional) Scope the response to just the desired line items by specifying a Collection of identifiers. Up to 50 ids may be provided.
     * @param fundingInstrumentIds (optional) Scope the response to just the desired funding instruments by specifying a Collection of identifiers. Up to 50 ids may be provided.
     * @param count                (optional) Specifies the number of campaigns to try and retrieve, up to a maximum of 1000 per distinct request.
     * @param cursor               (optional) Specify a cursor to retrieve data from a specific page (function automatically handles paging upon iteration when you do not specify cursor value).
     * @param sortByField          (optional) Specify to return the line items according to the sorted parameter given.
     * @param withDeleted          Include deleted results in your request. Defaults to false.
     * @return Retrieve the line items associated with a specific campaign belonging to the current account.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/line_items">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/line_items</a>
     */
    BaseAdsListResponseIterable<LineItem> getAllLineItems(String accountId, Optional<Collection<String>> campaignIds, Optional<Collection<String>> lineItemIds,
                                                          Optional<Collection<String>> fundingInstrumentIds, Optional<Integer> count, boolean withDeleted,
                                                          String cursor, Optional<LineItemsSortByField> sortByField) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param lineItemId A reference to the line item you are operating with in the request.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return Retrieve a specific line item associated with a campaign belonging to the current account.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/line_items/%3Aline_item_id">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/line_items/%3Aline_item_id</a>
     */
    BaseAdsResponse<LineItem> getLineItemById(String accountId, String lineItemId, boolean withDeleted) throws TwitterException;


    /**
     * @param lineItem A LineItem object representing the line item to be created.
     * @return created line item
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/line_items">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/line_items</a>
     */
    BaseAdsResponse<LineItem> createLineItem(LineItem lineItem) throws TwitterException;

    /**
     * @param accountId              The identifier for the leveraged account.
     * @param lineItemId             The line item identifier of the line item to update.
     * @param bidType                The BidType to use on this line item.
     * @param automaticallySelectBid Whether to use auto bidding on this line item.
     * @param bidAmountLocalMicro    (optional) Specify a new bid to set on this line item.
     * @param status                 Status to set
     * @param includeSentiment       (optional) Update the include sentiment parameter of line item.
     * @param chargeBy               (optional) Update the charge by parameter of line item.
     * @param bidUnit                (optional) Update the bid unit parameter of line item.
     * @param advertiserDomain       (optional) Update the advertiser domain of line item (for TAP campaigns).
     * @param iabCategories          (optional) Update the IAB categories associated with the line item (for TAP campaigns).
     * @return updated line item
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/put/accounts/%3Aaccount_id/line_items/%3Aline_item_id">https://dev.twitter.com/ads/reference/put/accounts/%3Aaccount_id/line_items/%3Aline_item_id</a>
     */
    BaseAdsResponse<LineItem> updateLineItem(String accountId, String lineItemId, BidType bidType, boolean automaticallySelectBid,
                                             Optional<Long> bidAmountLocalMicro, EntityStatus status, Optional<Sentiments> includeSentiment,
                                             Optional<Boolean> matchRelevantPopularQueries, Optional<String> chargeBy,
                                             Optional<String> bidUnit, Optional<String> advertiserDomain, String optimization,
                                             String[] iabCategories, String startTime, String endTime, String name,
                                             Long targetCPA, Long budget, String trackingTags) throws TwitterException;

    /**
     * @param accountId  The identifier for the leveraged account.
     * @param lineItemId The line item identifier of the line item to delete.
     * @return line item to be deleted with deleted field set to true
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/line_items/%3Aline_item_id">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/line_items/%3Aline_item_id</a>
     */
    BaseAdsResponse<LineItem> deleteLineItem(String accountId, String lineItemId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param lineItemId Scope the response to just the desired line item
     * @param userId Id of the user of the account to be promoted
     * @return created promoted account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/promoted_accounts">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/promoted_accounts</a>
     */
    BaseAdsResponse<PromotedAccount> createPromotedAccounts(String accountId, String lineItemId, String userId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param promotedAccountIds (optional) Scope the response to the Collection of promoted account IDs. These identifiers refer to a associated Promoted Account with a line item.
     * @param lineItemId         (optional) A reference to the line item you are operating with in the request. Omitting the lineItemId will return all
     *                           promoted tweets across all campaigns.
     * @param withDeleted        Include deleted results in your request. Defaults to false.
     * @param sortByField        Sorts by supported attribute in ascending or descending order.
     * @return references to the Promoted Accounts associated with one or more line items
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/promoted_accounts">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/promoted_accounts</a>
     */
    BaseAdsListResponseIterable<PromotedAccount> getPromotedAccounts(String accountId, Optional<Collection<String>> promotedAccountIds,
                                                                     Optional<String> lineItemId, boolean withDeleted,
                                                                     PromotedAccountsSortByField sortByField) throws TwitterException;

    /**
     * @param accountId               The identifier for the leveraged account.
     * @param lineItemId              The line item identifier of the line item to create call to action details for.
     * @param twitterCallToActionType The call to action type to be used with this pre-roll.
     * @param callToActionUrl         The call to action URL to be used with this pre-roll.
     * @return the response of creating call to action details for pre roll views
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/preroll_call_to_action">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/preroll_call_to_action</a>
     */
    BaseAdsResponse<TwitterMediaCallToAction> createCallToActionDetails(String accountId, String lineItemId,
                                                                        TwitterCallToActionType twitterCallToActionType,
                                                                        String callToActionUrl) throws TwitterException;

    /**
     * @param accountId      The identifier for the leveraged account.
     * @param lineItemId     The line item identifier of the line item to associate media with.
     * @param accountMediaId The account media ID to associate.
     * @param landingUrl     The url of the media creative.
     * @return response of associating media creative with account
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/media_creatives">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/media_creatives</a>
     */
    BaseAdsResponse<AssociateMediaCreativeResponse> associateMediaCreativeWithAccount(String accountId, String lineItemId, String accountMediaId,
                                                                                      String landingUrl) throws TwitterException;

    BaseAdsListResponseIterable<PromotedAccount> getPromotedAccounts(String accountId, Collection<String> promotedAccountIds, String lineItemId,
                                                                     boolean withDeleted) throws TwitterException;

    BaseAdsResponse<TwitterMediaCallToAction> updateCallToAction(String accountId, String channelId, String callToActionUrl,
                                                                 TwitterCallToActionType twitterCallToActionType) throws TwitterException;

    BaseAdsResponse<TwitterMediaCallToAction> deleteCallToAction(String accountId, String channelId) throws TwitterException;

    BaseAdsResponse<LineItemAppResponse> publishApp(String accountId, String lineItemId, String appStoreIdentifier, TwitterOSType twitterOSType)
        throws TwitterException;


    BaseAdsResponse<LineItemAppResponse> getForLineItemAppId(String accountId, String lineItemAppId) throws TwitterException;

    BaseAdsListResponseIterable<LineItemAppResponse> getForLineItemAppIds(String accountId, String lineItemId, List<String> lineItemAppIds,
                                                                          Integer count, String cursor, boolean withDeleted) throws TwitterException;

    BaseAdsResponse<LineItemAppResponse> deleteLineItemApp(String accountId, String lineItemAppId) throws TwitterException;
}
