package MppLibraryProject.business;

import java.util.List;
import java.util.ArrayList;

public class User {
	private String userId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Address address;
	private List<Role> roles;

	private User() {
	}

	public User(String uid, String fname, String lname, String phone, String str, String city, String state, int zip) {
		this.userId = uid;
		this.firstName = fname;
		this.lastName = lname;
		this.phoneNumber = phone;
		this.address = new Address(str, city, state, zip, this);
		this.roles = new ArrayList<Role>();
	}

	public boolean addRole(Role role) {
		if (role == null)
			return false;
		roles.add(role);
		return true;
	}

	public static User addUser(String uid, String fname, String lname, String phone, Address address) {
		User user = new User();
		user.userId = uid;
		user.firstName = fname;
		user.lastName = lname;
		user.phoneNumber = phone;
		user.address = address;

		return user;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String uid) {
		this.userId = uid;
	}

	public void setFirstName(String fname) {
		this.firstName = fname;
	}

	public void setLastName(String lname) {
		this.lastName = lname;
	}

	public void setPhoneNumber(String phone) {
		this.phoneNumber = phone;
	}

	public void setAdress(Address addr) {
		this.address = addr;
	}
}