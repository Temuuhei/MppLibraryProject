package MppLibraryProject.business;

public class Librarian extends User {

	private String password;

	public Librarian(String uid, String fname, String lname, String phone, String str, String city, String state,
			int zip, String password) {
		super(uid, fname, lname, phone, str, city, state, zip);
		this.password = password;
	}

//	public bolean checkOutBook(BookCopy bookcopy, Member user, Date dueDate) {
////		implement
//		return true;
//	}

}
