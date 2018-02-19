package twitter4jads;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import twitter4jads.internal.models4j.RateLimitStatus;
import twitter4jads.internal.models4j.TwitterResponse;
import twitter4jads.models.ads.RequestParameters;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Copyright (c) 2016-2017 Sprinklr, Inc. All rights reserved.
 * Created with Intellij IDEA.
 * User: ratneshjd
 * Date: 19/01/17
 * Time: 5:32 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseAdsListBatchPostResponse<T> implements Serializable, TwitterResponse {

    @SerializedName("data_type")
    private String dataType;

    @SerializedName("data")
    private List<T> data;

    @SerializedName("total_count")
    private Long totalCount;

    @SerializedName("request")
    private List<RequestParameters> request;

    @SerializedName("next_cursor")
    private String nextCursor;

    @SerializedName("cursor")
    private String cursor;

    @SerializedName("count")
    private Long count;

    private RateLimitStatus rateLimitStatus;

    private int accessLevel;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        if (data == null) {
            return Collections.emptyList();
        }
        return data;

    }

    void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<RequestParameters> getRequest() {
        return request;
    }

    public void setRequest(List<RequestParameters> request) {
        this.request = request;
    }

    public String getNextCursor() {
        if (nextCursor != null) {
            return nextCursor;
        } else if (cursor != null){
            return cursor;
        }
        return null;
    }

    void setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
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
