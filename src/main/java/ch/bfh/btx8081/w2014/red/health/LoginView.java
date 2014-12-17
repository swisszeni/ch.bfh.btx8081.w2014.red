package ch.bfh.btx8081.w2014.red.health;

import intelligentstuff.UserDataHardcoded;
import intelligentstuff.UserDataSource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import models.User;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends CustomComponent implements View, UserDataSource {

	private String thisUser;
	byte[] userPasswordHashed;
	TextArea wrongInput = new TextArea();
	TextField user = new TextField("Benutzername");
	PasswordField password = new PasswordField("Passwort");

	// Creates the LoginView with the needed fields and a button for login
	public LoginView() {
		setSizeFull();

		wrongInput
				.setValue("Eingabe ungültig. Wiederholen Sie den Vorgang und versuchen Sie es erneut");
		wrongInput.setReadOnly(true);
		wrongInput.setVisible(false);
		wrongInput.setWidth("300px");
		wrongInput.setHeight("80px");

		user.setWidth("300px");
		user.setRequired(true);
		user.setInputPrompt("Benutzername");
		user.setInvalidAllowed(false);

		password.setWidth("300px");
		password.setRequired(true);
		password.setValue("");
		password.setNullRepresentation("");

		// Checks if the username and the password entered can be found in the
		// database
		// if not, a textarea will pup up and inform the user that the entered
		// datas could not be found.
		// if there is a match in the database, user will be forwarded to the
		// ClientsView.
		Button loginButton = new Button("Login", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					compareUserAndPasswordFieldWithDatabase();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// MainUI.navigator.navigateTo(MainUI.CLIENTVIEW + "/" +
				// "13455");
			}
		});
		loginButton.setWidth("300px");

		// Add both to a panel
		VerticalLayout fields = new VerticalLayout(wrongInput, user, password,
				loginButton);
		fields.setCaption("Bitte einloggen. (test@test.com/passw0rd)");
		fields.setSpacing(true);
		fields.setMargin(new MarginInfo(true, true, true, false));
		fields.setSizeUndefined();

		// The view root layout
		VerticalLayout viewLayout = new VerticalLayout(fields);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
		setCompositionRoot(viewLayout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// Notification.show("Welcome to the Animal Farm");
	}

	// this method compares the username and the userpassword with the userdata
	// in the database.

	public void compareUserAndPasswordFieldWithDatabase()
			throws NoSuchAlgorithmException {

		// Get the username and the hashed userpassword
		thisUser = user.getValue();
		userPasswordHashed = getHashAsByteArray(password.getValue());

		// add two test users
		UserDataHardcoded testCase = UserDataHardcoded.getInstance();
		List<User> testUsers = testCase.getUsers();

		for (User user : testUsers) {
			byte[] hashedPassword = getHashAsByteArray(user.getPassword());

			if (thisUser.equals(user.getUsername())
					&& (Arrays.equals(userPasswordHashed, hashedPassword))) {

				MainUI.navigator.navigateTo(MainUI.CLIENTSVIEW);

			}
		}
		wrongInput.setVisible(true);
		password.setValue("");

	}

	@Override
	public User getUserForId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserForUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserss(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	// This method hashes a given password. The return value is an byte Array of
	// 512 bits
	public byte[] getHashAsByteArray(String password)
			throws NoSuchAlgorithmException {
		byte[] passwordHash;
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-512");
		md.update(password.getBytes());
		passwordHash = md.digest();
		return passwordHash;
	}
}
