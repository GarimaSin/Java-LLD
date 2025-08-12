package Proxy.Cache;

import java.util.HashMap;
import java.util.Map;

public class ProxyVideoDownloader implements VideoDownloader {
	private final Map<String, Video> videoCache = new HashMap<>(); 
	private final VideoDownloader downloader = new RealVideoDownloader();
	
	@Override
	public Video getVideo (String videoName) {
		if (!videoCache.containsKey(videoName)) {
			videoCache.put(videoName, downloader.getVideo (videoName));
		} else {
			System.out.println("Showing the cached version");
		}
		return videoCache.get(videoName);
	}
}
	