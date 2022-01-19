package MppLibraryProject.business;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Adminstrator extends User implements DataAccess{
	private String password;
	private List<Member> members;
	private List<Book> books;
	private Map<String, Member> memberMap;
	private Map<String, Book> bookMap;

	public Adminstrator(String uid, String fname, String lname, String phone, Address address, String password) {
		super(uid, fname, lname, phone,address);
		this.password = password;
		this.members = new ArrayList<Member>();
		this.books = new ArrayList<Book>();
		this.memberMap = new HashMap<>();
		this.bookMap = new HashMap<>();
	}
	
	@Override
	public boolean addMember(Member user) {
		if(user != null) 
			return false;
		String uid = user.getUserId();
		memberMap.put(uid, user);
		return true;
	}

	public boolean addBook(int bookID, String bookTitle, String ISBN, int bookCopies, Author author) {
		Book book = new Book(bookID,bookTitle,ISBN,bookCopies,author);
		books.add(book);
		bookMap.put(book.getISBN(), book);
		return true;
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
			if (b.getISBN() == isbn)
				return b;
		}
		return null;
	}

	@Override
	public HashMap<String, User> readUserMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Book> readBookMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Member> readMemberMap() {
		// TODO Auto-generated method stub
		return null;
	}


}
