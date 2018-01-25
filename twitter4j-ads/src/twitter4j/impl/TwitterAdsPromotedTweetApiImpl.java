package twitter4j.impl;

import static twitter4j.TwitterAdsConstants.PARAM_AS_USER_ID;
import static twitter4j.TwitterAdsConstants.PARAM_CARD_URI;
import static twitter4j.TwitterAdsConstants.PARAM_COUNT;
import static twitter4j.TwitterAdsConstants.PARAM_CURSOR;
import static twitter4j.TwitterAdsConstants.PARAM_LINE_ITEM_ID;
import static twitter4j.TwitterAdsConstants.PARAM_MEDIA_IDS;
import static twitter4j.TwitterAdsConstants.PARAM_NULLCAST;
import static twitter4j.TwitterAdsConstants.PARAM_SCHEDULED_TWEET_ID;
import static twitter4j.TwitterAdsConstants.PARAM_SORT_BY;
import static twitter4j.TwitterAdsConstants.PARAM_STATUS;
import static twitter4j.TwitterAdsConstants.PARAM_TEXT;
import static twitter4j.TwitterAdsConstants.PARAM_TWEET_IDS;
import static twitter4j.TwitterAdsConstants.PARAM_VIDEO_CTA;
import static twitter4j.TwitterAdsConstants.PARAM_VIDEO_CTA_VALUE;
import static twitter4j.TwitterAdsConstants.PARAM_VIDEO_DESCRIPTION;
import static twitter4j.TwitterAdsConstants.PARAM_VIDEO_ID;
import static twitter4j.TwitterAdsConstants.PARAM_VIDEO_TITLE;
import static twitter4j.TwitterAdsConstants.PARAM_WITH_DELETED;
import static twitter4j.TwitterAdsConstants.PATH_PROMOTED_TWEETS;
import static twitter4j.TwitterAdsConstants.PATH_PROMOTED_VIDEO_TWEET;
import static twitter4j.TwitterAdsConstants.PATH_SCHEDULED_PROMOTED_TWEETS;
import static twitter4j.TwitterAdsConstants.PREFIX_ACCOUNTS_URI_2;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;

import twitter4j.BaseAdsListResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterAdsClient;
import twitter4j.TwitterAdsConstants;
import twitter4j.api.TwitterAdsPromotedTweetApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.models4j.Status;
import twitter4j.internal.models4j.Twitter;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.ads.PromotedTweet;
import twitter4j.models.ads.PromotedTweets;
import twitter4j.models.ads.sort.PromotedTweetsSortByField;
import twitter4j.util.TwitterAdUtil;

/**
 * User: abhay
 * Date: 4/22/16
 * Time: 1:06 PM
 */
public class TwitterAdsPromotedTweetApiImpl implements TwitterAdsPromotedTweetApi {

