package twitter4jads.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.TwitterAdsClient;
import twitter4jads.api.TwitterAdsStatApi;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.Granularity;
import twitter4jads.models.TwitterSegmentationType;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.ads.JobDetails;
import twitter4jads.models.ads.Placement;
import twitter4jads.models.ads.TwitterAdStatistics;
import twitter4jads.models.ads.TwitterAuctionInsights;
import twitter4jads.models.ads.TwitterEntityStatistics;
import twitter4jads.models.ads.TwitterEntityStatisticsMetrics;
import twitter4jads.models.ads.TwitterEntityType;
import twitter4jads.util.TwitterAdUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.zip.GZIPInputStream;

import static twitter4jads.TwitterAdsConstants.GRANULARITY;
import static twitter4jads.TwitterAdsConstants.PARAM_CAMPAIGN_IDS;
import static twitter4jads.TwitterAdsConstants.PARAM_END_TIME;
import static twitter4jads.TwitterAdsConstants.PARAM_ENTITY_IDS;
import static twitter4jads.TwitterAdsConstants.PARAM_ENTITY_TYPE;
import static twitter4jads.TwitterAdsConstants.PARAM_JOB_IDS;
import static twitter4jads.TwitterAdsConstants.PARAM_LINE_ITEM_IDS;
import static twitter4jads.TwitterAdsConstants.PARAM_METRIC_GROUPS;
import static twitter4jads.TwitterAdsConstants.PARAM_PLACEMENT;
import static twitter4jads.TwitterAdsConstants.PARAM_SEGMENTATION_TYPE;
import static twitter4jads.TwitterAdsConstants.PARAM_START_TIME;
import static twitter4jads.TwitterAdsConstants.PARAM_WITH_DELETED;
import static twitter4jads.TwitterAdsConstants.PATH_REACH_STATS;
import static twitter4jads.TwitterAdsConstants.PREFIX_ACCOUNTS_URI;
import static twitter4jads.TwitterAdsConstants.PREFIX_STATS_ACCOUNTS_URI;
import static twitter4jads.TwitterAdsConstants.PREFIX_STATS_JOB_ACCOUNTS_URI;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 11:35 AM
 */
