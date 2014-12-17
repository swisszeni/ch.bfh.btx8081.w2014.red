package ch.bfh.btx8081.w2014.red.health;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
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
    protected static final String LANDINGVIEW = "";
    protected static final String LOGINVIEW = "login";
    protected static final String CLIENTVIEW = "client";
    protected static final String CLIENTSVIEW = "clients";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");
        
        // Create a navigator to control the views
        navigator = new Navigator(this, this);
        
        // Create and register the views
        navigator.addView(LANDINGVIEW, LandingView.class);
        navigator.addView(LOGINVIEW, LoginView.class);
        navigator.addView(CLIENTVIEW, ClientView.class);
        navigator.addView(CLIENTSVIEW, ClientsView.class);
        
        // Change Listener to prevent viewing protected views without being logged in
        navigator.addViewChangeListener(new ViewChangeListener() {
			
			@Override
			public boolean beforeViewChange(ViewChangeEvent event) {

                // Check if user is logged in or loginview is requested
                boolean isLoggedIn = getSession().getAttribute("user") != null;
                boolean isLoginView = event.getNewView() instanceof LoginView;

                if (!isLoggedIn && !isLoginView) {
                    // viewing not permitted, redirect to login
                    getNavigator().navigateTo(LOGINVIEW);
                    return false;

                } else if (isLoggedIn && isLoginView) {
                    // loginview requested while logged in... very stupid
                    return false;
                }

                // all cool, continue
                return true;
			}
			
			@Override
			public void afterViewChange(ViewChangeEvent event) {

			}
		});
    }

}
