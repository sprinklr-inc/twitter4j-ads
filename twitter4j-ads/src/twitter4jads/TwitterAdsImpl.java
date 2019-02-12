package twitter4jads;

import twitter4jads.api.TwitterAdsAccountApi;
import twitter4jads.api.TwitterAdsAudienceApi;
import twitter4jads.api.TwitterAdsBiddingApi;
import twitter4jads.api.TwitterAdsCampaignApi;
import twitter4jads.api.TwitterAdsCardsApi;
import twitter4jads.api.TwitterAdsFundingInstrumentApi;
import twitter4jads.api.TwitterAdsLineItemApi;
import twitter4jads.api.TwitterAdsMediaApi;
import twitter4jads.api.TwitterAdsMediaUploadApi;
import twitter4jads.api.TwitterAdsPreviewApi;
import twitter4jads.api.TwitterAdsPromotedTweetApi;
import twitter4jads.api.TwitterAdsStatApi;
import twitter4jads.api.TwitterAdsTargetingApi;
import twitter4jads.api.TwitterAdsWebEventApi;
import twitter4jads.api.TwitterCallToActionApi;
import twitter4jads.api.TwitterScheduledTweetApi;
import twitter4jads.auth.Authorization;
import twitter4jads.conf.Configuration;
import twitter4jads.impl.TwitterAdsAccountApiImpl;
import twitter4jads.impl.TwitterAdsAudienceApiImpl;
import twitter4jads.impl.TwitterAdsBiddingApiImpl;
import twitter4jads.impl.TwitterAdsCampaignApiImpl;
import twitter4jads.impl.TwitterAdsCardsApiImpl;
import twitter4jads.impl.TwitterAdsFundingInstrumentApiImpl;
import twitter4jads.impl.TwitterAdsLineItemApiImpl;
import twitter4jads.impl.TwitterAdsMediaApiImpl;
import twitter4jads.impl.TwitterAdsMediaUploadApiImpl;
import twitter4jads.impl.TwitterAdsPreviewApiImpl;
import twitter4jads.impl.TwitterAdsPromotedTweetApiImpl;
import twitter4jads.impl.TwitterAdsStatApiImpl;
import twitter4jads.impl.TwitterAdsTargetingApiImpl;
import twitter4jads.impl.TwitterAdsWebEventApiImpl;
import twitter4jads.impl.TwitterCallToActionApiImpl;
import twitter4jads.impl.TwitterScheduledTweetsApiImpl;

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
    private final TwitterAdsMediaApi promotedApi;
    private final TwitterAdsPromotedTweetApi promotedTweetApi;
    private final TwitterAdsAudienceApi tailoredAudienceApi;
    private final TwitterAdsStatApi statApi;
    private final TwitterAdsMediaUploadApi mediaUploadApi;
    private final TwitterAdsWebEventApi webEventApi;
    private final TwitterAdsCampaignApi campaignApi;
    private final TwitterAdsBiddingApi biddingApi;
    private final TwitterAdsPreviewApi adsPreviewApi;
    private final TwitterCallToActionApi callToActionApi;
    private final TwitterScheduledTweetApi scheduledTweetApi;

    TwitterAdsImpl(Configuration conf, Authorization auth) {
        this.twitterAdsClient = new TwitterAdsClient(conf, auth);
        this.targetingApi = new TwitterAdsTargetingApiImpl(twitterAdsClient);
        this.accountApi = new TwitterAdsAccountApiImpl(twitterAdsClient);
        this.lineItemApi = new TwitterAdsLineItemApiImpl(twitterAdsClient);
        this.cardsApi = new TwitterAdsCardsApiImpl(twitterAdsClient);
        this.fundingInstrumentApi = new TwitterAdsFundingInstrumentApiImpl(twitterAdsClient);
        this.promotedApi = new TwitterAdsMediaApiImpl(twitterAdsClient);
        this.tailoredAudienceApi = new TwitterAdsAudienceApiImpl(twitterAdsClient);
        this.statApi = new TwitterAdsStatApiImpl(twitterAdsClient);
        this.mediaUploadApi = new TwitterAdsMediaUploadApiImpl(twitterAdsClient);
        this.webEventApi = new TwitterAdsWebEventApiImpl(twitterAdsClient);
        this.campaignApi = new TwitterAdsCampaignApiImpl(twitterAdsClient);
        this.promotedTweetApi = new TwitterAdsPromotedTweetApiImpl(twitterAdsClient);
        this.biddingApi = new TwitterAdsBiddingApiImpl(twitterAdsClient);
        this.adsPreviewApi = new TwitterAdsPreviewApiImpl(twitterAdsClient);
        this.callToActionApi = new TwitterCallToActionApiImpl(twitterAdsClient);
        this.scheduledTweetApi = new TwitterScheduledTweetsApiImpl(twitterAdsClient);
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
    public TwitterAdsMediaApi getPromotedApi() {
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

    @Override
    public TwitterScheduledTweetApi getScheduledTweetApi() {
        return scheduledTweetApi;
    }

    public TwitterAdsMediaUploadApi getMediaUploadApi() {
        return mediaUploadApi;
    }
}
