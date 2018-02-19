package twitter4jads.api;

import twitter4jads.BaseAdsListResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.TwitterCreativePreview;
import twitter4jads.models.ads.TwitterPreviewTarget;

import java.util.List;

/**
 * User: abhishek.chatrath
 * Date: 13/06/16.
 * Time: 8:08 PM
 */
public interface TwitterAdsPreviewApi {

    /**
     * Sends a GET request to Twitter with the specified parameters and receives the corresponding JSON response for an unpublished tweet.
     *
     * @param accountId -   The identifier for the leveraged account. Appears within the resource’s path and is generally a required parameter for all
     *                      Advertising API requests excluding GET accounts. The specified account must be associated with the authenticating user.
     *
     * @param status -  The text of your status update, typically up to 140 characters. URL encode as necessary. t.co link wrapping may affect
     *                  character counts.
     *
     * @param asUserId -    The user ID of the advertiser on behalf of whom you are posting the Tweet. The advertiser must grant your handle (or
     *                      handles) access to their ads account via the Twitter UI at ads.twitter.com. This permission allows you to call the API
     *                      using the OAuth tokens of your own handle rather than the advertiser’s.
     *
     * @param mediaIds -    A list of up to four media ids to associate with the Tweet.
     *
     * @param cardId - The ID of the revenue card embedded in the Tweet.
     *
     * @param twitterPreviewTarget -    The target to render the Tweet preview for. You can preview a Tweet both for how it will look like on Twitter
     *                                  (TWITTER_TIMELINE) or on the Twitter Audience Platform (PUBLISHER_NETWORK). When using the PUBLISHER_NETWORK
     *                                  value for the preview_target parameter you should not use a card_id and you must specify media_ids.
     *
     * @return -
     *
     * @throws TwitterException - Exception class for when TwitterApi calls fail.
     */
    BaseAdsListResponse<TwitterCreativePreview> getUnpublishedTweetPreview(String accountId, String status, String asUserId, List<String> mediaIds,
                                                                           String cardId, TwitterPreviewTarget twitterPreviewTarget)
            throws TwitterException;

    /**
     * Sends a GET request to Twitter with the specified parameters and receives the corresponding JSON response for a published tweet.
     *
     * @param accountId -   The identifier for the leveraged account. Appears within the resource’s path and is generally a required parameter for all
     *                      Advertising API requests excluding GET accounts. The specified account must be associated with the authenticating user.
     *
     * @param tweetId - The unique identifier referring to a Tweet
     *
     * @param asUserId -    The user ID of the advertiser on behalf of whom you are posting the Tweet. The advertiser must grant your handle (or
     *                      handles) access to their ads account via the Twitter UI at ads.twitter.com. This permission allows you to call the API
     *                      using the OAuth tokens of your own handle rather than the advertiser’s.
     *
     * @param twitterPreviewTarget -    The target to render the Tweet preview for. You can preview a Tweet both for how it will look like on Twitter
     *                                  (TWITTER_TIMELINE) or on the Twitter Audience Platform (PUBLISHER_NETWORK).
     *
     * @return -
     *
     * @throws TwitterException - Exception class for when TwitterApi calls fail.
     */
    BaseAdsListResponse<TwitterCreativePreview> getPublishedTweetPreview(String accountId, String tweetId, String asUserId,
                                                                         TwitterPreviewTarget twitterPreviewTarget) throws TwitterException;

}