package controller;

import intelligentstuff.UserDataHardcoded;
import intelligentstuff.UserDataSource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import models.User;

public class UserController {

	private static UserDataSource dataSource;

	static {
		dataSource = UserDataHardcoded.getInstance();
	}

	public static User getUserForUsernameAndPassword(String username,
			String password) {

		String hashedPassword = null;
		try {
			hashedPassword = getHashAsString(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataSource.getUserForUsernameAndPassword(username,
				hashedPassword);

	}

	public static String getHashAsString(String password)
			throws NoSuchAlgorithmException {
		byte[] passwordHash;
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-512");
		md.update(password.getBytes());
		passwordHash = md.digest();
		return new String(passwordHash);
	}

	// public static void createNewUser(int personId, String lastName, String
	// firstName,
	// Address address, Date birthday, String email, String businessNr,
	// String privateNr, String mobileNr, String pictureUri,
	// String username, String password){
	//
	// User newUser = new User(personId, lastName, firstName, address, birthday,
	// email,
	// businessNr, privateNr, mobileNr, pictureUri, username, password);
	//
	//
	//
	// }
}
