package MppLibraryProject.business;

public class Role {
	private int roleId;
	private String name;
	private User user;
	
	public Role(int rid, String name) {
		this.roleId = rid;
		this.name = name ;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
