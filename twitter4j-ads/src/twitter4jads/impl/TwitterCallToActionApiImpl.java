package twitter4jads.impl;

import com.google.gson.reflect.TypeToken;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.TwitterAdsClient;
import twitter4jads.TwitterAdsConstants;
import twitter4jads.api.TwitterCallToActionApi;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.http.HttpResponse;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.media.TwitterMediaCallToAction;
import twitter4jads.models.video.TwitterCallToActionType;
import twitter4jads.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static twitter4jads.TwitterAdsConstants.PARAM_CALL_TO_ACTION;
import static twitter4jads.TwitterAdsConstants.PARAM_CALL_TO_ACTION_URL;
import static twitter4jads.TwitterAdsConstants.PARAM_LINE_ITEM_ID;
import static twitter4jads.TwitterAdsConstants.PARAM_WITH_DELETED;
import static twitter4jads.TwitterAdsConstants.PREFIX_ACCOUNTS_URI_4;
import static twitter4jads.TwitterAdsConstants.PRE_ROLL_CALL_TO_ACTION;

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
    public BaseAdsResponse<TwitterMediaCallToAction> create(String accountId, String lineItemId, TwitterCallToActionType twitterCallToActionType,
                                                            String callToActionUrl) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");
        TwitterAdUtil.ensureNotNull(callToActionUrl, "Call To Action Url");
        TwitterAdUtil.ensureNotNull(twitterCallToActionType, "Call To Action Type");

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        params.add(new HttpParameter(PARAM_CALL_TO_ACTION, twitterCallToActionType.name()));
        params.add(new HttpParameter(PARAM_CALL_TO_ACTION_URL, callToActionUrl));

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PRE_ROLL_CALL_TO_ACTION;
        final HttpResponse httpResponse = twitterAdsClient.postRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            final Type type = new TypeToken<BaseAdsResponse<TwitterMediaCallToAction>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse call to action response.");
        }
    }

    @Override
    public BaseAdsResponse<TwitterMediaCallToAction> update(String accountId, String preRollCTAId, TwitterCallToActionType twitterCallToActionType,
                                                              String callToActionUrl) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(preRollCTAId, "Pre Roll Call To Action Id");

        final List<HttpParameter> params = new ArrayList<>();
        if (twitterCallToActionType != null) {
            params.add(new HttpParameter(PARAM_CALL_TO_ACTION, twitterCallToActionType.name()));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(callToActionUrl)) {
            params.add(new HttpParameter(PARAM_CALL_TO_ACTION_URL, callToActionUrl));
        }

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PRE_ROLL_CALL_TO_ACTION + "/" + preRollCTAId;
        final HttpResponse httpResponse = twitterAdsClient.putRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            final Type type = new TypeToken<BaseAdsResponse<TwitterMediaCallToAction>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse call to action response.");
        }
    }

    @Override
    public BaseAdsListResponseIterable<TwitterMediaCallToAction> getByLineItemId(String accountId, String lineItemId, Boolean withDeleted)
        throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        if (withDeleted != null) {
            params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        }

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + TwitterAdsConstants.PREFIX_ACCOUNTS_URI_4 + accountId + PRE_ROLL_CALL_TO_ACTION;
        Type type = new TypeToken<BaseAdsListResponseIterable<TwitterMediaCallToAction>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterMediaCallToAction> getById(String accountId, String callToActionId, Boolean withDeleted)
        throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(callToActionId, "Pre Roll Call To Action Id");

        final List<HttpParameter> params = new ArrayList<>();
        if (withDeleted != null) {
            params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        }

        final String baseUrl =
                twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PRE_ROLL_CALL_TO_ACTION + "/" + callToActionId;
        final HttpResponse httpResponse = twitterAdsClient.putRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            final Type type = new TypeToken<BaseAdsResponse<TwitterMediaCallToAction>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse call to action response.");
        }
    }

    @Override
    public BaseAdsResponse<TwitterMediaCallToAction> delete(String accountId, String callToActionId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(callToActionId, "Pre Roll Call To Action Id");

        final String baseUrl =
                twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PRE_ROLL_CALL_TO_ACTION + "/" + callToActionId;
        final Type type = new TypeToken<BaseAdsResponse<TwitterMediaCallToAction>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }
}
