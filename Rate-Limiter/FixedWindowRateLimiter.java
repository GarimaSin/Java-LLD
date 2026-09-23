
public class FixedWindowRateLimiter {
	
	private final int maxRequests;
    private final long windowMillis;

    private long windowStart;
    private int requestCount;

    public FixedWindowRateLimiter(int maxRequests, long windowMillis) {
        this.maxRequests = maxRequests;
        this.windowMillis = windowMillis;

        this.windowStart = System.currentTimeMillis();
        this.requestCount = 0;
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        if (now - windowStart >= windowMillis) {
            windowStart = now;
            requestCount = 0;
        }

        if (requestCount >= maxRequests) {
            return false;
        }

        requestCount++;
        return true;
    }

    public static void main(String[] args) {
        FixedWindowRateLimiter limiter =
                new FixedWindowRateLimiter(5, 10_000);

        for (int i = 1; i <= 10; i++) {
            System.out.println(
                    "Request " + i + ": " + limiter.allowRequest()
            );
        }
    }

}
