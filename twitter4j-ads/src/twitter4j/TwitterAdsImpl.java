package twitter4j;

import twitter4j.api.*;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;
import twitter4j.impl.*;

/**
 * User: poly
 * Date: 29/01/14
 * Time: 11:55 AM
 */
public class TwitterAdsImpl implements TwitterAds {

    private final TwitterAdsClient twitterAdsClient;
    private final TwitterAdsTargetingApi targetingApi;
    private final TwitterAdsAccountApi accountApi;
    private final TwitterAdsLineItemApi lineItemApi;
    private final TwitterAdsCardsApi cardsApi;
    private final TwitterAdsFundingInstrumentApi fundingInstrumentApi;
    private final TwitterAdsVideoApi promotedApi;
    private final TwitterAdsPromotedTweetApi promotedTweetApi;
    private final TwitterAdsAudienceApi tailoredAudienceApi;
    private final TwitterAdsStatApi statApi;
    private final TwitterAdsWebEventApi webEventApi;
    private final TwitterAdsCampaignApi campaignApi;
    private final TwitterAdsBiddingApi biddingApi;
    private final TwitterAdsPreviewApi adsPreviewApi;
    private final TwitterCallToActionApi callToActionApi;

    TwitterAdsImpl(Configuration conf, Authorization auth) {
        this.twitterAdsClient = new TwitterAdsClient(conf, auth);
        this.targetingApi = new TwitterAdsTargetingApiImpl(twitterAdsClient);
        this.accountApi = new TwitterAdsAccountApiImpl(twitterAdsClient);
        this.lineItemApi = new TwitterAdsLineItemApiImpl(twitterAdsClient);
        this.cardsApi = new TwitterAdsCardsApiImpl(twitterAdsClient);
        this.fundingInstrumentApi = new TwitterAdsFundingInstrumentApiImpl(twitterAdsClient);
        this.promotedApi = new TwitterAdsVideoApiImpl(twitterAdsClient);
        this.tailoredAudienceApi = new TwitterAdsAudienceApiImpl(twitterAdsClient);
        this.statApi = new TwitterAdsStatApiImpl(twitterAdsClient);
        this.webEventApi = new TwitterAdsWebEventApiImpl(twitterAdsClient);
        this.campaignApi = new TwitterAdsCampaignApiImpl(twitterAdsClient);
        this.promotedTweetApi = new TwitterAdsPromotedTweetApiImpl(twitterAdsClient);
        this.biddingApi = new TwitterAdsBiddingApiImpl(twitterAdsClient);
        this.adsPreviewApi = new TwitterAdsPreviewApiImpl(twitterAdsClient);
        this.callToActionApi = new TwitterCallToActionApiImpl(twitterAdsClient);
    }

    @Override
    public TwitterAdsClient getTwitterAdsClient() {
        return twitterAdsClient;
    }

    @Override
    public TwitterAdsPreviewApi getPreviewApi() {
        return adsPreviewApi;
    }

    @Override
    public TwitterCallToActionApi getCallToActionApi() {
        return callToActionApi;
    }

    @Override
    public TwitterAdsCampaignApi getCampaignApi() {
        return campaignApi;
    }

    @Override
    public TwitterAdsCardsApi getCardsApi() {
        return cardsApi;
    }

    @Override
    public TwitterAdsFundingInstrumentApi getFundingInstrumentApi() {
        return fundingInstrumentApi;
    }

    @Override
    public TwitterAdsLineItemApi getLineItemApi() {
        return lineItemApi;
    }

    @Override
    public TwitterAdsVideoApi getPromotedApi() {
        return promotedApi;
    }

    @Override
    public TwitterAdsStatApi getStatApi() {
        return statApi;
    }

    @Override
    public TwitterAdsAudienceApi getTailoredAudienceApi() {
        return tailoredAudienceApi;
    }

    @Override
    public TwitterAdsTargetingApi getTargetingApi() {
        return targetingApi;
    }

    @Override
    public TwitterAdsWebEventApi getWebEventApi() {
        return webEventApi;
    }

    @Override
    public TwitterAdsAccountApi getAccountApi() {
        return accountApi;
    }

    @Override
    public TwitterAdsPromotedTweetApi getPromotedTweetApi() {
        return promotedTweetApi;
    }

    @Override
    public TwitterAdsBiddingApi getBiddingApi() {
        return biddingApi;
    }
}
