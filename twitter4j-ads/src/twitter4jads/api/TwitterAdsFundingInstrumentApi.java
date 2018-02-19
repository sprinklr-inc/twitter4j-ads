package twitter4jads.api;

import com.google.common.base.Optional;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.FundingInstrument;
import twitter4jads.models.ads.sort.FundingInstrumentSortByField;

import java.util.Collection;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:36 AM
 */
public interface TwitterAdsFundingInstrumentApi {

    /**
     * @param accountId            The identifier for the leveraged account.
     * @param withDeleted          Include deleted results in your request. Defaults to false.
     * @param fundingInstrumentIds (optional) Scope the response to just the desired funding instruments by specifying a Collection of identifiers. Up to 50 ids may be provided.
     * @param sortByField          (optional) Sorts by supported attribute in ascending or descending order.
     * @return Retrieve some or all funding instruments associated with the account.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/funding_instruments">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/funding_instruments</a>
     */
    BaseAdsListResponseIterable<FundingInstrument> getAllFundingInstruments(String accountId,boolean withDeleted, Optional<Collection<String>> fundingInstrumentIds,
                                                                            Optional<FundingInstrumentSortByField> sortByField) throws TwitterException;

    /**
     * @param accountId           The identifier for the leveraged account.
     * @param fundingInstrumentId The identifier for a funding instrument associated with the current account.
     * @param withDeleted         Include deleted results in your request. Defaults to false.
     * @return Retrieve a specific funding instrument associated with the account.
     * @throws TwitterException
     * @see <a href="https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/funding_instruments/%3Aid">https://dev.twitter.com/ads/reference/get/accounts/%3Aaccount_id/funding_instruments/%3Aid</a>
     */
    BaseAdsResponse<FundingInstrument> getFundingInstrumentById(String accountId, String fundingInstrumentId, boolean withDeleted)
            throws TwitterException;
}
