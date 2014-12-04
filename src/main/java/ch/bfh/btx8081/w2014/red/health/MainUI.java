package ch.bfh.btx8081.w2014.red.health;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MainUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MainUI.class, widgetset = "ch.bfh.btx8081.w2014.red.health.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}
	
    protected static Navigator navigator;
    protected static final String CLIENTVIEW = "client";
    protected static final String CLIENTSVIEW = "clients";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");
        
        // Create a navigator to control the views
        navigator = new Navigator(this, this);
        
        // Create and register the views
        navigator.addView("", new LoginView());
        navigator.addView(CLIENTVIEW, new ClientView());
        navigator.addView(CLIENTSVIEW, new ClientsView());
    }

}
