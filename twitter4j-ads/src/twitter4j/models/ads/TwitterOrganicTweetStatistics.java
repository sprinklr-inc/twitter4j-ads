package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;
import twitter4j.models.Granularity;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * User: ekanshmittal
 Date: 12/05/15
 Time: 12:46 PM
 */
public class TwitterOrganicTweetStatistics extends TwitterEntity {
    private static final String START_TIME = "start_time";
    private static final String GRANULARITY = "granularity";
    private static final String END_TIME = "end_time";

    public static final Set<String> ORGANIC_METRICS;

    public static final String ORGANIC_TWEET_APP_INSTALL_ATTEMPTS = "organic_tweet_app_install_attempts";
    public static final String ORGANIC_TWEET_APP_OPENS = "organic_tweet_app_opens";
    public static final String ORGANIC_TWEET_CLICKS = "organic_tweet_clicks";
    public static final String ORGANIC_TWEET_DETAIL_EXPANDS = "organic_tweet_detail_expands";
    public static final String ORGANIC_TWEET_ENGAGEMENT_RATE = "organic_tweet_engagement_rate";
    public static final String ORGANIC_TWEET_ENGAGEMENTS = "organic_tweet_engagements";
    public static final String ORGANIC_TWEET_FAVORITES = "organic_tweet_favorites";
    public static final String ORGANIC_TWEET_FOLLOWS = "organic_tweet_follows";
    public static final String ORGANIC_TWEET_IMPRESSIONS = "organic_tweet_impressions";
    public static final String ORGANIC_TWEET_REPLIES = "organic_tweet_replies";
    public static final String ORGANIC_TWEET_RETWEETS = "organic_tweet_retweets";
    public static final String ORGANIC_TWEET_URL_CLICKS = "organic_tweet_url_clicks";

    static {
        Set<String> organicMetrics = com.google.common.collect.Sets.newHashSet(ORGANIC_TWEET_APP_INSTALL_ATTEMPTS, ORGANIC_TWEET_APP_OPENS, ORGANIC_TWEET_CLICKS, ORGANIC_TWEET_DETAIL_EXPANDS,
                                                     ORGANIC_TWEET_ENGAGEMENT_RATE, ORGANIC_TWEET_ENGAGEMENTS, ORGANIC_TWEET_FAVORITES, ORGANIC_TWEET_FOLLOWS,
                                                     ORGANIC_TWEET_IMPRESSIONS, ORGANIC_TWEET_REPLIES, ORGANIC_TWEET_RETWEETS, ORGANIC_TWEET_URL_CLICKS);
        ORGANIC_METRICS = Collections.unmodifiableSet(organicMetrics);
    }

    @SerializedName(START_TIME)
    private Date startTime;

    @SerializedName(GRANULARITY)
    private Granularity granularity;

    @SerializedName(END_TIME)
    private Date endTime;

    @SerializedName(ORGANIC_TWEET_APP_INSTALL_ATTEMPTS)
    private String[] organicTweetAppInstallAttempts;

    @SerializedName(ORGANIC_TWEET_APP_OPENS)
    private String[] organicTweetAppOpens;

    @SerializedName(ORGANIC_TWEET_CLICKS)
    private String[] organicTweetClicks;

    @SerializedName(ORGANIC_TWEET_DETAIL_EXPANDS)
    private String[] organicTweetDetailExpands;

    @SerializedName(ORGANIC_TWEET_ENGAGEMENT_RATE)
    private String[] organicTweetEngagementRate;

    @SerializedName(ORGANIC_TWEET_ENGAGEMENTS)
    private String[] organicTweetEngagements;

    @SerializedName(ORGANIC_TWEET_FAVORITES)
    private String[] organicTweetFavorites;

    @SerializedName(ORGANIC_TWEET_FOLLOWS)
    private String[] organicTweetFollows;

    @SerializedName(ORGANIC_TWEET_IMPRESSIONS)
    private String[] organicTweetImpressions;

    @SerializedName(ORGANIC_TWEET_REPLIES)
    private String[] organicTweetReplies;

    @SerializedName(ORGANIC_TWEET_RETWEETS)
    private String[] organicTweetRetweets;

