package Proxy.Cache;

import java.time.Duration;

public class Video {

	String name;
	Duration length;
	
	
	public Video(String videoName) {
		this.name = videoName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Duration getLength() {
		return length;
	}
	public void setLength(Duration length) {
		this.length = length;
	}
	
}
