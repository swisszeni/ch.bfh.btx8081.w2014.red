package ch.bfh.btx8081.w2014.red.health;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MainUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MainUI.class, widgetset = "ch.bfh.btx8081.w2014.red.health.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}
	
	private HorizontalLayout menuContent;
    protected Navigator navigator;
    protected static final String LANDINGVIEW = "";
    protected static final String LOGINVIEW = "login";
    protected static final String CLIENTVIEW = "client";
    protected static final String CLIENTSVIEW = "clients";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Healthvisitor App");
        
        // The main grid to separate the Menubar from the content area
        VerticalLayout mainGrid = new VerticalLayout();
        mainGrid.setSizeFull();
        
        /*
         * THE MENU
         */
        Panel menuBar = new Panel();
        menuBar.setHeight(null);
        menuBar.setWidth("100%");
        menuContent = new HorizontalLayout();
        Button menuButton = new Button("Menu");
        menuContent.addComponent(menuButton);
        menuContent.setWidth(null);
        menuContent.setMargin(false);
        menuBar.setContent(menuContent);
        
        mainGrid.addComponent(menuBar);
        
        
        /*
         * THE CONTENT
         */
        Panel contentArea = new Panel();
        contentArea.setSizeFull();
        
        mainGrid.addComponent(contentArea);
        mainGrid.setExpandRatio(contentArea, 1.0f);
        
        setContent(mainGrid);
        
        
        
        // Create a navigator to control the views
        navigator = new Navigator(this, contentArea);
        
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
    
    protected void addMenuElement(Component c) {
    	menuContent.addComponent(c);
    }
    
    protected void removeMenuElement(Component c) {
    	menuContent.removeComponent(c);
    }

}
