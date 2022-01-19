package MppLibraryProject.business;

public class Author extends User {
	private int credential;
	private String bio;

	public Author(int userId, String firstName, String lastName, String phoneNumber, Address address, int credential,
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
}
