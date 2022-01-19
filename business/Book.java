package MppLibraryProject.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	private int bookID;
	private String bookTitle;
	private String isbn;
	private List<Author> authorsList;
	private List<BookCopy> bookCopiesList;

	public Book(int bookID, String bookTitle, String isbn, List<Author> author) {
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.isbn = isbn;
		this.bookCopiesList = new ArrayList<BookCopy>();
		authorsList = author;
	}

	public int getBookID() {
		return bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getISBN() {
		return isbn;
	}

	public List<BookCopy> getBookCopies() {
		return bookCopiesList;
	}

	public void addBookCopies(BookCopy bookCopy) {
		bookCopiesList.add(bookCopy);
	}

	public void removeBookCopies(BookCopy bookCopy) {
		bookCopiesList.remove(bookCopy);
	}

	public void addAuthor(Author author) {
		authorsList.add(author);
	}

	public List<Author> getAuthors() {
		return authorsList;
	}

	public static void main(String[] args) {
		List<Author> authors = new ArrayList<Author>();
		authors.add(new Author("1", "Jargal", "Ganbaatar", "641-819-2339",
				new Address("1000 N 4th St", "Fairfield", "IA", 52557, null), 1, "Zohiolch"));
		authors.add(new Author("2", "Temka", "Tsogt", "641-819-2339",
				new Address("1000 N 4th St", "Fairfield", "IA", 52556, null), 1, "Zohiolch"));
		authors.add(new Author("3", "Xocoo", "S", "641-233-0095",
				new Address("106 S D St", "Fairfield", "IA", 52556, null), 1, "Zohiolch"));

		Book book = new Book(1, "Jaran Tsagaan chavgants", "978-3-16-148410-0", authors);
		book.addBookCopies(new BookCopy(book, 12, true));
		book.addBookCopies(new BookCopy(book, 35, false));

		System.out.println("Book Title: " + book.bookTitle + " author: " + Arrays.toString(book.authorsList.toArray())
				+ " " + Arrays.toString(book.bookCopiesList.toArray()));
	}
}
