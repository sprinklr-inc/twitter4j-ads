package twitter4j.models.ads;

import twitter4j.BaseListResponse;
import twitter4j.Status;

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
