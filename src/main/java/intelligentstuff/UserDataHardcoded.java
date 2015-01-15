package intelligentstuff;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Address;
import models.User;

/**
 * For testing purposes, this class adds test users to the project. For example,
 * this test users are used to test the password handling.
 * 
 * @author florian, philipp
 *
 */
public class UserDataHardcoded implements UserDataSource {

	private static UserDataHardcoded instance;
	private static List<User> users;

	/**
	 * The constructor generates an ArrayList with several hardcoded users.
	 */
	@SuppressWarnings("deprecation")
	private UserDataHardcoded() {
		users = new ArrayList<User>();

		User testUser = new User(3243243, "Schnyder", "Florian", new Address(
				"Dorfstrasse", "3534", "Signau", "Schweiz"), new Date(1988, 03,
				03), "flo88@gmx.ch", "04545435", "454353544", "4343234342",
				"www.google.com", "Florian", getHashAsString("gay"));
		User testUser2 = new User(324232, "Schaad", "Philipp", new Address(
				"Ghettostrasse 1", "4500", "Olten", "Deutschland"), new Date(
				1987, 04, 04), "schaadli@bluewin.ch", "4534354354",
				"543543543", "4334434", "www.google.com", "Philipp",
				getHashAsString("abc"));
		User testUser3 = new User(265656, "Testerli", "Ruedi", null, null,
				null, null, null, null, null, "test@test.com",
				getHashAsString("passw0rd"));
		User testUser4 = new User(45345345, "Walther", "Dominque Cathrine",
				new Address("Friburgstrasse", "2500", "Freiburg", "Schweiz"),
				new Date(1988, 01, 01), "domi@bfh.ch", "434343432",
				"343243343", "24343242", "www.bing.com", "Dominique",
				getHashAsString("123"));

		users.add(0, testUser);
		users.add(1, testUser2);
		users.add(2, testUser3);
		users.add(3, testUser4);
	}

	/**
	 * This method generates the only instance of the UserDataHardcoded class
	 * 
	 * @return instance of UserDataHardcoded
	 */
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
	// Check if there is a match for username and password. If yes, the method
	// returns the User object.
	// If there is no match, the method returns null
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

	/**
	 * This method hashes the passwords for the hard coded Users.
	 * 
	 * @param password
	 *            : String - the user password
	 * @return a String with the hashed password value or an empty string if the
	 *         method needs to catch a NoSuchAlgorithmEception
	 */
	public String getHashAsString(String password) {
		byte[] passwordHashByte = null;
		MessageDigest md;
		String passwordHashString;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(password.getBytes());
			passwordHashByte = md.digest();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "";
		}
		passwordHashString = new String(passwordHashByte);
		return passwordHashString;
	}

}
