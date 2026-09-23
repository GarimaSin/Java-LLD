
public class FixedWindowCounter {

	private final int maxRequests;
    private final long windowSizeMillis;

    private long windowStart;
    private int requestCount;

    public FixedWindowCounter(int maxRequests, long windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
        this.windowStart = System.currentTimeMillis();
        this.requestCount = 0;
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        // Start a new window
        if (now - windowStart >= windowSizeMillis) {
            windowStart = now;
            requestCount = 0;
        }

        // Check limit
        if (requestCount >= maxRequests) {
            return false;
        }

        requestCount++;
        return true;
    }

    public static void main(String[] args) {
        FixedWindowCounter limiter =
                new FixedWindowCounter(5, 1000); // 5 requests / second

        for (int i = 1; i <= 10; i++) {
            System.out.println(
                    "Request " + i + ": " + limiter.allowRequest()
            );
        }
    }
}
