package IteratorPattern.Aggregator;

import java.util.List;
import IteratorPattern.Client.Book;
import IteratorPattern.Iterator.BookIterator;
import IteratorPattern.Iterator.Iterator;

public class Library implements Aggregator {
	
	private List<Book> booksList;

	public Library(List<Book> list) {
		this.booksList = list;
	}
	
	@Override
	public Iterator createIterator() {
		return new BookIterator(booksList);
	}
	
}
