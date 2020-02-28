package twitter4jads.lineitems;

import com.google.api.client.util.Lists;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsTest;
import twitter4jads.TwitterAds;
import twitter4jads.api.TwitterAdsLineItemApi;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.LineItem;
import twitter4jads.models.ads.sort.LineItemsSortByField;

import java.util.List;
import java.util.Optional;

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
            BaseAdsListResponseIterable<LineItem> allLineItems = lineItemApi.getAllLineItems("18ce53uo3nm", null, null, null, null, false, null, Optional.of(LineItemsSortByField.BID_AMOUNT_LOCAL_MICRO), null);
            for (BaseAdsListResponse<LineItem> allLineItem : allLineItems) {
                lineItemList.addAll(allLineItem.getData());
            }
            System.out.println(lineItemList.size());
        } catch (TwitterException e) {
            System.err.println(e.getErrorMessage());
        }

    }


}