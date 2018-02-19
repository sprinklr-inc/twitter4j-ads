package twitter4jads.internal.models4j;

import java.io.Serializable;

/**
 * @deprecated Do not use this class. New class has been created {@link twitter4jads.models.ads.Targeting}. This has been retained for backward
 * compatibility
 */
public interface Targeting extends Comparable<Targeting>, Serializable {

    String getName();
    String getTargetingValue();
    TargetingType getTargetingType();

}
