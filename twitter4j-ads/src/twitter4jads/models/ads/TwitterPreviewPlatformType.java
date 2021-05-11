package twitter4jads.models.ads;

/**
 * User : rohun
 * Date : 26/08/16.
 */
public enum TwitterPreviewPlatformType {
    IPHONE("iPhone"),
    ANDROID("Android"),
    WEB("Web"),
    UNKNOWN("Unknown");

    private String displayName;

    TwitterPreviewPlatformType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}