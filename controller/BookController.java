package MppLibraryProject.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import MppLibraryProject.business.Book;
import MppLibraryProject.config.Config;
import MppLibraryProject.config.Config.StorageType;

public class BookController {
	private static HashMap<String, Book> books;
	
	public BookController(){
		books = readBookMap();
	}
	@SuppressWarnings("unchecked")
	private HashMap<String, Book> readBookMap(){
		Object object = Config.readFromStorage(Config.StorageType.BOOKS);
		return object != null ? (HashMap<String, Book>) object : new HashMap<String, Book>();
		
	}
	
	public Book getBook(String isbn) {
		if(books.containsKey(isbn)) {
			return books.get(isbn);
		}
		return null;
	}
	
	public Collection<Book> getBookList(){
		return getBooksMap();
	}
	
	private Collection<Book> getBooksMap(){
		Object object = Config.readFromStorage(Config.StorageType.BOOKS);
		return object != null ? ((HashMap<String, Book>) object).values() : new ArrayList<Book>();
	}
	
	public void createBook(Book book) {
		String isbn = book.getISBN();
		books.put(isbn, book);
		Config.saveToStorage(StorageType.BOOKS, book);
	}
	
	public void updateBook(Book book) {
		String isbn = book.getISBN();
		if(books.containsKey(isbn)) {
			books.put(isbn, book);
			Config.saveToStorage(StorageType.BOOKS, book);
		}
		
	}
	
	public void deleteBook(String isbn) {
		if(books.containsKey(isbn)) {
			books.remove(isbn);
			Config.saveToStorage(StorageType.BOOKS, books);
		}
	}
	
	public void loadBookMap(List<Book> bookList) {
		Map<String, Book> books = new HashMap<>();
		bookList.forEach(book -> books.put(book.getISBN(),book));
		Config.saveToStorage(StorageType.BOOKS, books);
	}
}
