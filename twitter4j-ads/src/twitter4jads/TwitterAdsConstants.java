package twitter4jads;

import java.util.concurrent.TimeUnit;

/**
 * User: poly
 * Date: 13/03/14
 * Time: 11:52 AM
 */
public interface TwitterAdsConstants {

    String CURRENT_VERSION = "7";

    String PREFIX_ACCOUNTS_URI = CURRENT_VERSION + "/accounts/";
    String AUTHENTICATED_USER_ACCESS = "/authenticated_user_access";
    String PREFIX_BATCH_URI = CURRENT_VERSION + "/batch/";
    String UPLOAD_MEDIA_URL = "/media/";
    String UPLOAD_JSON = "upload.json";
    String PREFIX_BATCH_ACCOUNTS_URI = CURRENT_VERSION + "/batch/accounts/";
    String PREFIX_STATS_ACCOUNTS_URI = CURRENT_VERSION + "/stats/accounts/";
    String PREFIX_STATS_JOB_ACCOUNTS_URI = CURRENT_VERSION + "/stats/jobs/accounts/";
    String PARAM_WITH_DELETED = "with_deleted";
    String PARAM_WITH_TOTAL_COUNT = "with_total_count";
    String GRANULARITY = "granularity";
    String PARAM_FUNDING_INSTRUMENT_IDS = "funding_instrument_ids";
    String PARAM_CAMPAIGN_IDS = "campaign_ids";
    String PARAM_LINE_ITEM_IDS = "line_item_ids";
    String PARAM_LINE_ITEM_ID = "line_item_id";
    String PARAM_ACCOUNT_MEDIA_ID = "account_media_id";
    String PARAM_LANDING_URL = "landing_url";
    String PARAM_TV_MARKET_LOCALE = "tv_market_locale ";
    String PARAM_COUNT = "count";
    String PARAM_CURSOR = "cursor";
    String PARAM_SORT_BY = "sort_by";
    String PARAM_Q = "q";
    String PARAM_COUNTRY_CODE = "country_code";
    String PARAM_LOCATION_TYPE = "location_type";
    String PARAM_TARGETING_TYPE = "targeting_type";
    String PARAM_TARGETING_VALUE = "targeting_value";
    String PARAM_SCHEDULED_PROMOTED_TWEET_IDS = "scheduled_promoted_tweet_ids";
    @Deprecated
    String PARAM_TAILORED_AUDIENCE_EXPANSION = "tailored_audience_expansion";
    @Deprecated
    String PARAM_TAILORED_AUDIENCE_TYPE = "tailored_audience_type";
    String PARAM_PROMOTED_ACCOUNTS_IDS = "promoted_account_ids";
    String PARAM_ACCOUNT_ID = "account_id";
    String PARAM_CALL_TO_ACTION = "call_to_action";
    String PARAM_CALL_TO_ACTION_URL = "call_to_action_url";
    String PARAM_CREATIVE_TYPE = "creative_type";
    String PARAM_CURRENCY = "currency";
    String PARAM_TWEET_IDS = "tweet_ids";
    String PARAM_SCHEDULED_TWEET_ID = "scheduled_tweet_id";
    String PARAM_USER_ID = "user_id";
    String PARAM_NULLCAST = "nullcast";
    @Deprecated
    String PARAM_MEDIA_IDS = "media_ids";
    String PARAM_SCHEDULED_AT = "scheduled_at";
    String PARAM_CARD_URI = "card_uri";
    String PARAM_AS_USER_ID = "as_user_id";
    String PARAM_SCOPED_TO = "scoped_to";
    String PARAM_DAILY_BUDGET_AMOUNT_LOCAL_MICRO = "daily_budget_amount_local_micro";
    String PARAM_TOTAL_BUDGET_AMOUNT_LOCAL_MICRO = "total_budget_amount_local_micro";
    String PARAM_STANDARD_DELIVERY = "standard_delivery";
    String PARAM_FREQUENCY_CAP = "frequency_cap";
    String PARAM_DURATION_IN_DAYS = "duration_in_days";
    String PARAM_ENTITY_STATUS = "entity_status";
    String PARAM_AUDIENCE_EXPANSION = "audience_expansion";
    String PARAM_END_TIME = "end_time";
    String PARAM_START_TIME = "start_time";
    String PARAM_ENTITY_TYPE = "entity";
    String PARAM_JOB_IDS = "job_ids";
    String PARAM_ENTITY_IDS = "entity_ids";
    String PARAMS_PLACEMENT = "placement";
    String PARAM_FUNDING_INSTRUMENT_ID = "funding_instrument_id";
    String PARAM_NAME = "name";
    String PARAM_CAMPAIGN_ID = "campaign_id";
    String PARAM_TEXT = "text";
    String PARAM_BID_AMOUNT_LOCAL_MICRO = "bid_amount_local_micro";
    String PARAM_TARGET_CPA_LOCAL_MICRO = "target_cpa_local_micro";
    String PARAM_BID_TYPE = "bid_type";
    String PARAM_BID_UNIT = "bid_unit";
    String PARAM_OPTIMIZATION = "optimization";
    String PARAM_CHARGE_BY = "charge_by";
    String PARAM_PRODUCT_TYPE = "product_type";
    String PARAM_PLACEMENTS = "placements";
    String PARAM_MATCH_RELEVANT_POPULAR_QUERIES = "match_relevant_popular_queries";
    String PARAM_OBJECTIVE = "objective";
    String BID_AMOUNT_LOCAL_MICRO = "bid_amount_local_micro";
    String CURRENCY = "currency";
    String CAMPAIGN_DAILY_BUDGET_AMOUNT_LOCAL_MICRO = "campaign_daily_budget_amount_local_micro";
    String BID_TYPE = "bid_type";

