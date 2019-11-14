package twitter4jads.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import twitter4jads.BaseAdsListBatchPostResponse;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsResponse;
import twitter4jads.internal.http.HttpResponse;
import twitter4jads.internal.models4j.RateLimitStatus;
import twitter4jads.models.ads.TrackingTag;
import twitter4jads.models.ads.TwitterAdObjective;
import twitter4jads.models.ads.audience.AudienceApiResponse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static com.google.common.collect.Sets.newHashSet;
import static org.apache.commons.collections.SetUtils.unmodifiableSet;
import static twitter4jads.models.ads.TwitterAdObjective.WEBSITE_CONVERSIONS;
import static twitter4jads.util.TwitterAdHttpUtils.createFromResponseHeader;

/**
 * User: poly
 * Date: 29/01/14
 * Time: 2:23 PM
 */
public final class TwitterAdUtil {

    public static final String FOLLOWERS = "FOLLOWERS";
    public static final String TWEET_ENGAGEMENTS = "TWEET_ENGAGEMENTS";
    public static final String VIDEO_VIEWS = "VIDEO_VIEWS";
    public static final String WEBSITE_CLICKS = "WEBSITE_CLICKS";
    public static final String VIDEO_VIEWS_PREROLL = "VIDEO_VIEWS_PREROLL";
    public static final String APP_ENGAGEMENTS = "APP_ENGAGEMENTS";
    public static final String APP_INSTALLS = "APP_INSTALLS";
    public static final Set<TwitterAdObjective> TAP_SUPPORTED_OBJECTIVES =
        unmodifiableSet(newHashSet(APP_INSTALLS, APP_ENGAGEMENTS, VIDEO_VIEWS_PREROLL, WEBSITE_CLICKS, WEBSITE_CONVERSIONS));

    public static final Set<TwitterAdObjective> TARGET_CPA_SUPPORTED_OBJECTIVES = unmodifiableSet(newHashSet(WEBSITE_CONVERSIONS));
    public static final String UTC_TMZ = "UTC";
    public static final String FORMAT_YYYYMMDD_HHMM = "yyyyMMdd_HHmm";

    public static final ThreadLocal<Calendar> UTC_CALENDAR = new ThreadLocal<Calendar>() {
        @Override
        protected Calendar initialValue() {
            return Calendar.getInstance(TimeZone.getTimeZone(UTC_TMZ));
        }
    };

