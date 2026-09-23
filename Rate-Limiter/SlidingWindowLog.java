import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowLog {

	private final int maxRequests;
	private final long windowMillis;
	private final Deque<Long> requestLog = new ArrayDeque<>();

	public SlidingWindowLog(int maxRequests, long windowMillis) {
		this.maxRequests = maxRequests;
		this.windowMillis = windowMillis;
	}

	public synchronized boolean allowRequest() {
		long now = System.currentTimeMillis();

		long windowStart = now - windowMillis;

		// Remove requests that are outside the current window
		while (!requestLog.isEmpty()
				&& requestLog.peekFirst() <= windowStart) {
			requestLog.pollFirst();
		}

		// Limit already reached
		if (requestLog.size() >= maxRequests) {
			return false;
		}

		// Accept and record request
		requestLog.offerLast(now);

		return true;
	}
	
	public static void main(String[] args) {
		SlidingWindowLogRateLimiter limiter =
		        new SlidingWindowLogRateLimiter(5, 10_000);
	}
}