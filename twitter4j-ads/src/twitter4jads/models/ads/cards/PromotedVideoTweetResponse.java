package twitter4jads.models.ads.cards;

import twitter4jads.BaseAdsResponse;

/**
 * User: prashant
 * Date: 26/11/15
 */
public class PromotedVideoTweetResponse extends BaseAdsResponse<Object> {
    public Object getStatusJSON() {
        return getData();
    }
}
