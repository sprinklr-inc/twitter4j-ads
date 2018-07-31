package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * User: poly
 * Date: 29/01/14
 * Time: 11:52 AM
 */
public class RequestParameters {

    @SerializedName("params")
    private Map<String, Object> params;

    @SerializedName("total_count")
    private Long totalCount;

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
