package MppLibraryProject.business;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int bookID;
	private String bookTitle;
	private String ISBN;
	private List<Author> authorsList;
	// private List<BookCopy> bookCopiesList;
	// private int borrowDays;
	private int bookCopies;

	public Book(int bookID, String bookTitle, String ISBN, int bookCopies, Author author) {
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.ISBN = ISBN;
		this.bookCopies = bookCopies;
		authorsList = new ArrayList<Author>();
		authorsList.add(author);
	}

	public int getBookID() {
		return bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getISBN() {
		return ISBN;
	}

	public void addBookCopy() {
		bookCopies++;
	}

	public int getBookCopies() {
		return bookCopies;
	}

	public void addAuthor(Author author) {
		authorsList.add(author);
	}

	public List<Author> getAuthors() {
		return authorsList;
	}
}
