package Observer;

import Observer.Observable.IphoneStockObservableImpl;
import Observer.Observable.StocksOfItemsObservable;
import Observer.Observer.EmailAlertObserverImpl;
import Observer.Observer.MobileAlertObserverImpl;
import Observer.Observer.NotificationAlertObserver;

public class Store {
	
	public static void main(String[] args) {
		StocksOfItemsObservable iphoneStockObservable = new IphoneStockObservableImpl();
		
		NotificationAlertObserver observer1 = new EmailAlertObserverImpl("abc@gmail.com", iphoneStockObservable);
		NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneStockObservable);
		NotificationAlertObserver observer3 = new MobileAlertObserverImpl("123456789", iphoneStockObservable);
		
		iphoneStockObservable.add(observer1);
		iphoneStockObservable.add(observer2);
		iphoneStockObservable.add(observer3);
		
		iphoneStockObservable.setStockCount(10);
	}

}