    String PARAM_INCLUDE_SENTIMENT = "include_sentiment";
    String PARAM_SUGGESTION_TYPE = "suggestion_type";
    String PARAM_IGNORED_VALUES = "ignored_values";
    String PARAM_TARGETING_VALUES = "targeting_values";
    String PARAM_LOCATIONS = "locations";
    String PARAM_FOLLOWERS_OF_USERS = "followers_of_users";
    String PARAM_SIMILAR_TO_FOLLOWERS_OF_USERS = "similar_to_followers_of_users";
    String PARAM_INTERESTS = "interests";
    String PARAM_PLATFORMS = "platforms";
    String PARAM_PLATFORM_VERSIONS = "platform_versions";
    String PARAM_CONVERSATIONS = "conversations";
    String PARAM_DEVICES = "devices";
    String PARAM_WIFI_ONLY = "wifi_only";
    String PARAM_GENDER = "gender";
    String PARAM_TV_SHOWS = "tv_shows";
    String PARAM_TV_CHANNEL = "tv_channels";
    String PARAM_TV_GENRE = "tv_genres";
    String PARAM_NETWORK_OPERATOR = "network_operators";
    String PARAM_BROAD_KEYWORDS = "broad_keywords";
    String PARAM_EXACT_KEYWORDS = "exact_keywords";
    String PARAM_UNORDERED_KEYWORDS = "unordered_keywords";
    String PARAM_PHRASE_KEYWORDS = "phrase_keywords";
    String PARAM_NEGATIVE_EXACT_KEYWORDS = "negative_exact_keywords";
    String PARAM_NEGATIVE_UNORDERED_KEYWORDS = "negative_unordered_keywords";
    String PARAM_NEGATIVE_PHRASE_KEYWORDS = "negative_phrase_keywords";
    String PARAM_TAILORED_AUDIENCES = "tailored_audiences";
    String PARAM_TAILORED_AUDIENCES_EXPANDED = "tailored_audiences_expanded";
    String PARAM_TAILORED_AUDIENCES_EXCLUDED = "tailored_audiences_excluded";
    String PARAM_LANGUAGES = "languages";
    String PARAM_AGE_RANGE = "age_buckets";
    String PARAM_BEHAVIOR = "behaviors";
    String PARAM_NEGATIVE_BEHAVIOR = "negative_behaviors";
    String PARAM_BEHAVIOR_EXPANDED = "behaviors_expanded";
    String PARAM_PARENT_BEHAVIOR_TAXONOMY_IDS = "parent_behavior_taxonomy_ids";
    String PARAM_CARD_IDS = "card_ids";
    String PARAM_IPHONE_APP_ID = "iphone_app_id";
    String PARAM_IPAD_APP_ID = "ipad_app_id";
    String PARAM_GOOGLEPLAY_APP_ID = "googleplay_app_id";
    String PARAM_IPHONE_DEEP_LINK = "iphone_deep_link";
    String PARAM_IPAD_DEEP_LINK = "ipad_deep_link";
    String PARAM_GOOGLEPLAY_DEEP_LINK = "googleplay_deep_link";
    String PARAM_CUSTOM_APP_DESCRIPTION = "custom_app_description";
    String PARAM_ID = "id";
    String PARAM_APP_STORE_IDENTIFIER = "app_store_identifier";
    String PARAM_OS_TYPE = "os_type";
    String PARAM_LINE_ITEM_APP_IDS = "line_item_app_ids";
    @Deprecated
    String PARAM_WIDE_APP_IMAGE_MEDIA_ID = "wide_app_image_media_id";
    String PARAM_CUSTOM_ICON_MEDIA_ID = "custom_icon_media_id";
    String APP_CTA = "app_cta";
    String PARAM_PRIMARY_WEB_EVENT_TAG = "primary_web_event_tag";
    String PATH_FEATURES = "/features";

