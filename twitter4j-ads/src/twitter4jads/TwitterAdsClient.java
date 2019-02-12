package twitter4jads;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import twitter4jads.auth.Authorization;
import twitter4jads.auth.OAuthSupport;
import twitter4jads.conf.Configuration;
import twitter4jads.internal.http.HttpParameter;
import twitter4jads.internal.http.HttpResponse;
import twitter4jads.internal.models4j.TwitterAPIMonitor;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.internal.models4j.TwitterImpl;
import twitter4jads.internal.models4j.Version;
import twitter4jads.models.TwitterTonUploadResponse;
import twitter4jads.models.ads.HttpVerb;
import twitter4jads.models.media.TwitterLibraryMedia;
import twitter4jads.models.media.TwitterMediaLibraryStatus;
import twitter4jads.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static twitter4jads.TwitterAdsConstants.PATH_MEDIA_LIBRARY;
import static twitter4jads.TwitterAdsConstants.PREFIX_ACCOUNTS_URI_4;
import static twitter4jads.TwitterAdsConstants.SLASH;
import static twitter4jads.TwitterAdsConstants.WAIT_INTERVAL;
import static twitter4jads.models.media.TwitterMediaLibraryStatus.TRANSCODE_FAILED;
import static twitter4jads.util.TwitterAdUtil.constructBaseAdsResponse;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 7:07 PM
 */
public class TwitterAdsClient extends TwitterImpl implements OAuthSupport {

    public static final String ADS_API_URL = "https://ads-api.twitter.com/";
    public static final Gson GSON_INSTANCE = new Gson();

    private static final Map<String, String> requestHeaders;

    static {
        requestHeaders = new HashMap<>();
        requestHeaders.put("X-Twitter-Client-Version", Version.getVersion());
        requestHeaders.put("X-Twitter-Client-URL", "http://twitter4jads.org/en/twitter4jads-" + Version.getVersion() + ".xml");
        requestHeaders.put("X-Twitter-Client", "Twitter4J");
        requestHeaders.put("User-Agent", "twitter4jads http://twitter4jads.org/ /" + Version.getVersion());
        requestHeaders.put("Accept-Encoding", "gzip");
    }

    public static TwitterAdsClient getInstance(Configuration conf, Authorization auth) {
        return new TwitterAdsClient(conf, auth);
    }

    public TwitterAdsClient(Configuration conf, Authorization auth) {
        super(conf, auth);
    }

    private String getImplicitParamsStr() {
        return StringUtils.EMPTY;
    }


    public String getBaseAdsAPIUrl() {
        return ADS_API_URL;//conf.getAdsAPIURL();
    }

    public String getMediaUploadBaseUrl() {
        return conf.getMediaUploadBaseUrl();
    }

    public <T> BaseAdsListResponseIterable<T> executeHttpListRequest(String baseUrl, List<HttpParameter> params, Type type) throws TwitterException {
        return executeHttpListRequest(baseUrl, params, type, false);
    }

    public <T> BaseAdsListResponseIterable<T> executeHttpListRequest(String baseUrl, List<HttpParameter> params, Type type,
                                                                     boolean isCostBasedRateLimit) throws TwitterException {
        HttpResponse httpResponse;
        if (params != null) {
            httpResponse = get(baseUrl, params.toArray(new HttpParameter[params.size()]));
        } else {
            httpResponse = get(baseUrl);
        }
        BaseAdsListResponseIterable<T> response;
        try {
            response = constructBaseAdsListResponse(baseUrl, httpResponse, params, type, isCostBasedRateLimit);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse response.", e);
        }

        return response;
    }

    public <T> BaseAdsListResponseIterable<T> constructBaseAdsListResponse(String baseUrl, HttpResponse httpResponse, List<HttpParameter> params,
                                                                           Type type, boolean isCostBasedRateLimit)
            throws TwitterException, IOException {
        return new BaseAdsListResponseIterable<>(this, baseUrl, params, type, httpResponse, isCostBasedRateLimit);
    }

