
public class LeakyBucketUsingQ {

	private final int capacity;				// = Bucket size = Max 5 requests can wait in the bucket.
    private final long leakIntervalMillis;	// 1 request leaks out every 2 secs.

    private final Queue<Long> queue = new LinkedList<>();
    private long lastLeakTime;

    public LeakyBucketUsingQ(int capacity, long leakIntervalMillis) {
        this.capacity = capacity;
        this.leakIntervalMillis = leakIntervalMillis;
        this.lastLeakTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        // Remove requests that should have leaked/been processed
        long elapsed = now - lastLeakTime;

        int requestsToLeak = (int) (elapsed / leakIntervalMillis);

        while (requestsToLeak > 0 && !queue.isEmpty()) {
            queue.poll();
            requestsToLeak--;
            lastLeakTime += leakIntervalMillis;
        }

        // If queue/bucket is full, reject
        if (queue.size() >= capacity) {
            return false;
        }

        // Otherwise add request to bucket
        queue.offer(now);
        return true;
    }
}
