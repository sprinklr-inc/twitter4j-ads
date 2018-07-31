package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * User: abhay
 * Date: 2/5/17
 * Time: 7:36 PM
 */
public class TwitterAuctionStatistics {
    public static final String AUCTION_WIN_RATE = "auction_win_rate";
    public static final String AVERAGE_BID_LOCAL_MICRO = "average_bid_local_micro";
    public static final String AVERAGE_PRICE_LOCAL_MICRO = "average_price_local_micro";

    @SerializedName(AUCTION_WIN_RATE)
    private String[] auctionWinRate;

    @SerializedName(AVERAGE_BID_LOCAL_MICRO)
    private String[] averageBidLocalMicro;

    @SerializedName(AVERAGE_PRICE_LOCAL_MICRO)
    private String[] averagePriceLocalMicro;

    public String[] getAuctionWinRate() {
        return auctionWinRate;
    }

    public void setAuctionWinRate(String[] auctionWinRate) {
        this.auctionWinRate = auctionWinRate;
    }

    public String[] getAverageBidLocalMicro() {
        return averageBidLocalMicro;
    }

    public void setAverageBidLocalMicro(String[] averageBidLocalMicro) {
        this.averageBidLocalMicro = averageBidLocalMicro;
    }

    public String[] getAveragePriceLocalMicro() {
        return averagePriceLocalMicro;
    }

    public void setAveragePriceLocalMicro(String[] averagePriceLocalMicro) {
        this.averagePriceLocalMicro = averagePriceLocalMicro;
    }

    @Override
    public String toString() {
        return "TwitterAuctionStatistics{" +
               "auctionWinRate=" + auctionWinRate +
               ", averageBidLocalMicro=" + averageBidLocalMicro +
               ", averagePriceLocalMicro=" + averagePriceLocalMicro +
               '}';
    }
}
