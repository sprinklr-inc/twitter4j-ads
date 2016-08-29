package twitter4j.models.ads;

/**
 * User: abhishekanand
 * Date: 16/06/16 7:14 PM.
 */
public enum TwitterOperationType {

    CREATE("Create"), DELETE("Delete");

    private final String channelKey;

    TwitterOperationType(String channelKey) {this.channelKey = channelKey;}

    public String getChannelKey() {
        return this.channelKey;
    }


}
