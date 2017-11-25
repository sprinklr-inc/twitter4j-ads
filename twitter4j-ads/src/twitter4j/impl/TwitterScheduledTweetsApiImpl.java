package twitter4j.impl;

import com.google.gson.reflect.TypeToken;
import twitter4j.*;
import twitter4j.api.TwitterScheduledTweetApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.ScheduledTweet;
import twitter4j.models.ads.HttpVerb;
import twitter4j.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhishekanand
 * Date: 03/08/17 2:17 PM.
 */
public class TwitterScheduledTweetsApiImpl implements TwitterScheduledTweetApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterScheduledTweetsApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }


    @Override
    public BaseAdsListResponseIterable<ScheduledTweet> fetch(String accountId, String userId, boolean withDeleted, Integer count, String cursor)
            throws TwitterException {

        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(userId, "userId");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        params.add(new HttpParameter(PARAM_USER_ID, userId));

        if (TwitterAdUtil.isNotNullOrEmpty(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_SCHEDULED_TWEETS;
        Type type = new TypeToken<BaseAdsListResponse<ScheduledTweet>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<ScheduledTweet> fetchScheduledTweetById(String accountId, String scheduledTweetId, boolean withDeleted)
            throws TwitterException {

        TwitterAdUtil.ensureNotNull(scheduledTweetId, "scheduledTweetId");
        TwitterAdUtil.ensureNotNull(accountId, "accountId");

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_SCHEDULED_TWEETS + scheduledTweetId;
        Type type = new TypeToken<BaseAdsResponse<ScheduledTweet>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<ScheduledTweet> create(String accountId, Date scheduledAt, String text, String userId, String cardURI,
                                                  List<String> mediaIds,
                                                  boolean nullCast) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(userId, "userId");
        TwitterAdUtil.ensureNotNull(scheduledAt, "scheduledAt");

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(TwitterAdsConstants.PARAM_AS_USER_ID, userId));
        if (TwitterAdUtil.isNotNullOrEmpty(cardURI)) {
            params.add(new HttpParameter(PARAM_CARD_URI, cardURI));
        }
        params.add(new HttpParameter(PARAM_SCHEDULED_AT, TwitterAdUtil.convertTimeToZuluFormatAndToUTC(scheduledAt.getTime())));
        if (TwitterAdUtil.isNotEmpty(mediaIds)) {
            params.add(new HttpParameter(PARAM_MEDIA_IDS, TwitterAdUtil.getCsv(mediaIds)));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(text)) {
            params.add(new HttpParameter(PARAM_TEXT, text));
        }
        params.add(new HttpParameter(PARAM_NULLCAST, nullCast));
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_SCHEDULED_TWEETS;
        Type type = new TypeToken<BaseAdsResponse<ScheduledTweet>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<ScheduledTweet> update(String accountId, String scheduledTweetId, Date scheduledAt, String text, String cardURI,
                                                  List<String> mediaIds) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(scheduledTweetId, "scheduledTweetId");

        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNullOrEmpty(cardURI)) {
            params.add(new HttpParameter(PARAM_CARD_URI, cardURI));
        }
        if (TwitterAdUtil.isNotEmpty(mediaIds)) {
            params.add(new HttpParameter(PARAM_MEDIA_IDS, TwitterAdUtil.getCsv(mediaIds)));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(text)) {
            params.add(new HttpParameter(PARAM_TEXT, text));
        }
        if (scheduledAt != null) {
            params.add(new HttpParameter(PARAM_SCHEDULED_AT, TwitterAdUtil.convertTimeToZuluFormatAndToUTC(scheduledAt.getTime())));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_SCHEDULED_TWEETS + scheduledTweetId;
        Type type = new TypeToken<BaseAdsResponse<ScheduledTweet>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.PUT);

    }

    @Override
    public BaseAdsResponse<ScheduledTweet> delete(String accountId, String scheduledTweetId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(scheduledTweetId, "Tweet Id");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_SCHEDULED_TWEETS + scheduledTweetId;
        Type type = new TypeToken<BaseAdsResponse<ScheduledTweet>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }
}
