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
		hashedPassword = getHashAsString(password);

		return dataSource.getUserForUsernameAndPassword(username,
				hashedPassword);

	}

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
		}
		 passwordHashString = new String(passwordHashByte);
		 return passwordHashString;
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
