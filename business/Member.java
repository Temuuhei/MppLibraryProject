package MppLibraryProject.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
		return this.checkouts;
	}

	public static void main(String[] args) {
		Member member = new Member("1024", "Jargal", "Ganbaatar", "641-819-2339",
				new Address("1000 N 4th St", "Fairfield", "IA", 52557, null));
		MemberController memberController = new MemberController();
		memberController.createMember(member);
		System.out.println(memberController.getMember("1024").getUserId());

		Collection<Member> list = memberController.getMemberList();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Member member2 = (Member) iterator.next();
			System.out.println(member2.getUserId());
		}
	}
}
