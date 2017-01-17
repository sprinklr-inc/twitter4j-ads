package twitter4j.api;

import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.video.TwitterCallToActionType;
import twitter4j.models.video.TwitterPreRollCallToAction;

/**
 * User: abhishekanand
 * Date: 30/05/16 5:17 PM.
 */
public interface TwitterCallToActionApi {


    BaseAdsResponse<TwitterPreRollCallToAction> create(String accountId, String lineItemId, TwitterCallToActionType twitterCallToActionType,
                                                       String callToActionUrl) throws TwitterException;


    BaseAdsResponse<TwitterPreRollCallToAction> update(String accountId, String preRollCTAId, TwitterCallToActionType twitterCallToActionType,
                                                       String callToActionUrl) throws TwitterException;


    BaseAdsListResponseIterable<TwitterPreRollCallToAction> getByLineItemId(String accountId, String lineItemId, Boolean withDeleted) throws TwitterException;

    BaseAdsResponse<TwitterPreRollCallToAction> getById(String accountId, String callToActionId, Boolean withDeleted) throws TwitterException;



    BaseAdsResponse<TwitterPreRollCallToAction> delete(String accountId, String callToActionId) throws TwitterException;




}
