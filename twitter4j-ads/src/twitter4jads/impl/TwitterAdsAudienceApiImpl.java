package twitter4jads.impl;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import twitter4jads.BaseAdsListBatchPostResponse;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.ErrorResponse;
import twitter4jads.TwitterAdsClient;
import twitter4jads.api.TwitterAdsAudienceApi;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.http.HttpResponse;
import twitter4jads.internal.models4j.RateLimitStatus;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.ads.TailoredAudience;
import twitter4jads.models.ads.audience.AudienceApiResponse;
import twitter4jads.models.ads.audience.TailoredAudienceMatchingRules;
import twitter4jads.models.ads.audience.TailoredAudienceOperation;
import twitter4jads.models.ads.audience.TailoredAudiencePermission;
import twitter4jads.models.ads.audience.TailoredAudiencePermissionLevel;
import twitter4jads.models.ads.audience.TailoredAudienceUserDetails;
import twitter4jads.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

import static twitter4jads.TwitterAdsConstants.PARAM_CURSOR;
import static twitter4jads.TwitterAdsConstants.PATH_TAILORED_AUDIENCE;
import static twitter4jads.TwitterAdsConstants.PATH_TAILORED_AUDIENCES;
import static twitter4jads.TwitterAdsConstants.PATH_TAILORED_AUDIENCE_MATCHING_RULES;
import static twitter4jads.TwitterAdsConstants.PATH_TAILORED_AUDIENCE_PERMISSIONS;
import static twitter4jads.TwitterAdsConstants.PREFIX_ACCOUNTS_URI_4;
import static twitter4jads.TwitterAdsConstants.PREFIX_BATCH_ACCOUNTS_V4;
import static twitter4jads.TwitterAdsConstants.SLASH;
import static twitter4jads.TwitterAdsConstants.TAILORED_AUDIENCE_UPDATE_BATCH_SIZE;
import static twitter4jads.TwitterAdsConstants.USERS;
import static twitter4jads.internal.http.HttpResponseCode.BAD_REQUEST;
import static twitter4jads.internal.http.HttpResponseCode.NOT_FOUND;
import static twitter4jads.internal.http.HttpResponseCode.TOO_MANY_REQUESTS;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:54 AM
 */
public class TwitterAdsAudienceApiImpl implements TwitterAdsAudienceApi {

    private final TwitterAdsClient twitterAdsClient;
    private static final Gson GSON = new Gson();
    private static final long SIXTY_FOUR_MB = 64 * 1024 * 1024;
    private static final Set<Integer> acceptableApiErrors = Sets.newHashSet(BAD_REQUEST, NOT_FOUND, TOO_MANY_REQUESTS);

