package twitter4j.impl;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import twitter4j.BaseAdsListResponse;
import twitter4j.TwitterAdsClient;
import twitter4j.TwitterAdsConstants;
import twitter4j.api.TwitterAdsPreviewApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.ads.TwitterCreativePreview;
import twitter4j.models.ads.TwitterPreviewTarget;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * User: abhishek.chatrath
 * Date: 13/06/16
 */
public class TwitterAdsPreviewApiImpl implements TwitterAdsPreviewApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsPreviewApiImpl(TwitterAdsClient twitterAdsClient) {
        TwitterAdUtil.ensureNotNull(twitterAdsClient, "Twitter_Ads_Client");
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponse<TwitterCreativePreview> getUnpublishedTweetPreview(String accountId, String status, String asUserId,
                                                                                  List<String> mediaIds, String cardId,
                                                                                  TwitterPreviewTarget twitterPreviewTarget) throws TwitterException {

        List<HttpParameter> parameterList = validateAndGetParametersForUnpublishedPostPreview(status, asUserId, mediaIds, cardId,
                twitterPreviewTarget);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + TwitterAdsConstants.PREFIX_ACCOUNTS_V1 +
                accountId + TwitterAdsConstants.TWEET_PATH_PREVIEW;

        Type type = new TypeToken<BaseAdsListResponse<TwitterCreativePreview>>() {
        }.getType();
        HttpResponse response = twitterAdsClient.getRequest(baseUrl, parameterList.toArray(new HttpParameter[parameterList.size()]));

        try {
            return TwitterAdUtil.constructBaseAdsListResponse(response, response.asString(), type);
        } catch (IOException io) {
            throw new TwitterException("Response for tweet preview failed from TwitterApi.");
        }
    }

    @Override
    public BaseAdsListResponse<TwitterCreativePreview> getPublishedTweetPreview(String accountId, String tweetId, String asUserId,
                                                                                TwitterPreviewTarget twitterPreviewTarget) throws TwitterException {

        List<HttpParameter> parameterList = Lists.newArrayList();

        if (TwitterAdUtil.isNotNullOrEmpty(asUserId)) {
            parameterList.add(new HttpParameter(TwitterAdsConstants.PARAM_USER_ID, asUserId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(twitterPreviewTarget.name())) {
            parameterList.add(new HttpParameter(TwitterAdsConstants.PARAM_PREVIEW_TARGET, twitterPreviewTarget.name()));
        }

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + TwitterAdsConstants.PREFIX_ACCOUNTS_V1 +
                accountId + TwitterAdsConstants.TWEET_PATH_PREVIEW + tweetId;

        Type type = new TypeToken<BaseAdsListResponse<TwitterCreativePreview>>() {
        }.getType();
        HttpResponse response = twitterAdsClient.getRequest(baseUrl, parameterList.toArray(new HttpParameter[parameterList.size()]));

        try {
            return TwitterAdUtil.constructBaseAdsListResponse(response, response.asString(), type);
        } catch (IOException io) {
            throw new TwitterException("Response for tweet preview failed from TwitterApi");
        }
    }

    //-------------------------------------------------PRIVATE METHODS-------------------------------------------------------------//

    private List<HttpParameter> validateAndGetParametersForUnpublishedPostPreview(String status, String asUserId, List<String> mediaIds,
                                                                                  String cardId, TwitterPreviewTarget twitterPreviewTarget)
            throws TwitterException {

        boolean isPreviewTargetPublisherNetwork = twitterPreviewTarget == TwitterPreviewTarget.PUBLISHER_NETWORK;
        String mediaIdsCsv = TwitterAdUtil.getCsv(mediaIds);

        if (TwitterAdUtil.isNotNullOrEmpty(mediaIdsCsv) && TwitterAdUtil.isNotNullOrEmpty(cardId)) {
            cardId = StringUtils.EMPTY;
        }

        if (isPreviewTargetPublisherNetwork && !TwitterAdUtil.isNotNullOrEmpty(mediaIdsCsv)) {
            throw new TwitterException("To preview an unpublished tweet, mediaIds is a required field when preview_target is " +
                    TwitterPreviewTarget.PUBLISHER_NETWORK.name());
        }

        List<HttpParameter> parameterList = Lists.newArrayList();
        parameterList.add(new HttpParameter(TwitterAdsConstants.PARAM_STATUS, status));

        if (TwitterAdUtil.isNotNullOrEmpty(asUserId)) {
            parameterList.add(new HttpParameter(TwitterAdsConstants.PARAM_AS_USER_ID, asUserId));
        }

        if (TwitterAdUtil.isNotNull(twitterPreviewTarget)) {
            parameterList.add(new HttpParameter(TwitterAdsConstants.PARAM_PREVIEW_TARGET, twitterPreviewTarget.name()));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(mediaIdsCsv)) {
            parameterList.add(new HttpParameter(TwitterAdsConstants.PARAM_MEDIA_IDS, mediaIdsCsv));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(cardId) && !isPreviewTargetPublisherNetwork) {
            parameterList.add(new HttpParameter(TwitterAdsConstants.PARAM_CARD_ID, cardId));
        }

        return parameterList;
    }
}