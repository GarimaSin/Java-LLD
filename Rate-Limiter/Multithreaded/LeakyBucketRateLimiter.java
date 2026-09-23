class LeakyBucketRateLimiter {

	public class LeakyBucket {

	    private final BlockingQueue<Runnable> queue;
	    private final long leakIntervalMillis;

	    public LeakyBucket(int capacity, long leakIntervalMillis) {
	        this.queue = new LinkedBlockingQueue<>(capacity);
	        this.leakIntervalMillis = leakIntervalMillis;

	        Thread worker = new Thread(this::processRequests);
	        worker.setDaemon(true);
	        worker.start();
	    }

	    public boolean addRequest(Runnable request) {
	        return queue.offer(request);
	    }

	    private void processRequests() {
	        while (true) {
	            try {
	                Runnable request = queue.take();

	                // Process one request
	                request.run();

	                // Fixed processing rate
	                Thread.sleep(leakIntervalMillis);

	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	                break;
	            }
	        }
	    }

	    public static void main(String[] args) throws Exception {
	        // Queue can contain 5 requests
	        // One request processed every 500ms
	        LeakyBucket bucket = new LeakyBucket(5, 500);

	        for (int i = 1; i <= 10; i++) {
	            final int requestId = i;

	            boolean accepted = bucket.addRequest(() ->
	                    System.out.println("Processing request " + requestId)
	            );

	            System.out.println("Request " + requestId + " accepted = " + accepted);
	        }

	        Thread.sleep(5000);
	    }
	}
}