    public TwitterAdsAudienceApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<TailoredAudience> getAllTailoredAudiences(String accountId, Optional<Integer> count,
                                                                                 Optional<Boolean> withDeleted, Optional<String> cursor)
        throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_TAILORED_AUDIENCES;
        final List<HttpParameter> params = new ArrayList<>();
        if (count != null && count.isPresent() && count.get() < 1000) {
            params.add(new HttpParameter("count", count.get()));
        }
        if (withDeleted != null && withDeleted.isPresent()) {
            params.add(new HttpParameter("with_deleted", withDeleted.get()));
        }
        if (cursor != null && cursor.isPresent()) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor.get()));
        }

        final Type type = new TypeToken<BaseAdsListResponse<TailoredAudience>>() {
        }.getType();

        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public BaseAdsResponse<TailoredAudience> getTailoredAudienceForId(String accountId, String tailoredAudienceId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId;
        final Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TailoredAudience> deleteTailoredAudience(String accountId, String tailoredAudienceId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId;
        final Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {
        }.getType();

        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public BaseAdsResponse<TailoredAudience> createTailoredAudience(String accountId, String name) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(name, "name");
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_TAILORED_AUDIENCE;
        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("name", name));

        final Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    public BaseAdsResponse<TailoredAudienceMatchingRules> addMatchingRulesToAudience(TailoredAudienceMatchingRules tailoredAudienceMatchingRules,
                                                                                     String accountId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceMatchingRules, "Matching Rules");

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_TAILORED_AUDIENCE_MATCHING_RULES;
        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("tailored_audience_id", tailoredAudienceMatchingRules.getTailoredAudienceId()));
        params.add(new HttpParameter("website_tag_id", tailoredAudienceMatchingRules.getWebsiteTagId()));
        params.add(new HttpParameter("rule_type", tailoredAudienceMatchingRules.getRuleType().name()));
        if (StringUtils.isNotBlank(tailoredAudienceMatchingRules.getRuleValue())) {
            params.add(new HttpParameter("rule_value", tailoredAudienceMatchingRules.getRuleValue()));
        }

        final Type type = new TypeToken<BaseAdsResponse<TailoredAudienceMatchingRules>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }


    @Override
    public BaseAdsListBatchPostResponse<TailoredAudience> createFlexibleTailoredAudience(String accountId, String requestBody) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(requestBody, "params");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_BATCH_ACCOUNTS_V4 + accountId + PATH_TAILORED_AUDIENCE;

        Type type = new TypeToken<BaseAdsListBatchPostResponse<TailoredAudience>>() {
        }.getType();
        final HttpResponse httpResponse = twitterAdsClient.postBatchRequest(baseUrl, requestBody);
        return GSON.fromJson(httpResponse.asString(), type);
    }

    @Override
    public List<TailoredAudienceOperation> updateTailoredAudienceById(String accountId, String tailoredAudienceId,
                                                                      List<TailoredAudienceOperation> operations)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        TwitterAdUtil.ensureNotEmpty(operations, "operations");

        final String baseUrl =
                twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId + SLASH + USERS;
        final Gson gson = new Gson();
        final List<TailoredAudienceOperation> result = Lists.newArrayList();

        final Iterator<List<TailoredAudienceOperation>> batchIterator = generateBatchSequence(operations);

        while (batchIterator.hasNext()) {
            final List<TailoredAudienceOperation> batch = batchIterator.next();
            final List<NewAdsAudienceApiOperation> apiOperation =
                    batch.stream().map(this::generateRequestOperation).collect(Collectors.toList());
            final String requestBody = gson.toJson(apiOperation);
            final AudienceApiResponse apiResponse = publishAudienceWithRetry(baseUrl, requestBody);
            final boolean errorFlag = handleAudienceUpdateResponse(batch, apiResponse, result);
            if (errorFlag) {
                break;
            }
        }

        return result;
    }

    @Override
    public BaseAdsListResponse<TailoredAudiencePermission> getTailoredAudiencePermission(String accountId, String tailoredAudienceId) throws
            TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId
                + PATH_TAILORED_AUDIENCE_PERMISSIONS;

        final Type type = new TypeToken<BaseAdsListResponse<TailoredAudiencePermission>>() {
        }.getType();
        return twitterAdsClient.executeRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TailoredAudiencePermission> shareTailoredAudience(String accountId, String tailoredAudienceId, String
            grantedAccountId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        TwitterAdUtil.ensureNotNull(grantedAccountId, "grantedAccountId");

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId
                + PATH_TAILORED_AUDIENCE_PERMISSIONS;
        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("granted_account_id", grantedAccountId));
        params.add(new HttpParameter("permission_level", TailoredAudiencePermissionLevel.READ_WRITE.name()));

        final Type type = new TypeToken<BaseAdsResponse<TailoredAudiencePermission>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    // ----------------------------------------------------------------------- PRIVATE METHODS -----------------------------------------------------

    private Iterator<List<TailoredAudienceOperation>> generateBatchSequence(List<TailoredAudienceOperation> operations) {
        PriorityQueue<TailoredAudienceOperation> operationPriorityQueue =
                new PriorityQueue<>(Comparator.<TailoredAudienceOperation>comparingInt(operation -> operation.getUsers().size()).reversed());

        for (TailoredAudienceOperation operation : operations) {
            operationPriorityQueue.offer(operation);
        }

        return new Iterator<List<TailoredAudienceOperation>>() {
            @Override
            public boolean hasNext() {
                return !operationPriorityQueue.isEmpty();
            }

            @Override
            public List<TailoredAudienceOperation> next() {
                List<TailoredAudienceOperation> toReturn = Lists.newArrayList();
                int totalSize = 0;
                while (totalSize < TAILORED_AUDIENCE_UPDATE_BATCH_SIZE && !operationPriorityQueue.isEmpty()) {
                    int peekSize = operationPriorityQueue.peek().getUsers().size();
                    if (totalSize + peekSize < TAILORED_AUDIENCE_UPDATE_BATCH_SIZE) {
                        totalSize += peekSize;
                        toReturn.add(operationPriorityQueue.poll());
                    } else {
                        int diff = TAILORED_AUDIENCE_UPDATE_BATCH_SIZE - totalSize;
                        totalSize = TAILORED_AUDIENCE_UPDATE_BATCH_SIZE;

                        TailoredAudienceOperation topOperation = operationPriorityQueue.poll();
                        TailoredAudienceOperation fractionalTopOperation = new TailoredAudienceOperation();

                        fractionalTopOperation.setOperationType(topOperation.getOperationType());
                        fractionalTopOperation.setEffectiveFrom(topOperation.getEffectiveFrom());
                        fractionalTopOperation.setExpireAt(topOperation.getExpireAt());

                        Set<TailoredAudienceUserDetails> fractionalTopOperationUsers = Sets.newHashSet();
                        Iterator<TailoredAudienceUserDetails> topOperationUsersIterator = topOperation.getUsers().iterator();
                        while (diff > 0 && topOperationUsersIterator.hasNext()) {
                            fractionalTopOperationUsers.add(topOperationUsersIterator.next());
                            diff--;
                        }
                        topOperation.getUsers().removeAll(fractionalTopOperationUsers);
                        fractionalTopOperation.setUsers(fractionalTopOperationUsers);

                        operationPriorityQueue.offer(topOperation);
                        toReturn.add(fractionalTopOperation);
                        break;
                    }
                }
                return toReturn;
            }
        };
    }

    private NewAdsAudienceApiOperation generateRequestOperation(TailoredAudienceOperation operation) {
        NewAdsAudienceApiOperation apiOperation = new NewAdsAudienceApiOperation();
        apiOperation.setOperationType(operation.getOperationType().name());

        NewAdsAudienceApiParams apiParams = new NewAdsAudienceApiParams();
        apiParams.setExpireAt(operation.getExpireAt());
        apiParams.setEffectiveAt(operation.getEffectiveFrom());
        apiParams.setTailoredAudienceUserDetails(operation.getUsers());

        apiOperation.setParams(apiParams);
        return apiOperation;
    }

    private AudienceApiResponse publishAudienceWithRetry(String baseUrl, String requestBody) throws TwitterException {
        boolean retryFlag = true;
        final int retryCount = 2;
        int retry = 1;
        while (retryFlag && retry <= retryCount) {
            try {
                final HttpResponse httpResponse = twitterAdsClient.postRequest(baseUrl, requestBody);

                final String stringResponse = httpResponse.asString();

                return TwitterAdUtil.constructAudienceApiResponse(httpResponse, stringResponse);
            } catch (TwitterException eX) {
                if (!acceptableApiErrors.contains(eX.getStatusCode()) || StringUtils.isBlank(eX.getActualDetailMessage())
                        || eX.getResponse() == null) {
                    throw eX;
                }
                final AudienceApiResponse audienceApiResponse =
                        TwitterAdUtil.constructAudienceApiResponse(eX.getResponse(), eX.getActualDetailMessage());
                retryFlag = shouldRetryForRateLimitError(audienceApiResponse.getRateLimitStatus());
                if (!retryFlag) {
                    return audienceApiResponse;
                } else {
                    TwitterAdUtil.reallySleep(audienceApiResponse.getRateLimitStatus().getSecondsUntilReset() * 1000L);
                }
            } catch (Exception eX) {
                throw new TwitterException("Failed to update audience", eX);
            }
            retry++;
        }
        return null;
    }

    private boolean shouldRetryForRateLimitError(RateLimitStatus rateLimitStatus) {
        if (rateLimitStatus.getRemaining() == 0 && rateLimitStatus.getSecondsUntilReset() > 0) {
            return true;
        }
        return false;
    }

    private boolean handleAudienceUpdateResponse(List<TailoredAudienceOperation> batch, AudienceApiResponse apiResponse,
                                                 List<TailoredAudienceOperation> result) {
        boolean errorFlag = false;
        if (apiResponse.getData() != null) {
            AudienceApiResponse.NewAudienceApiResponseData response = apiResponse.getData();
            if (response.getSuccessCount().compareTo(response.getTotalCount()) != 0
                    || response.getSuccessCount().compareTo(countUsersInBatch(batch)) != 0) {
                fillErrorsInOperation(batch, apiResponse);
                errorFlag = true;
            }
        } else {
            fillErrorsInOperation(batch, apiResponse);
            errorFlag = true;
        }
        result.addAll(batch);
        return errorFlag;
    }

    private Long countUsersInBatch(List<TailoredAudienceOperation> batch) {
        long totalSize = 0;
        if (batch == null) {
            return totalSize;
        }
        for (TailoredAudienceOperation operation : batch) {
            totalSize += operation.getUsers().size();
        }
        return totalSize;
    }

    private void fillErrorsInOperation(List<TailoredAudienceOperation> batch, AudienceApiResponse apiResponse) {
        if (CollectionUtils.isEmpty(batch) ||
                (CollectionUtils.isEmpty(apiResponse.getErrors()) && CollectionUtils.isEmpty(apiResponse.getOperationErrors()))) {
            return;
        }
        final int batchSize = batch.size();
        for (int index = 0; index < batchSize; ++index) {
            final TailoredAudienceOperation operation = batch.get(index);

            // batch level errors
            if (CollectionUtils.isNotEmpty(apiResponse.getErrors())) {
                final List<String> errors = apiResponse.getErrors().stream().map(ErrorResponse::getMessage).collect(Collectors.toList());
                operation.getErrors().addAll(errors);
            }

            //operation level errors
            if (CollectionUtils.isNotEmpty(apiResponse.getOperationErrors())
                    && CollectionUtils.isNotEmpty(apiResponse.getOperationErrors().get(index))) {
                final List<String> operationErrors =
                        apiResponse.getOperationErrors().get(index).stream().map(ErrorResponse::getMessage).collect(Collectors.toList());
                operation.getOperationErrors().addAll(operationErrors);
            }
        }
    }
}

