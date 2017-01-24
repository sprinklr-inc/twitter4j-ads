package twitter4j.api;

import com.google.common.base.Optional;
import twitter4j.BaseAdsListBatchPostResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.TwitterTonUploadResponse;
import twitter4j.models.ads.TailoredAudience;
import twitter4j.models.ads.TailoredAudienceChangeInfo;
import twitter4j.models.ads.TailoredAudienceDataType;
import twitter4j.models.ads.TailoredAudienceOperation;

import java.io.File;
import java.io.InputStream;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:54 AM
 */
public interface TwitterAdsAudienceApi {

    /**
     * @param accountId The identifier for the leveraged account.
     * @param withDeleted (optional) Include deleted results in your request. Defaults to false.
     * @param count (optional) Limit the number returned per page of requests to the specified amount.
     * @param cursor (optional) Specifies a cursor to get the next page of TailoredAudience objects (function automatically handles paging upon iteration when you do not specify cursor value).
     * @return the collection of TailoredAudience objects belonging to the authenticated user.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audiences">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audiences</a>
     */
    BaseAdsListResponseIterable<TailoredAudience> getAllTailoredAudiences(String accountId, Optional<Integer> count,
                                                                          Optional<Boolean> withDeleted, Optional<String> cursor)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param tailoredAudienceId The identifier for a specific tailored audience.
     * @return detailed information on a specific tailored audience.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audiences/%3Aid">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audiences/%3Aid</a>
     */
    BaseAdsResponse<TailoredAudience> getTailoredAudienceForId(String accountId, String tailoredAudienceId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param tailoredAudienceId The identifier for a specific tailored audience.
     * @return response of deleting a tailored audience.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/tailored_audiences/%3Aid">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/tailored_audiences/%3Aid</a>
     */
    BaseAdsResponse<TailoredAudience> deleteTailoredAudience(String accountId, String tailoredAudienceId) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param name The name of the tailored audience to create.
     * @param tailoredAudienceDataType The data type of tailored audience being created (e.g. TWITTER_ID).
     * @return response of creating a tailored audience.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/tailored_audiences">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/tailored_audiences</a>
     */
    BaseAdsResponse<TailoredAudience> createTailoredAudience(String accountId, String name, TailoredAudienceDataType tailoredAudienceDataType)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param tailoredAudienceId The identifier for a specific tailored audience.
     * @return detailed information on the status of changes being processed for tailored audience.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audience_change/%3Aid">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audience_change/%3Aid</a>
     */
    BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForTailoredAudienceById(String accountId, String tailoredAudienceId)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param tailoredAudienceId The identifier for a specific tailored audience.
     * @param bucketLocation File path returned by data upload endpoints.
     * @param tailoredAudienceOperation The operation to perform on tailored audience (e.g. ADD, REMOVE, REPLACE).
     * @return response of request to edit users in existing tailored audience.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/tailored_audience_change">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/tailored_audience_change</a>
     */
    BaseAdsResponse<TailoredAudienceChangeInfo> editUsersInTailoredAudience(String accountId, String tailoredAudienceId, String bucketLocation,
                                                                            TailoredAudienceOperation tailoredAudienceOperation)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param count (optional) Limit the number returned per page of requests to the specified amount.
     * @param nextCursor (optional) Specify a cursor to retrieve data from a specific page (function automatically handles paging upon iteration when you do not specify cursor value).
     * @return a collection of change records for each tailored audience the authenticating account has access to.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audience_change">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/tailored_audience_change</a>
     */
    BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForAllTailoredAudiences(String accountId, Optional<Integer> count, Optional<String> nextCursor)
            throws TwitterException;

    /**
     * @return all possible custom audience targets to choose from
     * @throws TwitterException
     */

    TwitterTonUploadResponse uploadTailoredAudience(File file) throws TwitterException;


    TwitterTonUploadResponse resumableUploadTailoredAudience(Boolean resumable, String location, InputStream inputStream, String contentRange,
                                                             Integer chunkSize) throws TwitterException;

    void getGlobalOptOutListOfTailoredAudience(String accountId, String location) throws TwitterException;

    BaseAdsListBatchPostResponse<TailoredAudience> createFlexibleTailoredAudience(String accountId, String requestBody) throws TwitterException;
}
