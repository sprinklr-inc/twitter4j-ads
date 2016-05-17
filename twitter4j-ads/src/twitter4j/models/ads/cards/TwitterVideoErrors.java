package twitter4j.models.ads.cards;

/**
 * User: prashant
 * Date: 10/09/15
 */
public enum TwitterVideoErrors {
    DMCA_TAKE_DOWN("DMCA_TAKE_DOWN"),
    ERROR("ERROR"),
    NOT_A_VIDEO("NOT_A_VIDEO"),
    PROCESSING("PROCESSING"),
    VIDEO_INCOMPLETE("VIDEO_INCOMPLETE"),
    VIDEO_TOO_LONG("VIDEO_TOO_LONG");

    String label;

    TwitterVideoErrors(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
