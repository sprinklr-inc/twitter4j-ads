package twitter4jads.impl;

import com.google.common.base.Optional;
import com.google.gson.reflect.TypeToken;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsResponse;
import twitter4jads.TwitterAdsClient;
import twitter4jads.api.TwitterAdsCampaignApi;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.Campaign;
import twitter4jads.models.ads.EntityStatus;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.ads.sort.CampaignSortByField;
import twitter4jads.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static twitter4jads.TwitterAdsConstants.PARAM_CAMPAIGN_IDS;
import static twitter4jads.TwitterAdsConstants.PARAM_COUNT;
import static twitter4jads.TwitterAdsConstants.PARAM_CURSOR;
import static twitter4jads.TwitterAdsConstants.PARAM_DAILY_BUDGET_AMOUNT_LOCAL_MICRO;
import static twitter4jads.TwitterAdsConstants.PARAM_DURATION_IN_DAYS;
import static twitter4jads.TwitterAdsConstants.PARAM_END_TIME;
import static twitter4jads.TwitterAdsConstants.PARAM_ENTITY_STATUS;
import static twitter4jads.TwitterAdsConstants.PARAM_FREQUENCY_CAP;
import static twitter4jads.TwitterAdsConstants.PARAM_FUNDING_INSTRUMENT_ID;
import static twitter4jads.TwitterAdsConstants.PARAM_FUNDING_INSTRUMENT_IDS;
import static twitter4jads.TwitterAdsConstants.PARAM_NAME;
import static twitter4jads.TwitterAdsConstants.PARAM_SORT_BY;
import static twitter4jads.TwitterAdsConstants.PARAM_STANDARD_DELIVERY;
import static twitter4jads.TwitterAdsConstants.PARAM_START_TIME;
import static twitter4jads.TwitterAdsConstants.PARAM_TOTAL_BUDGET_AMOUNT_LOCAL_MICRO;
import static twitter4jads.TwitterAdsConstants.PARAM_WITH_DELETED;
import static twitter4jads.TwitterAdsConstants.PATH_CAMPAIGN;
import static twitter4jads.TwitterAdsConstants.PREFIX_ACCOUNTS_URI_4;

/**
 * User: abhay
 * Date: 4/7/16
 * Time: 12:26 PM
 */
public class TwitterAdsCampaignApiImpl implements TwitterAdsCampaignApi {

    private static final Integer MAX_REQUEST_PARAMETER_SIZE = 200;
    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsCampaignApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<Campaign> getAllCampaigns(String accountId, Optional<Collection<String>> campaignIds,
                                                                 Optional<Collection<String>> fundingInstrumentIds, boolean withDeleted, Optional<Integer> count,
                                                                 Optional<String> cursor, Optional<CampaignSortByField> sortByField) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        String campaignIdsAsString = null;
        String fundingInstrumentIdsAsString = null;
        if (campaignIds != null && campaignIds.isPresent()) {
            TwitterAdUtil.ensureMaxSize(campaignIds.get(), MAX_REQUEST_PARAMETER_SIZE);
            campaignIdsAsString = TwitterAdUtil.getCsv(campaignIds.get());
        }
        if (fundingInstrumentIds != null && fundingInstrumentIds.isPresent()) {
            TwitterAdUtil.ensureMaxSize(fundingInstrumentIds.get(), MAX_REQUEST_PARAMETER_SIZE);
            fundingInstrumentIdsAsString = TwitterAdUtil.getCsv(fundingInstrumentIds.get());
        }

        List<HttpParameter> params =
                getCampaignParameters(accountId, Optional.fromNullable(campaignIdsAsString), Optional.fromNullable(fundingInstrumentIdsAsString), withDeleted, count, cursor);

        if (sortByField != null && sortByField.isPresent()) {
            params.add(new HttpParameter(PARAM_SORT_BY, sortByField.get().getField()));
        }
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_CAMPAIGN;

