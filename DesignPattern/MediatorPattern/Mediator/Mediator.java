package MediatorPattern.Mediator;

import MediatorPattern.Bidders.Bidders;

public interface Mediator {

	void addBidder(Bidders bidder);
	void placeBid(Bidders bidder, int bidAmount);
}
