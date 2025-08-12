package MediatorPattern.Mediator;

import java.util.ArrayList;
import java.util.List;
import MediatorPattern.Bidders.Bidders;
import MediatorPattern.Mediator.Mediator;


public class AuctionMediator implements Mediator {
	
	List<Bidders> list = new ArrayList<>();

	@Override
	public void addBidder(Bidders bidder) {
		list.add(bidder);
	}

	@Override
	public void placeBid(Bidders bidder, int bidAmount) {
		for(Bidders bid : list) {
			if(!bid.getName().equals(bidder.getName())) {
				bid.recieveBidNotification(bidAmount);
			}
		}
		
	}

	
}
