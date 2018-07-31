package twitter4jads.models.ads;

/**
 * User: npurwar
 * Date: 04/05/15
 * Time: 1:52 PM
 */
public enum Placement {
    // Supported
    ALL_ON_TWITTER,
    PUBLISHER_NETWORK,

    // Not supported from v1.0 (Stats)
    TWITTER_SEARCH,
    TWITTER_TIMELINE,
    TWITTER_PROFILE,

    TAP_MRECT,
    //TAP
    TAP_NATIVE,
    TAP_FULL_LANDSCAPE,
    TAP_TABLET_LEADERBOARD,
    TAP_TABLET_FULL,
    TAP_TABLET_FULL_LANDSCAPE,
    TAP_BANNER,
    TAP_FULL
}
