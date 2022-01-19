package MppLibraryProject.business;

public class Librarian extends User {

	private String password;

	public Librarian(String uid, String fname, String lname, String phone, Address address, String password) {
		super(uid, fname, lname, phone, address);
		this.password = password;
	}

//	public boolean checkOutBook(BookCopy bookcopy, Member user, Date dueDate) {
////		implement
//		return true;
//	}

}
