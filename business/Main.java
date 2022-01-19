package MppLibraryProject.business;

public class Main {

	public static void main(String[] args) {
		Author author =Author new();
		Book book = new Book(0, "Bi medexgui", "978-1-56619-909-4", 5, author);
		book.addAuthor(Author author);
	}

}
