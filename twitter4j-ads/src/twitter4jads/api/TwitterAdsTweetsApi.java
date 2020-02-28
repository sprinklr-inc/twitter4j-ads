package twitter4jads.api;

import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.Tweet;
import twitter4jads.models.ads.TwitterTimelineType;
import twitter4jads.models.ads.TwitterTweetType;
import twitter4jads.models.video.TwitterCallToActionType;

import java.util.List;

public interface TwitterAdsTweetsApi {

    /**
     * @param accountId                 The identifier for the leveraged account. The specified account must be associated with the authenticated user.
     * @param tweetType                 The Tweet type for the specified tweet_ids. Possible values: DRAFT, PUBLISHED, SCHEDULED.
     * @param count                     Specifies the number of records to try and retrieve per distinct request. Values: [1, 1000], default = 200.
     * @param cursor                    Specifies a cursor to get the next page of results. See https://developer.twitter.com/en/docs/ads/general/guides/pagination.
     * @param includeMentionsAndReplies Whether to filter out mentions and replies from the list of available Tweets.
     * @param timelineType              Whether to return nullcasted (a.k.a. "Promoted-only") Tweets, organic Tweets, or both. Possible values: ALL, NULLCAST, ORGANIC.
     * @param trimUser                  Whether to exclude the user object in the Tweet response. When enabled, the only part of the user object that will be returned is the Tweet's author's user ID.
     * @param tweetIds                  A comma-separated list of identifiers. Up to 200 IDs may be provided.
     * @param userId                    Specifies the user to scope Tweets to. Defaults to the FULL promotable user on the account when not set.
     * @return Tweet details for the account's full promotable user (default) or the user specified in the user_id parameter.
     * @throws TwitterException
     */
    BaseAdsListResponse<Tweet> getTweets(String accountId, TwitterTweetType tweetType, Integer count, String cursor,
                                         Boolean includeMentionsAndReplies, TwitterTimelineType timelineType, Boolean trimUser,
                                         List<Long> tweetIds, Long userId)
            throws TwitterException;

    /**
     * Create a tweet for the account's user mentioned in 'as_user_id' parameter (defaults to full promotable user).
     *
     * @param accountId        The identifier for the leveraged account.
     * @param asUserId         The user ID of the advertiser on behalf of whom you are posting the Tweet.
     * @param statusUpdateText The text of your status update. Required if no media_keys are specified.
     * @param cardUri          Associate a card with the Tweet using the card_uri value from any cards response, if available.
     * @param mediaKeys        Associate media with the Tweet by specifying a comma-separated list of identifiers. Include up to 4 images, 1 animated GIF, or 1 video.
     * @param nullcast         Whether to create a nullcasted (or "Promoted-only") Tweet.
     * @param trimUser         Whether to exclude the user object in the Tweet response. When enabled, the only part of the user object that will be returned is the Tweet's author's user ID.
     * @param tweetMode        Whether the response should be in compatibility or extended mode. See this for additional information. Possible values: compat, extended.
     * @param videoCta         The CTA for the video. Possible values: VISIT_SITE, WATCH_NOW.
     * @param videoCtaValue    The value for the corresponding CTA on the video.
     * @param videoDescription The description that appears under the video. Maximum length: 200 characters.
     * @param videoTitle       The title (headline) that appears under the video. Maximum length: 70 characters.
     * @return Details of the created tweet.
     * @throws TwitterException
     */
    BaseAdsResponse<Tweet> createTweet(String accountId, Long asUserId, String statusUpdateText, String cardUri, List<String> mediaKeys,
                                       Boolean nullcast, Boolean trimUser, String tweetMode, TwitterCallToActionType videoCta,
                                       String videoCtaValue, String videoDescription, String videoTitle)
            throws TwitterException;
}