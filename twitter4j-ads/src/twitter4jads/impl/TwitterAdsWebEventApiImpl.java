package twitter4jads.impl;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.TwitterAdsClient;
import twitter4jads.api.TwitterAdsWebEventApi;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.ads.TwitterWebsiteTag;
import twitter4jads.models.ads.TwitterWebsiteTag.WebsiteTagType;
import twitter4jads.models.ads.tags.WebEventTag;
import twitter4jads.models.ads.tags.WebEventTagType;
import twitter4jads.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.util.List;

import static twitter4jads.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/7/16
 * Time: 12:16 PM
 */
public class TwitterAdsWebEventApiImpl implements TwitterAdsWebEventApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsWebEventApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public BaseAdsListResponseIterable<WebEventTag> getAllWebEventTags(String accountId, boolean withDeleted, Integer count, String cursor)
        throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");

        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_WEB_EVENT_TAGS;
        Type type = new TypeToken<BaseAdsListResponse<WebEventTag>>() {}.getType();

        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<WebEventTag> getWebEventTag(String accountId, boolean withDeleted, String webEventTagId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(webEventTagId, "Web Event Tag Id");
        HttpParameter[] params = new HttpParameter[]{new HttpParameter(PARAM_WITH_DELETED, withDeleted)};
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_WEB_EVENT_TAGS + webEventTagId;
        Type type = new TypeToken<BaseAdsResponse<WebEventTag>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, params, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<WebEventTag> createWebEventTag(String accountId, String name, Integer clickWindow, Integer viewThroughWindow,
                                                          WebEventTagType type, boolean retargetingEnabled) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");

        List<HttpParameter> params = validateAndCreateParamsForCreateWebEventTag(name, clickWindow, viewThroughWindow, type, retargetingEnabled);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_WEB_EVENT_TAGS;
        Type typeToken = new TypeToken<BaseAdsResponse<WebEventTag>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, params.toArray(new HttpParameter[params.size()]), typeToken, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<WebEventTag> updateWebEventTag(String accountId, String webEventTagId, String name, Integer clickWindow,
                                                          Integer viewThroughWindow, WebEventTagType type, boolean retargetingEnabled)
        throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(webEventTagId, "Web Event Tag Id");
        List<HttpParameter> params = validateAndCreateParamsForUpdateWebEventTag(name, clickWindow, viewThroughWindow, type, retargetingEnabled);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_WEB_EVENT_TAGS + webEventTagId;
        Type typeToken = new TypeToken<BaseAdsResponse<WebEventTag>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, params.toArray(new HttpParameter[params.size()]), typeToken, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<WebEventTag> deleteWebEventTag(String accountId, String webEventTagId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(webEventTagId, "Web Event Tag Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_WEB_EVENT_TAGS + webEventTagId;
        Type typeToken = new TypeToken<BaseAdsResponse<WebEventTag>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, null, typeToken, HttpVerb.DELETE);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public BaseAdsListResponseIterable<TwitterWebsiteTag> getAllWebsiteTags(String accountId, boolean withDeleted, Integer count, String cursor)
        throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");

        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_3 + accountId + PATH_WEBSITE_TAGS;
        final Type type = new TypeToken<BaseAdsListResponse<TwitterWebsiteTag>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteTag> getWebsiteTag(String accountId, boolean withDeleted, String websiteTagId) throws TwitterException {
        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_3 + accountId + PATH_WEBSITE_TAGS + websiteTagId;
        final Type type = new TypeToken<BaseAdsResponse<TwitterWebsiteTag>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteTag> createWebsiteTag(String accountId, WebsiteTagType websiteTagType) throws TwitterException {
        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_3 + accountId + PATH_WEBSITE_TAGS;
        final Type type = new TypeToken<BaseAdsResponse<TwitterWebsiteTag>>() {
        }.getType();

        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(TAG_TYPE, websiteTagType.name()));
        return twitterAdsClient.executeHttpRequest(url, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    // -------------------------------------------------------------- PRIVATE METHODS -------------------------------------------------------------

    private List<HttpParameter> validateAndCreateParamsForCreateWebEventTag(String name, Integer clickWindow, Integer viewThroughWindow,
                                                                            WebEventTagType type, boolean retargetingEnabled) {
        TwitterAdUtil.ensureNotNull(name, "Name");
        TwitterAdUtil.ensureNotNull(clickWindow, "Click Window");
        TwitterAdUtil.ensureNotNull(type, "Web Event Tag type");
        TwitterAdUtil.ensureNotNull(retargetingEnabled, "Retargeting");

        final List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_CLICK_WINDOW, clickWindow));
        if (viewThroughWindow == null) {
            params.add(new HttpParameter(PARAM_VIEW_THROUGH_WINDOW, 0));
        } else {
            params.add(new HttpParameter(PARAM_VIEW_THROUGH_WINDOW, viewThroughWindow));
        }
        params.add(new HttpParameter(PARAM_TYPE, type.name()));
        params.add(new HttpParameter(PARAM_RETARGETING_ENABLED, retargetingEnabled));

        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForUpdateWebEventTag(String name, Integer clickWindow, Integer viewThroughWindow,
                                                                            WebEventTagType type, boolean retargetingEnabled) {
        final List<HttpParameter> params = Lists.newArrayList();
        if (TwitterAdUtil.isNotNullOrEmpty(name)) {
            params.add(new HttpParameter(PARAM_NAME, name));
        }
        if (TwitterAdUtil.isNotNull(type)) {
            params.add(new HttpParameter(PARAM_TYPE, type.name()));
        }

        if (TwitterAdUtil.isNotNull(clickWindow)) {
            params.add(new HttpParameter(PARAM_CLICK_WINDOW, clickWindow));
        }
        if (TwitterAdUtil.isNotNull(viewThroughWindow)) {
            params.add(new HttpParameter(PARAM_VIEW_THROUGH_WINDOW, viewThroughWindow));
        }
        params.add(new HttpParameter(PARAM_RETARGETING_ENABLED, retargetingEnabled));
        return params;
    }
}
