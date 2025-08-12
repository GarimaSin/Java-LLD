package MediatorPattern.Bidders;

public interface Bidders {

	void placeBid(int bidAmount);
	void recieveBidNotification(int bidAmount);
	String getName();
}
