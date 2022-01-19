package MppLibraryProject.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import MppLibraryProject.business.User;
import MppLibraryProject.config.Config;
import MppLibraryProject.config.Config.StorageType;


public class UserController {
	private static HashMap<String, User> users;

	public UserController() {
		users = readUserMap();
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, User> readUserMap() {
		Object object = Config.readFromStorage(Config.StorageType.AUTHORS);
		return object != null ? (HashMap<String, User>) object : new HashMap<String, User>();
	}

	public User getUser(String uid) {
		if (users.containsKey(uid)) {
			return users.get(uid);
		}
		return null;
	}

	public Collection<User> getUserList() {
		return getUsersMap();
	}

	private Collection<User> getUsersMap() {
		Object object = Config.readFromStorage(Config.StorageType.USERS);
		return object != null ? ((HashMap<String, User>) object).values() : new ArrayList<User>();
	}

	public void createUser(User user) {
		String uid = user.getUserId();
		users.put(uid, user);
		Config.saveToStorage(StorageType.USERS, users);
	}

	public void updateUser(User user) {
		String uid = user.getUserId();
		if (users.containsKey(user)) {
			users.put(uid, user);
			Config.saveToStorage(StorageType.USERS, users);
		}
	}

	public void deleteUser(String uid) {
		if (users.containsKey(uid)) {
			users.remove(uid);
			Config.saveToStorage(StorageType.USERS, users);
		}
	}

	public void loadUserMap(List<User> userList) {
		Map<String, User> users = new HashMap<String, User>();
		userList.forEach(user -> users.put(user.getUserId(), user));
		Config.saveToStorage(StorageType.USERS, users);
	}
}
