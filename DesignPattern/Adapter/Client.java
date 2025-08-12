package Adapter;

public class Client {

	public static void main(String[] args) {
		MultiRestoInterface app = new MultiRestoApp();
		app.displayMenu(new XmlData());
		
		FancyUIServiceAdapter adapter = new FancyUIServiceAdapter();
		adapter.displayMenu(new XmlData());
	}
}