    /**
     * For Twitter Audience Platform
     */
    String PATH_IAB_CATEGORIES = CURRENT_VERSION + "/iab_categories/";
    String PATH_APP_LIST = "/app_lists/";
    String PARAM_ADVERTISER_DOMAIN = "advertiser_domain";
    String PARAM_ADDITIONAL_OWNERS = "additional_owners";
    String PARAM_ATTRIBUTABLE_USER_ID = "attributable_user_id";
    String PARAM_CATEGORIES = "categories";
    String PARAM_APP_STORE_IDENTIFIERS = "app_store_identifiers";
    String PARAM_EXCLUDE_APP_LIST_IDENTIFIER = "exclude_app_list";
    String USERS = "users";

    //Added for Tweet engagement retargeting
    String PARAM_ENGAGEMENT_TYPE = "engagement_type";
    String PARAM_USER_ENGAGEMENT = "user_engagement";
    String PARAM_CAMPAIGN_ENGAGEMENT = "campaign_engagement";

    String PARAM_APP_STORE_CATEGORY = "app_store_categories";
    String PARAM_APP_STORE_CATEGORY_LOOKALIKE = "app_store_categories_lookalike";
    String PARAM_APP_STORE_CATEGORY_EXPANDED = "app_store_categories_expanded";

    String PARAM_EVENT = "event";

    //Added for Network activation targeting
    String PARAM_NETWORK_ACTIVATION_DURATION_LT = "network_activation_duration_lt";
    String PARAM_NETWORK_ACTIVATION_DURATION_GTE = "network_activation_duration_gte";

