package intelligentstuff;

import java.util.ArrayList;
import java.util.List;

import models.User;

// @authors  Florian Schnyder, Philipp Schaad

public class UserDataHardcoded implements UserDataSource {

	private static UserDataHardcoded instance;
	private static List<User> users;

	// Generates an ArrayList with two hardcoded users
	private UserDataHardcoded() {
		users = new ArrayList<User>();

		User testUser = new User(3243243, null, null, null, null, null, null, null, null, null, "Florian", "gay");
		User testUser2 = new User(324232, null, null, null, null, null, null, null, null, null, "Philipp", "abc");
		User testUser3 = new User(265656, null, null, null, null, null, null, null, null, null, "test@test.com", "passw0rd");

		users.add(0, testUser);
		users.add(1, testUser2);
		users.add(2, testUser3);
	}

	public static UserDataHardcoded getInstance() {
		if (UserDataHardcoded.instance == null) {
			UserDataHardcoded.instance = new UserDataHardcoded();
		}

		return UserDataHardcoded.instance;
	}

	@Override
	public User getUserForId(int id) {
		return null;
	}

	@Override
	public User getUserForUsernameAndPassword(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username)
					&& user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public List<User> getUserss(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
