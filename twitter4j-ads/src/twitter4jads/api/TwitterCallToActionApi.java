package twitter4jads.api;

import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.media.TwitterMediaCallToAction;
import twitter4jads.models.video.TwitterCallToActionType;

import java.util.Collection;

/**
 * User: abhishekanand
 * Date: 30/05/16 5:17 PM.
 */
public interface TwitterCallToActionApi {


    BaseAdsResponse<TwitterMediaCallToAction> create(String accountId, String lineItemId, TwitterCallToActionType twitterCallToActionType,
                                                     String callToActionUrl) throws TwitterException;


    BaseAdsResponse<TwitterMediaCallToAction> update(String accountId, String preRollCTAId, TwitterCallToActionType twitterCallToActionType,
                                                       String callToActionUrl) throws TwitterException;

    @Deprecated
    BaseAdsListResponseIterable<TwitterMediaCallToAction> getByLineItemId(String accountId, String lineItemId, Boolean withDeleted)
            throws TwitterException;

    BaseAdsListResponseIterable<TwitterMediaCallToAction> getByLineItemId(String accountId, Collection<String> lineItemIds, Boolean withDeleted)
            throws TwitterException;

    BaseAdsResponse<TwitterMediaCallToAction> getById(String accountId, String callToActionId, Boolean withDeleted) throws TwitterException;


    BaseAdsResponse<TwitterMediaCallToAction> delete(String accountId, String callToActionId) throws TwitterException;


}
