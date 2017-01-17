package twitter4j.impl;

import com.google.gson.reflect.TypeToken;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterAdsClient;
import twitter4j.api.TwitterCallToActionApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.video.TwitterCallToActionType;
import twitter4j.models.video.TwitterPreRollCallToAction;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhishekanand
 * Date: 30/05/16 5:22 PM.
 */
public class TwitterCallToActionApiImpl implements TwitterCallToActionApi {
    private final TwitterAdsClient twitterAdsClient;

    public TwitterCallToActionApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }


    @Override
    public BaseAdsResponse<TwitterPreRollCallToAction> create(String accountId, String lineItemId, TwitterCallToActionType twitterCallToActionType,
                                                              String callToActionUrl) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");
        TwitterAdUtil.ensureNotNull(callToActionUrl, "Call To Action Url");
        TwitterAdUtil.ensureNotNull(twitterCallToActionType, "Call To Action Type");

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        params.add(new HttpParameter(PARAM_CALL_TO_ACTION, twitterCallToActionType.name()));
        params.add(new HttpParameter(PARAM_CALL_TO_ACTION_URL, callToActionUrl));

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PRE_ROLL_CALL_TO_ACTION;
        HttpResponse httpResponse = twitterAdsClient.postRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsResponse<TwitterPreRollCallToAction>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse call to action response.");
        }
    }

    @Override
    public BaseAdsResponse<TwitterPreRollCallToAction> update(String accountId, String preRollCTAId, TwitterCallToActionType twitterCallToActionType,
                                                              String callToActionUrl) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(preRollCTAId, "Pre Roll Call To Action Id");

        List<HttpParameter> params = new ArrayList<>();
        if (twitterCallToActionType != null) {
            params.add(new HttpParameter(PARAM_CALL_TO_ACTION, twitterCallToActionType.name()));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(callToActionUrl)) {
            params.add(new HttpParameter(PARAM_CALL_TO_ACTION_URL, callToActionUrl));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PRE_ROLL_CALL_TO_ACTION + "/" + preRollCTAId;
        HttpResponse httpResponse = twitterAdsClient.putRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsResponse<TwitterPreRollCallToAction>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse call to action response.");
        }
    }

    @Override
    public BaseAdsListResponseIterable<TwitterPreRollCallToAction> getByLineItemId(String accountId, String lineItemId, Boolean withDeleted)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        if (withDeleted != null) {
            params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        }

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PRE_ROLL_CALL_TO_ACTION;
        Type type = new TypeToken<BaseAdsListResponseIterable<TwitterPreRollCallToAction>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterPreRollCallToAction> getById(String accountId, String callToActionId, Boolean withDeleted)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(callToActionId, "Pre Roll Call To Action Id");

        List<HttpParameter> params = new ArrayList<>();
        if (withDeleted != null) {
            params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PRE_ROLL_CALL_TO_ACTION + "/" + callToActionId;
        HttpResponse httpResponse = twitterAdsClient.putRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsResponse<TwitterPreRollCallToAction>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse call to action response.");
        }
    }

    @Override
    public BaseAdsResponse<TwitterPreRollCallToAction> delete(String accountId, String callToActionId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(callToActionId, "Pre Roll Call To Action Id");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PRE_ROLL_CALL_TO_ACTION + "/" + callToActionId;
        Type type = new TypeToken<BaseAdsResponse<TwitterPreRollCallToAction>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

}
