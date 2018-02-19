package twitter4jads.api;

import com.google.common.base.Optional;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.LocationType;
import twitter4jads.models.ads.*;
import twitter4jads.models.ads.tags.TwitterApplicationList;
import twitter4jads.models.ads.targeting.TargetingParamRequest;
import twitter4jads.models.ads.targeting.TargetingParamResponse;

import java.util.List;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 7:15 PM
 */
public interface TwitterAdsTargetingApi {

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param lineItemId  Scope targeting criteria to a specific line item by providing its identifier.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return Retrieve details for some or all TargetingCriterias associated with the current account.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/targeting_criteria">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/targeting_criteria</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getTargetingCriterias(String accountId, String lineItemId, boolean withDeleted)
            throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param targetingId A reference to the targeting criteria you are operating with in the request.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return Retrieve detailed information on a targeting criterion associated with a specific line item.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/targeting_criteria/%3Aid">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/targeting_criteria/%3Aid</a>
     */
    BaseAdsResponse<TargetingCriteria> getTargetingCriteriaById(String accountId, String targetingId, boolean withDeleted) throws TwitterException;

    /**
     * @param accountId                 The identifier for the leveraged account.
     * @param lineItemId                The line item ID to create targeting criteria upon.
     * @param targetingType             The type of targeting to be used with this targeting criteria.
     * @param targetingValue            The targeting value being set.
     * @param tailoredAudienceExpansion (optional) Whether or not to expand tailored audiences.
     * @param tailoredAudienceType      (optional) The type of tailored audience being set.
     * @return created targeting criteria
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/targeting_criteria">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/targeting_criteria</a>
     */
    BaseAdsResponse<TargetingCriteria> createTargetingCriteria(String accountId, String lineItemId, TargetingType targetingType,
                                                               String targetingValue, boolean tailoredAudienceExpansion,
                                                               Optional<TailoredAudienceType> tailoredAudienceType)
            throws TwitterException;

    /**
     * @param accountId               The identifier for the leveraged account.
     * @param lineItemId              The line item ID to create targeting criteria upon.
     * @param targetingCriteriaValues A list of TargetingCriteria object to set multiple targeting criteria.
     * @return created targeting criterias
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/put/accounts/%3Aaccount_id/targeting_criteria">https://dev.twitter.com/ads/reference/put/accounts/%3Aaccount_id/targeting_criteria</a>
     */
    List<TargetingCriteria> createTargetingCriterias(String accountId, String lineItemId, List<TargetingCriteria> targetingCriteriaValues)
            throws TwitterException;

    /**
     * @param accountId           The identifier for the leveraged account.
     * @param targetingCriteriaId The targeting criteria ID to delete.
     * @return deleted targeting criteria with deleted field set to true
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/targeting_criteria">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/targeting_criteria</a>
     */
    BaseAdsResponse<TargetingCriteria> deleteTargetingCriteria(String accountId, String targetingCriteriaId) throws TwitterException;

    /**
     * @param locationType (optional) Scope the results to a specific type of location.
     * @param q            (optional) Search for a specific location.
     * @param countryCode  (optional) Specify a country code to retrieve results from.
     * @param count        (optional) Limit the number of results to the given count.
     * @return all possible targeting locations to choose from
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/locations">https://dev.twitter.com/ads/reference/get/targeting_criteria/locations</a>
     */
    BaseAdsListResponseIterable<TargetingLocation> getAllTargetingLocations(Optional<LocationType> locationType, String q,
                                                                            String countryCode, Optional<Integer> count) throws TwitterException;

    /**
     * @param locationType (optional) Scope the results to a specific type of location.
     * @param query        (optional) Search for a specific location.
     * @return all possible targeting locations to choose from for the given location type
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/locations">https://dev.twitter.com/ads/reference/get/targeting_criteria/locations</a>
     */
    BaseAdsListResponseIterable<TargetingLocation> getTargetingLocations(String query, LocationType locationType) throws TwitterException;

