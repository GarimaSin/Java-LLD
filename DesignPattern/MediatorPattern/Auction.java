package MediatorPattern;

import MediatorPattern.Bidders.Bidder;
import MediatorPattern.Bidders.Bidders;
import MediatorPattern.Mediator.AuctionMediator;
import MediatorPattern.Mediator.Mediator;

public class Auction {

	public static void main(String[] args) {
		Mediator med = new AuctionMediator();
		Bidders bidder1 = new Bidder("A", med);
		Bidders bidder2 = new Bidder("B", med);
		
		bidder1.placeBid(1000);
		bidder2.placeBid(2000);
		bidder1.placeBid(3000);
	}
}
