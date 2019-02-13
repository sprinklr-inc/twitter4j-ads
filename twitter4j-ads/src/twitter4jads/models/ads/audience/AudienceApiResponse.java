package twitter4jads.models.ads.audience;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import twitter4jads.ErrorResponse;
import twitter4jads.internal.models4j.RateLimitStatus;
import twitter4jads.models.ads.RequestParameters;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Twitter V4 Audience API response
 * User: mayankbhargava
 *
 * @date 25/11/18
 * @time 9:32 PM
 */
public class AudienceApiResponse {

    @SerializedName("operation_errors")
    List<List<ErrorResponse>> operationErrors;
    @JsonAdapter(RequestListAdapter.class)
    @SerializedName("request")
    private List<RequestParameters> request;
    @SerializedName("data")
    private NewAudienceApiResponseData data;
    @SerializedName("errors")
    private List<ErrorResponse> errors;
    private RateLimitStatus rateLimitStatus;

    public List<RequestParameters> getRequest() {
        return request;
    }

    public void setRequest(List<RequestParameters> request) {
        this.request = request;
    }

    public NewAudienceApiResponseData getData() {
        return data;
    }

    public void setData(NewAudienceApiResponseData data) {
        this.data = data;
    }

    public List<ErrorResponse> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorResponse> errors) {
        this.errors = errors;
    }

    public List<List<ErrorResponse>> getOperationErrors() {
        return operationErrors;
    }

    public void setOperationErrors(List<List<ErrorResponse>> operationErrors) {
        this.operationErrors = operationErrors;
    }

    public RateLimitStatus getRateLimitStatus() {
        return rateLimitStatus;
    }

    public void setRateLimitStatus(RateLimitStatus rateLimitStatus) {
        this.rateLimitStatus = rateLimitStatus;
    }

    public static class NewAudienceApiResponseData {

        @SerializedName("success_count")
        private Long successCount;

        @SerializedName("total_count")
        private Long totalCount;

        public Long getSuccessCount() {
            return successCount;
        }

        public void setSuccessCount(Long successCount) {
            this.successCount = successCount;
        }

        public Long getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Long totalCount) {
            this.totalCount = totalCount;
        }
    }

    /**
     * on success request is returned as object and on failure as list
     */
    public static class RequestListAdapter implements JsonDeserializer<List<RequestParameters>> {

        @Override
        public List<RequestParameters> deserialize(JsonElement element, Type type, JsonDeserializationContext context) {
            if (!element.isJsonArray()) {
                JsonArray array = new JsonArray();
                array.add(element);
                element = array;
            }

            return new Gson().fromJson(element, type);
        }
    }
}