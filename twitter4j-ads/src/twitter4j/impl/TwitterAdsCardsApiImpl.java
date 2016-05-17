package twitter4j.impl;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import twitter4j.*;
import twitter4j.api.TwitterAdsCardsApi;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.ads.TwitterUUIDResponse;
import twitter4j.models.ads.cards.*;
import twitter4j.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 8:10 PM
 */
public class TwitterAdsCardsApiImpl implements TwitterAdsCardsApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsCardsApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationCard> getLeadGenerationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterLeadGenerationCard> getAllLeadGenerationCards(String accountId, List<String> cardIds,
                                                                                            boolean withDeleted, Optional<Integer> count)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (count != null && count.isPresent()) {
            params.add(new HttpParameter(PARAM_COUNT, count.get()));
        }
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LEAD_GENERATION_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterLeadGenerationCard>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterImageAppDownloadCard> getAllImageAppDownloadCards(String accountId, List<String> cardIds,
                                                                                                boolean withDeleted, Optional<Integer> count)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (count != null && count.isPresent()) {
            params.add(new HttpParameter(PARAM_COUNT, count.get()));
        }
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterImageAppDownloadCard>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterVideoAppDownloadCard> getAllVideoAppDownloadCards(String accountId, List<String> cardIds,
                                                                                                boolean withDeleted, Optional<Integer> count)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (count != null && count.isPresent()) {
            params.add(new HttpParameter(PARAM_COUNT, count.get()));
        }
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterVideoAppDownloadCard>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationCard> deleteLeadGenerationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> deleteWebsiteCard(String accountId, String cardId) throws TwitterException {

        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_WEBSITE_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterWebsiteCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> getWebsiteCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_WEBSITE_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<VideoObjectResponseData>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterWebsiteCard> getAllWebsiteCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                              Optional<Integer> count) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (count != null && count.isPresent()) {
            params.add(new HttpParameter(PARAM_COUNT, count.get()));
        }

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_WEBSITE_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterWebsiteCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterMobileAppCard> getAllAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                    Optional<Integer> count) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (count != null && count.isPresent()) {
            params.add(new HttpParameter(PARAM_COUNT, count.get()));
        }
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> getAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TwitterVideoAppDownloadCard> deleteVideoAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoAppDownloadCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> deleteAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterImageAppDownloadCard> deleteImageAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterImageAppDownloadCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationStat> getTwitterLeadGenerationStat(String accountId, String cardId, String startTime, Optional<String> endTime,
                                                                                   Optional<String> granularity, Optional<String> metric, Optional<Boolean> withDeleted)
            throws TwitterException {

        final List<HttpParameter> params =
                validateAndCreateParamsForLeadGenerationCardStat(accountId, cardId, startTime, endTime, granularity, metric, withDeleted);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type typeToken = new TypeToken<BaseAdsResponse<TwitterLeadGenerationStat>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, typeToken, HttpVerb.GET);
    }

    @Override
    public String postVideoCardImage(String imageTonLocation) throws TwitterException {
        TwitterAdUtil.ensureNotNull(imageTonLocation, "imageTonLocation");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter("location", imageTonLocation));
        TwitterUUIDResponse twitterUUIDResponse = twitterAdsClient
                .executeRequest(UPLOAD_VIDEO_CARD_IMAGE_URL, params.toArray(new HttpParameter[params.size()]), TwitterUUIDResponse.class,
                        HttpVerb.POST);
        return twitterUUIDResponse.getuUID();
    }

    // --------------------------------------- Private Methods ---------------------------------------------

    private List<HttpParameter> validateAndCreateParamsForLeadGenerationCardStat(String accountId, String cardId, String startTime, Optional<String> endTime,
                                                                                 Optional<String> granularity, Optional<String> metric, Optional<Boolean> withDeleted) {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        TwitterAdUtil.ensureNotNull(startTime, "StartTime");

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_START_TIME, startTime));

        if (endTime != null && endTime.isPresent()) {
            params.add(new HttpParameter(PARAM_END_TIME, endTime.get()));
        }
        if (granularity != null && granularity.isPresent()) {
            params.add(new HttpParameter(PARAM_GRANULARITY, granularity.get()));
        }
        if (metric != null && metric.isPresent()) {
            params.add(new HttpParameter(PARAM_METRICS, metric.get()));
        }
        if (withDeleted != null && withDeleted.isPresent()) {
            params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted.get()));
        }

        return params;
    }
}
