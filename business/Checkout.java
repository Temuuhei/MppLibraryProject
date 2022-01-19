package MppLibraryProject.business;

import java.time.LocalDate;

public class Checkout {
	private Book book;
	private Member member;
	private boolean checkedOut;
	private LocalDate checkedOutDate;
	private LocalDate dueDate;
	private double lateReturnAmount;
	private LocalDate lateReturnDate;

	public Checkout(Book book, Member member, LocalDate dueDate) {
		this.book = book;
		this.member = member;
		this.checkedOut = false;
		this.dueDate = dueDate;

		this.book.removeBookCopy();
	}

	public Book getBook() {
		return book;
	}

	public Member getMember() {
		return member;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public LocalDate getCheckedOutDate() {
		return checkedOutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public double getLateReturnAmount() {
		return lateReturnAmount;
	}

	public LocalDate getLateReturnDate() {
		return lateReturnDate;
	}

	public boolean setCheckedout(LocalDate checkedoutDate) {
		this.checkedOut = true;
		this.checkedOutDate = checkedoutDate;
		this.book.addBookCopy();

		return true;
	}

	public boolean setLateReturn(double lateReturnAmount, LocalDate lateReturnDate) {
		this.lateReturnAmount = lateReturnAmount;
		this.lateReturnDate = lateReturnDate;

		return true;
	}
}
