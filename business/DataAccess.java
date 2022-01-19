package MppLibraryProject.business;

import java.util.HashMap;

public interface DataAccess {
	public HashMap<String, User> readUserMap();
	public HashMap<String, Book> readBookMap();
	public HashMap<String, Member> readMemberMap();
	public boolean addMember(Member member);
}
