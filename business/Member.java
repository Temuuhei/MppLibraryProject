package MppLibraryProject.business;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {
	private List<Checkout> checkouts;

	public Member(int userId, String firstName, String lastName, String phoneNumber, Address address) {
		super(userId, firstName, lastName, phoneNumber, address);
		this.checkouts = new ArrayList<Checkout>();
	}

	public boolean addCheckout(Checkout checkout) {
		this.checkouts.add(checkout);

		return true;
	}

	public List<Checkout> getCheckouts() {
		return this.checkouts;
	}
}
