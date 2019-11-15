package twitter4jads.api;

import twitter4jads.BaseAdsListBatchPostResponse;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.TailoredAudience;
import twitter4jads.models.ads.audience.TailoredAudienceMatchingRules;
import twitter4jads.models.ads.audience.TailoredAudienceOperation;
import twitter4jads.models.ads.audience.TailoredAudiencePermission;

import java.util.List;
import java.util.Optional;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:54 AM
 */
public interface TwitterAdsAudienceApi {

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count       (optional) Limit the number returned per page of requests to the specified amount.
     * @param cursor      (optional) Specifies a cursor to get the next page of TailoredAudience objects (function automatically handles paging upon iteration when you do not specify cursor value).
     * @return the collection of TailoredAudience objects belonging to the authenticated user.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audiences">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audiences</a>
     */
    BaseAdsListResponseIterable<TailoredAudience> getAllTailoredAudiences(String accountId, Optional<Integer> count,
                                                                          Optional<Boolean> withDeleted, Optional<String> cursor)
            throws TwitterException;

    /**
     * @param accountId          The identifier for the leveraged account.
     * @param tailoredAudienceId The identifier for a specific tailored audience.
     * @return detailed information on a specific tailored audience.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audiences/%3Aid">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audiences/%3Aid</a>
     */
    BaseAdsResponse<TailoredAudience> getTailoredAudienceForId(String accountId, String tailoredAudienceId) throws TwitterException;

    /**
     * @param accountId          The identifier for the leveraged account.
     * @param tailoredAudienceId The identifier for a specific tailored audience.
     * @return response of deleting a tailored audience.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/tailored_audiences/%3Aid">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/tailored_audiences/%3Aid</a>
     */
    BaseAdsResponse<TailoredAudience> deleteTailoredAudience(String accountId, String tailoredAudienceId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param name      The name of the tailored audience to create.
     * @return response of creating a tailored audience.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/tailored_audiences">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/tailored_audiences</a>
     */
    BaseAdsResponse<TailoredAudience> createTailoredAudience(String accountId, String name) throws TwitterException;

    /**
     * @param tailoredAudienceMatchingRules
     * @param accountId                     The identifier for the leveraged account.
     * @return Resultant matching rules for tailored audiences
     * @throws TwitterException
     */
    BaseAdsResponse<TailoredAudienceMatchingRules> addMatchingRulesToAudience(TailoredAudienceMatchingRules tailoredAudienceMatchingRules,
                                                                              String accountId)
            throws TwitterException;

    /**
     * Update tailored audience using specified operation.
     * Returns operations as actually sent to twitter.
     * The supplied operations will not be mixed but might be broken down into smaller operations for batch processing.
     * <p>
     * The operations returned are not guaranteed to be in the same order as when supplied.
     * Only the user detail correspondence with the effective, expire and operation fields is maintained.
     * <p>
     * Batching of operations is taken care automatically
     * Returns on first batch that fails.
     *
     * @param accountId          The identifier for the leveraged account.
     * @param tailoredAudienceId The identifier for a specific tailored audience.
     * @param operations         List of tailored audience operations to be performed
     * @return On successful update returns list of operations as actually sent with batching. On failure, last operation in list will be the one that failed.
     * @throws TwitterException
     */
    List<TailoredAudienceOperation> updateTailoredAudienceById(String accountId, String tailoredAudienceId,
                                                               List<TailoredAudienceOperation> operations)
            throws TwitterException;

    /**
     * @param accountId
     * @param requestBody
     * @return
     * @throws TwitterException
     */
    BaseAdsListBatchPostResponse<TailoredAudience> createFlexibleTailoredAudience(String accountId, String requestBody) throws TwitterException;

    /**
     * @param accountId
     * @param tailoredAudienceId
     * @return
     * @throws TwitterException
     */
    BaseAdsListResponse<TailoredAudiencePermission> getTailoredAudiencePermission(String accountId, String tailoredAudienceId) throws
            TwitterException;

    /**
     * @param accountId
     * @param tailoredAudienceId
     * @param grantedAccountId
     * @return
     * @throws TwitterException
     */
    BaseAdsResponse<TailoredAudiencePermission> shareTailoredAudience(String accountId, String tailoredAudienceId, String
            grantedAccountId) throws TwitterException;
}
