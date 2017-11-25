package twitter4j.impl;

import com.google.api.client.util.Maps;
import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import twitter4j.*;
import twitter4j.api.TwitterAdsAudienceApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.models4j.TwitterException;
import twitter4j.models.TwitterTonUploadResponse;
import twitter4j.models.ads.*;
import twitter4j.util.TwitterAdUtil;

import java.io.*;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:54 AM
 */
public class TwitterAdsAudienceApiImpl implements TwitterAdsAudienceApi {

    private final TwitterAdsClient twitterAdsClient;
    private static final Gson GSON = new Gson();

    public TwitterAdsAudienceApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<TailoredAudience> getAllTailoredAudiences(String accountId, Optional<Integer> count,
                                                                                 Optional<Boolean> withDeleted, Optional<String> cursor)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_TAILORED_AUDIENCES;
        List<HttpParameter> params = new ArrayList<>();
        if (count != null && count.isPresent() && count.get() < 1000) {
            params.add(new HttpParameter("count", count.get()));
        }
        if (withDeleted != null && withDeleted.isPresent()) {
            params.add(new HttpParameter("with_deleted", withDeleted.get()));
        }
        if (cursor != null && cursor.isPresent()) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor.get()));
        }
        Type type = new TypeToken<BaseAdsListResponse<TailoredAudience>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    public BaseAdsResponse<TailoredAudience> getTailoredAudienceForId(String accountId, String tailoredAudienceId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TailoredAudience> deleteTailoredAudience(String accountId, String tailoredAudienceId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TailoredAudience> createTailoredAudience(String accountId, String name, TailoredAudienceDataType tailoredAudienceDataType)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(name, "name");
        TwitterAdUtil.ensureNotNull(tailoredAudienceDataType, "tailoredAudienceDataType");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_TAILORED_AUDIENCE;
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("name", name));
        params.add(new HttpParameter("list_type", tailoredAudienceDataType.name()));
        Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForTailoredAudienceById(String accountId, String tailoredAudienceId)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_TAILORED_AUDIENCE_CHANGES + tailoredAudienceId;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudienceChangeInfo>>() {
        }.getType();
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
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_TAILORED_AUDIENCE_CHANGES;
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("account_id", accountId));
        params.add(new HttpParameter("tailored_audience_id", tailoredAudienceId));
        params.add(new HttpParameter("input_file_path", bucketLocation));
        params.add(new HttpParameter("operation", tailoredAudienceOperation.name()));
        Type type = new TypeToken<BaseAdsResponse<TailoredAudienceChangeInfo>>() {
        }.getType();
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
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_TAILORED_AUDIENCE_CHANGES;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudienceChangeInfo>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.GET);
    }

    @Override
    public TwitterTonUploadResponse uploadTailoredAudience(File file) throws TwitterException {
        String baseUrl = TwitterAdsConstants.POST_TON_DATA;
        Map<String, String> customHeaders = Maps.newHashMap();
        List<HttpParameter> params = new ArrayList<>();
        customHeaders.put("X-TON-Expires", getXTonExpireTime());
        if (file.length() > SIXTY_FOUR_MB) {
            return uploadInChunks(file, baseUrl, customHeaders);
        } else {
            customHeaders.put("Content-Type", "text/plain");
            customHeaders.put("Content-Length", String.valueOf(file.length()));
            params.add(new HttpParameter("file", file));
            return twitterAdsClient.executeHttpRequestForTon(baseUrl, params.toArray(new HttpParameter[params.size()]), HttpVerb.POST, customHeaders);
        }
    }

    @Override
    public TwitterTonUploadResponse resumableUploadTailoredAudience(Boolean resumable, String location, InputStream inputStream, String contentRange, Integer chunkSize) throws TwitterException {
        String baseUrl = "https://ton.twitter.com" + location;
        Map<String, String> customHeaders = Maps.newHashMap();
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("path", location, inputStream));
        customHeaders.put("Content-Range", "bytes " + contentRange);
        customHeaders.put("Content-Length", String.valueOf(chunkSize));
        customHeaders.put("Content-Type", "text/plain");
        return twitterAdsClient.executeHttpRequestForTon(baseUrl, params.toArray(new HttpParameter[params.size()]), HttpVerb.PUT, customHeaders);
    }

    @Override
    public void getGlobalOptOutListOfTailoredAudience(String accountId, String location) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(location, "location");
        Map<String, String> customHeaders = Maps.newHashMap();
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_2 + accountId + PATH_TAILORED_AUDIENCE_CHANGES;
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("input_file_path", location));
        twitterAdsClient.executeHttpRequestForTon(baseUrl, params.toArray(new HttpParameter[params.size()]), HttpVerb.PUT, customHeaders);
    }

    @Override
    public BaseAdsListBatchPostResponse<TailoredAudience> createFlexibleTailoredAudience(String accountId, String requestBody) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(requestBody, "params");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_BATCH_ACCOUNTS_V1 + accountId + PATH_TAILORED_AUDIENCE;

        Type type = new TypeToken<BaseAdsListBatchPostResponse<TailoredAudience>>() {
        }.getType();
        final HttpResponse httpResponse = twitterAdsClient.postBatchRequest(baseUrl, requestBody);
        return GSON.fromJson(httpResponse.asString(), type);
    }


    private String getXTonExpireTime() {
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusDays(10);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
        return dateFormat.format(dateTime.toDate());
    }

    public TwitterTonUploadResponse uploadInChunks(File file, String baseUrl, Map<String, String> customHeaders) throws TwitterException {
        baseUrl = baseUrl + "?resumable=true";
        customHeaders.put("X-TON-Content-Type", "text/css");
        customHeaders.put("X-TON-Content-Length", String.valueOf(file.length()));
        customHeaders.put("Content-Type", "text/plain");
        TwitterTonUploadResponse audienceUploadDetails = twitterAdsClient.executeHttpRequestForTon(baseUrl, null, HttpVerb.POST, customHeaders);

        try {
            uploadFileInChunks(file, audienceUploadDetails.getLocation(), audienceUploadDetails.getMinimumChunkSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return audienceUploadDetails;
    }

    private void uploadFileInChunks(File file, String bucketLocation, Integer minimumUploadSize) throws IOException, TwitterException {
        TwitterTonUploadResponse audienceUploadDetails = new TwitterTonUploadResponse(bucketLocation);
        String contentLengthString = Long.toString(file.length());
        InputStream inputStream = null;

        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytesPortion = new byte[minimumUploadSize];
        int byteNumber;
        int offset = 0;
        int bytesRead;
        try {
            while ((bytesRead = fileInputStream.read(bytesPortion, offset, minimumUploadSize)) != -1) {
                if (bytesRead == 0) {
                    continue;
                }
                inputStream = new ByteArrayInputStream(bytesPortion, offset, bytesRead);
                try {
                    String contentRange = Integer.toString(offset);
                    byteNumber = offset + minimumUploadSize;
                    contentRange += "-" + (byteNumber - 1) + "/" + contentLengthString;

                    audienceUploadDetails = resumableUploadTailoredAudience(true, bucketLocation, inputStream, contentRange, minimumUploadSize);
                    offset += minimumUploadSize;
                } catch (Exception e) {
                    inputStream.mark(audienceUploadDetails.getBytesUploaded());
                    inputStream.reset();
                    throw new TwitterException(e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new TwitterException(e.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }
}

