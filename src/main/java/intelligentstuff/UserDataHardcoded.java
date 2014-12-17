package intelligentstuff;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import models.User;

// @authors  Florian Schnyder, Philipp Schaad

public class UserDataHardcoded implements UserDataSource {

	private static UserDataHardcoded instance;
	private static List<User> users;

	// Generates an ArrayList with two hardcoded users
	private UserDataHardcoded() throws NoSuchAlgorithmException {
		users = new ArrayList<User>();

		User testUser = new User(3243243, null, null, null, null, null, null, null, null, null, "Florian", getHashAsString("gay"));
		User testUser2 = new User(324232, null, null, null, null, null, null, null, null, null, "Philipp", getHashAsString("abc"));
		User testUser3 = new User(265656, null, null, null, null, null, null, null, null, null, "test@test.com", getHashAsString("passw0rd"));
		User testUser4 = new User(45345345, null, null, null, null, null, null, null, null, null, "Dominique", getHashAsString("123"));

		users.add(0, testUser);
		users.add(1, testUser2);
		users.add(2, testUser3);
		users.add(3, testUser4);
	}

	public static UserDataHardcoded getInstance() {
		if (UserDataHardcoded.instance == null) {
			try {
				UserDataHardcoded.instance = new UserDataHardcoded();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	// This method hashes the passwords for the hardcoded Users
	public String getHashAsString(String password)
			throws NoSuchAlgorithmException {
		byte[] passwordHash;
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-512");
		md.update(password.getBytes());
		passwordHash = md.digest();
		return new String(passwordHash);
	}

}
