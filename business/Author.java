package MppLibraryProject.business;

import java.io.Serializable;

import MppLibraryProject.controller.AuthorController;

public class Author extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int credential;
	private String bio;

	public Author(String userId, String firstName, String lastName, String phoneNumber, Address address, int credential,
			String bio) {
		super(userId, firstName, lastName, phoneNumber, address);
		this.credential = credential;
		this.bio = bio;
	}

	public int getAuthor() {
		return credential;
	}

	public void setAuthor(int credential) {
		this.credential = credential;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public static void main(String[] args) {
		Author author = new Author("1024", "Jargal", "Ganbaatar", "641-819-2339",
				new Address("1000 N 4th St", "Fairfield", "IA", 52557, null), 1, "Zohiolch");
		AuthorController authorController = new AuthorController();
		authorController.createAuthor(author);
		System.out.println(authorController.getAuthor("1024").getBio());
	}
}
