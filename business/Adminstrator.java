package MppLibraryProject.business;

import java.util.List;
import java.util.ArrayList;

public class Adminstrator extends User {
	private String password;
	private List<Member> members;
	private List<Book> books;

	public Adminstrator(String uid, String fname, String lname, String phone, String str, String city, String state, int zip, String password) {
		super(uid, fname, lname, phone, str,city,state,zip);
		this.password = password;
		this.members = new ArrayList<Member> members;
		this.books = new ArrayList<Book> books;
	}

	public boolean addMember(Member user) {
		if (user != null) {
			members.add(user);
			return true;
		} else
			return false;
	}

	public boolean addBook(Book book) {
		if (book != null) {
			books.add(book);
			return true;
		} else
			return false;
	}

	public Member searchMember(String memberId) {
		for (Member m : members) {
			if (m.getUserId() == memberId)
				return m;
		}
		return null;
	}

	public Book searchBook(String isbn) {
		for (Book b : books) {
			if (b.getIsbn() == isbn)
				return b;
		}
		return null;
	}

}
