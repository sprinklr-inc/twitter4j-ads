package twitter4j.models.ads;

import twitter4j.models.MetricGroup;

/**
 * User: abhay
 * Date: 4/19/16
 * Time: 8:51 PM
 */
public enum TwitterAdObjective {

    APP_ENGAGEMENTS("app_engagements", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION,
                     MetricGroup.MEDIA, MetricGroup.VIDEO),

    APP_INSTALLS("app_installs", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION,
                  MetricGroup.MEDIA, MetricGroup.VIDEO),

    FOLLOWERS("followers", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MEDIA),

    LEAD_GENERATION("lead_generation", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MEDIA),

    PREROLL_VIEWS("preroll_views", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.VIDEO),

    TWEET_ENGAGEMENTS("tweet_engagements", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MEDIA),

    QUALIFIED_VIEWS("qualified_views", MetricGroup.ENGAGEMENT, MetricGroup.BILLING),

    VIDEO_VIEWS("video_views", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.VIDEO),

    WEBSITE_CLICKS("website_clicks", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.WEB_CONVERSION, MetricGroup.MEDIA);

    private MetricGroup[] metricGroups;
    private String objective;

    TwitterAdObjective(String objective, MetricGroup... metricGroups) {
        this.metricGroups = metricGroups;
        this.objective = objective;
    }

    public MetricGroup[] getMetricGroups() {
        return metricGroups;
    }

    public String getObjective() {
        return objective;
    }
}
