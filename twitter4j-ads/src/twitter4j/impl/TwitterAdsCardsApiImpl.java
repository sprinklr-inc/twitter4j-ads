package twitter4j.impl;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import twitter4j.BaseAdsListResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterAdsClient;
import twitter4j.api.TwitterAdsCardsApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.models4j.Media;
import twitter4j.internal.models4j.MediaUpload;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.internal.models4j.TwitterInvalidParameterException;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.ads.TwitterEntity;
import twitter4j.models.ads.TwitterUUIDResponse;
import twitter4j.models.ads.cards.*;
import twitter4j.models.video.TwitterVideo;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static twitter4j.TwitterAdsConstants.*;
import static twitter4j.TwitterAdsConstants.PARAM_POSTER_IMAGE_ID;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 8:10 PM
 */
public class TwitterAdsCardsApiImpl implements TwitterAdsCardsApi {

    private final TwitterAdsClient twitterAdsClient;
    private static final int DM_CARD_CTA_LENGTH = 20;

    public TwitterAdsCardsApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationCard> getLeadGenerationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {
        }.getType();
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
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_LEAD_GENERATION_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterLeadGenerationCard>>() {
        }.getType();
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
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterImageAppDownloadCard>>() {
        }.getType();
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
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterVideoAppDownloadCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationCard> deleteLeadGenerationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> deleteWebsiteCard(String accountId, String cardId) throws TwitterException {

        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_WEBSITE_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterWebsiteCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> getWebsiteCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_WEBSITE_CARDS + cardId;
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

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_WEBSITE_CARDS;
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
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> getAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TwitterVideoAppDownloadCard> deleteVideoAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoAppDownloadCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> deleteAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterImageAppDownloadCard> deleteImageAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS + cardId;
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
    public BaseAdsResponse<TwitterLeadGenerationCard> createLeadGenerationCard(String accountId, String name, String title, String cta, String fallbackUrl, String privacyPolicyUrl, String imageUrl, String imageData, String submitMethod, String submitUrl, String customKeyScreenName, String customKeyName, String customKeyEmail, Map<String, String> customParamKeys) throws TwitterException {
        String mediaId = uploadImageForCards(imageUrl, imageData);

        final List<HttpParameter> params =
                validateAndCreateParamsForCreateLeadGenerationCard(accountId, name, title, cta, fallbackUrl, privacyPolicyUrl, submitMethod,
                        submitUrl, customKeyScreenName, customKeyName, customKeyEmail, customParamKeys,
                        mediaId);

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_LEAD_GENERATION_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);

    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationCard> updateLeadGenerationCard(String accountId, String cardId, String name, String title, String cta, String fallbackUrl, String privacyPolicyUrl, String imageUrl, String imageData, String submitMethod, String submitUrl, String customKeyScreenName, String customKeyName, String customKeyEmail, Map<String, String> customParamKeys) throws TwitterException {
        String mediaId = uploadImageForCards(imageUrl, imageData);

        final List<HttpParameter> params =
                validateAndCreateParamsForCreateLeadGenerationCard(accountId, name, title, cta, fallbackUrl, privacyPolicyUrl, submitMethod,
                        submitUrl, customKeyScreenName, customKeyName, customKeyEmail, customParamKeys,
                        mediaId);

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterImageConversationCard> getAllImageConversationCards(String accountId, List<String> cardIds, boolean withDeleted, Integer count) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_CONVERSATION_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterImageConversationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterVideoConversationCard> getAllVideoConversationCards(String accountId, List<String> cardIds, boolean withDeleted, Integer count) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_CONVERSATION_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterVideoConversationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> updateWebsiteCard(String accountId, String name, String cardId, String websiteTitle, String websiteUrl, String channelImage, String channelImageData) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        String mediaId = uploadImageForCards(channelImage, channelImageData);

        List<HttpParameter> params = validateAndCreateParamsForCreateWebsiteCard(accountId, name, websiteTitle, websiteUrl, mediaId);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_WEBSITE_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterWebsiteCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> createWebsiteCard(String accountId, String name, String websiteTitle, String websiteUrl, String channelImage, String channelImageData) throws TwitterException {
        Long imageSizeInBytesLong;
        try {
            imageSizeInBytesLong = Long.valueOf(getMediaUrlSizeInBytes(channelImageData));
        } catch (NumberFormatException | IOException eX) {
            throw new TwitterException("Image for Website Card could not be uploaded as connection could not be established");
        }
        if (imageSizeInBytesLong > MAX_IMAGE_SIZE_FOR_WEBSITE_IN_BYTES) {
            throw new TwitterInvalidParameterException("Image for Website Card should be less than 1 MB in size");
        }
        String mediaId = uploadImageForCards(channelImage, channelImageData);

        final List<HttpParameter> params = validateAndCreateParamsForCreateWebsiteCard(accountId, name, websiteTitle, websiteUrl, mediaId);

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_WEBSITE_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterWebsiteCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> createAppDownloadCard(String accountId, String name, String appCountryCode, String iphoneAppId, String ipadAppId, String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink, String customIcon, String customIconData, String customAppDescription, String callToAction) throws TwitterException {
        String mediaId = uploadImageForCards(customIcon, customIconData);
        List<HttpParameter> params =
                validateAndCreateParamsForCreateAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                        iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, customAppDescription, mediaId,
                        callToAction);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_APP_DOWNLOAD_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> updateAppDownloadCard(String accountId, String name, String cardId, String appCountryCode, String iphoneAppId, String ipadAppId, String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink, String customIcon, String customIconData, String customAppDescription, String callToAction) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        String mediaId = uploadImageForCards(customIcon, customIconData);

        List<HttpParameter> params =
                validateAndCreateParamsForUpdateAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                        iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, customAppDescription, mediaId,
                        callToAction);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_APP_DOWNLOAD_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterImageAppDownloadCard> createImageAppDownloadCard(String accountId, String name, String appCountryCode, String iphoneAppId, String ipadAppId, String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink, String wideAppImage, String wideAppImageData, String callToAction) throws TwitterException {
        String mediaId = uploadImageForCards(wideAppImage, wideAppImageData);

        List<HttpParameter> params =
                validateAndCreateParamsForCreateImageAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                        iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, mediaId, callToAction);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterImageAppDownloadCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TwitterImageAppDownloadCard> updateImageAppDownloadCard(String accountId, String name, String cardId, String appCountryCode, String iphoneAppId, String ipadAppId, String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink, String wideAppImage, String wideAppImageData, String callToAction) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        String mediaId = uploadImageForCards(wideAppImage, wideAppImageData);

        List<HttpParameter> params =
                validateAndCreateParamsForUpdateImageAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                        iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, mediaId, callToAction);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterImageAppDownloadCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterVideoAppDownloadCard> createVideoAppDownloadCard(String accountId, String name, String appCountryCode, String iphoneAppId, String ipadAppId, String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink, String videoUrl, String imageUrl, String callToAction) throws TwitterException, IOException, InterruptedException {
        String imageMediaId = uploadImageForCards(null, imageUrl);

        TwitterVideo video = twitterAdsClient.uploadAndCreateVideoObject(videoUrl, accountId);
        String videoMediaId = video.getId();

        List<HttpParameter> params =
                validateAndCreateParamsForCreateVideoAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                        iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, imageMediaId, videoMediaId,
                        callToAction);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoAppDownloadCard>>() {
        }.getType();

        BaseAdsResponse<TwitterVideoAppDownloadCard> twitterVideoAppDownloadResponse =
                twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
        TwitterVideoAppDownloadCard videoAppDownloadCard = twitterVideoAppDownloadResponse.getData();
        if (video.getId() != null) {
            videoAppDownloadCard.setChannelVideoId(video.getId());
        }
        if (video.getPreviewUrl() != null) {
            videoAppDownloadCard.setChannelVideoUrl(video.getPreviewUrl());
        }
        if (video.getDuration() != null) {
            videoAppDownloadCard.setChannelVideoLength(video.getDuration().toString());
        }
        videoAppDownloadCard.setChannelImageId(imageMediaId);

        return twitterVideoAppDownloadResponse;
    }

