package MppLibraryProject.business;

public class Address {
	private String street;
	private String city;
	private String state;
	private int zip;
	private User user;

	public Address(String str, String city, String state, int zip, User user) {
		this.street = str;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.user = user;
	}

	private void setStreet(String newStr) {
		this.street = newStr;
	}

	private void setSCity(String newCity) {
		this.city = newCity;
	}

	private void setState(String newState) {
		this.state = newState;
	}

	private void setZip(int newZip) {
		this.zip = newZip;
	}

}