    /**
     * @param q (optional) Search results for matching a specific locale.
     * @return all possible twitter targeting languages to choose from
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/languages">https://dev.twitter.com/ads/reference/get/targeting_criteria/languages</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingLocales(String q) throws TwitterException;

    /**
     * @param q (optional) Search for a specific event.
     * @return all possible events to choose from
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/events">https://dev.twitter.com/ads/reference/get/targeting_criteria/events</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingEvents(String q) throws TwitterException;

    /**
     * @return all the events that can be targeted
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/events">https://dev.twitter.com/ads/reference/get/targeting_criteria/events</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllEvents() throws TwitterException;

    /**
     * @param q (optional) Search for a specific interest.
     * @return all possible targeting interests to choose from
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/interests">https://dev.twitter.com/ads/reference/get/targeting_criteria/interests</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingInterests(String q) throws TwitterException;

    /**
     * @param q (optional) Search results for matching a specific platform.
     * @return all possible targeting platforms to choose from
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/platforms">https://dev.twitter.com/ads/reference/get/targeting_criteria/platforms</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingPlatforms(String q) throws TwitterException;

    /**
     * @param q (optional) Search results for matching a specific network operator.
     * @return all possible network operators to choose from
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/network_operators">https://dev.twitter.com/ads/reference/get/targeting_criteria/network_operators</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingNetworkOperators(String q) throws TwitterException;

    /**
     * @return all possible targeting platform versions to choose from
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/platform_versions">https://dev.twitter.com/ads/reference/get/targeting_criteria/platform_versions</a>
     */
    BaseAdsListResponseIterable<PlatformVersions> getAllTargetingPlatformVersions() throws TwitterException;

    /**
     * @param q (optional) Search results for matching a specific device.
     * @return all possible targeting devices to choose from
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/devices">https://dev.twitter.com/ads/reference/get/targeting_criteria/devices</a>
     */
    BaseAdsListResponseIterable<Devices> getAllTargetingDevices(String q) throws TwitterException;

    /**
     * @param tvMarketLocale (optional) Scope the results to a specific tv market locale.
     * @param count          (optional) Limit the number of results to the given count.
     * @param cursor         (optional) Specify a cursor to retrieve data from a specific page (function automatically handles paging upon iteration when you do not specify cursor value).
     * @return all possible twitter targeting tv channels to choose from
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/tv_channels">https://dev.twitter.com/ads/reference/get/targeting_criteria/tv_channels</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingTVChannels(String tvMarketLocale, Optional<Integer> count, Optional<String> cursor)
            throws TwitterException;

    /**
     * @param tvMarket (optional) Scope the results to a specific tv market.
     * @param q        (optional) Search results for matching a specific tv show.
     * @param count    (optional) Limit the number of results to the given count.
     * @param cursor   (optional) Specify a cursor to retrieve data from a specific page (function automatically handles paging upon iteration when you do not specify cursor value).
     * @return all the tv shows (matching q if provided) that can be targeted
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/tv_shows">https://dev.twitter.com/ads/reference/get/targeting_criteria/tv_shows</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTVShows(String tvMarket, String q, Optional<Integer> count, Optional<String> cursor) throws TwitterException;

    /**
     * @return All the TV Markets that can be targeted
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/tv_markets">https://dev.twitter.com/ads/reference/get/targeting_criteria/tv_markets</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTVMarkets() throws TwitterException;

    /**
     * @return All the TV Genres that can be targeted
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/tv_genres">https://dev.twitter.com/ads/reference/get/targeting_criteria/tv_genres</a>
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingTVGenres() throws TwitterException;


    /**
     * @param accountId       The identifier for the leveraged account.
     * @param suggestionType  Specify the enum of suggestions being received.
     * @param targetingValues Targeting values being used to seed the suggestion.
     * @param count           (optional) Limit the number of results to the given count.
     * @param ignoredValues   (optional) A list of values to ignore from suggested output.
     * @return list of targeting suggestions for keywords and user IDs
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/targeting_suggestions">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/targeting_suggestions</a>
     */
    List<TargetingSuggestion> getTargetingSuggestion(String accountId, SuggestionType suggestionType, List<String> targetingValues,
                                                     Optional<Integer> count, List<String> ignoredValues) throws TwitterException;

