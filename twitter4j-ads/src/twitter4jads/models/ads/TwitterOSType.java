package twitter4jads.models.ads;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * User: abhishekanand
 * Date: 10/02/17 4:48 PM.
 */
public enum TwitterOSType {
    IOS, ANDROID;

    private static final Map<String, TwitterOSType> NAME_TO_OS_TYPE;

    static {
        Map<String, TwitterOSType> nameToOs = Maps.newHashMap();
        for (TwitterOSType twitterOSType : TwitterOSType.values()) {
            nameToOs.put(twitterOSType.name(), twitterOSType);
        }
        NAME_TO_OS_TYPE = Collections.unmodifiableMap(nameToOs);
    }


    public static TwitterOSType getFromName(String name) {
        return NAME_TO_OS_TYPE.get(name);
    }


}
