package MppLibraryProject.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Address address;
	private List<Role> roles;

	private User() {
	}

// address нэг чиглэлд object р дамжина
	public User(String uid, String fname, String lname, String phone, Address address) {
		this.userId = uid;
		this.firstName = fname;
		this.lastName = lname;
		this.phoneNumber = phone;
		this.address = address;
		this.roles = new ArrayList<Role>();
	}

	public boolean addRole(Role role) {
		if (role == null)
			return false;
		roles.add(role);
		return true;
	}

// comment болго
	public static boolean updateUser(User user, String uid, String fname, String lname, String phone, Address address) {
		if (user == null) {
			return false;
		}
		user.userId = uid;
		user.firstName = fname;
		user.lastName = lname;
		user.phoneNumber = phone;
		user.address = address;
		return true;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public Address getAdress() {
		return this.address;
	}
}
