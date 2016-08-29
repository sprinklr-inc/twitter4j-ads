package twitter4j.impl;

import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import twitter4j.*;
import twitter4j.api.TwitterAdsStatApi;
import twitter4j.models.Granularity;
import twitter4j.models.TwitterSegmentationType;
import twitter4j.models.ads.*;
import twitter4j.util.TwitterAdUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.zip.GZIPInputStream;

import static twitter4j.TwitterAdsConstants.*;
import static twitter4j.TwitterAdsConstants.V1_PREFIX_STATS_JOB_ACCOUNTS_URI;

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
                                                                               boolean withDeleted, Granularity granularity,
                                                                               TwitterAdObjective objective, Placement placement)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(entityIds, "entityIds");
        TwitterAdUtil.ensureNotNull(placement, "placement");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + V1_PREFIX_STATS_ACCOUNTS_URI + accountId;

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(GRANULARITY, granularity.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        params.add(new HttpParameter(PARAM_ENTITY_TYPE, twitterEntity.name()));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }

        String metrics = StringUtils.join(TwitterAdStatisticsMetrics.getMetricGroups(objective), ",");
        params.add(new HttpParameter(PARAM_METRIC_GROUPS, metrics));
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        params.add(new HttpParameter(PARAM_ENTITY_IDS, TwitterAdUtil.getCsv(entityIds)));
        params.add(new HttpParameter(PARAM_PLACEMENT, placement.name()));

        Type type = new TypeToken<BaseAdsListResponse<TwitterEntityStatistics>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<JobDetails> createAsyncJob(String accountId, TwitterEntityType twitterEntityType, Collection<String> ids, long startTime,
                                                      long endTime, boolean withDeleted, Granularity granularity,
                                                      TwitterAdObjective twitterAdObjective, Placement placement,
                                                      Optional<TwitterSegmentationType> twitterSegmentationType) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(ids, "entityIds");
        TwitterAdUtil.ensureNotNull(placement, "placement");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + V1_PREFIX_STATS_JOB_ACCOUNTS_URI + accountId;

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(GRANULARITY, granularity.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        params.add(new HttpParameter(PARAM_ENTITY_TYPE, twitterEntityType.name()));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }

        if (twitterSegmentationType != null && twitterSegmentationType.isPresent()) {
            params.add(new HttpParameter(PARAM_SEGMENTATION_TYPE, twitterSegmentationType.get().name()));
        }

        String metrics = StringUtils.join(TwitterAdStatisticsMetrics.getMetricGroups(twitterAdObjective), ",");
        params.add(new HttpParameter(PARAM_METRIC_GROUPS, metrics));
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        params.add(new HttpParameter(PARAM_ENTITY_IDS, TwitterAdUtil.getCsv(ids)));
        params.add(new HttpParameter(PARAM_PLACEMENT, placement.name()));

        Type type = new TypeToken<BaseAdsResponse<JobDetails>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsListResponseIterable<JobDetails> getJobExecutionDetails(String accountId, Collection<String> jobIds) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_JOB_IDS, TwitterAdUtil.getCsv(jobIds)));

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + V1_PREFIX_STATS_JOB_ACCOUNTS_URI + accountId;

        Type type = new TypeToken<BaseAdsListResponse<JobDetails>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponse<TwitterEntityStatistics> fetchJobDataAsync(String dataUrl) throws TwitterException {
        // TODO: Use executeHttpListRequest once the bug from twitter is resolved (encoding in headers)
        String responseAsString = getResponseFromGZipStream(dataUrl);
        Type type = new TypeToken<BaseAdsListResponse<TwitterEntityStatistics>>() {}.getType();
        return new Gson().fromJson(responseAsString, type);
    }

    // ----------------------------------------- Private Methods -------------------------------------------------

    private String getResponseFromGZipStream(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Accept-Encoding", "gzip");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(con.getInputStream())));

            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }
            return builder.toString();
        } catch (Exception e) {
            // Throw Execption
        }
        return null;
    }

    private String getMetrics(TwitterEntityType twitterEntity, TwitterAdObjective objective, TwitterSegmentationType twitterSegmentationType) {
        String metrics;
        if (objective == null && twitterEntity.equals(TwitterEntityType.ORGANIC_TWEET)) {
            metrics = StringUtils.join(TwitterEntityStatisticsMetrics.ORGANIC_METRIC_GROUPS, ",");
        } else {
            metrics = StringUtils.join(TwitterEntityStatisticsMetrics.getMetricGroups(objective, twitterSegmentationType), ",");
        }
        return metrics;
    }
}
