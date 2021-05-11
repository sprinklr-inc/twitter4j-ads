package twitter4jads.models.ads.targeting;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import twitter4jads.models.ads.TargetingType;
import twitter4jads.util.TwitterAdUtil;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * User: abhishekanand
 * Date: 02/07/16 12:52 AM.
 */
public enum TwitterTargetingOperator {

    EQ,
    GTE(TargetingType.PLATFORM_VERSION, TargetingType.NETWORK_ACTIVATION_DURATION_GTE),
    NE(TargetingType.CONTENT_PUBLISHER_USER, TargetingType.TAILORED_AUDIENCES_EXCLUDED, TargetingType.NEGATIVE_BEHAVIOR,
            TargetingType.NEGATIVE_EXACT_KEYWORD, TargetingType.NEGATIVE_PHRASE_KEYWORD, TargetingType.NEGATIVE_UNORDERED_KEYWORD,
            TargetingType.EXCLUDE_APP_LIST, TargetingType.EXCLUDED_IAB_CATEGORY),
    LT(TargetingType.NETWORK_ACTIVATION_DURATION_LT);

    private static final Map<TargetingType, TwitterTargetingOperator> OPERATOR_TYPE_MAP;

    static {
        Map<TargetingType, TwitterTargetingOperator> operatorTypeMap = Maps.newHashMap();
        for (TwitterTargetingOperator twitterTargetingOperator : TwitterTargetingOperator.values()) {
            Set<TargetingType> targetingTypes = twitterTargetingOperator.getTargetingTypeSet();
            if (TwitterAdUtil.isNotEmpty(targetingTypes)) {
                for (TargetingType targetingType : targetingTypes) {
                    operatorTypeMap.put(targetingType, twitterTargetingOperator);
                }
            }
        }

        OPERATOR_TYPE_MAP = Collections.unmodifiableMap(operatorTypeMap);
    }

    private final Set<TargetingType> targetingTypeSet;

    TwitterTargetingOperator(TargetingType... targetingTypes) {
        this.targetingTypeSet = Sets.newHashSet(targetingTypes);
    }

    public static TwitterTargetingOperator getOperatorType(TargetingType targetingType) {
        TwitterTargetingOperator operatorType = OPERATOR_TYPE_MAP.get(targetingType);
        if (operatorType == null) {
            operatorType = EQ;
        }
        return operatorType;
    }

    public Set<TargetingType> getTargetingTypeSet() {
        return targetingTypeSet;
    }

}