    /**
     * for website cards
     */
    String PARAM_WEBSITE_URL = "website_url";
    String PARAM_WEBSITE_TITLE = "website_title";
    @Deprecated
    String PARAM_IMAGE_MEDIA_ID = "image_media_id";
    /**
     * for lead generation cards
     */
    String PARAM_TITLE = "title";
    /*
     for video app download card
     */
    @Deprecated
    String PARAM_VIDEO_ID = "video_id"; //in v6 see media_keys, media_key instead
    @Deprecated
    String PARAM_VIDEO_MEDIA_ID = "video_media_id";
    @Deprecated
    String PARAM_VIDEO_IDS = "video_ids";
    String PARAM_COMMAND = "command";
    //deprecated in API v6, but still used for chunked upload endpoint
    String PARAM_MEDIA_ID = "media_id";
    String PARAM_MEDIA_KEY = "media_key";
    String PARAM_MEDIA_DATA = "media_data";
    String PARAM_MEDIA_TYPE = "media_type";
    //deprecated in API v6, but still used for chunked upload endpoint
    String PARAM_MEDIA_CATEGORY = "media_category";
    String PARAM_SHARED = "shared";
    String PARAM_TOTAL_BYTES = "total_bytes";
    String PARAM_SEGMENT_INDEX = "segment_index";
    String STATE_SUCCEEDED = "succeeded";
    String STATE_IN_PROGRESS = "in_progress";
    String PARAM_POSTER_IMAGE_ID = "poster_image_media_id";
    @Deprecated
    String PARAM_POSTER_IMAGE_KEY = "poster_image_media_key";
    String PARAM_POSTER_MEDIA_KEY = "poster_media_key";

    /*
    for direct message cards
    */

    String PARAM_RECIPIENT_USER_ID = "recipient_user_id";
    String PARAM_FIRST_CTA_WELCOME_MESSAGE_ID = "first_cta_welcome_message_id";
    String PARAM_SECOND_CTA_WELCOME_MESSAGE_ID = "second_cta_welcome_message_id";
    String PARAM_THIRD_CTA_WELCOME_MESSAGE_ID = "third_cta_welcome_message_id";
    String PARAM_FOURTH_CTA_WELCOME_MESSAGE_ID = "fourth_cta_welcome_message_id";
    /*
    for conversation cards
     */

    String PARAM_FIRST_CTA = "first_cta";
    String PARAM_FIRST_CTA_TWEET = "first_cta_tweet";
    String PARAM_SECOND_CTA = "second_cta";
    String PARAM_SECOND_CTA_TWEET = "second_cta_tweet";
    String PARAM_THIRD_CTA = "third_cta";
    String PARAM_THIRD_CTA_TWEET = "third_cta_tweet";
    String PARAM_FOURTH_CTA = "fourth_cta";
    String PARAM_FOURTH_CTA_TWEET = "fourth_cta_tweet";
    String PARAM_THANK_YOU_TEXT = "thank_you_text";
    String PARAM_THANK_YOU_URL = "thank_you_url";

    String PARAM_VIDEO_TITLE = "video_title";
    String PARAM_VIDEO_DESCRIPTION = "video_description";
    String PARAM_VIDEO_CTA = "video_cta";
    String PARAM_VIDEO_CTA_VALUE = "video_cta_value";

    Long MAX_IMAGE_SIZE_FOR_TWITTER_IN_BYTES = 5242775L;//5MB
    Long MAX_VIDEO_SIZE_IN_BYTES = 524277511L; // 500 MB.
    Long MAX_IMAGE_SIZE_FOR_WEBSITE_IN_BYTES = 3 * 1040000L; //1 Megabyte
    int TWO_MIB = 2 * 1024 * 1024;
    Long FIFTY_MIB = 50 * 1024 * 1024L;
    Long ONE_HUNDRED_FIFTY_MIB = 150 * 1024 * 1024L;
    Long FIVE_HUNDRED_MIB = 500 * 1024 * 1024L;
    int SUCCESSFULL_CALL_BEGIN_CODE = 200;
    int SUCCESSFULL_CALL_END_CODE = 299;
    long WAIT_INTERVAL_TRANSCODING = TimeUnit.SECONDS.toMillis(5);
    long WAIT_INTERVAL = TimeUnit.MINUTES.toMillis(2);
    long MAX_WAIT_INTERVAL_FIFTY_MIB = TimeUnit.MINUTES.toMillis(10);
    long MAX_WAIT_INTERVAL_ONE_HUNDRED_FIFTY_MIB = TimeUnit.MINUTES.toMillis(15);
    long MAX_WAIT_INTERVAL_FIVE_HUNDRED_MIB = TimeUnit.MINUTES.toMillis(45);
    long MAX_VIDEO_WEBSITE_CARD_NAME_LENGTH = 80L;
    long MAX_VIDEO_WEBSITE_CARD_TITLE_LENGTH = 70L;
    int TAILORED_AUDIENCE_UPDATE_BATCH_SIZE = 2500;
    int MAX_LINE_ITEM_IDS_REQUEST_SIZE = 200;

