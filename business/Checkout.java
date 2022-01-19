package MppLibraryProject.business;

import java.io.Serializable;
import java.time.LocalDate;

import MppLibraryProject.config.Config.DayType;

public class Checkout implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookCopy bookCopy;
	private Member member;
	private DayType borrowDay;
	private boolean checkedOut;
	private LocalDate checkedOutDate;
	private LocalDate dueDate;
	private double lateReturnAmount;
	private LocalDate lateReturnDate;

	public Checkout(BookCopy bookCopy, Member member, DayType borrowDay) {
		this.bookCopy = bookCopy;
		this.member = member;
		this.borrowDay = borrowDay;
		this.checkedOut = false;
		this.dueDate = LocalDate.now().plusDays(Long.parseLong(borrowDay.toString().split("_")[1]));
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public Member getMember() {
		return member;
	}

	public DayType getBorrowDay() {
		return borrowDay;
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

		return true;
	}

	public boolean setLateReturn(double lateReturnAmount, LocalDate lateReturnDate) {
		this.lateReturnAmount = lateReturnAmount;
		this.lateReturnDate = lateReturnDate;

		return true;
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;

		if (ob.getClass() != getClass())
			return false;

		Checkout c = (Checkout) ob;
		return this.bookCopy.equals(c.bookCopy) && this.member.equals(c.member);
	}

	@Override
	public String toString() {
		return borrowDay.toString() + ", " + dueDate.toString() + ", " + checkedOut;
	}

}
