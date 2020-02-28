package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author niketkhandelwal
 */
public class PollEntity implements Serializable {

    @SerializedName("options")
    private List<PollOption> options;

    @SerializedName("end_datetime")
    private String endDateTime;

    @SerializedName("duration_minutes")
    private String durationMinutes;

    public static class PollOption implements Serializable {

        @SerializedName("position")
        private Integer position;

        @SerializedName("text")
        private String text;
    }
}