    @Override
    public BaseAdsResponse<TwitterVideoAppDownloadCard> updateVideoAppDownloadCard(String accountId, String name, String cardId, String appCountryCode, String iphoneAppId, String ipadAppId, String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink, String updatedImageUrl, String updatedVideoUrl, String originalImageId, String originalVideoId, String callToActionValue) throws TwitterException, IOException, InterruptedException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");

        String imageMediaId;
        String videoMediaId;
        TwitterVideo video;

        if (updatedImageUrl != null) {
            imageMediaId = uploadImageForCards(null, updatedImageUrl);
        } else {
            imageMediaId = originalImageId;
        }

        if (updatedVideoUrl != null) {
            video = twitterAdsClient.uploadAndCreateVideoObject(updatedVideoUrl, accountId);
            videoMediaId = video.getId();
        } else {
            video = twitterAdsClient.waitForVideoProcessing(accountId, originalVideoId, TimeUnit.MINUTES.toMillis(2));
            videoMediaId = originalVideoId;
        }

        List<HttpParameter> params =
                validateAndCreateParamsForUpdateVideoAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                        iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, imageMediaId, videoMediaId,
                        callToActionValue);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoAppDownloadCard>>() {
        }.getType();
        BaseAdsResponse<TwitterVideoAppDownloadCard> twitterVideoAppDownloadResponse =
                twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);

        TwitterVideoAppDownloadCard videoAppDownloadCard = twitterVideoAppDownloadResponse.getData();
        if (video != null) {
            if (video.getId() != null) {
                videoAppDownloadCard.setChannelVideoId(video.getId());
            }
            if (video.getPreviewUrl() != null) {
                videoAppDownloadCard.setChannelVideoUrl(video.getPreviewUrl());
            }
            if (video.getDuration() != null) {
                videoAppDownloadCard.setChannelVideoLength(video.getDuration().toString());
            }
        }
        videoAppDownloadCard.setChannelImageId(imageMediaId);

        return twitterVideoAppDownloadResponse;
    }

    @Override
    public BaseAdsResponse<TwitterImageConversationCard> createImageConversationCard(String accountId, String name, String title, String firstCta, String firstCtaTweet, String secondCta, String secondCtaTweet, String thanksText, String thanksUrl, String imageUrl) throws TwitterException {
        List<HttpParameter> params =
                validateAndCreateParamsForCreateImageConversationCard(accountId, name, title, firstCta, firstCtaTweet, secondCta, secondCtaTweet,
                        thanksText, thanksUrl, imageUrl);

        String mediaId = uploadImageForCards(null, imageUrl);
        params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, mediaId));

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_CONVERSATION_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterImageConversationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TwitterImageConversationCard> updateImageConversationCard(String accountId, String cardId, String name, String title, String firstCta, String firstCtaTweet, String secondCta, String secondCtaTweet, String thanksText, String thanksUrl, String imageUrl) throws TwitterException {
        BaseAdsResponse<TwitterImageConversationCard> response = getImageConversationCard(accountId, cardId);
        TwitterImageConversationCard existingCard = response.getData();

        List<HttpParameter> params =
                validateAndCreateParamsForUpdateImageConversationCard(accountId, name, title, firstCta, firstCtaTweet, secondCta, secondCtaTweet,
                        thanksText, thanksUrl, imageUrl, existingCard);

        String mediaId = uploadImageForCards(null, imageUrl);
        params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, mediaId));

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_CONVERSATION_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterImageConversationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterImageConversationCard> deleteImageConversationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_CONVERSATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterImageConversationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterVideoConversationCard> createVideoConversationCard(String accountId, String name, String title, String firstCta,
                                                                                     String firstCtaTweet, String secondCta, String secondCtaTweet,
                                                                                     String thanksText, String thanksUrl, String imageUrl,
                                                                                     String videoUrl) throws TwitterException {
        List<HttpParameter> params =
                validateAndCreateParamsForCreateVideoConversationCard(accountId, name, title, firstCta, firstCtaTweet, secondCta, secondCtaTweet,
                        thanksText, thanksUrl, videoUrl);
        if (TwitterAdUtil.isNotNullOrEmpty(imageUrl)) {
            String imageMediaId = uploadImageForCards(null, imageUrl);
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, imageMediaId));
        }

        TwitterVideo video = twitterAdsClient.uploadAndCreateVideoObject(videoUrl, accountId);
        params.add(new HttpParameter(PARAM_VIDEO_ID, video.getId()));

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_CONVERSATION_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoConversationCard>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TwitterVideoConversationCard> updateVideoConversationCard(String accountId, String cardId, String name, String title, String firstCta, String firstCtaTweet, String secondCta, String secondCtaTweet, String thanksText, String thanksUrl, String updatedImageUrl, String updatedVideoUrl) throws TwitterException {
        BaseAdsResponse<TwitterVideoConversationCard> response = getVideoConversationCard(accountId, cardId);
        TwitterVideoConversationCard existingCard = response.getData();

        List<HttpParameter> params =
                validateAndCreateParamsForUpdateVideoConversationCard(accountId, name, title, firstCta, firstCtaTweet, secondCta, secondCtaTweet,
                        thanksText, thanksUrl, updatedVideoUrl, existingCard);

        if (TwitterAdUtil.isNotNullOrEmpty(updatedImageUrl)) {
            String imageMediaId = uploadImageForCards(null, updatedImageUrl);
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, imageMediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(updatedVideoUrl)) {
            TwitterVideo video = twitterAdsClient.uploadAndCreateVideoObject(updatedVideoUrl, accountId);
            params.add(new HttpParameter(PARAM_VIDEO_ID, video.getId()));
        }

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_CONVERSATION_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoConversationCard>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterVideoConversationCard> deleteVideoConversationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_CONVERSATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoConversationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterImageDMCard> createImageDMCard(String accountId, String name, String firstCta, Long firstWelcomeMessageId, String secondCta, Long secondWelcomeMessageId, String thirdCta, Long thirdWelcomeMessageId, String fourthCta, Long fourthWelcomeMessageId, Long recipientAccountId, String imageUrl, String imageMediaId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(name, "Title");
        TwitterAdUtil.ensureNotNull(firstCta, "First Cta");
        TwitterAdUtil.ensureNotNull(firstWelcomeMessageId, "First Welcome Message ID");
        TwitterAdUtil.ensureNotNull(recipientAccountId, "Promotable Account ID");

        verifyCtaLength(firstCta, "First Cta");

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_RECIPIENT_USER_ID, recipientAccountId));
        params.add(new HttpParameter(PARAM_FIRST_CTA, firstCta));
        params.add(new HttpParameter(PARAM_FIRST_CTA_WELCOME_MESSAGE_ID, firstWelcomeMessageId));

        if (TwitterAdUtil.isNotNull(secondCta) && TwitterAdUtil.isNotNull(secondWelcomeMessageId)) {
            verifyCtaLength(secondCta, "Second Cta");
            params.add(new HttpParameter(PARAM_SECOND_CTA, secondCta));
            params.add(new HttpParameter(PARAM_SECOND_CTA_WELCOME_MESSAGE_ID, secondWelcomeMessageId));
        }

        if (TwitterAdUtil.isNotNull(thirdCta) && TwitterAdUtil.isNotNull(thirdWelcomeMessageId)) {
            verifyCtaLength(thirdCta, "Third Cta");
            params.add(new HttpParameter(PARAM_THIRD_CTA, thirdCta));
            params.add(new HttpParameter(PARAM_THIRD_CTA_WELCOME_MESSAGE_ID, thirdWelcomeMessageId));
        }

        if (TwitterAdUtil.isNotNull(fourthCta) && TwitterAdUtil.isNotNull(fourthWelcomeMessageId)) {
            verifyCtaLength(fourthCta, "Fourth Cta");
            params.add(new HttpParameter(PARAM_FOURTH_CTA, fourthCta));
            params.add(new HttpParameter(PARAM_FOURTH_CTA_WELCOME_MESSAGE_ID, fourthWelcomeMessageId));
        }

        params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, imageMediaId));

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_DM_CARDS;
        final HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterImageDMCard>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TwitterVideoDMCard> createVideoDMCard(String accountId, String name, String firstCta, Long firstWelcomeMessageId, String secondCta, Long secondWelcomeMessageId, String thirdCta, Long thirdWelcomeMessageId, String fourthCta, Long fourthWelcomeMessageId, Long recipientAccountId, String imageUrl, String videoUrl, String imageMediaId, String videoMediaId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(videoUrl, "Video Url");
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(name, "Title");
        TwitterAdUtil.ensureNotNull(firstCta, "First Cta");
        TwitterAdUtil.ensureNotNull(firstWelcomeMessageId, "First Welcome Message ID");
        TwitterAdUtil.ensureNotNull(recipientAccountId, "Promotable Account ID");

        verifyCtaLength(firstCta, "First Cta");

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_RECIPIENT_USER_ID, recipientAccountId));
        params.add(new HttpParameter(PARAM_FIRST_CTA, firstCta));
        params.add(new HttpParameter(PARAM_FIRST_CTA_WELCOME_MESSAGE_ID, firstWelcomeMessageId));

        if (TwitterAdUtil.isNotNull(secondCta) && TwitterAdUtil.isNotNull(secondWelcomeMessageId)) {
            verifyCtaLength(secondCta, "Second Cta");
            params.add(new HttpParameter(PARAM_SECOND_CTA, secondCta));
            params.add(new HttpParameter(PARAM_SECOND_CTA_WELCOME_MESSAGE_ID, secondWelcomeMessageId));
        }

        if (TwitterAdUtil.isNotNull(thirdCta) && TwitterAdUtil.isNotNull(thirdWelcomeMessageId)) {
            verifyCtaLength(thirdCta, "Third Cta");
            params.add(new HttpParameter(PARAM_THIRD_CTA, thirdCta));
            params.add(new HttpParameter(PARAM_THIRD_CTA_WELCOME_MESSAGE_ID, thirdWelcomeMessageId));
        }

        if (TwitterAdUtil.isNotNull(fourthCta) && TwitterAdUtil.isNotNull(fourthWelcomeMessageId)) {
            verifyCtaLength(fourthCta, "Fourth Cta");
            params.add(new HttpParameter(PARAM_FOURTH_CTA, fourthCta));
            params.add(new HttpParameter(PARAM_FOURTH_CTA_WELCOME_MESSAGE_ID, fourthWelcomeMessageId));
        }

        if (StringUtils.isNotBlank(imageMediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, imageMediaId));
        }
        params.add(new HttpParameter(PARAM_VIDEO_ID, videoMediaId));

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_DM_CARDS;
        final HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoDMCard>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TwitterEntity> associateDMVideoToAccount(String accountId, String videoMediaId, String imageMediaId) throws TwitterException {
        final List<HttpParameter> params = new ArrayList<>();
        if (StringUtils.isNotBlank(imageMediaId)) {
            params.add(new HttpParameter(PARAM_POSTER_IMAGE_ID, imageMediaId));
        }

        TwitterAdUtil.ensureNotNull(videoMediaId, "Video Media Id");
        params.add(new HttpParameter(PARAM_VIDEO_MEDIA_ID, videoMediaId));

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PREFIX_VIDEOS;
        final HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterEntity>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TwitterImageDMCard> updateImageDMCard(String accountId, String name, String firstCta, Long firstWelcomeMessageId, String secondCta, Long secondWelcomeMessageId, String thirdCta, Long thirdWelcomeMessageId, String fourthCta, Long fourthWelcomeMessageId, String imageUrl, String imageMediaId, String channelId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(channelId, "Card Channel Id");

        final List<HttpParameter> params = new ArrayList<>();
        if (StringUtils.isNotBlank(name)) {
            params.add(new HttpParameter(PARAM_NAME, name));
        }

        if (TwitterAdUtil.isNotNull(firstCta) && TwitterAdUtil.isNotNull(firstWelcomeMessageId)) {
            verifyCtaLength(firstCta, "First Cta");
            params.add(new HttpParameter(PARAM_FIRST_CTA, firstCta));
            params.add(new HttpParameter(PARAM_FIRST_CTA_WELCOME_MESSAGE_ID, firstWelcomeMessageId));
        }

        if (TwitterAdUtil.isNotNull(secondCta) && TwitterAdUtil.isNotNull(secondWelcomeMessageId)) {
            verifyCtaLength(secondCta, "Second Cta");
            params.add(new HttpParameter(PARAM_SECOND_CTA, secondCta));
            params.add(new HttpParameter(PARAM_SECOND_CTA_WELCOME_MESSAGE_ID, secondWelcomeMessageId));
        }

        if (TwitterAdUtil.isNotNull(thirdCta) && TwitterAdUtil.isNotNull(thirdWelcomeMessageId)) {
            verifyCtaLength(thirdCta, "Third Cta");
            params.add(new HttpParameter(PARAM_THIRD_CTA, thirdCta));
            params.add(new HttpParameter(PARAM_THIRD_CTA_WELCOME_MESSAGE_ID, thirdWelcomeMessageId));
        }

        if (TwitterAdUtil.isNotNull(fourthCta) && TwitterAdUtil.isNotNull(fourthWelcomeMessageId)) {
            verifyCtaLength(fourthCta, "Fourth Cta");
            params.add(new HttpParameter(PARAM_FOURTH_CTA, fourthCta));
            params.add(new HttpParameter(PARAM_FOURTH_CTA_WELCOME_MESSAGE_ID, fourthWelcomeMessageId));
        }
        if (StringUtils.isNotBlank(imageMediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, imageMediaId));
        }

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_DM_CARDS + channelId;
        final HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterImageDMCard>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterVideoDMCard> updateVideoDMCard(String accountId, String name, String firstCta, Long firstWelcomeMessageId, String secondCta, Long secondWelcomeMessageId, String thirdCta, Long thirdWelcomeMessageId, String fourthCta, Long fourthWelcomeMessageId, String imageUrl, String videoUrl, String imageMediaId, String videoMediaId, String channelId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(channelId, "Card Channel Id");

        final List<HttpParameter> params = new ArrayList<>();
        if (StringUtils.isNotBlank(name)) {
            params.add(new HttpParameter(PARAM_NAME, name));
        }

        if (TwitterAdUtil.isNotNull(firstCta) && TwitterAdUtil.isNotNull(firstWelcomeMessageId)) {
            verifyCtaLength(firstCta, "First Cta");
            params.add(new HttpParameter(PARAM_FIRST_CTA, firstCta));
            params.add(new HttpParameter(PARAM_FIRST_CTA_WELCOME_MESSAGE_ID, firstWelcomeMessageId));
        }

        if (TwitterAdUtil.isNotNull(secondCta) && TwitterAdUtil.isNotNull(secondWelcomeMessageId)) {
            verifyCtaLength(secondCta, "Second Cta");
            params.add(new HttpParameter(PARAM_SECOND_CTA, secondCta));
            params.add(new HttpParameter(PARAM_SECOND_CTA_WELCOME_MESSAGE_ID, secondWelcomeMessageId));
        }

        if (TwitterAdUtil.isNotNull(thirdCta) && TwitterAdUtil.isNotNull(thirdWelcomeMessageId)) {
            verifyCtaLength(thirdCta, "Third Cta");
            params.add(new HttpParameter(PARAM_THIRD_CTA, thirdCta));
            params.add(new HttpParameter(PARAM_THIRD_CTA_WELCOME_MESSAGE_ID, thirdWelcomeMessageId));
        }

        if (TwitterAdUtil.isNotNull(fourthCta) && TwitterAdUtil.isNotNull(fourthWelcomeMessageId)) {
            verifyCtaLength(fourthCta, "Fourth Cta");
            params.add(new HttpParameter(PARAM_FOURTH_CTA, fourthCta));
            params.add(new HttpParameter(PARAM_FOURTH_CTA_WELCOME_MESSAGE_ID, fourthWelcomeMessageId));
        }
        if (StringUtils.isNotBlank(imageMediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, imageMediaId));
        }
        if (StringUtils.isNotBlank(videoMediaId)) {
            params.add(new HttpParameter(PARAM_VIDEO_ID, videoMediaId));
        }

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_DM_CARDS + channelId;
        final HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoDMCard>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterImageDMCard> deleteImageDMCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_DM_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterImageDMCard>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterVideoDMCard> deleteVideoDMCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_DM_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoDMCard>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterVideoWebsiteCard> createVideoWebsiteCard(String accountId, String name, String title, String videoId, String websiteUrl) throws TwitterException {
        return null;
    }

    @Override
    public BaseAdsResponse<TwitterVideoWebsiteCard> updateVideoWebsiteCard(String accountId, String cardId, String name, String title, String videoId, String websiteUrl) throws TwitterException {
        return null;
    }

    @Override
    public BaseAdsResponse<TwitterVideoWebsiteCard> deleteVideoWebsiteCard(String accountId, String cardId) throws TwitterException {
        return null;
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

    private BaseAdsResponse<TwitterVideoConversationCard> getVideoConversationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_VIDEO_CONVERSATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoConversationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    private String uploadImageForCards(String channelImage, String nonTwitterImageUrl) {
        String image = null;
        if (TwitterAdUtil.isNotNullOrEmpty(nonTwitterImageUrl)) {
            image = nonTwitterImageUrl;
        } else if (TwitterAdUtil.isNotNullOrEmpty(channelImage)) {
            image = channelImage;
        }
        if (image == null) {
            return null;
        }
        return getMediaId(image);
    }

    private String getMediaId(String image) {
        Media media;
        try {
            TwitterAdUtil.ensureNotNull(image, "image");
            InputStream fileBody = new URL(image).openStream();
            media = twitterAdsClient.upload(new MediaUpload(fileBody));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (media != null) {
            return media.getMediaIdString();
        }
        return null;
    }

    private List<HttpParameter> validateAndCreateParamsForCreateLeadGenerationCard(String accountId, String name, String title, String cta,
                                                                                   String fallbackUrl, String privacyPolicyUrl, String submitMethod,
                                                                                   String submitUrl, String customKeyScreenName, String customKeyName,
                                                                                   String customKeyEmail, Map<String, String> customParamKeys,
                                                                                   String mediaId) throws TwitterException {
        List<HttpParameter> params = Lists.newArrayList();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(name, "Name");
        TwitterAdUtil.ensureNotNull(title, "Title");
        TwitterAdUtil.ensureNotNull(cta, "Cta");
        TwitterAdUtil.ensureNotNull(fallbackUrl, "Fallback Url");
        TwitterAdUtil.ensureNotNull(privacyPolicyUrl, "Privacy Policy Url");
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_TITLE, title));
        params.add(new HttpParameter(PARAM_CTA, cta));
        params.add(new HttpParameter(PARAM_FALLBACK_URL, fallbackUrl));
        params.add(new HttpParameter(PARAM_PRIVACY_POLICY_URL, privacyPolicyUrl));

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, mediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(submitMethod)) {
            params.add(new HttpParameter(PARAM_SUBMIT_METHOD, submitMethod));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(submitUrl)) {
            params.add(new HttpParameter(PARAM_SUBMIT_URL, submitUrl));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(customKeyScreenName)) {
            params.add(new HttpParameter(PARAM_CUSTOM_KEY_SCREEN_NAME, customKeyScreenName));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(customKeyName)) {
            params.add(new HttpParameter(PARAM_CUSTOM_KEY_NAME, customKeyName));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(customKeyEmail)) {
            params.add(new HttpParameter(PARAM_CUSTOM_KEY_EMAIL, customKeyEmail));
        }
        if (MapUtils.isNotEmpty(customParamKeys)) {
            for (Map.Entry<String, String> paramEntry : customParamKeys.entrySet()) {
                params.add(new HttpParameter(paramEntry.getKey(), paramEntry.getValue()));
            }
        }
        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForCreateWebsiteCard(String accountId, String name, String websiteTitle, String websiteUrl,
                                                                            String mediaId) throws TwitterException {
        List<HttpParameter> params = Lists.newArrayList();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(name, "Name");
        TwitterAdUtil.ensureNotNull(websiteTitle, "WebsiteTitle");
        TwitterAdUtil.ensureNotNull(websiteUrl, "WebsiteUrl");
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_WEBSITE_TITLE, websiteTitle));
        params.add(new HttpParameter(PARAM_WEBSITE_URL, websiteUrl));

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, mediaId));
        }

        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForUpdateImageConversationCard(String accountId, String name, String title, String firstCta,
                                                                                      String firstCtaTweet, String secondCta, String secondCtaTweet,
                                                                                      String thanksText, String thanksUrl, String imageUrl,
                                                                                      TwitterImageConversationCard existingCard)
            throws TwitterException {

        TwitterAdUtil.ensureNotNull(imageUrl, "Image");
        return validateAndCreateParamsForUpdateConversationCard(accountId, name, title, firstCta, firstCtaTweet, secondCta, secondCtaTweet,
                thanksText, thanksUrl, existingCard);
    }

    private List<HttpParameter> validateAndCreateParamsForUpdateConversationCard(String accountId, String name, String title, String firstCta,
                                                                                 String firstCtaTweet, String secondCta, String secondCtaTweet,
                                                                                 String thanksText, String thanksUrl,
                                                                                 AbstractConversationCard existingCard) throws TwitterException {
        List<HttpParameter> params =
                validateAndCreateParamsForCreateConversationCard(accountId, name, title, firstCta, firstCtaTweet, secondCta, secondCtaTweet,
                        thanksText, thanksUrl);

        if (!TwitterAdUtil.isNotNullOrEmpty(title) && TwitterAdUtil.isNotNullOrEmpty(existingCard.getTitle())) {
            params.add(new HttpParameter(PARAM_TITLE, ""));
        }

        if (!TwitterAdUtil.isNotNullOrEmpty(secondCta) && TwitterAdUtil.isNotNullOrEmpty(existingCard.getSecondCta())) {
            params.add(new HttpParameter(PARAM_SECOND_CTA, ""));
        }

        if (!TwitterAdUtil.isNotNullOrEmpty(secondCtaTweet) && TwitterAdUtil.isNotNullOrEmpty(existingCard.getSecondCtaTweet())) {
            params.add(new HttpParameter(PARAM_SECOND_CTA_TWEET, ""));
        }

        if (!TwitterAdUtil.isNotNullOrEmpty(thanksUrl) && TwitterAdUtil.isNotNullOrEmpty(existingCard.getThankUrl())) {
            params.add(new HttpParameter(PARAM_THANK_YOU_URL, ""));
        }

        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForCreateAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                                String customAppDescription, String mediaId, String callToAction)
            throws TwitterException {
        List<HttpParameter> params =
                getCardHttpParameters(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink, ipadDeepLink,
                        googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_CUSTOM_ICON_MEDIA_ID, mediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(customAppDescription)) {
            params.add(new HttpParameter(PARAM_CUSTOM_APP_DESCRIPTION, customAppDescription));
        }
        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForUpdateVideoConversationCard(String accountId, String name, String title, String firstCta,
                                                                                      String firstCtaTweet, String secondCta, String secondCtaTweet,
                                                                                      String thanksText, String thanksUrl, String videoUrl,
                                                                                      TwitterVideoConversationCard existingCard)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(videoUrl, "Video");
        return validateAndCreateParamsForUpdateConversationCard(accountId, name, title, firstCta, firstCtaTweet, secondCta, secondCtaTweet,
                thanksText, thanksUrl, existingCard);
    }

    private List<HttpParameter> getCardHttpParameters(String accountId, String name, String appCountryCode, String iphoneAppId, String ipadAppId,
                                                      String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink)
            throws TwitterException {
        List<HttpParameter> params = Lists.newArrayList();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(appCountryCode, "App Country Code");
        TwitterAdUtil.ensureNotNull(name, "Name");
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_APP_COUNTRY_CODE, appCountryCode));

        // This is done in order to satisfy the condition: atleast one of the app ids is provided
        if (!(TwitterAdUtil.isNotNullOrEmpty(googlePlayAppId) || TwitterAdUtil.isNotNullOrEmpty(ipadAppId) ||
                TwitterAdUtil.isNotNullOrEmpty(iphoneAppId))) {
            throw new TwitterException(
                    new UnsupportedOperationException("Please provide atleast one valid store app id to create an app download card"));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(iphoneAppId)) {
            params.add(new HttpParameter(PARAM_IPHONE_APP_ID, iphoneAppId));
            if (TwitterAdUtil.isNotNullOrEmpty(iphoneDeepLink)) {
                params.add(new HttpParameter(PARAM_IPHONE_DEEP_LINK, iphoneDeepLink));
            }
        }
        if (TwitterAdUtil.isNotNullOrEmpty(ipadAppId)) {
            params.add(new HttpParameter(PARAM_IPAD_APP_ID, ipadAppId));
            if (TwitterAdUtil.isNotNullOrEmpty(ipadDeepLink)) {
                params.add(new HttpParameter(PARAM_IPAD_DEEP_LINK, ipadDeepLink));
            }
        }
        if (TwitterAdUtil.isNotNullOrEmpty(googlePlayAppId)) {
            params.add(new HttpParameter(PARAM_GOOGLEPLAY_APP_ID, googlePlayAppId));
            if (TwitterAdUtil.isNotNullOrEmpty(googlePlayDeepLink)) {
                params.add(new HttpParameter(PARAM_GOOGLEPLAY_DEEP_LINK, googlePlayDeepLink));
            }
        }
        return params;
    }

    private String getMediaUrlSizeInBytes(String mediaUrl) throws IOException {
        URLConnection urlConnection = new URL(mediaUrl).openConnection();
        return urlConnection.getHeaderField("Content-Length");
    }

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

    private BaseAdsResponse<TwitterImageConversationCard> getImageConversationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_IMAGE_CONVERSATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterImageConversationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    private List<HttpParameter> validateAndCreateParamsForUpdateAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                                String customAppDescription, String mediaId, String callToAction)
            throws TwitterException {
        List<HttpParameter> params =
                getCardHttpParametersForUpdate(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink, ipadDeepLink,
                        googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_CUSTOM_ICON_MEDIA_ID, mediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(customAppDescription)) {
            params.add(new HttpParameter(PARAM_CUSTOM_APP_DESCRIPTION, customAppDescription));
        }
        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForCreateVideoConversationCard(String accountId, String name, String title, String firstCta,
                                                                                      String firstCtaTweet, String secondCta, String secondCtaTweet,
                                                                                      String thanksText, String thanksUrl, String videoUrl)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(videoUrl, "Video");
        return validateAndCreateParamsForCreateConversationCard(accountId, name, title, firstCta, firstCtaTweet, secondCta, secondCtaTweet,
                thanksText, thanksUrl);
    }

    private List<HttpParameter> getCardHttpParametersForUpdate(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                               String ipadAppId, String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink,
                                                               String googlePlayDeepLink) throws TwitterException {
        List<HttpParameter> params = Lists.newArrayList();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(appCountryCode, "App Country Code");
        TwitterAdUtil.ensureNotNull(name, "Name");
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_APP_COUNTRY_CODE, appCountryCode));

        // This is done in order to satisfy the condition: atleast one of the app ids is provided
        if (!(TwitterAdUtil.isNotNullOrEmpty(googlePlayAppId) || TwitterAdUtil.isNotNullOrEmpty(ipadAppId) ||
                TwitterAdUtil.isNotNullOrEmpty(iphoneAppId))) {
            throw new TwitterException(
                    new UnsupportedOperationException("Please provide atleast one valid store app id to create an app download card"));
        }

        iphoneAppId = iphoneAppId == null ? "" : iphoneAppId;
        iphoneDeepLink = iphoneDeepLink == null ? "" : iphoneDeepLink;
        ipadAppId = ipadAppId == null ? "" : ipadAppId;
        ipadDeepLink = ipadDeepLink == null ? "" : ipadDeepLink;
        googlePlayAppId = googlePlayAppId == null ? "" : googlePlayAppId;
        googlePlayDeepLink = googlePlayDeepLink == null ? "" : googlePlayDeepLink;

        params.add(new HttpParameter(PARAM_IPHONE_APP_ID, iphoneAppId));
        params.add(new HttpParameter(PARAM_IPHONE_DEEP_LINK, iphoneDeepLink));
        params.add(new HttpParameter(PARAM_IPAD_APP_ID, ipadAppId));
        params.add(new HttpParameter(PARAM_IPAD_DEEP_LINK, ipadDeepLink));
        params.add(new HttpParameter(PARAM_GOOGLEPLAY_APP_ID, googlePlayAppId));
        params.add(new HttpParameter(PARAM_GOOGLEPLAY_DEEP_LINK, googlePlayDeepLink));

        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForCreateImageAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                     String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                     String iphoneDeepLink, String ipadDeepLink,
                                                                                     String googlePlayDeepLink, String mediaId, String callToAction)
            throws TwitterException {
        List<HttpParameter> params =
                getCardHttpParameters(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink, ipadDeepLink,
                        googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_WIDE_APP_IMAGE_MEDIA_ID, mediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }
        return params;

    }

    private List<HttpParameter> validateAndCreateParamsForUpdateImageAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                     String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                     String iphoneDeepLink, String ipadDeepLink,
                                                                                     String googlePlayDeepLink, String mediaId, String callToAction)
            throws TwitterException {
        List<HttpParameter> params =
                getCardHttpParametersForUpdate(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink, ipadDeepLink,
                        googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_WIDE_APP_IMAGE_MEDIA_ID, mediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }
        return params;

    }

    private List<HttpParameter> validateAndCreateParamsForCreateImageConversationCard(String accountId, String name, String title, String firstCta,
                                                                                      String firstCtaTweet, String secondCta, String secondCtaTweet,
                                                                                      String thanksText, String thanksUrl, String imageUrl)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(imageUrl, "Image");
        return validateAndCreateParamsForCreateConversationCard(accountId, name, title, firstCta, firstCtaTweet, secondCta, secondCtaTweet,
                thanksText, thanksUrl);
    }

    private List<HttpParameter> validateAndCreateParamsForCreateConversationCard(String accountId, String name, String title, String firstCta,
                                                                                 String firstCtaTweet, String secondCta, String secondCtaTweet,
                                                                                 String thanksText, String thanksUrl) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(name, "Name");
        TwitterAdUtil.ensureNotNull(firstCta, "First Cta Hashtag");
        TwitterAdUtil.ensureNotNull(firstCtaTweet, "First Cta Tweet");
        TwitterAdUtil.ensureNotNull(thanksText, "Thanks tweet text");

        if (TwitterAdUtil.isNotNullOrEmpty(title) && TwitterAdUtil.isNotNullOrEmpty(secondCta)) {
            throw new TwitterException(new UnsupportedOperationException("Card Title cannot be used with second hashtag"));
        }

        if (!TwitterAdUtil.isNotNullOrEmpty(title) && !TwitterAdUtil.isNotNullOrEmpty(secondCta)) {
            throw new TwitterException(new UnsupportedOperationException("Atleast one of card title or second hashtag is compulsory"));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(secondCta) && !TwitterAdUtil.isNotNullOrEmpty(secondCtaTweet)) {
            throw new TwitterException(new UnsupportedOperationException("Please provide tweet along with second hashtag"));
        }


        List<HttpParameter> params = new ArrayList<>();

        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_FIRST_CTA, firstCta));
        params.add(new HttpParameter(PARAM_FIRST_CTA_TWEET, firstCtaTweet));
        params.add(new HttpParameter(PARAM_THANK_YOU_TEXT, thanksText));

        if (TwitterAdUtil.isNotNull(title)) {
            params.add(new HttpParameter(PARAM_TITLE, title));
        }

        if (TwitterAdUtil.isNotNull(secondCta)) {
            params.add(new HttpParameter(PARAM_SECOND_CTA, secondCta));
        }

        if (TwitterAdUtil.isNotNull(secondCtaTweet)) {
            params.add(new HttpParameter(PARAM_SECOND_CTA_TWEET, secondCtaTweet));
        }

        if (TwitterAdUtil.isNotNull(thanksUrl)) {
            params.add(new HttpParameter(PARAM_THANK_YOU_URL, thanksUrl));
        }

        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForCreateVideoAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                     String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                     String iphoneDeepLink, String ipadDeepLink,
                                                                                     String googlePlayDeepLink, String posterMediaId,
                                                                                     String videoMediaId, String callToAction)
            throws TwitterException {

        List<HttpParameter> params =
                getCardHttpParameters(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink, ipadDeepLink,
                        googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(videoMediaId)) {
            params.add(new HttpParameter(PARAM_VIDEO_ID, videoMediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(posterMediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, posterMediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }

        return params;

    }

    private List<HttpParameter> validateAndCreateParamsForUpdateVideoAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                     String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                     String iphoneDeepLink, String ipadDeepLink,
                                                                                     String googlePlayDeepLink, String imageMediaId,
                                                                                     String videoMediaId, String callToAction)
            throws TwitterException {

        List<HttpParameter> params =
                getVideoCardHttpParametersForUpdate(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink,
                        ipadDeepLink, googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(imageMediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, imageMediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(videoMediaId)) {
            params.add(new HttpParameter(PARAM_VIDEO_ID, videoMediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }
        return params;

    }

    private List<HttpParameter> getVideoCardHttpParametersForUpdate(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                                    String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                    String ipadDeepLink, String googlePlayDeepLink) throws TwitterException {
        List<HttpParameter> params = Lists.newArrayList();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(appCountryCode, "App Country Code");
        TwitterAdUtil.ensureNotNull(name, "Name");
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_APP_COUNTRY_CODE, appCountryCode));

        // This is done in order to satisfy the condition: atleast one of the app ids is provided
        if (!(TwitterAdUtil.isNotNullOrEmpty(googlePlayAppId) || TwitterAdUtil.isNotNullOrEmpty(ipadAppId) ||
                TwitterAdUtil.isNotNullOrEmpty(iphoneAppId))) {
            throw new TwitterException(
                    new UnsupportedOperationException("Please provide atleast one valid store app id to create an app download card"));
        }

        if (TwitterAdUtil.isNotNull(iphoneAppId)) {
            params.add(new HttpParameter(PARAM_IPHONE_APP_ID, iphoneAppId));
            if (TwitterAdUtil.isNotNull(iphoneDeepLink)) {
                params.add(new HttpParameter(PARAM_IPHONE_DEEP_LINK, iphoneDeepLink));
            }
        }
        if (TwitterAdUtil.isNotNull(ipadAppId)) {
            params.add(new HttpParameter(PARAM_IPAD_APP_ID, ipadAppId));
            if (TwitterAdUtil.isNotNull(ipadDeepLink)) {
                params.add(new HttpParameter(PARAM_IPAD_DEEP_LINK, ipadDeepLink));
            }
        }
        if (TwitterAdUtil.isNotNull(googlePlayAppId)) {
            params.add(new HttpParameter(PARAM_GOOGLEPLAY_APP_ID, googlePlayAppId));
            if (TwitterAdUtil.isNotNull(googlePlayDeepLink)) {
                params.add(new HttpParameter(PARAM_GOOGLEPLAY_DEEP_LINK, googlePlayDeepLink));
            }
        }
        return params;
    }

    private void verifyCtaLength(String cta, String label) throws TwitterException {
        if (cta.length() > DM_CARD_CTA_LENGTH) {
            throw new TwitterException(
                    new UnsupportedOperationException(label + " cannot be more than " + DM_CARD_CTA_LENGTH + " characters"));
        }
    }
}