    /**
     * for lead generation card stat
     */
    String PARAM_METRICS_GROUPS = "metric_groups";

    String PARAM_SEGMENTATION_TYPE = "segmentation_type";
    String PATH_CAMPAIGN = "/campaigns/";
    String PATH_FUNDING_INSTRUMENTS = "/funding_instruments/";
    String PATH_BIDDING_RULES = CURRENT_VERSION + "/bidding_rules";
    String PATH_PROMOTED_TWEETS = "/promoted_tweets/";
    String PATH_SCHEDULED_TWEETS = "/scheduled_tweets/";
    String PATH_SCHEDULED_PROMOTED_TWEETS = "/scheduled_promoted_tweets/";
    String PATH_PROMOTED_ACCOUNTS = "/promoted_accounts/";
    String PATH_PROMOTABLE_USERS = "/promotable_users/";
    String PATH_REACH_ESTIMATE = "/reach_estimate/";
    String PATH_LINE_ITEMS = "/line_items/";
    String PATH_TARGETING_CRITERIA = "/targeting_criteria/";
    String PATH_TARGETING_CRITERIA_LOCATION = CURRENT_VERSION + "/targeting_criteria/locations";
    String PATH_TARGETING_CRITERIA_INTERESTS = CURRENT_VERSION + "/targeting_criteria/interests";
    String PATH_TARGETING_CRITERIA_PLATFORMS = CURRENT_VERSION + "/targeting_criteria/platforms";
    String PATH_TARGETING_CRITERIA_PLATFORM_VERSIONS = CURRENT_VERSION + "/targeting_criteria/platform_versions";
    String PATH_TARGETING_CRITERIA_CONVERSATIONS = CURRENT_VERSION + "/targeting_criteria/conversations";
    String PATH_TARGETING_CRITERIA_DEVICES = CURRENT_VERSION + "/targeting_criteria/devices";
    String PATH_TARGETING_CRITERIA_APP_STORE_CATEGORIES = CURRENT_VERSION + "/targeting_criteria/app_store_categories";
    String PATH_TARGETING_CRITERIA_NETWORK_OPERATORS = CURRENT_VERSION + "/targeting_criteria/network_operators/";
    String PATH_TARGETING_CRITERIA_EVENT = CURRENT_VERSION + "/targeting_criteria/events";
    String PATH_TARGETING_LANGUAGES = CURRENT_VERSION + "/targeting_criteria/languages";
    String PATH_TAILORED_AUDIENCES = "/tailored_audiences";
    String PATH_TARGETING_SUGGESTIONS = "/targeting_suggestions/";
    String PATH_TV_SHOWS = CURRENT_VERSION + "/targeting_criteria/tv_shows/";
    String PATH_TV_MARKETS = CURRENT_VERSION + "/targeting_criteria/tv_markets/";
    String PATH_TV_CHANNELS = CURRENT_VERSION + "/targeting_criteria/tv_channels/";
    String PATH_TV_GENRES = CURRENT_VERSION + "/targeting_criteria/tv_genres/";
    String PATH_BEHAVIORS = CURRENT_VERSION + "/targeting_criteria/behaviors/";
    String PATH_BEHAVIORS_TAXONOMY = CURRENT_VERSION + "/targeting_criteria/behavior_taxonomies/";
    String PATH_IMAGE_APP_DOWNLOAD_CARDS = "/cards/image_app_download/";
    String PATH_VIDEO_APP_DOWNLOAD_CARDS = "/cards/video_app_download/";
    String PATH_IMAGE_CONVERSATION_CARDS = "/cards/image_conversation/";
    String PATH_VIDEO_CONVERSATION_CARDS = "/cards/video_conversation/";
    String PATH_IMAGE_DM_CARDS = "/cards/image_direct_message/";
    String PATH_VIDEO_DM_CARDS = "/cards/video_direct_message/";
    String PATH_VIDEO_WEBSITE_CARDS = "/cards/video_website/";
    String PATH_WEBSITE_CARDS = "/cards/website/";
    @Deprecated
    String PATH_SCOPED_TIMELINE = "/scoped_timeline/";
    String PATH_ACCOUNT_MEDIA = "/account_media";
    String PATH_ACCOUNTS = "accounts/";
    String PATH_MEDIA_CREATIVES = "/media_creatives";
    String PATH_MEDIA_LIBRARY = "/media_library";
    String PRE_ROLL_CALL_TO_ACTION = "/preroll_call_to_actions";
    String PATH_LINE_ITEM_APPS = "/line_item_apps";
    String PATH_ACTIVE_ENTITIES = "/active_entities";
    String PATH_UNIFIED_CARDS = "/cards";
    String PATH_PROMOTED_VIDEO_TWEET = "/tweet";
    String PATH_PROMOTED_TWEET_V2 = "/tweet";