        final Type type = new TypeToken<BaseAdsListResponse<Campaign>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<Campaign> getCampaignById(String accountId, String campaignId, boolean withDeleted) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(campaignId, "campaignId");

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_CAMPAIGN + campaignId;
        final HttpParameter[] params = new HttpParameter[]{new HttpParameter(PARAM_WITH_DELETED, withDeleted)};

        final Type type = new TypeToken<BaseAdsResponse<Campaign>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<Campaign> createCampaign(Campaign campaign) throws TwitterException {
        TwitterAdUtil.ensureNotNull(campaign.getAccountId(), "Account Id");
        final String accountId = campaign.getAccountId();
        final List<HttpParameter> params = validateCreateCampaignParameters(campaign);
        HttpParameter[] parameters = null;
        if (!params.isEmpty()) {
            parameters = params.toArray(new HttpParameter[params.size()]);
        }

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_CAMPAIGN;
        Type type = new TypeToken<BaseAdsResponse<Campaign>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, parameters, type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<Campaign> updateCampaign(String accountId, String campaignId, Optional<String> name,
                                                    Long totalBudgetAmountLocalMicro, Optional<Long> dailyBudgetAmountLocalMicro, Optional<String> startTime,
                                                    Optional<String> endTime, EntityStatus status,
                                                    Optional<Boolean> standardDelivery, int frequencyCap, int durationInDays) throws TwitterException {

        final List<HttpParameter> params =
                validateUpdateCampaignParameters(accountId, campaignId, name, totalBudgetAmountLocalMicro, dailyBudgetAmountLocalMicro, startTime,
                        endTime, status, standardDelivery, frequencyCap, durationInDays);
        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_CAMPAIGN + campaignId;
        final Type type = new TypeToken<BaseAdsResponse<Campaign>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.PUT);

    }

    @Override
    public BaseAdsResponse<Campaign> deleteCampaign(String accountId, String campaignId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(campaignId, "Campaign Id");

        final String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_CAMPAIGN + campaignId;
        final Type type = new TypeToken<BaseAdsResponse<Campaign>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    // ------------------------------------------------------------------------ PRIVATE METHODS -----------------------------------------------------

    private List<HttpParameter> validateCreateCampaignParameters(Campaign campaign) {
        TwitterAdUtil.ensureNotNull(campaign.getName(), "Name");
        final String name = campaign.getName();

        TwitterAdUtil.ensureNotNull(campaign.getFundingInstrumentId(), "Funding Instrument ID");
        final String fundingInstrumentId = campaign.getFundingInstrumentId();

        TwitterAdUtil.ensureNotNull(campaign.getStartTime(), "Start Time");
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        final String startTime = String.valueOf(df.format(campaign.getStartTime()));

        TwitterAdUtil.ensureNotNull(campaign.getDailyBudgetInMicro(), "Daily Budget Amount");
        final Long dailyBudgetAmountLocalMicro = campaign.getDailyBudgetInMicro();

        final List<HttpParameter> params = new ArrayList<>();
        final Long totalBudgetAmountLocalMicro = campaign.getTotalBudgetInMicro();
        if (totalBudgetAmountLocalMicro != null) {
            params.add(new HttpParameter(PARAM_TOTAL_BUDGET_AMOUNT_LOCAL_MICRO, totalBudgetAmountLocalMicro));
        }

        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_FUNDING_INSTRUMENT_ID, fundingInstrumentId));
        params.add(new HttpParameter(PARAM_START_TIME, startTime));
        params.add(new HttpParameter(PARAM_DAILY_BUDGET_AMOUNT_LOCAL_MICRO, dailyBudgetAmountLocalMicro));

