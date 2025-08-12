package Observer.Observer;

import Observer.Observable.StocksOfItemsObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

	String userName;
	StocksOfItemsObservable observable;

	public MobileAlertObserverImpl(String userName, StocksOfItemsObservable observable) {
		this.observable = observable;
		this.userName = userName;
	}
	
	@Override
	public void update() {
		sendMsgOnMobile(userName, "Product is in stock, count = " + observable.getStockCount());
	}
	
	private void sendMsgOnMobile(String email, String msg) {
		System.out.println("Mail sent to: "+email);
	}
}
