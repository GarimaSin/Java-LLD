package MediatorPattern.Bidders;

import MediatorPattern.Mediator.Mediator;

public class Bidder implements Bidders {
	
	String name;
	Mediator mediator;
	
	public Bidder(String name, Mediator med) {
		this.name = name;
		this.mediator = med;
		mediator.addBidder(this);
	}

	@Override
	public void placeBid(int bidAmount) {
		mediator.placeBid(this, bidAmount);
	}

	@Override
	public void recieveBidNotification(int bidAmount) {
		System.out.println("Bidder : "+name+" got the notification that someone has put the bid of: "+bidAmount);
	}

	@Override
	public String getName() {
		return name;
	}

}
