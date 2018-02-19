package twitter4jads.campaigns;

import com.google.common.collect.Lists;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsTest;
import twitter4jads.TwitterAds;
import twitter4jads.api.TwitterAdsCampaignApi;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.Campaign;

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
