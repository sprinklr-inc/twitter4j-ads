package twitter4jads.models.ads;

/**
 * User: poly
 * Date: 30/01/14
 * Time: 11:51 AM
 */
public enum TargetingType {
    //specify if its negative targeting, this is for batch targeting
    LOCATION,
    FOLLOWERS_OF_USER,
    SIMILAR_TO_FOLLOWERS_OF_USER,
    INTEREST,
    PLATFORM,
    PLATFORM_VERSION,
    DEVICE,
    WIFI_ONLY,
    GENDER,
    TV_SHOW,
    TV_CHANNEL,
    TV_GENRE,
    TV_AD_TARGETING,
    TV_MARKET,
    BROAD_KEYWORD,
    UNORDERED_KEYWORD,
    PHRASE_KEYWORD,
    EXACT_KEYWORD,
    @Deprecated
    NEGATIVE_PHRASE_KEYWORD(true, PHRASE_KEYWORD),
    @Deprecated
    NEGATIVE_UNORDERED_KEYWORD(true, UNORDERED_KEYWORD),
    @Deprecated
    NEGATIVE_EXACT_KEYWORD(true, EXACT_KEYWORD),
    TAILORED_AUDIENCE,
    TAILORED_AUDIENCES_EXCLUDED(true, TAILORED_AUDIENCE),
    FLEXIBLE_TAILORED_AUDIENCE,
    //this is for batch targeting
    TAILORED_AUDIENCE_EXPANDED,
    LANGUAGE,
    TAILORED_AUDIENCES_EXPANDED(false, TAILORED_AUDIENCE_EXPANDED),
    RTB_APP_CATEGORY,
    NETWORK_OPERATOR,
    NETWORK_ACTIVATION_DURATION,//this is for batch targeting
    @Deprecated
    NETWORK_ACTIVATION_DURATION_LT(false, NETWORK_ACTIVATION_DURATION),
    @Deprecated
    NETWORK_ACTIVATION_DURATION_GTE(false, NETWORK_ACTIVATION_DURATION),
    AGE,
    BEHAVIOR,
    @Deprecated
    NEGATIVE_BEHAVIOR(true, BEHAVIOR),
    BEHAVIOR_EXPANDED,
    TV_SHOW_AIRING_RESTRICTED,
    APP_STORE_CATEGORY,
    APP_STORE_CATEGORY_LOOKALIKE,
    APP_STORE_CATEGORY_EXPANDED,
    ENGAGEMENT_TYPE,
    CAMPAIGN_ENGAGEMENT,
    //read response from Twitter for exclude_app_list is CUSTOM_APP_LIST with operator_type NE
    CUSTOM_APP_LIST,
    //batch request to Twitter for exclude_app_list is expected as APP_LIST with operator_type NE
    APP_LIST,
    @Deprecated
    EXCLUDE_APP_LIST(true, APP_LIST),
    USER_ENGAGEMENT,
    EVENT,
    CONTENT_PUBLISHER_USER,
    CONVERSATION,
    IAB_CATEGORY,
    EXCLUDED_IAB_CATEGORY(true, IAB_CATEGORY);

    private final boolean isNegativeTargeting;
    private final TargetingType negativeOf;
    private final TargetingType valueForBatchType;

    TargetingType() {
        this(false, null, null);
    }

    TargetingType(boolean isNegativeTargeting, TargetingType negativeOf, TargetingType valueForBatchType) {
        this.isNegativeTargeting = isNegativeTargeting;
        this.negativeOf = negativeOf;
        this.valueForBatchType = valueForBatchType;
    }

    TargetingType(boolean isNegativeTargeting, TargetingType targetingType) {
        this(isNegativeTargeting, targetingType, targetingType);
    }

    TargetingType(boolean isNegativeTargeting) {
        this(isNegativeTargeting, null, null);
    }

    public boolean isNegativeTargeting() {
        return isNegativeTargeting;
    }

    public TargetingType getNegativeOf() {
        return negativeOf;
    }

    public TargetingType getValueForBatchType() {
        return valueForBatchType;
    }

}
