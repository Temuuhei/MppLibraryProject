package MppLibraryProject.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import MppLibraryProject.business.Checkout;
import MppLibraryProject.business.Member;
import MppLibraryProject.config.Config;
import MppLibraryProject.config.Config.StorageType;

public class MemberController {
	private static HashMap<String, Member> members;

	public MemberController() {
		members = readMemberMap();
	}

	private HashMap<String, Member> readMemberMap() {
		Object object = Config.readFromStorage(Config.StorageType.MEMBERS);
		return object != null ? (HashMap<String, Member>) object : new HashMap<String, Member>();
	}

	public Member getMember(String memberId) {
		if (members.containsKey(memberId)) {
			return members.get(memberId);
		}
		return null;
	}

	public Collection<Member> getMemberList() {
		return getMembersMap();
	}

	private Collection<Member> getMembersMap() {
		Object object = Config.readFromStorage(Config.StorageType.MEMBERS);
		return object != null ? ((HashMap<String, Member>) object).values() : new ArrayList<Member>();
	}

	public void createMember(Member member) {
		String memberId = member.getUserId();
		members.put(memberId, member);
		Config.saveToStorage(StorageType.MEMBERS, members);
	}

	public void updateMember(Member member) {
		String memberId = member.getUserId();
		if (members.containsKey(memberId)) {
			members.put(memberId, member);
			Config.saveToStorage(StorageType.MEMBERS, members);
		}
	}

	public void deleteMember(String memberId) {
		if (members.containsKey(memberId)) {
			members.remove(memberId);
			Config.saveToStorage(StorageType.MEMBERS, members);
		}
	}

	public void createCheckout(Member member, Checkout checkout) {
		String memberId = member.getUserId();
		if (members.containsKey(memberId)) {
			members.get(memberId).addCheckout(checkout);
			Config.saveToStorage(StorageType.MEMBERS, members);
		}
	}

	public void updateCheckedout(Member member, Checkout checkout, LocalDate checkedoutDate) {
		String memberId = member.getUserId();
		if (members.containsKey(memberId)) {
			List<Checkout> list = members.get(memberId).getCheckouts();
			for (Checkout c : list) {
				if (c.equals(checkout)) {
					c.setCheckedout(checkedoutDate);
					c.getBookCopy().changeAvailability();
					Config.saveToStorage(StorageType.MEMBERS, members);
					break;
				}
			}
		}
	}

	public void updateLateReturn(Member member, Checkout checkout, double lateReturnAmount, LocalDate lateReturnDate) {
		String memberId = member.getUserId();
		if (members.containsKey(memberId)) {
			List<Checkout> list = members.get(memberId).getCheckouts();
			for (Checkout c : list) {
				if (c.equals(checkout)) {
					c.setLateReturn(lateReturnAmount, lateReturnDate);
					Config.saveToStorage(StorageType.MEMBERS, members);
					break;
				}
			}
		}
	}

	public void loadMemberMap(List<Member> memberList) {
		HashMap<String, Member> members = new HashMap<String, Member>();
		memberList.forEach(member -> members.put(member.getUserId(), member));
		Config.saveToStorage(StorageType.MEMBERS, members);
	}
}
