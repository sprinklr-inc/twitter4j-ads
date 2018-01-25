package twitter4j.api;

import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.ScheduledTweet;

import java.util.Date;
import java.util.List;

/**
 * User: abhishekanand
 * Date: 02/08/17 8:26 PM.
 */
public interface TwitterScheduledTweetApi {

    /**
     * @param accountId The identifier for the leveraged account.
     * @param userId Full promotable user Id.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @param count Specifies the number of Scheduled Promoted Tweets to try to retrieve, up to a maximum of 1000 per distinct request.
     * @param cursor Specifies a cursor to get the next page of Scheduled Promoted Tweets.
     */

    BaseAdsListResponseIterable<ScheduledTweet> fetch(String accountId, String userId, boolean withDeleted, Integer count, String cursor)
            throws TwitterException;


    /**
     * @param accountId The identifier for the leveraged account.
     * @param scheduledTweetId The id of the scheduled tweet
     * @param withDeleted Include deleted results in your request. Defaults to false.
     */
    BaseAdsResponse<ScheduledTweet> fetchScheduledTweetById(String accountId, String scheduledTweetId, boolean withDeleted) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param userId The user ID of the advertiser on behalf of whom you are posting the Tweet. The advertiser must grant your handle (or handles) access to their ads account via ads.twitter.com. This permission allows you to call the API using the OAuth tokens of your own handle rather than the advertiser’s..
     * @param scheduledAt The time, expressed in ISO 8601, that the Tweet should be published (or go live).. 2017-12-31T23:59:00Z
     * Tweets can only be scheduled up to one year in the future.
     * Note: Tweets should only be scheduled at minute-granularity; seconds will be ignored.
     * @param text The text of your status update, typically up to 140 characters.
     * @param cardURI Associate a card with the Tweet using the card_uri value from any cards response, if available. card://855591459410511943
     * IMPORTANT
     * @param mediaIds Associate media with the Tweet by specifying a comma-separated list of identifiers. Include up to 4 images, 1 animated GIF, or 1 video. See Uploading Media for additional details on uploading media.
     * @param nullCast Whether to create a nullcasted (or Promoted-only) Tweet..
     */
    BaseAdsResponse<ScheduledTweet> create(String accountId, Date scheduledAt, String text, String userId, String cardURI, List<String> mediaIds,
                                           boolean nullCast) throws TwitterException;


    BaseAdsResponse<ScheduledTweet> update(String accountId, String scheduledTweetId, Date scheduledAt, String text, String cardURI,
                                           List<String> mediaIds) throws TwitterException;


    BaseAdsResponse<ScheduledTweet> delete(String accountId, String scheduledTweetId) throws TwitterException;
}
