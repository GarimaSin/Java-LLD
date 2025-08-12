package Proxy;

import Proxy.Cache.ProxyVideoDownloader;
import Proxy.Cache.VideoDownloader;
import Proxy.Restriction.Internet;
import Proxy.Restriction.ProxyInternet;

public class Main {

	public static void main(String[] args) {
		//Implementing Access control
		Internet internet = new ProxyInternet();
		internet.connectTo("google.com");
		internet.connectTo("banned.com");
		
		System.out.println("");
		System.out.println("");
		
		//Implementing Caching
		VideoDownloader videoDownloader = new ProxyVideoDownloader(); 
		videoDownloader.getVideo ("geekific"); // video downloaded 
		videoDownloader.getVideo ("geekific"); // Loaded from cache 
		videoDownloader.getVideo ("likeNsub"); // video downloaded 
		videoDownloader.getVideo ("likeNsub"); // loaded from cache 
		videoDownloader.getVideo ("geekific"); // loaded from cache
	}
}
