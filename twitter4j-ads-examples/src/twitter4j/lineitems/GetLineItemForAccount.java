package twitter4j.lineitems;

import com.google.common.collect.Lists;
import twitter4j.BaseAdsListResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsTest;
import twitter4j.TwitterAds;
import twitter4j.api.TwitterAdsLineItemApi;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.ads.LineItem;

import java.util.List;

/**
 * User: shivraj
 * Date: 12/05/16 2:08 PM.
 */
public class GetLineItemForAccount extends BaseAdsTest {

    public static void main(String[] args) {
        TwitterAds twitterAdsInstance = getTwitterAdsInstance();
        TwitterAdsLineItemApi lineItemApi = twitterAdsInstance.getLineItemApi();
        List<LineItem> lineItemList = Lists.newArrayList();
        try {
            BaseAdsListResponseIterable<LineItem> allLineItems = lineItemApi.getAllLineItems("18ce53uo3nm", null, null, null, null, false, null, null);
            for (BaseAdsListResponse<LineItem> allLineItem : allLineItems) {
                lineItemList.addAll(allLineItem.getData());
            }
            System.out.println(lineItemList.size());
        } catch (TwitterException e) {
            System.err.println(e.getErrorMessage());
        }
    }
}