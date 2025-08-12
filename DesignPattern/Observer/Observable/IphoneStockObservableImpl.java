package Observer.Observable;

import java.util.ArrayList;
import java.util.List;
import Observer.Observer.NotificationAlertObserver;


public class IphoneStockObservableImpl implements StocksOfItemsObservable{
	
	public List<NotificationAlertObserver> list = new ArrayList<>();
	public int stockCount = 0;

	@Override
	public void add(NotificationAlertObserver obs) {
		list.add(obs);
	}

	@Override
	public void remove(NotificationAlertObserver obs) {
		list.remove(obs);
	}

	@Override
	public void notifySubscribers() {
		for(NotificationAlertObserver observer: list) {
			observer.update();
		}
		
	}
	
	public void setStockCount(int newStockAdded) {
		if(stockCount == 0) {						// ONLY if prev count was 0, notify that count is increased
			notifySubscribers();
		}
		stockCount = stockCount + newStockAdded;
	}
	
	
	public int getStockCount() {
		return stockCount;
	}

}
