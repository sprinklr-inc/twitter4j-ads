package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * User: poly Date: 29/01/14 Time: 11:54 AM
 */
public class LineItem extends TwitterEntity {

    @SerializedName("account_id")
    private String accountId;

    @SerializedName("name")
    private String name;

    @SerializedName("bid_amount_local_micro")
    private Long bidAmtInMicro;

    @SerializedName("campaign_id")
    private String campaignId;

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("currency")
    private String currency;

    @SerializedName("goal_settings")
    private String goalSettings;

    @SerializedName("match_relevant_popular_queries")
    private Boolean matchRelevantPopularQueries;

    @SerializedName("objective")
    private String objective;

    @SerializedName("deleted")
    private Boolean deleted;

    @SerializedName("placements")
    private List<Placement> placements;

    @SerializedName("product_type")
    private ProductType productType;

    @SerializedName("include_sentiment")
    private Sentiments sentiment;

    @SerializedName("primary_web_event_tag")
    private String webEventTag;

    @SerializedName("suggested_high_cpe_bid_local_micro")
    private Long suggestedHighCpeBidInMicro;

    @SerializedName("suggested_low_cpe_bid_local_micro")
    private Long suggestedLowCpeBidInMicro;

    @SerializedName("target_cpa_local_micro")
    private Long targetCpaLocalMicro;

    @SerializedName("updated_at")
    private Date updatedAt;

    @SerializedName("automatically_select_bid")
    private boolean automaticallySelectBid;

    @SerializedName("bid_type")
    private BidType bidType;

    @SerializedName("charge_by")
    private String chargeBy;

    @SerializedName("bid_unit")
    private String bidUnit;

    @SerializedName("advertiser_domain")
    private String advertiserDomain;

    @SerializedName("advertiser_user_id ")
    private String advertiserUserId;

    @SerializedName("categories")
    private String[] categories;

    @SerializedName("optimization")
    private String optimization;

    @SerializedName("creative_source")
    private String creativeSource;

    @SerializedName("start_time")
    private Date startTimeInUTC;

    @SerializedName("end_time")
    private Date endTimeInUTC;

    @SerializedName("total_budget_amount_local_micro")
    private Long budget;

    @SerializedName("tracking_tags")
    private List<TrackingTag> trackingTags;

    @SerializedName("entity_status")
    private EntityStatus status;

    public String getCreativeSource() {
        return creativeSource;
    }

    public void setCreativeSource(String creativeSource) {
        this.creativeSource = creativeSource;
    }

    public String getOptimization() {
        return optimization;
    }

    public void setOptimization(String optimization) {
        this.optimization = optimization;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getBidAmtInMicro() {
        return bidAmtInMicro;
    }

    public void setBidAmtInMicro(Long bidAmtInMicro) {
        this.bidAmtInMicro = bidAmtInMicro;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGoalSettings() {
        return goalSettings;
    }

    public void setGoalSettings(String goalSettings) {
        this.goalSettings = goalSettings;
    }

    public Boolean getMatchRelevantPopularQueries() {
        return matchRelevantPopularQueries;
    }

    public void setMatchRelevantPopularQueries(Boolean matchRelevantPopularQueries) {
        this.matchRelevantPopularQueries = matchRelevantPopularQueries;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Sentiments getSentiment() {
        return sentiment;
    }

    public void setSentiment(Sentiments sentiment) {
        this.sentiment = sentiment;
    }

    public Long getSuggestedHighCpeBidInMicro() {
        return suggestedHighCpeBidInMicro;
    }

    public void setSuggestedHighCpeBidInMicro(Long suggestedHighCpeBidInMicro) {
        this.suggestedHighCpeBidInMicro = suggestedHighCpeBidInMicro;
    }

    public Long getSuggestedLowCpeBidInMicro() {
        return suggestedLowCpeBidInMicro;
    }

    public void setSuggestedLowCpeBidInMicro(Long suggestedLowCpeBidInMicro) {
        this.suggestedLowCpeBidInMicro = suggestedLowCpeBidInMicro;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public boolean isAutomaticallySelectBid() {
        return automaticallySelectBid;
    }

    public void setAutomaticallySelectBid(boolean automaticallySelectBid) {
        this.automaticallySelectBid = automaticallySelectBid;
    }

    public BidType getBidType() {
        return bidType;
    }

    public void setBidType(BidType bidType) {
        this.bidType = bidType;
    }

    public String getChargeBy() {
        return chargeBy;
    }

    public void setChargeBy(String chargeBy) {
        this.chargeBy = chargeBy;
    }

    public String getBidUnit() {
        return bidUnit;
    }

    public void setBidUnit(String bidUnit) {
        this.bidUnit = bidUnit;
    }

    public String getWebEventTag() {
        return webEventTag;
    }

    public void setWebEventTag(String webEventTag) {
        this.webEventTag = webEventTag;
    }

    public String getAdvertiserDomain() {
        return advertiserDomain;
    }

    public void setAdvertiserDomain(String advertiserDomain) {
        this.advertiserDomain = advertiserDomain;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdvertiserUserId() {
        return advertiserUserId;
    }

    public void setAdvertiserUserId(String advertiserUserId) {
        this.advertiserUserId = advertiserUserId;
    }

    public List<TrackingTag> getTrackingTags() {
        return trackingTags;
    }

    public void setTrackingTags(List<TrackingTag> trackingTags) {
        this.trackingTags = trackingTags;
    }

    public Date getStartTime() {
        return startTimeInUTC;
    }

    public void setStartTime(Date startTimeInUTC) {
        this.startTimeInUTC = startTimeInUTC;
    }

    public Date getEndTime() {
        return endTimeInUTC;
    }

    public void setEndTime(Date endTimeInUTC) {
        this.endTimeInUTC = endTimeInUTC;
    }

    public Long getTargetCpaLocalMicro() {
        return targetCpaLocalMicro;
    }

    public void setTargetCpaLocalMicro(Long targetCpaLocalMicro) {
        this.targetCpaLocalMicro = targetCpaLocalMicro;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LineItem{"
                + "accountId='" + accountId + '\''
                + ", name='" + name + '\''
                + ", bidAmtInMicro=" + bidAmtInMicro
                + ", campaignId='" + campaignId + '\''
                + ", createdAt=" + createdAt
                + ", currency='" + currency + '\''
                + ", goalSettings='" + goalSettings + '\''
                + ", matchRelevantPopularQueries=" + matchRelevantPopularQueries
                + ", objective='" + objective + '\''
                + ", deleted=" + deleted
                + ", placements=" + placements
                + ", productType=" + productType
                + ", sentiment=" + sentiment
                + ", status=" + status
                + ", webEventTag='" + webEventTag + '\''
                + ", suggestedHighCpeBidInMicro=" + suggestedHighCpeBidInMicro
                + ", suggestedLowCpeBidInMicro=" + suggestedLowCpeBidInMicro
                + ", targetCpaLocalMicro=" + targetCpaLocalMicro
                + ", updatedAt=" + updatedAt
                + ", automaticallySelectBid=" + automaticallySelectBid
                + ", bidType=" + bidType
                + ", chargeBy='" + chargeBy + '\''
                + ", bidUnit='" + bidUnit + '\''
                + ", advertiserDomain='" + advertiserDomain + '\''
                + ", advertiserUserId='" + advertiserUserId + '\''
                + ", categories=" + Arrays.toString(categories)
                + ", startTime=" + startTimeInUTC
                + ", endTime=" + endTimeInUTC
                + ", optimization='" + optimization + '\''
                + ", creativeSource='" + creativeSource + '\''
                + ", budget='" + budget + '\''
                + '}';
    }
}
