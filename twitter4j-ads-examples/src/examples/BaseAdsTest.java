package examples;

import twitter4j.TwitterAds;
import twitter4j.TwitterAdsFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * User: abhishekanand
 * Date: 10/05/16 10:49 PM.
 */
public class BaseAdsTest {

    public static TwitterAds getTwitterAdsInstance() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerSecret("").setOAuthConsumerKey("").setOAuthAccessToken("").setOAuthAccessTokenSecret("").setHttpRetryCount(0).setHttpConnectionTimeout(5000);
        return new TwitterAdsFactory(configurationBuilder.build()).getAdsInstance();
    }


}
