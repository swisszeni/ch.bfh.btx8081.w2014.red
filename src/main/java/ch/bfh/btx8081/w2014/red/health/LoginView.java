package ch.bfh.btx8081.w2014.red.health;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends CustomComponent implements View {
    
	public LoginView() {
        setSizeFull();

        TextField user = new TextField("Benutzername");
        user.setWidth("300px");
        user.setRequired(true);
        user.setInputPrompt("Benutzername");
        user.setInvalidAllowed(false);
        
        PasswordField password = new PasswordField("Passwort");
        password.setWidth("300px");
        password.setRequired(true);
        password.setValue("");
        password.setNullRepresentation("");
        
        
        Button loginButton = new Button("Login",
                new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
            	MainUI.navigator.navigateTo(MainUI.CLIENTSVIEW);
                //MainUI.navigator.navigateTo(MainUI.CLIENTVIEW + "/" + "13455");
            }
        });
        loginButton.setWidth("300px");

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
        //Notification.show("Welcome to the Animal Farm");
    }
}
