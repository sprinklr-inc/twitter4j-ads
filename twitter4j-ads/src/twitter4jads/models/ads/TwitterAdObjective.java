package twitter4jads.models.ads;

import twitter4jads.models.MetricGroup;

/**
 * User: abhay
 * Date: 4/19/16
 * Time: 8:51 PM
 */
public enum TwitterAdObjective {

    APP_ENGAGEMENTS("app_engagements", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION,
            MetricGroup.MEDIA, MetricGroup.VIDEO, MetricGroup.WEB_CONVERSION),

    APP_INSTALLS("app_installs", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION,
            MetricGroup.MEDIA, MetricGroup.VIDEO, MetricGroup.WEB_CONVERSION),

    FOLLOWERS("followers", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION, MetricGroup.MEDIA, MetricGroup.VIDEO,
            MetricGroup.WEB_CONVERSION),

    LEAD_GENERATION("lead_generation", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION, MetricGroup.MEDIA, MetricGroup
            .VIDEO, MetricGroup.WEB_CONVERSION),

    VIDEO_VIEWS_PREROLL("video_views_preroll", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION, MetricGroup.MEDIA,
            MetricGroup.VIDEO, MetricGroup.WEB_CONVERSION),

    TWEET_ENGAGEMENTS("tweet_engagements", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION, MetricGroup.MEDIA,
            MetricGroup.VIDEO, MetricGroup.WEB_CONVERSION),

    QUALIFIED_VIEWS("qualified_views", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION, MetricGroup.MEDIA, MetricGroup
            .VIDEO, MetricGroup.WEB_CONVERSION),

    VIDEO_VIEWS("video_views", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION, MetricGroup.MEDIA, MetricGroup.VIDEO,
            MetricGroup.WEB_CONVERSION),

    WEBSITE_CLICKS("website_clicks", MetricGroup.ENGAGEMENT, MetricGroup.BILLING, MetricGroup.MOBILE_CONVERSION, MetricGroup.MEDIA, MetricGroup
            .VIDEO, MetricGroup.WEB_CONVERSION);

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
