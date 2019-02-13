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

    TwitterAdsMediaApi getPromotedApi();

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