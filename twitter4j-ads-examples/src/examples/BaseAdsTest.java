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
        //configurationBuilder.setOAuthConsumerSecret("2lH9gEuUIBkwGoKLXKTKG0kgm4lvLcvKU7xNKoVWZr0").setOAuthConsumerKey("TP7ebHOCMLv9Xd9nkT20Q").setOAuthAccessToken("23996599-7rNHIgpoq7oZSxhplIE7U62qaDtNPBnPFzgRNbBvb").setOAuthAccessTokenSecret("wtDMHs6yfNTxkQnhliQKicoZyB4Uni4J2RJYPFci4LTjt").setHttpRetryCount(0).setHttpConnectionTimeout(5000);
        configurationBuilder.setOAuthConsumerSecret("zXU9DkEnJyXZYISnfTKMD6jPwzlhqsQfh7DMtBERI").setOAuthConsumerKey("bLvcK5WM1VJyWtJTL5Hpg").setOAuthAccessToken("2814063755-oMeSa2tvOd7gzXnxAbiDqH6HxBRLN9piiPaujCT").setOAuthAccessTokenSecret("Wt1OwiYHiYq7fN8UBSpYw7bapBZMRXa69YwUEZctOnsKE").setHttpRetryCount(0).setHttpConnectionTimeout(5000);
        return new TwitterAdsFactory(configurationBuilder.build()).getAdsInstance();
    }


}
