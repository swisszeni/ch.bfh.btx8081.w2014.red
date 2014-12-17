package ch.bfh.btx8081.w2014.red.health;

import intelligentstuff.UserDataSource;

import java.security.NoSuchAlgorithmException;
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

import controller.UserController;

public class LoginView extends CustomComponent implements View, UserDataSource {

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
					checkUserAndPasswordFieldWithDatabase();
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

	public void checkUserAndPasswordFieldWithDatabase()
			throws NoSuchAlgorithmException {

		// Provides the username and the unhashed userpassword to the
		// UserContorller
		User testUser = UserController.getUserForUsernameAndPassword(
				user.getValue(), password.getValue());

		if (testUser != null) {

			MainUI.navigator.navigateTo(MainUI.CLIENTSVIEW);

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

}
