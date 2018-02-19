package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class TwitterAdStatsBreakdown {

    private static final String TOTAL = "total";
    private static final String POST_VIEW = "post_view";
    private static final String POST_ENGAGEMENT = "post_engagement";
    private static final String ASSISTED = "assisted";

    @SerializedName(TOTAL)
    private String[] total;

    @SerializedName(POST_VIEW)
    private String[] postView;

    @SerializedName(POST_ENGAGEMENT)
    private String[] postEngagement;

    @SerializedName(ASSISTED)
    private String[] assisted;

    public String[] getTotal() {
        return total;
    }

    public void setTotal(String[] total) {
        this.total = total;
    }

    public String[] getPostView() {
        return postView;
    }

    public void setPostView(String[] postView) {
        this.postView = postView;
    }

    public String[] getPostEngagement() {
        return postEngagement;
    }

    public void setPostEngagement(String[] postEngagement) {
        this.postEngagement = postEngagement;
    }

    public String[] getAssisted() {
        return assisted;
    }

    public void setAssisted(String[] assisted) {
        this.assisted = assisted;
    }

    @Override
    public String toString() {
        return "TwitterAdStatsBreakdown{" +
               "total=" + Arrays.toString(total) +
               ", postView=" + Arrays.toString(postView) +
               ", postEngagement=" + Arrays.toString(postEngagement) +
               ", assisted=" + Arrays.toString(assisted) +
               '}';
    }
}
