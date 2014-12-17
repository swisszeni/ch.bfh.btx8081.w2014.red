package ch.bfh.btx8081.w2014.red.health;

import models.User;



import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class LandingView extends CustomComponent implements View {

	public LandingView() {
		User loggedInUser = new User(1, "Hans", "Nötig", null, null, null, null, null, null, null, null, null);//(User) getSession().getAttribute("user");
		Label hello = new Label("Hallo " + loggedInUser.getFirstName());
		
		VerticalLayout viewLayout = new VerticalLayout(hello);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(hello, Alignment.MIDDLE_CENTER);
		setCompositionRoot(viewLayout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
