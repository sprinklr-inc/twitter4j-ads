package twitter4jads.impl;

import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import twitter4jads.*;
import twitter4jads.api.TwitterScheduledTweetsApi;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.ads.ScheduledTweet;
import twitter4jads.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static twitter4jads.TwitterAdsConstants.*;

/**
 * User: abhishekanand
 * Date: 03/08/17 2:17 PM.
 */
public class TwitterScheduledTweetsApiImpl implements TwitterScheduledTweetsApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterScheduledTweetsApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public BaseAdsListResponseIterable<ScheduledTweet> getScheduledTweets(String accountId, String userId, boolean withDeleted, Integer count, String cursor)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(userId, "userId");

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_USER_ID, userId));
        if (TwitterAdUtil.isNotNullOrEmpty(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_SCHEDULED_TWEETS;
        final Type type = new TypeToken<BaseAdsListResponse<ScheduledTweet>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public BaseAdsResponse<ScheduledTweet> getScheduledTweetById(String accountId, String scheduledTweetId, boolean withDeleted)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(scheduledTweetId, "scheduledTweetId");
        TwitterAdUtil.ensureNotNull(accountId, "accountId");

        //noinspection MismatchedQueryAndUpdateOfCollection
        final List<HttpParameter> params = new ArrayList<>();

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_SCHEDULED_TWEETS + scheduledTweetId;
        final Type type = new TypeToken<BaseAdsResponse<ScheduledTweet>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[0]), type, HttpVerb.GET);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public BaseAdsResponse<ScheduledTweet> createScheduledTweet(String accountId, Date scheduledAt, String text, String userId, String cardId,
                                                                List<String> mediaKeys,
                                                                boolean nullCast) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(userId, "userId");
        TwitterAdUtil.ensureNotNull(scheduledAt, "scheduledAt");

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(TwitterAdsConstants.PARAM_AS_USER_ID, userId));
        if (StringUtils.isNotBlank(cardId)) {
            params.add(new HttpParameter(PARAM_CARD_URI, "card://" + cardId));
        }
        params.add(new HttpParameter(PARAM_SCHEDULED_AT, TwitterAdUtil.convertTimeToZuluFormatAndToUTC(scheduledAt.getTime())));
        if (TwitterAdUtil.isNotEmpty(mediaKeys)) {
            params.add(new HttpParameter(PARAM_MEDIA_KEYS, TwitterAdUtil.getCsv(mediaKeys)));
        }
        if (StringUtils.isNotBlank(text)) {
            params.add(new HttpParameter(PARAM_TEXT, text));
        }
        params.add(new HttpParameter(PARAM_NULLCAST, nullCast));

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_SCHEDULED_TWEETS;
        final Type type = new TypeToken<BaseAdsResponse<ScheduledTweet>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[0]), type, HttpVerb.POST);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public BaseAdsResponse<ScheduledTweet> updateScheduledTweet(String accountId, String scheduledTweetId, Date scheduledAt, String text, String cardId,
                                                                List<String> mediaKeys) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(scheduledTweetId, "scheduledTweetId");

        final List<HttpParameter> params = new ArrayList<>();
        if (StringUtils.isNotBlank(cardId)) {
            params.add(new HttpParameter(PARAM_CARD_URI, "card://" + cardId));
        }
        if (TwitterAdUtil.isNotEmpty(mediaKeys)) {
            params.add(new HttpParameter(PARAM_MEDIA_KEYS, TwitterAdUtil.getCsv(mediaKeys)));
        }
        if (StringUtils.isNotBlank(text)) {
            params.add(new HttpParameter(PARAM_TEXT, text));
        }
        if (scheduledAt != null) {
            params.add(new HttpParameter(PARAM_SCHEDULED_AT, TwitterAdUtil.convertTimeToZuluFormatAndToUTC(scheduledAt.getTime())));
        }

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_SCHEDULED_TWEETS + scheduledTweetId;
        final Type type = new TypeToken<BaseAdsResponse<ScheduledTweet>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[0]), type, HttpVerb.PUT);

    }

    @SuppressWarnings("Duplicates")
    @Override
    public BaseAdsResponse<ScheduledTweet> deleteScheduledTweet(String accountId, String scheduledTweetId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(scheduledTweetId, "Tweet Id");

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_SCHEDULED_TWEETS + scheduledTweetId;
        final Type type = new TypeToken<BaseAdsResponse<ScheduledTweet>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }
}