        if (campaign.getEndTime() != null) {
            String endTime = String.valueOf(df.format(campaign.getEndTime()));
            params.add(new HttpParameter(PARAM_END_TIME, endTime));
        }
        if (campaign.getEntityStatus() != null) {
            params.add(new HttpParameter(PARAM_ENTITY_STATUS, campaign.getEntityStatus()));
        }
        if (campaign.getStandardDelivery() != null) {
            Boolean standardDelivery = campaign.getStandardDelivery();
            params.add(new HttpParameter(PARAM_STANDARD_DELIVERY, standardDelivery));
        }
        if (campaign.getFrequencyCap() != null) {
            params.add(new HttpParameter(PARAM_FREQUENCY_CAP, campaign.getFrequencyCap()));
        }
        if (campaign.getDurationInDays() != null) {
            params.add(new HttpParameter(PARAM_DURATION_IN_DAYS, campaign.getDurationInDays()));
        }

        return params;
    }

    private List<HttpParameter> getCampaignParameters(String accountId, Optional<String> campaignIds, Optional<String> fundingInstrumentIds, boolean withDeleted,
                                                      Optional<Integer> count, Optional<String> cursor) {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        final List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (campaignIds != null && campaignIds.isPresent()) {
            params.add(new HttpParameter(PARAM_CAMPAIGN_IDS, campaignIds.get()));
        }
        if (fundingInstrumentIds != null && fundingInstrumentIds.isPresent()) {
            params.add(new HttpParameter(PARAM_FUNDING_INSTRUMENT_IDS, fundingInstrumentIds.get()));
        }
        if (count != null && count.isPresent()) {
            params.add(new HttpParameter(PARAM_COUNT, count.get()));
        }
        if (cursor != null && cursor.isPresent()) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor.get()));
        }

        return params;
    }

    private List<HttpParameter> validateUpdateCampaignParameters(String accountId, String campaignId, Optional<String> name, Long totalBudgetAmountLocalMicro,
                                                                 Optional<Long> dailyBudgetAmountLocalMicro, Optional<String> startTime,
                                                                 Optional<String> endTime, EntityStatus status,
                                                                 Optional<Boolean> standardDelivery, int frequencyCap, int durationInDays) {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(campaignId, "Campaign Id");
        final List<HttpParameter> params = new ArrayList<>();
        //The Ones that can be changed to null

        //The Ones that can be changed to null
        if (totalBudgetAmountLocalMicro == null || totalBudgetAmountLocalMicro >= 0) {
            params.add(new HttpParameter(PARAM_TOTAL_BUDGET_AMOUNT_LOCAL_MICRO, String.valueOf(totalBudgetAmountLocalMicro)));
        }

        if (endTime != null && endTime.isPresent()) {
            params.add(new HttpParameter(PARAM_END_TIME, String.valueOf(endTime)));
        }
        //The Ones that cannot be changed to null below
        if (name != null && name.isPresent()) {
            params.add(new HttpParameter(PARAM_NAME, name.get()));
        }
        if (dailyBudgetAmountLocalMicro != null && dailyBudgetAmountLocalMicro.isPresent()) {
            params.add(new HttpParameter(PARAM_DAILY_BUDGET_AMOUNT_LOCAL_MICRO, dailyBudgetAmountLocalMicro.get()));
        }
        if (startTime != null && startTime.isPresent()) {
            params.add(new HttpParameter(PARAM_START_TIME, startTime.get()));
        }
        if (endTime != null && endTime.isPresent()) {
            params.add(new HttpParameter(PARAM_END_TIME, endTime.get()));
        }
        if (status != null) {
            params.add(new HttpParameter(PARAM_ENTITY_STATUS, status.name()));
        }
        if (standardDelivery != null && standardDelivery.isPresent()) {
            params.add(new HttpParameter(PARAM_STANDARD_DELIVERY, standardDelivery.get()));
        }
        if (frequencyCap > 0) {
            params.add(new HttpParameter(PARAM_FREQUENCY_CAP, frequencyCap));
        }
        if (durationInDays > 0) {
            params.add(new HttpParameter(PARAM_DURATION_IN_DAYS, durationInDays));
        }

        return params;
    }


}
