import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowLog {
	private final int maxRequests;
    private final long windowSizeMillis;
    private final Deque<Long> timestamps = new ArrayDeque<>();

    public SlidingWindowLog(int maxRequests, long windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        // Remove requests outside the window
        while (!timestamps.isEmpty()
                && now - timestamps.peekFirst() >= windowSizeMillis) {
            timestamps.pollFirst();
        }

        // Check limit
        if (timestamps.size() >= maxRequests) {
            return false;
        }

        // Record this request
        timestamps.addLast(now);
        return true;
    }

    public static void main(String[] args) {
        SlidingWindowLog limiter =
                new SlidingWindowLog(5, 1000); // 5 requests / second

        for (int i = 1; i <= 10; i++) {
            System.out.println(
                    "Request " + i + ": " + limiter.allowRequest()
            );
        }
    }
}
