package twitter4jads.models.video;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * User: abhishekanand
 * Date: 19/04/16 5:46 PM.
 */
public enum TwitterCallToActionType {

    VISIT_SITE,
    WATCH_NOW;

    private static final Map<String, TwitterCallToActionType> NAME_TO_CALL_TO_ACTION;

    static {
        Map<String, TwitterCallToActionType> map = Maps.newHashMap();
        for (TwitterCallToActionType type : TwitterCallToActionType.values()) {
            map.put(type.name(), type);
        }
        NAME_TO_CALL_TO_ACTION = Collections.unmodifiableMap(map);
    }

    public static TwitterCallToActionType getCallToAction(String name) {
        return NAME_TO_CALL_TO_ACTION.get(name);
    }


    }
