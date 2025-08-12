package IteratorPattern.Client;

import java.util.ArrayList;
import java.util.List;
import IteratorPattern.Aggregator.Library;
import IteratorPattern.Iterator.Iterator;


public class Client {

	public static void main(String[] args) {
		List<Book> list = new ArrayList<>();
		list.add(new Book(100, "Science"));
		list.add(new Book(200, "Maths"));
		list.add(new Book(300, "English"));
		list.add(new Book(400, "Gk"));
		
		Library lib = new Library(list);
		Iterator iterator = lib.createIterator();
		
		while(iterator.hasNext()) {
			Book book = (Book) iterator.next();
			System.out.println(book.getName());
		}
	}
}
