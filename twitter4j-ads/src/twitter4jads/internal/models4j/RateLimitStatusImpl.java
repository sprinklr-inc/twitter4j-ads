package twitter4jads.internal.models4j;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 11:29 AM
 */
public class RateLimitStatusImpl implements RateLimitStatus {

    private int remaining;
    private int limit;
    private int resetTimeInSeconds;
    private int costValue;
    private int secondsUntilReset;

    public RateLimitStatusImpl(int remaining, int limit, int resetTimeInSeconds) {
        this(remaining, limit, resetTimeInSeconds, 0);
    }

    public RateLimitStatusImpl(int remaining, int limit, int resetTimeInSeconds, int costValue) {
        this.remaining = remaining;
        this.limit = limit;
        this.resetTimeInSeconds = resetTimeInSeconds;
        this.costValue = costValue;
        this.secondsUntilReset = (int) ((resetTimeInSeconds * 1000L - System.currentTimeMillis()) / 1000);
    }

    @Override
    public int getRemaining() {
        return remaining;
    }

    @Override
    public int getRemainingHits() {
        return getRemaining();
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public int getResetTimeInSeconds() {
        return resetTimeInSeconds;
    }

    @Override
    public int getSecondsUntilReset() {
        return secondsUntilReset;
    }

    @Override
    public String toString() {
        return "RateLimitStatusImpl{" +
               "remaining=" + remaining +
               ", limit=" + limit +
               ", resetTimeInSeconds=" + resetTimeInSeconds +
               ", costValue=" + costValue +
               ", secondsUntilReset=" + secondsUntilReset +
               '}';
    }
}
