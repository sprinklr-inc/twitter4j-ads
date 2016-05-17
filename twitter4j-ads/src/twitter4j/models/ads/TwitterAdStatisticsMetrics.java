package twitter4j.models.ads;

import com.google.api.client.util.Sets;
import com.google.common.collect.Maps;
import twitter4j.models.MetricGroup;

import java.util.Collections;
import java.util.Map;
import java.util.Set;


/**
 * User: abhay
 * Date: 2/27/16
 * Time: 10:34 AM
 */

public class TwitterAdStatisticsMetrics {

    public static final Set<String> ALL_METRIC_GROUPS;
    public static final Map<TwitterAdObjective, Set<String>> METRIC_GROUPS_BY_OBJECTIVE;

    static {
        Set<String> metricGroups = Sets.newHashSet();
        for (MetricGroup metricGroup : MetricGroup.values()) {
            metricGroups.add(metricGroup.name());
        }

        ALL_METRIC_GROUPS = Collections.unmodifiableSet(metricGroups);

        Map<TwitterAdObjective, Set<String>> metricsGroupsByObjective = Maps.newHashMap();
        for (TwitterAdObjective adObjective : TwitterAdObjective.values()) {
            Set<String> metricGroupNames = Sets.newHashSet();
            for (MetricGroup metricGroup : adObjective.getMetricGroups()) {
                metricGroupNames.add(metricGroup.name());
            }
            metricsGroupsByObjective.put(adObjective, metricGroupNames);
        }
        METRIC_GROUPS_BY_OBJECTIVE = Collections.unmodifiableMap(metricsGroupsByObjective);
    }

    public static Set<String> getMetricGroups(TwitterAdObjective objective) {
        if (objective == null) {
            return ALL_METRIC_GROUPS;
        }
        Set<String> toReturn = METRIC_GROUPS_BY_OBJECTIVE.get(objective);
        if (toReturn == null) {
            return ALL_METRIC_GROUPS;
        }
        return toReturn;
    }


    enum AdObjective {
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

        AdObjective(String objective, MetricGroup... metricGroups) {
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
}
