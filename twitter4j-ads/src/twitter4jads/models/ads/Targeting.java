package twitter4jads.models.ads;

import java.io.Serializable;

public interface Targeting extends Comparable<Targeting>, Serializable {

    String getName();
    String getTargetingValue();
    TargetingType getTargetingType();

}
