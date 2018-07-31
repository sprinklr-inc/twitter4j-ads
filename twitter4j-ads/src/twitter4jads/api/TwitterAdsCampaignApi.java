package twitter4jads.api;

import com.google.common.base.Optional;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.Campaign;
import twitter4jads.models.ads.EntityStatus;
import twitter4jads.models.ads.sort.CampaignSortByField;

import java.util.Collection;

/**
 * User: abhay
 * Date: 4/7/16
 * Time: 12:25 PM
 */
public interface TwitterAdsCampaignApi {

    /**
     * @param accountId            The identifier for the leveraged account.
     * @param campaignIds          (optional) Scope the response to just the desired campaigns by specifying a comma-separated list of identifiers. Up to 50 ids may be provided.
     * @param fundingInstrumentIds (optional) Scope the response to just the desired funding instruments by specifying a comma-separated list of identifiers.
     *                             Up to 50 ids may be provided.
     * @param withDeleted          Include deleted results in your request. Defaults to false.
     * @param count                (optional) Specifies the number of campaigns to try and retrieve, up to a maximum of 1000 per distinct request.
     * @param cursor               (optional) Specify a cursor to retrieve data from a specific page (function automatically handles paging upon iteration when you do not specify cursor value).
     * @return Retrieve details for some or all campaigns associated with the current account.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/campaigns">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/campaigns</a>
     */
    BaseAdsListResponseIterable<Campaign> getAllCampaigns(String accountId, Optional<Collection<String>> campaignIds,
                                                          Optional<Collection<String>> fundingInstrumentIds, boolean withDeleted, Optional<Integer> count,
                                                          Optional<String> cursor, Optional<CampaignSortByField> sortByField) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param campaignId  The identifier for a campaign associated with the current account.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return Retrieve details for a specific campaign associated with the current account.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/campaigns/%3Acampaign_id">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/campaigns/%3Acampaign_id</a>
     */
    BaseAdsResponse<Campaign> getCampaignById(String accountId, String campaignId, boolean withDeleted) throws TwitterException;


    /**
     * @param campaign A Campaign object representing the campaign to be created.
     * @return created campaign response.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/campaigns">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/campaigns</a>
     */
    BaseAdsResponse<Campaign> createCampaign(Campaign campaign) throws TwitterException;

    /**
     * @param accountId                   The identifier for the leveraged account.
     * @param campaignId                  The identifier of campaign to update.
     * @param name                        (optional) Name to update the cmapaign with.
     * @param totalBudgetAmountLocalMicro Name to update the cmapaign with.
     * @param dailyBudgetAmountLocalMicro (optional) Name to update the cmapaign with.
     * @param startTime                   (optional) Start time to update the cmapaign with.
     * @param endTime                     (optional) End time to update the cmapaign with.
     * @param status                      Status of the campaign
     * @param standardDelivery            (optional) Update the standard delivery setting of campaign.
     * @param frequencyCap                (if value passed greater than 0) Update integer representing the number of times for which one user could be delivered an ad to.
     * @param durationInDays              (if value passed greater than 0) Update integer representing the time period within which the frequency_cap frequency is achieved. Only supports values of: 1, 7 and 30.
     * @return updated campaign response.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/put/accounts/%3Aaccount_id/campaigns/%3Acampaign_id">https://dev.twitter.com/ads/reference/put/accounts/%3Aaccount_id/campaigns/%3Acampaign_id</a>
     */
    BaseAdsResponse<Campaign> updateCampaign(String accountId, String campaignId, Optional<String> name,
                                             Long totalBudgetAmountLocalMicro, Optional<Long> dailyBudgetAmountLocalMicro, Optional<String> startTime,
                                             Optional<String> endTime, EntityStatus status,
                                             Optional<Boolean> standardDelivery, int frequencyCap, int durationInDays) throws TwitterException;

    /**
     * @param accountId  The identifier for the leveraged account.
     * @param campaignId The identifier of campaign to delete.
     * @return Campaign to be deleted with deleted field set to true
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/campaigns/%3Acampaign_id">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/campaigns/%3Acampaign_id</a>
     */
    BaseAdsResponse<Campaign> deleteCampaign(String accountId, String campaignId) throws TwitterException;

}
