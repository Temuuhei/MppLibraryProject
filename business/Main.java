package MppLibraryProject.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import MppLibraryProject.config.Config.DayType;
import MppLibraryProject.controller.AuthorController;
import MppLibraryProject.controller.BookController;
import MppLibraryProject.controller.MemberController;
import MppLibraryProject.controller.UserController;

public class Main {

	static AuthorController authorController = new AuthorController();
	static BookController bookController = new BookController();
	static MemberController memberController = new MemberController();
	static UserController userController = new UserController();

	public static void main(String[] args) {
		Main c = new Main();
		c.bookData();
		c.libraryMemberData();
		c.userData();
		c.authorData();

		System.out.println("Book: " + bookController.getBook("23-11451").getBookTitle());
		System.out.println("Member: " + memberController.getMember("1003").getFirstName());
		System.out.println("Author: " + authorController.getAuthor("A3").getFirstName());

		Checkout checkout = new Checkout(bookController.getBook("23-11451").getBookCopies().get(0),
				memberController.getMember("1003"), DayType.SEVEN_7);
		memberController.createCheckout(memberController.getMember("1003"), checkout);

		System.out.println("Member: " + memberController.getMember("1003").getCheckouts());

	}

	/// create books
	public void bookData() {
		allBooks.get(0).addBookCopies(new BookCopy(allBooks.get(0), 1, true));
		;
		allBooks.get(0).addBookCopies(new BookCopy(allBooks.get(0), 2, true));
		allBooks.get(1).addBookCopies(new BookCopy(allBooks.get(1), 1, true));
		allBooks.get(3).addBookCopies(new BookCopy(allBooks.get(3), 1, true));
		allBooks.get(2).addBookCopies(new BookCopy(allBooks.get(2), 1, true));
		allBooks.get(2).addBookCopies(new BookCopy(allBooks.get(2), 2, true));
		bookController.loadBookMap(allBooks);
	}

	public void userData() {
		userController.loadUserMap(allUsers);
	}

	public void authorData() {
		authorController.loadAuthorMap(allAuthors);
	}

	// create library members
	public void libraryMemberData() {

		Member libraryMember = new Member("1001", "Andy", "Rogers", "641-223-2211", addresses.get(4));
		members.add(libraryMember);

		libraryMember = new Member("1002", "Drew", "Stevens", "702-998-2414", addresses.get(5));
		members.add(libraryMember);

		libraryMember = new Member("1003", "Sarah", "Eagleton", "451-234-8811", addresses.get(6));
		members.add(libraryMember);

		libraryMember = new Member("1004", "Ricardo", "Montalbahn", "641-472-2871", addresses.get(7));
		members.add(libraryMember);

		memberController.loadMemberMap(members);
	}

	///////////// DATA //////////////
	List<Member> members = new ArrayList<Member>();
	@SuppressWarnings("serial")

	List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("101 S. Main", "Fairfield", "IA", 52556, null));
			add(new Address("51 S. George", "Georgetown", "MI", 65434, null));
			add(new Address("23 Headley Ave", "Seville", "Georgia", 41234, null));
			add(new Address("1 N. Baton", "Baton Rouge", "LA", 33556, null));
			add(new Address("5001 Venice Dr.", "Los Angeles", "CA", 93736, null));
			add(new Address("1435 Channing Ave", "Palo Alto", "CA", 94301, null));
			add(new Address("42 Dogwood Dr.", "Fairfield", "IA", 52556, null));
			add(new Address("501 Central", "Mountain View", "CA", 94707, null));
		}
	};

	@SuppressWarnings("serial")
	public List<Author> allAuthors = new ArrayList<Author>() {
		{
			add(new Author("A1", "Joe", "Thomas", "641-445-2123", addresses.get(0), 1, "A happy man is he."));
			add(new Author("A2", "Sandra", "Thomas", "641-445-2123", addresses.get(0), 2, "A happy wife is she."));
			add(new Author("A3", "Nirmal", "Pugh", "641-919-3223", addresses.get(1), 3, "Thinker of thoughts."));
			add(new Author("A4", "Andrew", "Cleveland", "976-445-2232", addresses.get(2), 4,
					"Author of childrens' books."));
			add(new Author("A5", "Sarah", "Connor", "123-422-2663", addresses.get(3), 5,
					"Known for her clever style."));
		}
	};

	@SuppressWarnings("serial")
	List<Book> allBooks = new ArrayList<Book>() {
		{
			add(new Book(1, "The Big Fish", "23-11451", Arrays.asList(allAuthors.get(0), allAuthors.get(1))));
			add(new Book(2, "Antartica", "28-12331", Arrays.asList(allAuthors.get(2))));
			add(new Book(3, "Thinking Java", "99-22223", Arrays.asList(allAuthors.get(3))));
			add(new Book(4, "Jimmy's First Day of School", "48-56882", Arrays.asList(allAuthors.get(4))));
		}
	};

	@SuppressWarnings("serial")
	List<User> allUsers = new ArrayList<User>() {
		{
			add(new User("101", "admin1", "admin1", "123-422-2663", addresses.get(2)));
			add(new User("102", "admin2", "admin2", "123-422-2663", addresses.get(0)));
			add(new User("103", "admin3", "admin3", "123-422-2663", addresses.get(3)));
		}
	};

}