public class TwitterAdsStatApiImpl implements TwitterAdsStatApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsStatApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    public BaseAdsListResponseIterable<TwitterEntityStatistics> fetchStatsSync(String accountId, TwitterEntityType twitterEntity,
                                                                               Collection<String> entityIds, long startTime, long endTime,
                                                                               boolean withDeleted, Granularity granularity, Placement placement)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(entityIds, "entityIds");
        TwitterAdUtil.ensureNotNull(placement, "placement");

        final String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        final String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId;

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(GRANULARITY, granularity.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        params.add(new HttpParameter(PARAM_ENTITY_TYPE, twitterEntity.name()));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }

        String metrics = StringUtils.join(getMetrics(twitterEntity, null), ",");
        params.add(new HttpParameter(PARAM_METRIC_GROUPS, metrics));
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        params.add(new HttpParameter(PARAM_ENTITY_IDS, TwitterAdUtil.getCsv(entityIds)));
        params.add(new HttpParameter(PARAM_PLACEMENT, placement.name()));

        final Type type = new TypeToken<BaseAdsListResponse<TwitterEntityStatistics>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterAuctionInsights> fetchAuctionInsights(String accountId, Collection<String> lineItemIds, long startTime,
                                                                                    long endTime, Granularity granularity, Placement placement)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(lineItemIds, "lineItemIds");
        TwitterAdUtil.ensureNotNull(placement, "placement");

        final String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        final String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + "/auction_insights";

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(GRANULARITY, granularity.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }
        params.add(new HttpParameter(PARAM_LINE_ITEM_IDS, TwitterAdUtil.getCsv(lineItemIds)));
        params.add(new HttpParameter(PARAM_PLACEMENT, placement.name()));

        final Type type = new TypeToken<BaseAdsListResponse<TwitterAuctionInsights>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<JobDetails> createAsyncJob(String accountId, TwitterEntityType twitterEntityType, Collection<String> ids, long startTime,
                                                      long endTime, boolean withDeleted, Granularity granularity, Placement placement,
                                                      Optional<TwitterSegmentationType> twitterSegmentationType) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(ids, "entityIds");
        TwitterAdUtil.ensureNotNull(placement, "placement");

        final String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        final String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_JOB_ACCOUNTS_URI + accountId;

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(GRANULARITY, granularity.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        params.add(new HttpParameter(PARAM_ENTITY_TYPE, twitterEntityType.name()));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }

        TwitterSegmentationType segmentationType = null;
        if (twitterSegmentationType != null && twitterSegmentationType.isPresent()) {
            segmentationType = twitterSegmentationType.get();
            params.add(new HttpParameter(PARAM_SEGMENTATION_TYPE, twitterSegmentationType.get().name()));
        }


        String metrics = StringUtils.join(getMetrics(twitterEntityType, segmentationType), ",");
        params.add(new HttpParameter(PARAM_METRIC_GROUPS, metrics));
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        params.add(new HttpParameter(PARAM_ENTITY_IDS, TwitterAdUtil.getCsv(ids)));
        params.add(new HttpParameter(PARAM_PLACEMENT, placement.name()));

        final Type type = new TypeToken<BaseAdsResponse<JobDetails>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsListResponseIterable<JobDetails> getJobExecutionDetails(String accountId, Collection<String> jobIds) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_JOB_IDS, TwitterAdUtil.getCsv(jobIds)));

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_JOB_ACCOUNTS_URI + accountId;
        final Type type = new TypeToken<BaseAdsListResponse<JobDetails>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponse<TwitterEntityStatistics> fetchJobDataAsync(String dataUrl) throws TwitterException {
        // TODO: Use executeHttpListRequest once the bug from twitter is resolved (encoding in headers)
        final String responseAsString = getResponseFromGZipStream(dataUrl);
        final Type type = new TypeToken<BaseAdsListResponse<TwitterEntityStatistics>>() {
        }.getType();
        return new Gson().fromJson(responseAsString, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterAdStatistics> fetchCampaignStats(String accountId, Collection<String> campaignIds, long startTime,
                                                                               long endTime) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(campaignIds, "campaignIds");

        final String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        final String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + PATH_REACH_STATS;

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_CAMPAIGN_IDS, TwitterAdUtil.getCsv(campaignIds)));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }

        final Type type = new TypeToken<BaseAdsListResponse<TwitterAdStatistics>>() {
        }.getType();

        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<JobDetails> deleteJob(String accountId, String jobId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(jobId, "jobId");

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_JOB_ACCOUNTS_URI + accountId + "/" + jobId;
        final Type type = new TypeToken<BaseAdsResponse<JobDetails>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    // ----------------------------------------- Private Methods -------------------------------------------------

    // ------------------------------------------------------------------ PRIVATE METHODS -----------------------------------------------------------

    private String getResponseFromGZipStream(String urlString) {
        try {
            final URL url = new URL(urlString);
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Accept-Encoding", "gzip");

            final BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(con.getInputStream()), "utf-8"));
            final StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }
            return builder.toString();
        } catch (Exception e) {
            // Throw Exception
        }

        return null;
    }

    private String getMetrics(TwitterEntityType twitterEntity, TwitterSegmentationType twitterSegmentationType) {
        String metrics;
        switch (twitterEntity) {
            case ORGANIC_TWEET:
                metrics = StringUtils.join(TwitterEntityStatisticsMetrics.ORGANIC_METRIC_GROUPS, ",");
                break;
            case ACCOUNT:
                metrics = StringUtils.join(TwitterEntityStatisticsMetrics.ENGAGEMENT_METRIC_GROUPS, ",");
                break;
            default:
                metrics = StringUtils.join(TwitterEntityStatisticsMetrics.getMetricGroups(twitterSegmentationType), ",");
        }

        return metrics;
    }
}
