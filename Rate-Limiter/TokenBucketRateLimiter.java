import java.util.ArrayDeque;
import java.util.Deque;

public class TokenBucketRateLimiter {

	private final double capacity;
    private final double refillTokensPerSecond;

    private double tokens;
    private long lastRefillTime;

    public TokenBucketRateLimiter(int capacity, double refillTokensPerSecond) {
        this.capacity = capacity;
        this.refillTokensPerSecond = refillTokensPerSecond;

        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refill();

        if (tokens < 1) {
            return false;
        }

        tokens--;
        return true;
    }

    private void refill() {
        long now = System.nanoTime();
        double elapsedSeconds = (now - lastRefillTime) / 1_000_000_000.0;
        double newTokens = elapsedSeconds * refillTokensPerSecond;

        tokens = Math.min(capacity, tokens + newTokens);
        lastRefillTime = now;
    }

    public static void main(String[] args) {
        TokenBucketRateLimiter limiter =
                new TokenBucketRateLimiter(5, 0.5);

        for (int i = 1; i <= 10; i++) {
            System.out.println(
                    "Request " + i + ": " + limiter.allowRequest()
            );
        }
    }
}