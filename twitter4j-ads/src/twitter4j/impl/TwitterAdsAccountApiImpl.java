package twitter4j.impl;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections.CollectionUtils;
import twitter4j.BaseAdsListResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterAdsClient;
import twitter4j.api.TwitterAdsAccountApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.ads.AdAccount;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.ads.PromotableUser;
import twitter4j.models.ads.TwitterAccountPermissions;
import twitter4j.models.ads.sort.AccountsSortByField;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 7:54 PM
 */
public class TwitterAdsAccountApiImpl implements TwitterAdsAccountApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsAccountApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<AdAccount> getAllAccounts(boolean withDeleted, Optional<AccountsSortByField> sortByField) throws TwitterException {
        List<HttpParameter> param = new ArrayList<>();
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1;
        param.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (sortByField!= null && sortByField.isPresent()) {
            param.add(new HttpParameter(PARAM_SORT_BY, sortByField.get().getField()));
        }
        Type type = new TypeToken<BaseAdsListResponse<AdAccount>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, param, type);
    }

    @Override
    public BaseAdsResponse<AdAccount> getAdAccountById(String accountId, boolean withDeleted) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        HttpParameter[] param;
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId;
        param = new HttpParameter[]{new HttpParameter(PARAM_WITH_DELETED, withDeleted)};
        Type type = new TypeToken<BaseAdsResponse<AdAccount>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, param, type, HttpVerb.GET);
    }

    @Override
    public List<TwitterAccountPermissions> getAccountPermissions(String accountId) throws TwitterException {
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_FEATURES;
        HttpResponse httpResponse = twitterAdsClient.getWithoutMergeOfParams(baseUrl, null);
        List<TwitterAccountPermissions> permissionsFromChannel = Lists.newArrayList();
        try {
            Type type = new TypeToken<BaseAdsListResponse<String>>() {}.getType();
            BaseAdsListResponse<String> permissions = TwitterAdUtil.constructBaseAdsListResponse(httpResponse, httpResponse.asString(), type);
            if (permissions == null || CollectionUtils.isEmpty(permissions.getData())) {
                throw new TwitterException("Empty response returned for Account Permissions");
            }
            List<String> data = permissions.getData();
            for (String key : data) {
                TwitterAccountPermissions accountPermission = TwitterAccountPermissions.getAccountPermission(key);
                if (accountPermission != null) {
                    permissionsFromChannel.add(accountPermission);
                }
            }
        } catch (IOException e) {
            throw new TwitterException("Exception occurred while getting the Account Permissions", e);
        }
        return permissionsFromChannel;
    }

    @Override
    public BaseAdsListResponseIterable<PromotableUser> getPromotableUsers(String accountId, boolean withDeleted) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        List<HttpParameter> params = new ArrayList<>();

        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_PROMOTABLE_USERS;
        Type type = new TypeToken<BaseAdsListResponse<PromotableUser>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }
}
