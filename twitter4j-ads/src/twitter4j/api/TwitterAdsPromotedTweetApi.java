package twitter4j.api;

import com.google.common.base.Optional;
import twitter4j.BaseAdsListResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.internal.models4j.Status;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.ads.PromotedTweets;
import twitter4j.models.ads.sort.PromotedTweetsSortByField;

import java.io.IOException;
import java.util.Collection;

/**
 * User: abhay
 * Date: 4/22/16
 * Time: 1:04 PM
 */
public interface TwitterAdsPromotedTweetApi {

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param lineItemId  A reference to the line item you are operating with in the request. Omitting the lineItemId will return all promoted
     *                    tweets across all campaigns.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @param sortByField (optional) Sorts by supported attribute in ascending or descending order.
     * @param count       (optional) Specifies the number of Promoted Tweets to try to retrieve, up to a maximum of 1000 per distinct request.
     * @param cursor      (optional) Specify a cursor to retrieve data from a specific page (function automatically handles paging upon iteration when you do not specify cursor value).
     * @return Retrieve references to the Promoted Tweets associated with one or more line items.
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/promoted_tweets">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/promoted_tweets</a>
     */
    BaseAdsListResponseIterable<PromotedTweets> getAllPromotedTweets(String accountId, String lineItemId, boolean withDeleted,
                                                                     Optional<Integer> count, String cursor, Optional<PromotedTweetsSortByField> sortByField) throws TwitterException;


    /**
     * @param accountId       The identifier for the leveraged account.
     * @param promotedTweetId A reference to the promoted tweet you are operating with in the request.
     * @return Retrieve references to the Promoted Tweets associated with the promotedTweetId.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/promoted_tweets">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/promoted_tweets</a>
     */
    BaseAdsResponse<PromotedTweets> getPromotedTweetsById(String accountId, String promotedTweetId) throws TwitterException;

    /**
     * @param accountId  The identifier for the leveraged account.
     * @param lineItemId Scope the response to just the desired line item
     * @param tweetIds   tweet ids to promote
     * @return created promoted tweet details
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/promoted_tweets">https://dev.twitter.com/ads/reference/post/accounts/%3Aaccount_id/promoted_tweets</a>
     */
    BaseAdsListResponse<PromotedTweets> createPromotedTweets(String accountId, String lineItemId, Collection<String> tweetIds)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param tweetId   Tweet Id to be deleted
     * @return Promoted tweet with deleted field set to true
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/promoted_tweets/%3Aid">https://dev.twitter.com/ads/reference/delete/accounts/%3Aaccount_id/promoted_tweets/%3Aid</a>
     */
    BaseAdsResponse<PromotedTweets> deletePromotedTweets(String accountId, String tweetId) throws TwitterException;

    Status createPromotedVideoTweet(String accountId, String targetUserId, String tweetText, String videoId, String videoTitle,
                                    String videoDescription, String callToAction, String ctaValue)
            throws TwitterException, IOException, InterruptedException;

}
