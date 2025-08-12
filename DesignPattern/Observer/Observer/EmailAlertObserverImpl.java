package Observer.Observer;

import Observer.Observable.StocksOfItemsObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
	
	String email;
	StocksOfItemsObservable observable;

	public EmailAlertObserverImpl(String email, StocksOfItemsObservable observable) {
		this.observable = observable;
		this.email = email;
	}
	
	@Override
	public void update() {
		sendMail(email, "Product is in stock, count = " + observable.getStockCount());
	}
	
	private void sendMail(String email, String msg) {
		System.out.println("Mail sent to: "+email);
	}

}