    /**
     * @param behaviorIds (optional) Scope the results to a set of behavior IDs.
     * @param count       (optional) Limit the number of results to the given count.
     * @param cursor      (optional) Specify a cursor to retrieve data from a specific page (function automatically handles paging upon iteration when you do not specify cursor value).
     * @return all the behaviors that can be targeted
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/behaviors">https://dev.twitter.com/ads/reference/get/targeting_criteria/behaviors</a>
     */
    BaseAdsListResponseIterable<TwitterBehavior> getBehaviors(Optional<Integer> count, Optional<String> cursor, List<String> behaviorIds)
            throws TwitterException;

    /**
     * @param behaviorTaxonomyIds       (optional) List of behavior taxonomy identifiers by which to filter the response.
     * @param parentBehaviorTaxonomyIds (optional) List of behavior taxonomy identifiers of parent nodes in the tree structures. Specifying parents will only return children nodes of the taxonomy.
     * @param count                     (optional) Limit the number of results to the given count.
     * @param cursor                    (optional) Specify a cursor to retrieve data from a specific page (function automatically handles paging upon iteration when you do not specify cursor value).
     * @return the full or partial behavior taxonomy tree
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/behavior_taxonomies">https://dev.twitter.com/ads/reference/get/targeting_criteria/behavior_taxonomies</a>
     */
    BaseAdsListResponseIterable<TwitterBehaviorTaxonomy> getBehaviorTaxonomy(List<String> behaviorTaxonomyIds,
                                                                             List<String> parentBehaviorTaxonomyIds, Optional<Integer> count,
                                                                             Optional<String> cursor) throws TwitterException;

    /**
     * @param q                  (optional) Search results for matching a specific app store category.
     * @param appStoreSearchType (optional) Limit the number of results to the given count.
     * @return Some or all of the targetable app store categories
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/targeting_criteria/app_store_categories">https://dev.twitter.com/ads/reference/get/targeting_criteria/app_store_categories</a>
     */
    List<TwitterAppStore> searchAppStoreCategories(String q, Optional<AppStoreSearchType> appStoreSearchType) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @return all app lists associated with the specified account ID
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/app_lists">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/app_lists</a>
     */
    BaseAdsListResponseIterable<TwitterApplicationList> getAllAppLists(String accountId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param listId    A specific app list ID.
     * @return an application list given a specific list ID
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/app_lists">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/app_lists</a>
     */
    BaseAdsResponse<TwitterApplicationList> getAllAppsListsById(String accountId, String listId) throws TwitterException;

    /**
     * @param accountId              The identifier for the leveraged account.
     * @param twitterApplicationList A list of applications to add to app list.
     * @return response of creating a new application list
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/app_lists">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/app_lists</a>
     */
    BaseAdsResponse<TwitterApplicationList> createNewApplicationList(String accountId, TwitterApplicationList twitterApplicationList)
            throws TwitterException;

    /**
     * @param q (optional) Search results for matching a specific IAB category.
     * @return all the Twitter IAB categories that can be targeted
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/iab_categories">https://dev.twitter.com/ads/reference/get/iab_categories</a>
     */
    BaseAdsListResponseIterable<IabCategory> getAllIabCategories(String q) throws TwitterException;

    /**
     * @return reach_estimate of the ad
     */
    BaseAdsResponse<NewTwitterReachEstimate> getReachEstimate(String accountId, ProductType productType, List<TargetingCriteria> targetingCriterias,
                                                              String objective, Long bidAmountLocalMicro, String currency, Long campaignDailyBudgetAmountLocalMicro, String bidType)
            throws TwitterException;

    BaseAdsListResponseIterable<IabCategory> fetchIabCategories(String q) throws TwitterException;

    TargetingParamResponse createTargetingBatchRequest(String accountId, List<TargetingParamRequest> targetingParamRequests)
            throws TwitterException;

}
