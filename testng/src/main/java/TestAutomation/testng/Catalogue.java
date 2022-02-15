package TestAutomation.testng;

import java.util.ArrayList;
import java.util.Iterator;

public class Catalogue {

	public ArrayList<Book> books;
	
	public Catalogue() {

		this.books = new ArrayList<Book>();
		
	}
	
	public void addBook(Book newBook)
	{
		this.books.add(newBook);
	}
	
	public void removeBook(int bookID)
	{
		for (Iterator iterator = books.iterator(); iterator.hasNext();) {
			Book book = (Book) iterator.next();
			if(book.getId() == bookID)
			{
				iterator.remove();
			}
			
		}
	}
	
	public int getCatalogueSize()
	{
		return this.books.size();
	}
	
	
	public ArrayList<Book> getBooks(){
		return books;
	}
	public Book searchBook(String searchString)
	{
	for (Iterator iterator = books.iterator(); iterator.hasNext();) {
	Book book = (Book) iterator.next();
	if(book.getNameOfTheBook().contains(searchString) || book.getAuthorOfTheBook().contains(searchString))
	{
	return book;
	}
	}
	return null;
	}
	
	public void addToLibrary(Object b) throws Exception
	{
		if(b instanceof Book)
		{
			addBook((Book)b);
		}
		else
		{
			throw new LibraryObjectNotSupported();
		}
	}
}
