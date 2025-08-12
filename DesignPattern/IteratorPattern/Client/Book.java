package IteratorPattern.Client;

public class Book {

	
	private int price;
	private String name;
	
	Book(int p, String n) {
		this.price = p;
		this.name = n;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
}
