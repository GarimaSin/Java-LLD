import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowLogRateLimiter {

	private final int maxRequests;
    private final long windowSizeMillis;

    private final Deque<Long> requestLog = new ArrayDeque<>();

    public SlidingWindowLogRateLimiter(int maxRequests, long windowMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowMillis;
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        long windowStart = now - windowSizeMillis;

        while (!requestLog.isEmpty() && requestLog.peekFirst() <= windowStart) {
            requestLog.pollFirst();
        }

        if (requestLog.size() >= maxRequests) {
            return false;
        }

        requestLog.offerLast(now);
        return true;
    }

    public static void main(String[] args) {
        SlidingWindowLogRateLimiter limiter = new SlidingWindowLogRateLimiter(5, 10_000);

        for (int i = 1; i <= 10; i++) {
            System.out.println(
                    "Request " + i + ": " + limiter.allowRequest()
            );
        }
    }
}