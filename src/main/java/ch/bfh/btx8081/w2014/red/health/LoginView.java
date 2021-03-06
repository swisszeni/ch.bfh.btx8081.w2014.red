package ch.bfh.btx8081.w2014.red.health;

import models.User;

import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import controller.UserController;

@SuppressWarnings("serial")
public class LoginView extends CustomComponent implements View {

	private TextField user = new TextField("Benutzername");
	private PasswordField password = new PasswordField("Passwort");
	private final Button loginButton;

	// private StringLengthValidator validator = new
	// StringLengthValidator("Username and password musst be provided!", 1,
	// null, false);

	// Creates the LoginView with the needed fields and a button for login
	public LoginView() {
		setSizeFull();

		user.setWidth("300px");
		user.setRequired(true);
		user.setInputPrompt("Benutzername");
		user.setInvalidAllowed(false);
		user.setRequiredError("Username must be provided!");
		user.setValidationVisible(false);

		password.setWidth("300px");
		password.setRequired(true);
		password.setValue("");
		password.setNullRepresentation("");
		password.setRequiredError("Password musst be provided!");
		password.setValidationVisible(false);

		// Checks if the username and the password entered can be found in the
		// database. If there is a null value in either the password or the user
		// field, user will be informed
		// if there is a match in the database, user will be forwarded to the
		// ClientsView.
		loginButton = new Button("Login", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {

				if (!user.isValid() || !password.isValid()) {
					user.setValidationVisible(true);
					password.setValidationVisible(true);
					user.validate();
					password.validate();
				} else {
					user.setValidationVisible(false);
					password.setValidationVisible(false);
					loginUserWithCredentials(user.getValue(),
							password.getValue());
				}
			}

		});
		loginButton.setWidth("300px");

		password.addFocusListener(new FocusListener() {
			// Add a shortcut to login when pressing enter while password-field
			// is focused
			public void focus(final FocusEvent event) {
				loginButton.setClickShortcut(KeyCode.ENTER);
			}
		});

		password.addBlurListener(new BlurListener() {
			// remove the shortcut when password-field loses focus
			@Override
			public void blur(final BlurEvent event) {
				loginButton.removeClickShortcut();
			}
		});

		// Add both to a panel
		VerticalLayout fields = new VerticalLayout(user, password, loginButton);
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

	}

	private void loginUserWithCredentials(String username, String password) {
		User loginUser = UserController.getUserForUsernameAndPassword(username,
				password);
		handleLoginResult(loginUser);
	}

	private void handleLoginResult(User loginUser) {
		if (loginUser != null) {
			getSession().setAttribute("user", loginUser);
			((MainUI) UI.getCurrent()).navigator.navigateTo(MainUI.LANDINGVIEW);
		} else {
			Notification.show("Invalid login credentials!");
			password.setValue("");
			password.focus();
		}

	}

}
