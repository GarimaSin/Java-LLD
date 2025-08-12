package Adapter;

public class FancyUIServiceAdapter implements MultiRestoInterface {
	
	private final FancyUIService fancyUIService;
	
	public FancyUIServiceAdapter() {
		fancyUIService = new FancyUIService();
	}

	@Override
	public void displayMenu(XmlData data) {
		JsonData jsonData = convertXmlToJson(data);
		fancyUIService.displayMenu(jsonData);
	}

	@Override
	public void displayRecommendations(XmlData data) {
		JsonData jsonData = convertXmlToJson(data);
		fancyUIService.displayRecommendations(jsonData);
	}
	
	private JsonData convertXmlToJson(XmlData data) {
		// Convert Xml to Json and return
		return null;
	}

}
