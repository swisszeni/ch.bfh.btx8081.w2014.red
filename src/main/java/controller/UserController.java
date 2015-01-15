package controller;

import intelligentstuff.UserDataHardcoded;
import intelligentstuff.UserDataSource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import models.User;

/**
 * Handles the transfer of users within the project. Creates the only instance of the UserDataHardcoded class
 * 
 * @author florian, philipp
 *
 */
public class UserController {

	private static UserDataSource dataSource;

	static {
		dataSource = UserDataHardcoded.getInstance();
	}

	/**
	 * Returns an user related to the given username and password.
	 * 
	 * @param username : String 
	 * @param password : String
	 * @return User
	 */
	public static User getUserForUsernameAndPassword(String username,
			String password) {

		String hashedPassword = null;
		hashedPassword = getHashAsString(password);

		return dataSource.getUserForUsernameAndPassword(username,
				hashedPassword);

	}

	/**
	 * This method hashes the given password.
	 * 
	 * @param password : String - the user password
	 * @return a String with the hashed password value or an empty string if the
	 *         method needs to catch a NoSuchAlgorithmEception
	 */
	public static String getHashAsString(String password) {
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
