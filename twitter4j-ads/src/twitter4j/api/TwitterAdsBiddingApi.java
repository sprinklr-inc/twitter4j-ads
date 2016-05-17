package twitter4j.api;

import com.google.common.base.Optional;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.TwitterException;
import twitter4j.models.ads.BiddingRules;
import twitter4j.models.ads.TwitterBidInfo;

/**
 * User: prashant
 * Date: 22/04/16.
 * Time: 2:49 PM
 */
public interface TwitterAdsBiddingApi {
    /**
     * @param currency The type of a currency to filter results by, identified using ISO-4217
     * @return Retrieve the bidding rules for a specific or all currencies.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<BiddingRules> getBiddingRules(String currency) throws TwitterException;

    TwitterBidInfo getBidInfo(String accountId, String campaignType, Optional<String> currency, Optional<String> objectiveForBidding) throws TwitterException;

}
