package ch.bfh.btx8081.w2014.red.health;

import models.User;








import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Theme("mytheme")
@SuppressWarnings("serial")
public class LandingView extends CustomComponent implements View {

	private Label hello;
	
	public LandingView() {
		setSizeFull();
		
		// Cant set the text now, since the view gets created before the user loggs in...
		hello = new Label();
		Button toClients = new Button("GET  TO  DA  CHOPPA!!!", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				MainUI.navigator.navigateTo(MainUI.CLIENTSVIEW);
			}
		});
		
		VerticalLayout fields = new VerticalLayout(hello, toClients);
		fields.setSpacing(true);
		fields.setMargin(true);
		fields.setSizeUndefined();
		
		VerticalLayout viewLayout = new VerticalLayout(fields);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
		setCompositionRoot(viewLayout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// Setting the welcome text
		User loggedInUser = (User) getSession().getAttribute("user");
		hello.setCaption("Hello " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
	}
}
