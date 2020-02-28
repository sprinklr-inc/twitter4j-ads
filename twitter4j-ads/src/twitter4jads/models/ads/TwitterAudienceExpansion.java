package twitter4jads.models.ads;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * User:  dheeraj
 * Date:  19/12/17.
 */
public enum TwitterAudienceExpansion {
    DEFINED("Defined", "Lookalikes that most closely match your audience features", "DEFINED"),
    EXPANDED("Expanded", " Lookalikes from defined and people that somewhat match your audience features", "EXPANDED"),
    BROAD("Broad", "Lookalikes from defined and expanded, along with people loosely-related to your audience features", "BROAD"),
    NO_EXPANSION("No Expansion", "No expansion of your audience", "NO_EXPANSION");

    public static final Map<String, TwitterAudienceExpansion> NAME_ON_CHANNEL_TO_ENUM = Maps.newHashMap();
    public static final Map<String, TwitterAudienceExpansion> DISPLAY_NAME_TO_ENUM = Maps.newHashMap();
    public static final String FIELD_DISPLAY_NAME = "Expand your audience";

    static {
        for (TwitterAudienceExpansion twitterAudienceExpansion : TwitterAudienceExpansion.values()) {
            NAME_ON_CHANNEL_TO_ENUM.put(twitterAudienceExpansion.getChannelName(), twitterAudienceExpansion);
            DISPLAY_NAME_TO_ENUM.put(twitterAudienceExpansion.getDisplayName().toLowerCase(), twitterAudienceExpansion);
        }
    }

    private final String displayName;
    private final String description;
    private final String channelName;

    TwitterAudienceExpansion(String displayName, String description, String channelName) {
        this.description = description;
        this.displayName = displayName;
        this.channelName = channelName;
    }

    public static TwitterAudienceExpansion getEnumFromChannelName(String channelName) {
        return NAME_ON_CHANNEL_TO_ENUM.get(channelName);
    }

    public static TwitterAudienceExpansion getEnumFromDisplayName(String displayName) {
        return DISPLAY_NAME_TO_ENUM.get(displayName.toLowerCase());
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public String getChannelName() {
        return channelName;
    }
}
