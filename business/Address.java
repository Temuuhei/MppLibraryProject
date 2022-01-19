package MppLibraryProject.business;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

// factory method
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