    private static final Integer MAX_REQUEST_PARAMETER_SIZE = 50;

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsPromotedTweetApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<PromotedTweets> getAllPromotedTweets(String accountId, boolean withDeleted, List<String> lineItemIds,
                                                                            Optional<Integer> count, String cursor, Optional<PromotedTweetsSortByField> sortByField) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        
        if (TwitterAdUtil.isNotEmpty(lineItemIds)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_LINE_ITEM_IDS, TwitterAdUtil.getCsv(lineItemIds)));
        }
        
        if (count != null && count.isPresent()) {
            params.add(new HttpParameter(PARAM_COUNT, count.get()));
        }
        
        if (TwitterAdUtil.isNotNullOrEmpty(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }
        
        if (sortByField != null && sortByField.isPresent()) {
            params.add(new HttpParameter(PARAM_SORT_BY, sortByField.get().getField()));
        }
        
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_PROMOTED_TWEETS;
        Type type = new TypeToken<BaseAdsListResponse<PromotedTweets>>() {
        }.getType();
        
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<PromotedTweets> getPromotedTweetsById(String accountId, String promotedTweetsId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(promotedTweetsId, "promotedTweetsId");
        Type type = new TypeToken<BaseAdsResponse<PromotedTweets>>() {
        }.getType();
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_PROMOTED_TWEETS + promotedTweetsId;
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsListResponse<PromotedTweets> createPromotedTweets(String accountId, String lineItemId, Collection<String> tweetIds)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        String tweetIdsAsString;
        if (TwitterAdUtil.isNotEmpty(tweetIds)) {
            TwitterAdUtil.ensureMaxSize(tweetIds, MAX_REQUEST_PARAMETER_SIZE);
            tweetIdsAsString = TwitterAdUtil.getCsv(tweetIds);
            params.add(new HttpParameter(PARAM_TWEET_IDS, tweetIdsAsString));
        }
        HttpResponse httpResponse = twitterAdsClient.postRequest(twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId +
                PATH_PROMOTED_TWEETS, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsListResponse<PromotedTweets>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsListResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse promoted tweets.");
        }
    }

    @Override
    public BaseAdsResponse<PromotedTweets> deletePromotedTweets(String accountId, String tweetId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(tweetId, "Tweet Id");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_PROMOTED_TWEETS +
                tweetId;
        Type type = new TypeToken<BaseAdsResponse<PromotedTweets>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    @Override
    public Status createPromotedVideoTweet(String accountId, String targetUserId, String tweetText, String videoId, String videoTitle, String videoDescription, String callToAction, String ctaValue) throws TwitterException, IOException, InterruptedException {
        try {
            TwitterAdUtil.ensureNotNull(accountId, "AccountId");
            TwitterAdUtil.ensureNotNull(tweetText, "Tweet text");
            TwitterAdUtil.ensureNotNull(videoId, "Video");

            List<HttpParameter> params = Lists.newArrayList();
            if (TwitterAdUtil.isNotNullOrEmpty(targetUserId)) {
                params.add(new HttpParameter(PARAM_AS_USER_ID, targetUserId));
            }

            if (TwitterAdUtil.isNotNullOrEmpty(tweetText)) {
                params.add(new HttpParameter(PARAM_STATUS, tweetText));
            }

            if (TwitterAdUtil.isNotNullOrEmpty(videoId)) {
                params.add(new HttpParameter(PARAM_VIDEO_ID, videoId));
            }

            if (TwitterAdUtil.isNotNullOrEmpty(videoTitle)) {
                params.add(new HttpParameter(PARAM_VIDEO_TITLE, videoTitle));
            }

            if (TwitterAdUtil.isNotNullOrEmpty(videoDescription)) {
                params.add(new HttpParameter(PARAM_VIDEO_DESCRIPTION, videoDescription));
            }

            if (TwitterAdUtil.isNotNullOrEmpty(callToAction) && TwitterAdUtil.isNotNullOrEmpty(ctaValue)) {
                params.add(new HttpParameter(PARAM_VIDEO_CTA, callToAction));
                params.add(new HttpParameter(PARAM_VIDEO_CTA_VALUE, ctaValue));
            }
            String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_PROMOTED_VIDEO_TWEET;
            HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
            Type type = new TypeToken<BaseAdsResponse<PromotedTweet>>() {
            }.getType();
            BaseAdsResponse<PromotedTweet> response = twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
            PromotedTweet tweet = response.getData();
            if (tweet == null) {
                throw new TwitterException("Unable to create Video promoted Tweet. Definitely something is wrong here.");
            }
            return tweet;
        } catch (Exception eX) {
            throw new TwitterException("Unable to Create Promoted Video Tweet. " + eX.getMessage());
        }
    }

    @Override
    public BaseAdsResponse<PromotedTweets> createScheduledPromotedTweets(String accountId, String lineItemId, String scheduledTweetId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");
        TwitterAdUtil.ensureNotNull(scheduledTweetId, "Scheduled Tweet Id");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        params.add(new HttpParameter(PARAM_SCHEDULED_TWEET_ID, scheduledTweetId));

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_SCHEDULED_PROMOTED_TWEETS;
        Type type = new TypeToken<BaseAdsResponse<PromotedTweets>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<PromotedTweets> deleteScheduledPromotedTweet(String accountId, String scheduledPromotedTweet) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(scheduledPromotedTweet, "scheduledPromotedTweet");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_SCHEDULED_PROMOTED_TWEETS +
                scheduledPromotedTweet;
        Type type = new TypeToken<BaseAdsResponse<PromotedTweets>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    @Override
    public Status createPromotedTweetV2(String accountId, String targetUserId, String tweetText, List<String> mediaIds, String videoId, String videoTitle, String videoDescription, String videoCallToAction, String videoCtaValue, String cardUri, boolean promotedOnly) throws TwitterException, IOException {
        try {
            TwitterAdUtil.ensureNotNull(accountId, "AccountId");
            TwitterAdUtil.ensureNotNull(tweetText, "Tweet text");
            List<HttpParameter> params = Lists.newArrayList();

            params.add(new HttpParameter(PARAM_NULLCAST, promotedOnly));

            if (TwitterAdUtil.isNotNullOrEmpty(targetUserId)) {
                params.add(new HttpParameter(PARAM_AS_USER_ID, targetUserId));
            }

            if (TwitterAdUtil.isNotNullOrEmpty(tweetText)) {
                params.add(new HttpParameter(PARAM_TEXT, tweetText));
            }

            if (TwitterAdUtil.isNotNullOrEmpty(cardUri)) {
                params.add(new HttpParameter(PARAM_CARD_URI, cardUri));
            }

            if (TwitterAdUtil.isNotEmpty(mediaIds)) {
                params.add(new HttpParameter(PARAM_MEDIA_IDS, TwitterAdUtil.getCsv(mediaIds)));
            }
            if (TwitterAdUtil.isNotNullOrEmpty(videoId)) {
                params.add(new HttpParameter(PARAM_VIDEO_ID, videoId));
            }

            if (TwitterAdUtil.isNotNullOrEmpty(videoTitle)) {
                params.add(new HttpParameter(PARAM_VIDEO_TITLE, videoTitle));
            }

            if (TwitterAdUtil.isNotNullOrEmpty(videoDescription)) {
                params.add(new HttpParameter(PARAM_VIDEO_DESCRIPTION, videoDescription));
            }

            if (TwitterAdUtil.isNotNullOrEmpty(videoCallToAction) && TwitterAdUtil.isNotNullOrEmpty(videoCtaValue)) {
                params.add(new HttpParameter(PARAM_VIDEO_CTA, videoCallToAction));
                params.add(new HttpParameter(PARAM_VIDEO_CTA_VALUE, videoCtaValue));
            }

            String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_PROMOTED_TWEETS;
            HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
            Type type = new TypeToken<BaseAdsResponse<PromotedTweet>>() {
            }.getType();
            BaseAdsResponse<PromotedTweet> response = twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
            PromotedTweet tweet = response.getData();
            if (tweet == null) {
                throw new TwitterException("Unable to create the tweet. What is this, something is definitely wrong");
            }
            return tweet;
        } catch (Exception eX) {
            throw new TwitterException("Unable to create the tweet. " + eX.getMessage());
        }
    }

    @Override
    public BaseAdsListResponseIterable<PromotedTweets> getScheduledPromotedTweets(String accountId, List<String> lineItemIds, List<String> scheduledPromotedTweetIds, Integer count, String cursor, String sortBy, boolean withDeleted, boolean includeTotalCount) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        params.add(new HttpParameter(TwitterAdsConstants.PARAM_WITH_TOTAL_COUNT, includeTotalCount));
        if (TwitterAdUtil.isNotNullOrEmpty(sortBy)) {
            params.add(new HttpParameter(PARAM_SORT_BY, sortBy));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }

        if (CollectionUtils.isNotEmpty(lineItemIds)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_LINE_ITEM_IDS, TwitterAdUtil.getCsv(lineItemIds)));
        }
        if (CollectionUtils.isNotEmpty(scheduledPromotedTweetIds)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_SCHEDULED_PROMOTED_TWEET_IDS, TwitterAdUtil.getCsv(scheduledPromotedTweetIds)));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_SCHEDULED_PROMOTED_TWEETS;
        Type type = new TypeToken<BaseAdsListResponse<PromotedTweets>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }
}