    String PATH_TAILORED_AUDIENCE = "/tailored_audiences/";
    @Deprecated
    String PATH_TAILORED_AUDIENCE_CHANGES = "/tailored_audience_changes/";
    String PATH_TAILORED_AUDIENCE_PERMISSIONS = "/permissions/";
    String PATH_TAILORED_AUDIENCE_MATCHING_RULES = "/tailored_audience_matching_rules/";

    String POST_TON_DATA = "https://ton.twitter.com/1.1/ton/bucket/ta_partner";
    String PARAM_DESCRIPTION = "description";
    String PARAM_FILE_NAME = "file_name";

    /**
     * for tracking tag
     */
    String PARAM_TRACKING_TAGS = "tracking_tags";

    /**
     * for web event tags
     */

    String PARAM_CLICK_WINDOW = "click_window";
    String PARAM_VIEW_THROUGH_WINDOW = "view_through_window";
    String PARAM_TYPE = "type";
    String PARAM_RETARGETING_ENABLED = "retargeting_enabled";

    String PATH_WEB_EVENT_TAGS = "/web_event_tags/";
    String PATH_WEBSITE_TAGS = "/website_tags/";
    String TAG_TYPE = "tag_type";

    String PATH_REACH_STATS = "/reach/campaigns/";
    String SLASH = "/";

    /**
     * for Twitter preview
     */

    String TWEET_PATH_PREVIEW = "/tweet/preview/";
    String PARAM_PREVIEW_TARGET = "preview_target";
    String PARAM_TWEET_TYPE = "tweet_type";
    String PARAM_TWEET_MODE = "tweet_mode";
    String TWEET_PATH_PREVIEW_NEW = "/tweet_previews/";

    /**
     * For Tweets endpoint
     */
    String PATH_TWEETS = "/tweets";
    String PATH_TWEET = "/tweet";
    String PARAM_INCLUDE_MENTIONS_AND_REPLIES = "include_mentions_and_replies";
    String PARAM_TIMELINE_TYPE = "timeline_type";
    String PARAM_TRIM_USER = "trim_user";
    String PARAM_MEDIA_KEYS = "media_keys";
    String PARAM_LOCALE = "locale";
    String PARAM_OPERATOR_TYPE = "operator_type";
    String COMPATIBILITY_TWEET_MODE = "compat";
    String EXTENDED_TWEET_MODE = "extended";

    String ACCOUNT_ID = "Account Id";
    String LINE_ITEM_ID = "Line Item Id";
    String CARD_ID = "Card Id";

    String GENDER_MALE_OLD_VALUE = "1";
    String GENDER_FEMALE_OLD_VALUE = "2";
    String GENDER_MALE_NEW_VALUE = "MALE";
    String GENDER_FEMALE_NEW_VALUE = "FEMALE";
}
