
public class LeakyBucketRateLimiter {
	
	private final double capacity;
    private final double leakRatePerSecond;

    private double water;
    private long lastLeakTime;

    public LeakyBucketRateLimiter(int capacity, double leakRatePerSecond) {
        this.capacity = capacity;
        this.leakRatePerSecond = leakRatePerSecond;

        this.water = 0;
        this.lastLeakTime = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        leak();

        // Bucket is full
        if (water + 1 > capacity) {
            return false;
        }

        // Add new request into bucket
        water++;
        return true;
    }

    private void leak() {
        long now = System.nanoTime();

        double elapsedSeconds = (now - lastLeakTime) / 1_000_000_000.0;
        double leaked = elapsedSeconds * leakRatePerSecond;

        water = Math.max(0, water - leaked);
        lastLeakTime = now;
    }

	public static void main(String[] args) {
		LeakyBucketRateLimiter limiter =
		        new LeakyBucketRateLimiter(5, 0.5);
	}

}
