package MppLibraryProject.business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import MppLibraryProject.config.Config.DayType;
import MppLibraryProject.controller.MemberController;

public class Member extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Checkout> checkouts;

	public Member(String userId, String firstName, String lastName, String phoneNumber, Address address) {
		super(userId, firstName, lastName, phoneNumber, address);
		this.checkouts = new ArrayList<Checkout>();
	}

	public boolean addCheckout(Checkout checkout) {
		this.checkouts.add(checkout);

		return true;
	}

	public List<Checkout> getCheckouts() {
		Comparator<Checkout> compareByDate = (o1, o2) -> o1.getDueDate().compareTo(o2.getDueDate());
		Collections.sort(this.checkouts, compareByDate);
		return this.checkouts;
	}

	public static void main(String[] args) {
		Member member = new Member("1024", "Jargal", "Ganbaatar", "641-819-2339",
				new Address("1000 N 4th St", "Fairfield", "IA", 52557, null));
		MemberController memberController = new MemberController();
		memberController.createMember(member);
		System.out.println(memberController.getMember("1024").getUserId());

		BookCopy bookCopy = new BookCopy(null, 1, true);

		Checkout checkout = new Checkout(bookCopy, member, DayType.SEVEN_7);
		memberController.createCheckout(member, checkout);
		System.out.println(memberController.getMember("1024").getCheckouts());

		memberController.updateCheckedout(member, checkout, LocalDate.now());
		System.out.println(memberController.getMember("1024").getCheckouts());
	}
}
