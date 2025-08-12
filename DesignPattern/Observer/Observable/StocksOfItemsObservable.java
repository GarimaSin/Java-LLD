package Observer.Observable;

import Observer.Observer.NotificationAlertObserver;

public interface StocksOfItemsObservable {

	public void add(NotificationAlertObserver obs);
	public void remove(NotificationAlertObserver obs);
	public void notifySubscribers();
	public void setStockCount(int i);
	public int getStockCount();
}
