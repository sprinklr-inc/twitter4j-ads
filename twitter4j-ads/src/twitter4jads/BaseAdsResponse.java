package twitter4jads;

import com.google.gson.annotations.SerializedName;
import twitter4jads.internal.models4j.RateLimitStatus;
import twitter4jads.internal.models4j.TwitterResponse;
import twitter4jads.models.ads.RequestParameters;

import java.io.Serializable;


/**
 * User: poly
 * Date: 02/02/14
 * Time: 11:56 AM
 */
public class BaseAdsResponse<T> implements Serializable, TwitterResponse {

    @SerializedName("data")
    private T data;

    @SerializedName("request")
    private RequestParameters request;

    private RateLimitStatus rateLimitStatus;

    private int accessLevel = NONE;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RequestParameters getRequest() {
        return request;
    }

    public void setRequest(RequestParameters request) {
        this.request = request;
    }

    @Override
    public RateLimitStatus getRateLimitStatus() {
        return rateLimitStatus;
    }

    public void setRateLimitStatus(RateLimitStatus rateLimitStatus) {
        this.rateLimitStatus = rateLimitStatus;
    }

    @Override
    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
