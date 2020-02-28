package twitter4jads.impl;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.TwitterAdsClient;
import twitter4jads.api.TwitterAdsMediaApi;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.media.*;
import twitter4jads.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static twitter4jads.TwitterAdsConstants.*;

/**
 * User: abhishekanand
 * Date: 16/05/16 12:25 PM.
 */
public class TwitterAdsMediaApiImpl implements TwitterAdsMediaApi {


    public static final int TWITTER_MAX_LIBRARY_GET_COUNT = 50;
    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsMediaApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<TwitterAccountMedia> getAccountMediaForAccount(String accountId, String sortBy) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_ACCOUNT_MEDIA;
        final List<HttpParameter> parameters = Lists.newArrayList();
        parameters.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));
        if (StringUtils.isNotBlank(sortBy)) {
            parameters.add(new HttpParameter(PARAM_SORT_BY, sortBy));
        }

        final Type type = new TypeToken<BaseAdsListResponse<TwitterAccountMedia>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, parameters, type);
    }

    @Override
    public BaseAdsResponse<TwitterAccountMedia> getAccountMediaById(String accountId, String accountMediaId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);
        TwitterAdUtil.ensureNotNull(accountMediaId, "Account Media Id");

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_ACCOUNT_MEDIA + "/" + accountMediaId;
        final Type type = new TypeToken<BaseAdsResponse<TwitterAccountMedia>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterAccountMediaCreative> getMediaCreativesForAccount(String accountId, Boolean fetchDeleted)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_MEDIA_CREATIVES;
        final List<HttpParameter> parameters = Lists.newArrayList();
        parameters.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));
        if (fetchDeleted != null) {
            parameters.add(new HttpParameter(PARAM_WITH_DELETED, fetchDeleted));
        }

        final Type type = new TypeToken<BaseAdsListResponse<TwitterAccountMediaCreative>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, parameters, type);
    }

    @Override
    public BaseAdsResponse<TwitterLibraryMedia> getMediaCreativeByKeyFromLibrary(String accountId, String mediaKey) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);
        TwitterAdUtil.ensureNotNull(mediaKey, "Media Key");

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_MEDIA_LIBRARY + "/" + mediaKey;
        final Type type = new TypeToken<BaseAdsResponse<TwitterLibraryMedia>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterLibraryMedia> getMediaFromLibraryForAccount(String accountId, Integer count, String cursor,
                                                                                          TwitterMediaLibraryType mediaType, String q)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_MEDIA_LIBRARY;
        final List<HttpParameter> parameters = Lists.newArrayList();
        parameters.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));
        if (StringUtils.isNotBlank(cursor)) {
            parameters.add(new HttpParameter(PARAM_CURSOR, cursor));
        }
        if (mediaType != null) {
            parameters.add(new HttpParameter(PARAM_MEDIA_TYPE, mediaType.name()));
        }
        if (count == null) {
            parameters.add(new HttpParameter(PARAM_COUNT, 50));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(q)) {
            parameters.add(new HttpParameter(PARAM_Q, q));
        }

        final Type type = new TypeToken<BaseAdsListResponse<TwitterLibraryMedia>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, parameters, type);
    }


    @Override
    public BaseAdsResponse<TwitterAccountMediaCreative> deleteMediaCreative(String accountId, String mediaKey) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);
        TwitterAdUtil.ensureNotNull(mediaKey, "Media Id");

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_MEDIA_CREATIVES + "/" + mediaKey;
        final Type type = new TypeToken<BaseAdsResponse<TwitterAccountMediaCreative>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterAccountMediaCreative> createAccountMediaCreative(String accountId, String lineItemId, String accountMediaId,
                                                                                   String landingUrl) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");
        TwitterAdUtil.ensureNotNull(accountMediaId, "Account Media Id");

        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_ACCOUNT_MEDIA_ID, accountMediaId));
        params.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        if (StringUtils.isNotBlank(landingUrl)) {
            params.add(new HttpParameter(PARAM_LANDING_URL, landingUrl));
        }

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_MEDIA_CREATIVES;
        final Type type = new TypeToken<BaseAdsResponse<TwitterAccountMediaCreative>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public TwitterLibraryMedia createAndGetLibraryMedia(String accountId, String mediaKey, TwitterMediaLibraryCategory mediaCategory, String name,
                                                        String title, String description, String posterImageMediaId, String fileName)
            throws TwitterException {
        BaseAdsResponse<TwitterLibraryMedia> channelResponse =
                associateMediaToLibrary(accountId, mediaKey, mediaCategory, name, title, description, posterImageMediaId, fileName);
        if (channelResponse.getData() == null) {
            throw new TwitterException("Could not associate media to library, please retry");
        }

        final TwitterLibraryMedia video = channelResponse.getData();
        return twitterAdsClient.waitForMediaProcessing(accountId, video.getMediaKey(), TimeUnit.MINUTES.toMillis(10));
    }

    @Override
    public BaseAdsResponse<TwitterLibraryMedia> updateLibraryMediaByKey(String accountId, String mediaKey, String name, String title,
                                                                        String description, String posterMediaKey, String fileName)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);
        TwitterAdUtil.ensureNotNull(mediaKey, "Video Media Key");
        final List<HttpParameter> params = Lists.newArrayList();

        if (TwitterAdUtil.isNotNullOrEmpty(name)) {
            params.add(new HttpParameter(PARAM_NAME, name));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(title)) {
            params.add(new HttpParameter(PARAM_TITLE, title));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(description)) {
            params.add(new HttpParameter(PARAM_DESCRIPTION, description));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(posterMediaKey)) {
            params.add(new HttpParameter(PARAM_POSTER_MEDIA_KEY, posterMediaKey));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(fileName)) {
            params.add(new HttpParameter(PARAM_FILE_NAME, fileName));
        }

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_MEDIA_LIBRARY + "/" + mediaKey;
        final Type type = new TypeToken<BaseAdsResponse<TwitterLibraryMedia>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.PUT);
    }

    @Override
    public TwitterLibraryMedia waitForProcessingAndGetMedia(String accountId, String mediaKey) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);
        TwitterAdUtil.ensureNotNull(mediaKey, "Media Key");
        return twitterAdsClient.waitForMediaProcessing(accountId, mediaKey, TimeUnit.MINUTES.toMillis(4));
    }

    @Override
    public BaseAdsResponse<TwitterLibraryMedia> deleteLibraryMediaByKey(String accountId, String mediaKey) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);
        TwitterAdUtil.ensureNotNull(mediaKey, "Media Key");

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_MEDIA_LIBRARY + SLASH + mediaKey;
        Type type = new TypeToken<BaseAdsResponse<TwitterLibraryMedia>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    //----------------------------------------------PRIVATE METHODS----------------------------------------------

    private BaseAdsResponse<TwitterLibraryMedia> associateMediaToLibrary(String accountId, String mediaKey, TwitterMediaLibraryCategory mediaCategory,
                                                                         String name, String title,
                                                                         String description,
                                                                         String posterMediaKey, String fileName)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, ACCOUNT_ID);

        final List<HttpParameter> params = new ArrayList<>();

        TwitterAdUtil.ensureNotNull(mediaKey, "Media Key");
        params.add(new HttpParameter(PARAM_MEDIA_KEY, mediaKey));

        if (StringUtils.isNotBlank(description)) {
            params.add(new HttpParameter(PARAM_DESCRIPTION, description));
        }
        if (StringUtils.isNotBlank(fileName)) {
            params.add(new HttpParameter(PARAM_FILE_NAME, fileName));
        }
        if (StringUtils.isNotBlank(name)) {
            params.add(new HttpParameter(PARAM_NAME, name));
        }
        if (StringUtils.isNotBlank(posterMediaKey)) {
            params.add(new HttpParameter(PARAM_POSTER_MEDIA_KEY, posterMediaKey));
        }
        if (StringUtils.isNotBlank(title)) {
            params.add(new HttpParameter(PARAM_TITLE, title));
        }

        final String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI + accountId + PATH_MEDIA_LIBRARY;
        final HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterLibraryMedia>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
    }
}
