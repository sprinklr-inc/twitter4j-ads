package twitter4j.impl;

import com.google.common.base.Optional;
import com.google.gson.reflect.TypeToken;
import twitter4j.BaseAdsListResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterAdsClient;
import twitter4j.api.TwitterAdsAudienceApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.TwitterTonUploadResponse;
import twitter4j.models.ads.*;
import twitter4j.util.TwitterAdUtil;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:54 AM
 */
public class TwitterAdsAudienceApiImpl implements TwitterAdsAudienceApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsAudienceApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<TailoredAudience> getAllTailoredAudiences(String accountId, Optional<Integer> count,
                                                                                 Optional<Boolean> withDeleted, Optional<String> cursor)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TAILORED_AUDIENCES;
        List<HttpParameter> params = new ArrayList<>();
        if (count != null && count.isPresent() && count.get() < 1000) {
            params.add(new HttpParameter("count", count.get()));
        }
        if (withDeleted!=null && withDeleted.isPresent()) {
            params.add(new HttpParameter("with_deleted", withDeleted.get()));
        }
        if (cursor!=null && cursor.isPresent()) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor.get()));
        }
        Type type = new TypeToken<BaseAdsListResponse<TailoredAudience>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    public BaseAdsResponse<TailoredAudience> getTailoredAudienceForId(String accountId, String tailoredAudienceId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TailoredAudience> deleteTailoredAudience(String accountId, String tailoredAudienceId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TailoredAudience> createTailoredAudience(String accountId, String name, TailoredAudienceDataType tailoredAudienceDataType)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(name, "name");
        TwitterAdUtil.ensureNotNull(tailoredAudienceDataType, "tailoredAudienceDataType");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TAILORED_AUDIENCE;
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("name", name));
        params.add(new HttpParameter("list_type", tailoredAudienceDataType.name()));
        Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForTailoredAudienceById(String accountId, String tailoredAudienceId)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TAILORED_AUDIENCE_CHANGES + tailoredAudienceId;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudienceChangeInfo>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TailoredAudienceChangeInfo> editUsersInTailoredAudience(String accountId, String tailoredAudienceId, String bucketLocation,
                                                                                   TailoredAudienceOperation tailoredAudienceOperation)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        TwitterAdUtil.ensureNotNull(bucketLocation, "bucketLocation");
        TwitterAdUtil.ensureNotNull(tailoredAudienceOperation, "tailoredAudienceOperation");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TAILORED_AUDIENCE_CHANGES;
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("account_id", accountId));
        params.add(new HttpParameter("tailored_audience_id", tailoredAudienceId));
        params.add(new HttpParameter("input_file_path", bucketLocation));
        params.add(new HttpParameter("operation", tailoredAudienceOperation.name()));
        Type type = new TypeToken<BaseAdsResponse<TailoredAudienceChangeInfo>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForAllTailoredAudiences(String accountId, Optional<Integer> count,
                                                                                               Optional<String> nextCursor)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = new ArrayList<>();
        if (count != null && count.isPresent() && count.get() < 1000) {
            params.add(new HttpParameter("count", count.get()));

        }
        if (nextCursor != null && nextCursor.isPresent()) {
            params.add(new HttpParameter("cursor", nextCursor.get()));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TAILORED_AUDIENCE_CHANGES;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudienceChangeInfo>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.GET);
    }

    @Override
    public TwitterTonUploadResponse uploadTailoredAudience(File file) throws TwitterException {
        return null;
    }

    @Override
    public TwitterTonUploadResponse resumableUploadTailoredAudience(Boolean resumable, String location, InputStream inputStream, String contentRange, Integer chunkSize) throws TwitterException {
        return null;
    }

    @Override
    public void getGlobalOptOutListOfTailoredAudience(String accountId, String location) throws TwitterException {

    }

    @Override
    public BaseAdsResponse<TailoredAudience> createFlexibleTailoredAudience(String accountId, String requestBody) throws TwitterException {
        return null;
    }
}