    public static final ThreadLocal<SimpleDateFormat> FORMATTER_UTC_YYYYMMDD_HHMM = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat rv = new SimpleDateFormat(FORMAT_YYYYMMDD_HHMM);
            rv.setCalendar(UTC_CALENDAR.get());
            return rv;
        }
    };

    public static String convertTimeToZuluFormatAndToUTC(long time) {
        String dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";

        DateTime dateTimeStart = new DateTime(time, DateTimeZone.UTC);

        return dateTimeStart.toString(dateFormat);
    }

    public static <T> String getCsv(Collection<T> collection) {
        String result = "";
        if (collection != null && collection.size() != 0) {
            result = getLocalCsv(collection);
        }
        return result;
    }

    public static <T> String getLocalCsv(Collection<T> coll) {
        StringBuilder buff = new StringBuilder();
        int i = 0;
        for (T value : coll) {
            if (i != 0) {
                buff.append(",");
            }
            buff.append(value);
            i++;
        }
        return buff.toString();
    }

    public static boolean isNotNullOrEmpty(String string) {
        return !(string == null || string.isEmpty());
    }

    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static <T> void containedInList(T object, List<T> list, String message) {
        if (list == null || !list.contains(object)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void ensureNotNull(Object object, String name) {
        if (object == null) {
            throw new IllegalArgumentException(name + " can not be null.");
        }
    }

    public static <T> void ensureNotEmpty(Collection<T> collection, String name) {
        if (!isNotEmpty(collection)) {
            throw new IllegalArgumentException(name + " can not be null or empty.");
        }
    }

    public static <T> boolean isNotEmpty(Collection<T> collection) {
        return collection != null && collection.size() != 0;
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static <T> Boolean ensureMaxSize(Collection<T> collection, int size) {
        if (isNotEmpty(collection) && size > 0) {
            if (collection.size() > size) {
                throw new IllegalArgumentException("Collection size must be less than " + size);
            }
        }
        return true;
    }

    public static <E> List<E> createMutableList(Collection<E> collection) {
        List<E> mutableList = new ArrayList<>();
        if (isNotEmpty(collection)) {
            for (E data : collection) {
                mutableList.add(data);
            }
        }
        return mutableList;
    }

    public static String getDelimiterSeparatedMethod(final Collection<String> values, String delimiter) {
        if (values == null || values.isEmpty()) {
            return "";
        }
        String rv = "";
        for (String value : values) {
            rv = rv + value + delimiter;
        }
        rv = rv.substring(0, rv.length() - 1);
        return rv;
    }

    public static <T> BaseAdsResponse<T> constructBaseAdsResponse(HttpResponse httpResponse, String response, Type type) throws IOException {
        if (type == null) {
            return null;
        }
        Gson gson = new Gson();
        BaseAdsResponse<T> baseResponse = gson.fromJson(response, type);
        RateLimitStatus rateLimitStatus = createFromResponseHeader(httpResponse);
        baseResponse.setRateLimitStatus(rateLimitStatus);
        return baseResponse;
    }

    public static <T> BaseAdsListResponse<T> constructBaseAdsListResponse(HttpResponse httpResponse, String response, Type type) throws IOException {
        Gson gson = new Gson();
        BaseAdsListResponse<T> baseResponse = gson.fromJson(response, type);
        RateLimitStatus rateLimitStatus = createFromResponseHeader(httpResponse);
        baseResponse.setRateLimitStatus(rateLimitStatus);
        return baseResponse;
    }

    public static <T> BaseAdsListBatchPostResponse<T> constructBaseAdsListBatchPostResponse(HttpResponse httpResponse, String response, Type type) throws IOException {
        Gson gson = new Gson();
        BaseAdsListBatchPostResponse<T> baseResponse = gson.fromJson(response, type);
        RateLimitStatus rateLimitStatus = createFromResponseHeader(httpResponse);
        baseResponse.setRateLimitStatus(rateLimitStatus);
        return baseResponse;
    }

    public static AudienceApiResponse constructAudienceApiResponse(HttpResponse httpResponse, String response) {
        Gson gson = new Gson();
        Type audienceApiResponseType = new TypeToken<AudienceApiResponse>() {
        }.getType();
        AudienceApiResponse audienceApiResponse = gson.fromJson(response, audienceApiResponseType);
        RateLimitStatus rateLimitStatus = createFromResponseHeader(httpResponse);
        audienceApiResponse.setRateLimitStatus(rateLimitStatus);
        return audienceApiResponse;
    }

    public static void reallySleep(long millis) {
        boolean threadInterrupted = false;
        final long nanos = TimeUnit.MILLISECONDS.toNanos(millis);
        final long end = System.nanoTime() + nanos;
        long remaining;
        try {
            do {
                remaining = end - System.nanoTime();
                if (remaining <= 0) {
                    break;
                }
                try {
                    Thread.sleep(TimeUnit.NANOSECONDS.toMillis(remaining));
                } catch (InterruptedException e) {
                    threadInterrupted = true;
                }
            } while (remaining > 0);
        } finally {
            if (threadInterrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static String getTrackingTagString(List<TrackingTag> trackingTags) {
        if (isNotEmpty(trackingTags)) {
            TrackingTag trackingTag = trackingTags.get(0);
            return trackingTag.getTrackingPartner() + "-" + trackingTag.getTrackingTag();
        }

        return null;
    }

}
