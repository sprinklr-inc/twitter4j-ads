package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class TwitterAdStatsBreakdown {

    private static final String TOTAL = "total";
    private static final String POST_VIEW = "post_view";
    private static final String POST_ENGAGEMENT = "post_engagement";
    private static final String ASSISTED = "assisted";
    private static final String SALE_AMOUNT = "sale_amount";
    private static final String METRIC = "metric";
    private static final String ORDER_QUANTITY = "order_quantity";
    private static final String ORDER_QUANTITY_ENGAGEMENT = "order_quantity_engagement";
    private static final String SALE_AMOUNT_ENGAGEMENT = "sale_amount_engagement";
    private static final String SALE_AMOUNT_VIEW = "sale_amount_view";
    private static final String ORDER_QUANTITY_VIEW = "order_quantity_view";

    @SerializedName(TOTAL)
    private String[] total;

    @SerializedName(POST_VIEW)
    private String[] postView;

    @SerializedName(POST_ENGAGEMENT)
    private String[] postEngagement;

    @SerializedName(ASSISTED)
    private String[] assisted;

    @SerializedName(SALE_AMOUNT)
    private String[] saleAmount;

    @SerializedName(METRIC)
    private String[] metric;

    @SerializedName(ORDER_QUANTITY)
    private String[] orderQuantity;

    @SerializedName(ORDER_QUANTITY_ENGAGEMENT)
    private String[] orderQuantityEngagement;

    @SerializedName(SALE_AMOUNT_ENGAGEMENT)
    private String[] saleAmountEngagement;

    @SerializedName(SALE_AMOUNT_VIEW)
    private String[] saleAmountView;

    @SerializedName(ORDER_QUANTITY_VIEW)
    private String[] orderQuantityView;

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

    public String[] getOrderQuantityEngagement() {
        return orderQuantityEngagement;
    }

    public void setOrderQuantityEngagement(String[] orderQuantityEngagement) {
        this.orderQuantityEngagement = orderQuantityEngagement;
    }

    public String[] getOrderQuantityView() {
        return orderQuantityView;
    }

    public void setOrderQuantityView(String[] orderQuantityView) {
        this.orderQuantityView = orderQuantityView;
    }

    public String[] getSaleAmountView() {
        return saleAmountView;
    }

    public void setSaleAmountView(String[] saleAmountView) {
        this.saleAmountView = saleAmountView;
    }

    public String[] getSaleAmountEngagement() {
        return saleAmountEngagement;
    }

    public void setSaleAmountEngagement(String[] saleAmountEngagement) {
        this.saleAmountEngagement = saleAmountEngagement;
    }

    public String[] getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(String[] saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String[] getMetric() {
        return metric;
    }

    public void setMetric(String[] metric) {
        this.metric = metric;
    }

    public String[] getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String[] orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "TwitterAdStatsBreakdown{" +
                "assisted=" + Arrays.toString(assisted) +
                ", metric=" + Arrays.toString(metric) +
                ", orderQuantity=" + Arrays.toString(orderQuantity) +
                ", orderQuantityEngagement=" + Arrays.toString(orderQuantityEngagement) +
                ", orderQuantityView=" + Arrays.toString(orderQuantityView) +
                ", postEngagement=" + Arrays.toString(postEngagement) +
                ", postView=" + Arrays.toString(postView) +
                ", saleAmount=" + Arrays.toString(saleAmount) +
                ", saleAmountEngagement=" + Arrays.toString(saleAmountEngagement) +
                ", saleAmountView=" + Arrays.toString(saleAmountView) +
                ", total=" + Arrays.toString(total) +
                '}';
    }
}
