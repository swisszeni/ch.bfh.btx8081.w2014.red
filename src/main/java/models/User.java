package models;

import java.util.Date;

/**
 * extends the Person class with the user attributes username and password
 * 
 * @author florian, aline, dominique, philipp
 *
 */
public class User extends Person {

	private String username;
	private String password;

	public User(int personId, String lastName, String firstName,
			Address address, Date birthday, String email, String businessNr,
			String privateNr, String mobileNr, String pictureUri,
			String username, String password) {
		super(personId, lastName, firstName, address, birthday, email,
				businessNr, privateNr, mobileNr, pictureUri);

		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
