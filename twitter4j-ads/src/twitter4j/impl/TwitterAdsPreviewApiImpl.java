package twitter4j.impl;

import com.google.gson.reflect.TypeToken;
import twitter4j.*;
import twitter4j.api.TwitterAdsPreviewApi;
import twitter4j.models.ads.preview.TwitterPreviewInfo;
import twitter4j.models.ads.preview.TwitterPreviewTarget;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * User: abhishekanand
 * Date: 02/05/16 3:11 PM.
 */
public class TwitterAdsPreviewApiImpl implements TwitterAdsPreviewApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsPreviewApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponse<TwitterPreviewInfo> getUnpublishedPromotedTweetPreview(String accountId, String status,
                                                                                      String userId, List<String> mediaIds,
                                                                                      String cardId,
                                                                                      TwitterPreviewTarget twitterPreviewTarget) throws TwitterException {

        TwitterAdUtil.ensureNotNull(accountId, "account Id");
        TwitterAdUtil.ensureNotNull(status, "status");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + TwitterAdsConstants.PREFIX_ACCOUNTS_V1 + accountId + TwitterAdsConstants.TWEET_PREVIEW_PATH;
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(TwitterAdsConstants.PARAM_ACCOUNT_ID, accountId));
        params.add(new HttpParameter(TwitterAdsConstants.PARAM_STATUS, status));
        if (TwitterAdUtil.isNotNullOrEmpty(userId)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_AS_USER_ID, userId));
        }
        if (!TwitterAdUtil.isNotEmpty(mediaIds) && mediaIds.size() > 4) {
            throw new TwitterException("Media ids cannot be grater than 4");
        }
        if (twitterPreviewTarget == null) {
            twitterPreviewTarget = TwitterPreviewTarget.TWITTER_TIMELINE;
        }
        params.add(new HttpParameter(TwitterAdsConstants.TWEET_PREVIEW_TARGET, twitterPreviewTarget.name()));

        switch (twitterPreviewTarget) {
            case PUBLISHER_NETWORK:
                if (!TwitterAdUtil.isNotEmpty(mediaIds)) {
                    throw new TwitterException("For Preview of tweet using preview_target PUBLISHER_NETWORK, media ids is a compulsory field");
                }
                params.add(new HttpParameter(TwitterAdsConstants.PARAM_MEDIA_IDS, TwitterAdUtil.getCsv(mediaIds)));
                break;
            case TWITTER_TIMELINE:
                params.add(new HttpParameter(TwitterAdsConstants.PARAM_MEDIA_IDS, TwitterAdUtil.getCsv(mediaIds)));
                params.add(new HttpParameter(TwitterAdsConstants.PARAM_CARD_ID, cardId));
                break;
        }
        Type type = new TypeToken<BaseAdsListResponse<TwitterPreviewInfo>>() {
        }.getType();
        HttpResponse httpResponse = twitterAdsClient.get(url, params.toArray(new HttpParameter[params.size()]));
        try {
            return TwitterAdUtil.constructBaseAdsListResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Some error occurred while adapting response for previews");
        }
    }

    @Override
    public BaseAdsListResponse<TwitterPreviewInfo> getPromotedTweetPreview(String accountId, String tweetId, String userId, TwitterPreviewTarget twitterPreviewTarget) throws TwitterException {

        TwitterAdUtil.ensureNotNull(accountId, "account Id");
        TwitterAdUtil.ensureNotNull(tweetId, "status");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + TwitterAdsConstants.PREFIX_ACCOUNTS_V1 + accountId + TwitterAdsConstants.TWEET_PREVIEW_PATH + tweetId;
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(TwitterAdsConstants.PARAM_ACCOUNT_ID, accountId));
        params.add(new HttpParameter(TwitterAdsConstants.PARAM_TWEET_ID, tweetId));
        if (TwitterAdUtil.isNotNullOrEmpty(userId)) {
            params.add(new HttpParameter(TwitterAdsConstants.PARAM_AS_USER_ID, userId));
        }
        if (twitterPreviewTarget == null) {
            twitterPreviewTarget = TwitterPreviewTarget.TWITTER_TIMELINE;
        }
        params.add(new HttpParameter(TwitterAdsConstants.TWEET_PREVIEW_TARGET, twitterPreviewTarget.name()));
        Type type = new TypeToken<BaseAdsListResponse<TwitterPreviewInfo>>() {
        }.getType();
        HttpResponse httpResponse = twitterAdsClient.get(url, params.toArray(new HttpParameter[params.size()]));
        try {
            return TwitterAdUtil.constructBaseAdsListResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Some error occurred while adapting response for previews");
        }
    }
}
