package twitter4jads.models.ads;


import twitter4jads.BaseListResponse;
import twitter4jads.internal.models4j.Status;

import java.util.List;

/**
 * User: abhay
 * Date: 3/17/16
 * Time: 12:49 PM
 */
public class ListStatusResponse extends BaseListResponse<Status> {

    public List<Status> getStatuses() {
        return getData();
    }

}
