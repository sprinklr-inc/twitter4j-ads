package twitter4jads;

import twitter4jads.api.*;

/**
 * User: poly
 * Date: 29/01/14.
 * Time: 8:08 PM
 */
public interface TwitterAds extends java.io.Serializable {

    TwitterAdsCampaignApi getCampaignApi();

    TwitterAdsCardsApi getCardsApi();

    TwitterAdsFundingInstrumentApi getFundingInstrumentApi();

    TwitterAdsLineItemApi getLineItemApi();

    TwitterAdsVideoApi getPromotedApi();

    TwitterAdsStatApi getStatApi();

    TwitterAdsAudienceApi getTailoredAudienceApi();

    TwitterAdsTargetingApi getTargetingApi();

    TwitterAdsWebEventApi getWebEventApi();

    TwitterAdsAccountApi getAccountApi();

    TwitterAdsPromotedTweetApi getPromotedTweetApi();

    TwitterAdsBiddingApi getBiddingApi();

    TwitterAdsClient getTwitterAdsClient();

    TwitterCallToActionApi getCallToActionApi();

    TwitterAdsPreviewApi getPreviewApi();

    TwitterScheduledTweetApi getScheduledTweetApi();

    TwitterAdsMediaUploadApi getMediaUploadApi();
}