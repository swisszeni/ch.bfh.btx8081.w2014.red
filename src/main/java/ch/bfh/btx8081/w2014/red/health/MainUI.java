package ch.bfh.btx8081.w2014.red.health;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
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
	
	private HorizontalLayout menuBarContent;
	private ArrayList<Component> externalMenuBarContent;
	private MenuWindow menu;
	private boolean menu_is_visible;
    protected Navigator navigator;
    protected static final String LANDINGVIEW = "";
    protected static final String LOGINVIEW = "login";
    protected static final String CLIENTVIEW = "client";
    protected static final String CLIENTSVIEW = "clients";
    protected static final String JOURNALVIEW = "journal";
    protected static final String DETAILSVIEW = "details";
    protected static final String NEWJOURNALENTRYVIEW = "newJournalEntry";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Healthvisitor App");
        
        // The main grid to separate the Menubar from the content area
        VerticalLayout mainGrid = new VerticalLayout();
        mainGrid.setSizeFull();
        
        /*
         * THE MENU
         */     
        menuBarContent = new HorizontalLayout();
        menuBarContent.setHeight(null);
        menuBarContent.setWidth("100%");
        menuBarContent.setSpacing(false);
        
        
        //menuContent.setHeight("20px");
        externalMenuBarContent = new ArrayList<Component>();
        Button menuButton = new Button("Menu", new Button.ClickListener() {

            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
            	if(menu_is_visible) {
            		hideMenu();
            		menu_is_visible = false;
            	} else {
            		showMenu();
            		menu_is_visible = true;
            	}
                //mainWindow.removeWindow(dialogWindow);
            }

        });
        
        menuButton.setHeight("26px");
        menuButton.setWidth("100%");

        menuBarContent.addComponent(menuButton);
        menuBarContent.setExpandRatio(menuButton, 1.0f);
        
        mainGrid.addComponent(menuBarContent);
        
        menu = new MenuWindow();
        menu.setClosable(false);
        menu.setResizable(false);
        menu.setDraggable(false);
        menu.setPositionY(27);
        menu.setWidth("160px");
        
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
        navigator.addView(JOURNALVIEW, JournalView.class);
        navigator.addView(DETAILSVIEW, DetailsView.class);
        navigator.addView(NEWJOURNALENTRYVIEW, JournalNewEntryView.class);
        
        // Change Listener to prevent viewing protected views without being logged in
        navigator.addViewChangeListener(new ViewChangeListener() {
			
			@Override
			public boolean beforeViewChange(ViewChangeEvent event) {
				// Remove all the external menu elements from the old view
				removeExternalMenuElements();
				
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
    	c.setHeight("26px");
    	externalMenuBarContent.add(c);
        c.setWidth("100%");

        menuBarContent.addComponent(c);
        menuBarContent.setExpandRatio(c, 1.0f);
    }
    
    protected void removeMenuElement(Component c) {
    	menuBarContent.removeComponent(c);
    }
    
    protected void removeExternalMenuElements() {
    	for (Component component : externalMenuBarContent) {
    		menuBarContent.removeComponent(component);
		}
    	externalMenuBarContent.clear();
    }

    private void showMenu() {
        this.addWindow(menu);
    }
    
    private void hideMenu() {
    	this.removeWindow(menu);
    }
}
