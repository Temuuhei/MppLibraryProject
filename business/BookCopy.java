package MppLibraryProject.business;

import java.io.Serializable;

public class BookCopy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	private int uniqueNo;
	private boolean availability = true;

	public BookCopy(Book book, int uniqueNo, boolean availability) {
		this.book = book;
		this.uniqueNo = uniqueNo;
		this.availability = availability;
	}

	public Book getBook() {
		return book;
	}

	public int getUniqueNo() {
		return uniqueNo;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void changeAvailability() {
		availability = !availability;
	}

	@Override
	public String toString() {
		return "UniquNo:  " + getUniqueNo() + " availability: " + availability;
	}
}
