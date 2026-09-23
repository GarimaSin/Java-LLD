
public class TokenBucket {
	private final long capacity;
    private final double refillRate; // tokens per second

    private double tokens;
    private long lastRefillTime;

    public TokenBucket(long capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;

        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refill();

        if (tokens >= 1) {
            tokens--;
            return true;
        }

        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        long elapsedNanos = now - lastRefillTime;
        double elapsedSeconds = elapsedNanos / 1_000_000_000.0;
        double tokensToAdd = elapsedSeconds * refillRate;

        tokens = Math.min(capacity, tokens + tokensToAdd);
        lastRefillTime = now;
    }

    public static void main(String[] args) {

        // Bucket can hold 5 tokens
        // Refills at 2 tokens/sec
        TokenBucket limiter = new TokenBucket(5, 2);

        for (int i = 1; i <= 10; i++) {
            System.out.println(
                    "Request " + i + ": " + limiter.allowRequest()
            );
        }
    }
}
