package examples.campaign;

import com.google.common.collect.Lists;
import examples.BaseAdsTest;
import twitter4j.BaseAdsListResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.TwitterAds;
import twitter4j.TwitterException;
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
            BaseAdsListResponseIterable<Campaign> allCampaigns = campaignApi.getAllCampaigns("18ce53uo3nm", null, null, false, null, null, null);
            for (BaseAdsListResponse<Campaign> allCampaign : allCampaigns) {
                campaignList.addAll(allCampaign.getData());
            }
            System.out.println(campaignList);
        } catch (TwitterException e) {
            System.err.println(e.getErrorMessage());
        }
    }
}
