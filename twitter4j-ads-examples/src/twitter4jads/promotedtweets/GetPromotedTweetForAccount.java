package twitter4jads.promotedtweets;

import com.google.common.collect.Lists;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsTest;
import twitter4jads.TwitterAds;
import twitter4jads.api.TwitterAdsPromotedTweetApi;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.PromotedTweets;

import java.util.List;

/**
 * User: shivraj
 * Date: 12/05/16 2:08 PM.
 */
public class GetPromotedTweetForAccount extends BaseAdsTest {

    public static void main(String[] args) {
        TwitterAds twitterAdsInstance = getTwitterAdsInstance();
        TwitterAdsPromotedTweetApi promotedTweetApi = twitterAdsInstance.getPromotedTweetApi();
        List<PromotedTweets> promotedTweetsList = Lists.newArrayList();
        try {
            BaseAdsListResponseIterable<PromotedTweets> allPromotedTweets = promotedTweetApi.getAllPromotedTweets("18ce53uo3nm", false, null, null, null, null);
            for (BaseAdsListResponse<PromotedTweets> allPromotedTweet : allPromotedTweets) {
                promotedTweetsList.addAll(allPromotedTweet.getData());
            }
            System.out.println(promotedTweetsList.size());
        } catch (TwitterException e) {
            System.err.println(e.getErrorMessage());
        }
    }
}