    public <T> BaseAdsResponse<T> executeHttpRequest(String baseUrl, HttpParameter[] params, Type type, HttpVerb httpVerb) throws TwitterException {
        HttpResponse httpResponse;
        String stringResponse;
        BaseAdsResponse<T> response = null;
        //noinspection Duplicates
        switch (httpVerb) {
            case GET:
                try {
                    httpResponse = get(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case PUT:
                try {
                    httpResponse = put(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case POST:
                //noinspection Duplicates
                try {
                    httpResponse = postRequest(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case DELETE:
                try {
                    httpResponse = delete(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructBaseAdsResponse(httpResponse, stringResponse, type);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
        }

        return response;
    }

    public HttpResponse postRequest(String url, String requestBody) throws TwitterException {
        return super.post(url, requestBody);
    }

    public HttpResponse postRequest(String url, HttpParameter[] params) throws TwitterException {
        return post(url, params);
    }

    public HttpResponse getRequest(String url, HttpParameter[] params) throws TwitterException {
        return get(url, params);
    }

    public HttpResponse getRequest(String url) throws TwitterException {
        return get(url);
    }

    public HttpResponse getWithoutMergeOfParams(String url, HttpParameter[] params) throws TwitterException {
        return getWithoutMergingImplicitParams(url, params);
    }

    public HttpResponse putRequest(String url, HttpParameter[] params) throws TwitterException {
        return put(url, params);
    }

    public TwitterTonUploadResponse executeHttpRequestForTon(String baseUrl, HttpParameter[] params, HttpVerb httpVerb,
                                                             Map<String, String> customHeaders) throws TwitterException {
        HttpResponse httpResponse;
        TwitterTonUploadResponse response = null;
        switch (httpVerb) {
            case PUT:
                httpResponse = putWithCustomHeaders(baseUrl, params, customHeaders, true);
                response = getResponseFromHeaders(httpResponse);

                break;
            case POST:
                httpResponse = postWithCustomHeaders(baseUrl, params, customHeaders, true);
                response = getResponseFromHeaders(httpResponse);
                break;
        }

        return response;
    }

    public <T> T executeRequest(String baseUrl, HttpParameter[] params, Type typeToken, HttpVerb httpVerb) throws TwitterException {
        HttpResponse httpResponse;
        String stringResponse;
        T response = null;
        switch (httpVerb) {
            case GET:
                try {
                    httpResponse = getRequest(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case PUT:
                try {
                    httpResponse = put(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case POST:
                try {
                    httpResponse = postRequest(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
            case DELETE:
                try {
                    httpResponse = delete(baseUrl, params);
                    stringResponse = httpResponse.asString();
                    response = constructHTTPRequestResponse(stringResponse, typeToken);
                } catch (IOException e) {
                    throw new TwitterException("Failed to parse response.", e);
                }
                break;
        }
        return response;
    }

    //https://twittercommunity.com/t/details-for-media-library-media-status/117756
    public TwitterLibraryMedia waitForMediaProcessing(String accountId, String mediaKey, long maxWaitTime) throws TwitterException {
        Long totalWaitTime = 0L;
        String url = getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_4 + accountId + PATH_MEDIA_LIBRARY + SLASH + mediaKey;

        Type type = new TypeToken<BaseAdsResponse<TwitterLibraryMedia>>() {
        }.getType();
        while (totalWaitTime < maxWaitTime) {
            final BaseAdsResponse<TwitterLibraryMedia> response = executeHttpRequest(url, null, type, HttpVerb.GET);
            final TwitterLibraryMedia media = response.getData();
            TwitterMediaLibraryStatus status;
            try {
                status = TwitterMediaLibraryStatus.valueOf(media.getMediaStatus());
            } catch (Exception eX) {
                return null;
            }

            switch (status) {
                case TRANSCODE_FAILED:
                    throw new TwitterException("Media processing error. Status: " + TRANSCODE_FAILED.name());
                case TRANSCODE_COMPLETED:
                    return media;
                case TRANSCODE_PENDING:
                case TRANSCODE_IN_PROGRESS:
                    TwitterAdUtil.reallySleep(WAIT_INTERVAL);
                    totalWaitTime += WAIT_INTERVAL;
                    break;
            }
        }

        return null;
    }

    public Configuration getConf() {
        return super.getConfiguration();
    }

    // ------------------------------------------------------------------- PRIVATE METHODS -------------------------------------------------

    private <T> T constructHTTPRequestResponse(String response, Type typeToken) throws IOException {
        return GSON_INSTANCE.fromJson(response, typeToken);
    }

    public HttpResponse get(String url) throws TwitterException {
        ensureAuthorizationEnabled();

        if (!conf.isMBeanEnabled()) {
            return http.get(url, null, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.get(url, null, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    public HttpResponse get(String url, HttpParameter... params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.get(url, params, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.get(url, params, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    public HttpResponse post(String url, HttpParameter... params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.post(url, params, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.post(url, params, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    private boolean isOk(HttpResponse response) {
        return response != null && response.getStatusCode() < 300;
    }

    protected HttpResponse put(String url, HttpParameter[] params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.put(url, params, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.put(url, params, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse delete(String url) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.delete(url, null, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.delete(url, null, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse delete(String url, HttpParameter[] params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.delete(url, params, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.delete(url, params, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    protected HttpResponse getWithoutMergingImplicitParams(String url, HttpParameter[] params) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled()) {
            return http.get(url, params, auth);
        } else {
            // intercept HTTP call for monitoring purposes
            HttpResponse response = null;
            long start = System.currentTimeMillis();
            try {
                response = http.get(url, params, auth);
            } finally {
                long elapsedTime = System.currentTimeMillis() - start;
                TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, isOk(response));
            }
            return response;
        }
    }

    private TwitterTonUploadResponse getResponseFromHeaders(HttpResponse httpResponse) {
        Integer minChunkSize = null;
        Integer maxChunkSize = null;
        String location = httpResponse.getResponseHeader("location");
        Integer bytesSuccessfullyUploaded = getBytesUploadedFromHeader(httpResponse);
        String minimumChunkSizeFromHeader = httpResponse.getResponseHeader("x-ton-min-chunk-size");
        if (minimumChunkSizeFromHeader != null) {
            minChunkSize = Integer.valueOf(minimumChunkSizeFromHeader);

        }
        String maximumChunkSizeFromHeader = httpResponse.getResponseHeader("x-ton-max-chunk-size");
        if (maximumChunkSizeFromHeader != null) {
            maxChunkSize = Integer.valueOf(maximumChunkSizeFromHeader);

        }
        return new TwitterTonUploadResponse(location, minChunkSize, maxChunkSize, bytesSuccessfullyUploaded, null);
    }

    private Integer getBytesUploadedFromHeader(HttpResponse httpResponse) {
        String range;
        String rangeFromHeader = httpResponse.getResponseHeader("range");
        if (rangeFromHeader != null) {
            int i = rangeFromHeader.indexOf("-");
            if (i > 0) {
                range = rangeFromHeader.substring(i + 1, rangeFromHeader.length());
                return Integer.valueOf(range);
            }
        }
        return null;
    }
}

