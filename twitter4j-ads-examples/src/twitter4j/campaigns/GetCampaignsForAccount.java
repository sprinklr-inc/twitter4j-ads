package twitter4j.campaigns;

import com.google.common.collect.Lists;
import twitter4j.*;
import twitter4j.BaseAdsTest;
import twitter4j.api.TwitterAdsCampaignApi;
import twitter4j.models.ads.Campaign;

import java.util.List;

/**
 * User: abhishekanand
 * Date: 11/05/16 2:08 PM.
 */
public class GetCampaignsForAccount extends BaseAdsTest {

    public static void main(String[] args) {
        TwitterAds twitterAdsInstance = getTwitterAdsInstance();
        TwitterAdsCampaignApi campaignApi = twitterAdsInstance.getCampaignApi();
        List<Campaign> campaignList = Lists.newArrayList();
        try {
            // BaseAdsListResponseIterable<Campaign> allCampaigns = campaignApi.getAllCampaigns("18ce53uo3nm", null, null, false, null, null, null);
            BaseAdsListResponseIterable<Campaign> allCampaigns = campaignApi.getAllCampaigns("1b83s0", null, null, false, null, null, null);
            for (BaseAdsListResponse<Campaign> allCampaign : allCampaigns) {
                campaignList.addAll(allCampaign.getData());
            }
            System.out.println(campaignList.size());
        } catch (TwitterException e) {
            System.err.println(e.getErrorMessage());
        }
    }
}
