package twitter4j.api;

import com.google.common.base.Optional;
import twitter4j.BaseAdsListResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.Granularity;
import twitter4j.models.TwitterSegmentationType;
import twitter4j.models.ads.*;

import java.util.Collection;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 11:31 AM
 */
public interface TwitterAdsStatApi {

    /**
     * @param accountId            The identifier for the leveraged account.
     * @param twitterEntity        The enum of entity type (e.g. LINE_ITEM, PROMOTED_TWEET).
     * @param ids                  A collection of ids to retrieve stats for.
     * @param startTime            The time to retrieve stats from.
     * @param endTime              The time to retrieve stats until.
     * @param withDeleted          Whether or not to include deleted items in the results. Defaults to false.
     * @param granularity          The granularity as enum such as DAY or HOUR.
     * @param objective            The objective of entity to retrieve stats for.
     * @param placement            The placement of entity to retrieve stats for.
     * @return analytics data for the given parameters
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/1/get/stats/accounts/%3Aaccount_id">https://dev.twitter.com/ads/reference/1/get/stats/accounts/%3Aaccount_id</a>
     */
    BaseAdsListResponseIterable<TwitterEntityStatistics> fetchStatsSync(String accountId, TwitterEntityType twitterEntity, Collection<String> ids,
                                                                        long startTime, long endTime, boolean withDeleted, Granularity granularity,
                                                                        TwitterAdObjective objective, Placement placement) throws TwitterException;

    /**
     * @param accountId            The identifier for the leveraged account.
     * @param twitterEntityType        The enum of entity type (e.g. LINE_ITEM, PROMOTED_TWEET).
     * @param ids                  A collection of ids to retrieve stats for.
     * @param startTime            The time to retrieve stats from.
     * @param endTime              The time to retrieve stats until.
     * @param withDeleted          Whether or not to include deleted items in the results. Defaults to false.
     * @param granularity          The granularity as enum such as DAY or HOUR.
     * @param twitterAdObjective   The objective of entity to retrieve stats for.
     * @param placement            The placement of entity to retrieve stats for.
     * @param twitterSegmentationType  (optional) Break down analytics data via a supported segmentation type.
     * @return job details for async job to fetch analytics data for the given paramters
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/1/post/stats/jobs/accounts/%3Aaccount_id">https://dev.twitter.com/ads/reference/1/post/stats/jobs/accounts/%3Aaccount_id</a>
     */
    BaseAdsResponse<JobDetails> createAsyncJob(String accountId, TwitterEntityType twitterEntityType, Collection<String> ids, long startTime,
                                               long endTime, boolean withDeleted, Granularity granularity, TwitterAdObjective twitterAdObjective,
                                               Placement placement, Optional<TwitterSegmentationType> twitterSegmentationType) throws TwitterException;

    /**
     * @param accountId            The identifier for the leveraged account.
     * @param jobIds               A collection of job IDs to retrieve status of.
     * @return job execution details for given job IDs
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/1/get/stats/jobs/accounts/%3Aaccount_id">https://dev.twitter.com/ads/reference/1/get/stats/jobs/accounts/%3Aaccount_id</a>
     */
    BaseAdsListResponseIterable<JobDetails> getJobExecutionDetails(String accountId, Collection<String> jobIds) throws TwitterException;

    /**
     * @param dataUrl   The path given as output via a completed async job.
     * @return analytics data extracted from the finished output path of a async job
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/1/get/stats/jobs/accounts/%3Aaccount_id">https://dev.twitter.com/ads/reference/1/get/stats/jobs/accounts/%3Aaccount_id</a>
     */
    BaseAdsListResponse<TwitterEntityStatistics> fetchJobDataAsync(String dataUrl) throws TwitterException;
}