    @SerializedName(ORGANIC_TWEET_URL_CLICKS)
    private String[] organicTweetUrlClicks;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    public void setGranularity(Granularity granularity) {
        this.granularity = granularity;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String[] getOrganicTweetAppInstallAttempts() {
        return organicTweetAppInstallAttempts;
    }

    public void setOrganicTweetAppInstallAttempts(String[] organicTweetAppInstallAttempts) {
        this.organicTweetAppInstallAttempts = organicTweetAppInstallAttempts;
    }

    public String[] getOrganicTweetAppOpens() {
        return organicTweetAppOpens;
    }

    public void setOrganicTweetAppOpens(String[] organicTweetAppOpens) {
        this.organicTweetAppOpens = organicTweetAppOpens;
    }

    public String[] getOrganicTweetClicks() {
        return organicTweetClicks;
    }

    public void setOrganicTweetClicks(String[] organicTweetClicks) {
        this.organicTweetClicks = organicTweetClicks;
    }

    public String[] getOrganicTweetDetailExpands() {
        return organicTweetDetailExpands;
    }

    public void setOrganicTweetDetailExpands(String[] organicTweetDetailExpands) {
        this.organicTweetDetailExpands = organicTweetDetailExpands;
    }

    public String[] getOrganicTweetEngagementRate() {
        return organicTweetEngagementRate;
    }

    public void setOrganicTweetEngagementRate(String[] organicTweetEngagementRate) {
        this.organicTweetEngagementRate = organicTweetEngagementRate;
    }

    public String[] getOrganicTweetEngagements() {
        return organicTweetEngagements;
    }

    public void setOrganicTweetEngagements(String[] organicTweetEngagements) {
        this.organicTweetEngagements = organicTweetEngagements;
    }

    public String[] getOrganicTweetFavorites() {
        return organicTweetFavorites;
    }

    public void setOrganicTweetFavorites(String[] organicTweetFavorites) {
        this.organicTweetFavorites = organicTweetFavorites;
    }

    public String[] getOrganicTweetFollows() {
        return organicTweetFollows;
    }

    public void setOrganicTweetFollows(String[] organicTweetFollows) {
        this.organicTweetFollows = organicTweetFollows;
    }

    public String[] getOrganicTweetImpressions() {
        return organicTweetImpressions;
    }

    public void setOrganicTweetImpressions(String[] organicTweetImpressions) {
        this.organicTweetImpressions = organicTweetImpressions;
    }

    public String[] getOrganicTweetReplies() {
        return organicTweetReplies;
    }

    public void setOrganicTweetReplies(String[] organicTweetReplies) {
        this.organicTweetReplies = organicTweetReplies;
    }

    public String[] getOrganicTweetRetweets() {
        return organicTweetRetweets;
    }

    public void setOrganicTweetRetweets(String[] organicTweetRetweets) {
        this.organicTweetRetweets = organicTweetRetweets;
    }

    public String[] getOrganicTweetUrlClicks() {
        return organicTweetUrlClicks;
    }

    public void setOrganicTweetUrlClicks(String[] organicTweetUrlClicks) {
        this.organicTweetUrlClicks = organicTweetUrlClicks;
    }

    @Override
    public String toString() {
        return "TwitterOrganicTweetStatistics{" +
               "startTime=" + startTime +
               ", granularity=" + granularity +
               ", endTime=" + endTime +
               ", organicTweetAppInstallAttempts=" + Arrays.toString(organicTweetAppInstallAttempts) +
               ", organicTweetAppOpens=" + Arrays.toString(organicTweetAppOpens) +
               ", organicTweetClicks=" + Arrays.toString(organicTweetClicks) +
               ", organicTweetDetailExpands=" + Arrays.toString(organicTweetDetailExpands) +
               ", organicTweetEngagementRate=" + Arrays.toString(organicTweetEngagementRate) +
               ", organicTweetEngagements=" + Arrays.toString(organicTweetEngagements) +
               ", organicTweetFavorites=" + Arrays.toString(organicTweetFavorites) +
               ", organicTweetFollows=" + Arrays.toString(organicTweetFollows) +
               ", organicTweetImpressions=" + Arrays.toString(organicTweetImpressions) +
               ", organicTweetReplies=" + Arrays.toString(organicTweetReplies) +
               ", organicTweetRetweets=" + Arrays.toString(organicTweetRetweets) +
               ", organicTweetUrlClicks=" + Arrays.toString(organicTweetUrlClicks) +
               '}';
    }
}
