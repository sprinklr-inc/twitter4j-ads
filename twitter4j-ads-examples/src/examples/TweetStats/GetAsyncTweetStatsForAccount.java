package examples.TweetStats;

import com.google.common.collect.Lists;
import examples.BaseAdsTest;
import twitter4j.*;
import twitter4j.api.TwitterAdsStatApi;
import twitter4j.models.Granularity;
import twitter4j.models.ads.*;
import twitter4j.util.TwitterAdUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * User: shivraj
 * Date: 12/05/16 2:08 PM.
 */
public class GetAsyncTweetStatsForAccount extends BaseAdsTest {

    public static void main(String[] args) {
        TwitterAds twitterAdsInstance = getTwitterAdsInstance();
        TwitterAdsStatApi statApi = twitterAdsInstance.getStatApi();
        try {
            BaseAdsResponse<JobDetails> twitterAsyncJob = statApi.createAsyncJob("1b83s0", TwitterEntityType.CAMPAIGN, Lists.newArrayList("4u3mr"), 1461664800000L, 1462183200000L, Boolean.TRUE, Granularity.TOTAL, TwitterAdObjective.VIDEO_VIEWS, Placement.ALL_ON_TWITTER, null);
            BaseAdsListResponseIterable<JobDetails> jobExecutionDetails;
            boolean flag;
            long timeOut = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2);
            do {
                flag = false; //continue iterating as long as status of job of job is either queued, uploading or processing
                TwitterAdUtil.reallySleep(10000L);
                jobExecutionDetails = statApi.getJobExecutionDetails("1b83s0", Lists.newArrayList(twitterAsyncJob.getData().getJobId()));

                for (BaseAdsListResponse<JobDetails> base : jobExecutionDetails) {
                    List<JobDetails> baselist = base.getData();
                    for (JobDetails jd : baselist) {
                        if ((jd != null) && (jd.getStatus() != TwitterAsyncQueryStatus.SUCCESS)) {
                            flag = true;
                        }
                    }
                }
            } while (flag && System.currentTimeMillis() <= timeOut);

            List<TwitterEntityStatistics> twitterEntityStatsList = Lists.newArrayList();

            for (BaseAdsListResponse<JobDetails> base : jobExecutionDetails) {
                List<JobDetails> baselist = base.getData();
                for (JobDetails jd : baselist) {
                    BaseAdsListResponse<TwitterEntityStatistics> allTwitterEntityStat = statApi.fetchJobDataAsync(jd.getUrl());
                    if(allTwitterEntityStat == null || allTwitterEntityStat.getData() == null){
                        continue;
                    }
                    twitterEntityStatsList.addAll(allTwitterEntityStat.getData());
                }
                System.out.println(twitterEntityStatsList);
            }
        } catch (TwitterException e) {
            System.err.println(e.getErrorMessage());
        }
    }
}