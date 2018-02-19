package twitter4jads.models.ads;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.Map;

/**
 * User: abhishekanand
 * Date: 18/04/16 12:19 PM.
 */
public enum TwitterAccountPermissions {

    AGE_TARGETING,
    BRAND_TPN,
    CPI_CHARGING,
    INSTALLED_APP_CATEGORY_TARGETING,
    MOBILE_CONVERSION_TRANSACTION_VALUE,
    OPTIMIZED_ACTION_BIDDING,
    OPTIMIZED_WEBSITE_CONVERSION,
    VIDEO_VIEWS_OBJECTIVE,
    REACH_AND_FREQUENCY_ANALYTICS,
    ALLOW_SKIPPABLE_VIDEOS_FOR_VIDEO_VIEWS_PREROLL_OBJECTIVE,
    VIDEO_APP_DOWNLOAD_CARD,
    EVENT_TARGETING, ENGAGER_RETARGETING, DR_TAP, QUALIFIED_IMPRESSIONS_OBJECTIVE,
    VIDEO_VIEWS_PREROLL_OBJECTIVE;

    private static final Map<String, TwitterAccountPermissions> KEY_TO_PERMISSION;

    static {
        Map<String, TwitterAccountPermissions> keyToPermissions = Maps.newHashMap();
        for (TwitterAccountPermissions twitterAccountPermissions : TwitterAccountPermissions.values()) {
            keyToPermissions.put(twitterAccountPermissions.name(), twitterAccountPermissions);
        }
        KEY_TO_PERMISSION = Collections.<String, TwitterAccountPermissions>unmodifiableMap(keyToPermissions);
    }

    public static TwitterAccountPermissions getAccountPermission(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return KEY_TO_PERMISSION.get(key);
    }
}
