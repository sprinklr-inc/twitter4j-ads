package twitter4jads.impl;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsResponse;
import twitter4jads.TwitterAdsClient;
import twitter4jads.TwitterAdsConstants;
import twitter4jads.api.TwitterAdsTweetsApi;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.http.HttpResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.ads.Tweet;
import twitter4jads.models.ads.TwitterTimelineType;
import twitter4jads.models.ads.TwitterTweetType;
import twitter4jads.models.video.TwitterCallToActionType;
import twitter4jads.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static twitter4jads.models.video.TwitterCallToActionType.VISIT_SITE;
import static twitter4jads.models.video.TwitterCallToActionType.WATCH_NOW;

/**
 * @author niketkhandelwal
 * @Date Dec 20, 2019
 */
public class TwitterAdsTweetsApiImpl implements TwitterAdsTweetsApi {

    private static final Integer MAX_TWEET_IDS_REQUEST_SIZE = 200;
    private static final Integer NUMBER_OF_RECORDS_PER_REQUEST = 1000;
    private static final Integer DEFAULT_NUMBER_OF_RECORDS_PER_REQUEST = 200;
    private static final String CARD_URI_PREFIX = "card://";
    private static final Integer VIDEO_DESCRIPTION_MAX_LENGTH = 200;
    private static final Integer VIDEO_TITLE_MAX_LENGTH = 70;
    private TwitterAdsClient twitterAdsClient;

    public TwitterAdsTweetsApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponse<Tweet> getTweets(String accountId, TwitterTweetType tweetType, Integer count, String cursor,
                                                Boolean includeMentionsAndReplies, TwitterTimelineType timelineType, Boolean trimUser,
                                                List<Long> tweetIds, Long userId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, TwitterAdsConstants.PARAM_ACCOUNT_ID);
        TwitterAdUtil.ensureNotNull(tweetType, TwitterAdsConstants.PARAM_TWEET_TYPE);
        final List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(TwitterAdsConstants.PARAM_TWEET_TYPE, tweetType.name()));
        validateGetTweetParametersAndAddToParams(params, count, cursor, includeMentionsAndReplies, timelineType, trimUser, tweetIds, userId);

        final String baseUrl =
                twitterAdsClient.getBaseAdsAPIUrl() + TwitterAdsConstants.PREFIX_ACCOUNTS_URI + accountId + TwitterAdsConstants.PATH_TWEETS;

        final Type type = new TypeToken<BaseAdsListResponse<Tweet>>() {
        }.getType();

        final HttpResponse response = twitterAdsClient.getRequest(baseUrl, params.toArray(new HttpParameter[0]));
        try {
            return TwitterAdUtil.constructBaseAdsListResponse(response, response.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse tweets.");
        }
    }

    @Override
    public BaseAdsResponse<Tweet> createTweet(String accountId, Long asUserId, String statusUpdateText, String cardUri, List<String> mediaKeys,
                                              Boolean nullcast, Boolean trimUser, String tweetMode, TwitterCallToActionType videoCta,
                                              String videoCtaValue, String videoDescription, String videoTitle)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, TwitterAdsConstants.PARAM_ACCOUNT_ID);
        TwitterAdUtil.ensureNotNull(asUserId, TwitterAdsConstants.PARAM_AS_USER_ID);
        if (TwitterAdUtil.isEmpty(mediaKeys) && StringUtils.isBlank(statusUpdateText)) {
            throw new IllegalArgumentException("Status update text is required if no media keys are provided");
        }

        List<HttpParameter> params = Lists.newArrayList();

        params.add(new HttpParameter(TwitterAdsConstants.PARAM_AS_USER_ID, asUserId));
        validateCreateTweetParametersAndAddToParams(params, statusUpdateText, cardUri, mediaKeys, nullcast, trimUser, tweetMode, videoCta,
                videoCtaValue, videoDescription, videoTitle);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + TwitterAdsConstants.PREFIX_ACCOUNTS_URI + accountId + TwitterAdsConstants.PATH_TWEET;

        final Type type = new TypeToken<BaseAdsResponse<Tweet>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[0]), type, HttpVerb.POST);
    }

    //--------------------------------------------------------------- PRIVATE METHODS ----------------------------------------------------------------

    private void validateCreateTweetParametersAndAddToParams(List<HttpParameter> params, String statusUpdateText, String cardUri,
                                                             List<String> mediaKeys, Boolean nullcast, Boolean trimUser, String tweetMode,
                                                             TwitterCallToActionType videoCta, String videoCtaValue, String videoDescription,
                                                             String videoTitle) {
        if (TwitterAdUtil.isNotNullOrEmpty(statusUpdateText)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_TEXT, statusUpdateText));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(cardUri)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_CARD_URI, CARD_URI_PREFIX + cardUri));
        }
        if (TwitterAdUtil.isNotEmpty(mediaKeys)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_MEDIA_KEYS, TwitterAdUtil.getCsv(mediaKeys)));
        }
        if (TwitterAdUtil.isNotNull(nullcast)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_NULLCAST, nullcast));
        }
        if (TwitterAdUtil.isNotNull(trimUser)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_TRIM_USER, trimUser));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(tweetMode)) {
            if (TwitterAdsConstants.COMPATIBILITY_TWEET_MODE.equals(tweetMode)) {
                params.add(new HttpParameter(TwitterAdsConstants.PARAM_TWEET_MODE, TwitterAdsConstants.COMPATIBILITY_TWEET_MODE));
            } else if (TwitterAdsConstants.EXTENDED_TWEET_MODE.equals(tweetMode)) {
                params.add(new HttpParameter(TwitterAdsConstants.PARAM_TWEET_MODE, TwitterAdsConstants.EXTENDED_TWEET_MODE));
            }
        }
        if (TwitterAdUtil.isNotNull(videoCta) && (videoCta == VISIT_SITE || videoCta == WATCH_NOW)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_VIDEO_CTA, videoCta.name()));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(videoCtaValue)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_VIDEO_CTA_VALUE, videoCtaValue));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(videoDescription) && videoDescription.length() <= VIDEO_DESCRIPTION_MAX_LENGTH) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_VIDEO_DESCRIPTION, videoDescription));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(videoTitle) && videoTitle.length() <= VIDEO_TITLE_MAX_LENGTH) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_VIDEO_TITLE, videoTitle));
        }
    }

    private void validateGetTweetParametersAndAddToParams(List<HttpParameter> params, Integer count, String cursor, Boolean includeMentionsAndReplies,
                                                          TwitterTimelineType timelineType, Boolean trimUser, List<Long> tweetIds, Long userId) {
        if (count != null && count < NUMBER_OF_RECORDS_PER_REQUEST) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_COUNT, count));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(cursor)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_CURSOR, cursor));
        }
        if (TwitterAdUtil.isNotNull(includeMentionsAndReplies)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_INCLUDE_MENTIONS_AND_REPLIES, includeMentionsAndReplies));
        }
        if (TwitterAdUtil.isNotNull(timelineType)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_TIMELINE_TYPE, timelineType.name()));
        }
        if (TwitterAdUtil.isNotNull(trimUser)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_TRIM_USER, trimUser));
        }
        if (TwitterAdUtil.isNotNull(tweetIds) && TwitterAdUtil.isNotEmpty(tweetIds)) {
            TwitterAdUtil.ensureMaxSize(tweetIds, MAX_TWEET_IDS_REQUEST_SIZE);
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_TWEET_IDS, TwitterAdUtil.getCsv(tweetIds)));
        }
        if (TwitterAdUtil.isNotNull(userId)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_USER_ID, userId));
        }
    }
}
