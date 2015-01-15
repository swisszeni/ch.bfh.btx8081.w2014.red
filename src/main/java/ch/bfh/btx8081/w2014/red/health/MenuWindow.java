package ch.bfh.btx8081.w2014.red.health;

import java.util.ArrayList;

import models.Client;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class MenuWindow extends Window {
	public enum State {
			LOGGEDOUT, LOGGEDIN, CLIENTACTIVE
		 };
		 
	public enum Section {
				MAIN, PATIENT
			 };
	
	private State state;
	private VerticalLayout content;
	private Button logoutButton;
	
	private ArrayList<IMenuListable> menuEntrys = new ArrayList<IMenuListable>();
	
	private ArrayList<Button> externalEntrys = new ArrayList<Button>();
	private ArrayList<Button> internalEntrys = new ArrayList<Button>();
	private ArrayList<Button> clientEntrys = new ArrayList<Button>();
	
	public MenuWindow() {
		content = new VerticalLayout();
		this.setContent(content);
		
		logoutButton = new Button("Logout", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getSession().setAttribute("user", null);
				getSession().setAttribute("client", null);
				((MainUI) UI.getCurrent()).navigator.navigateTo(MainUI.LOGINVIEW);
			}

		});
		
		logoutButton.setWidth("160px");
		
		menuEntrys.add(new LandingView());
		menuEntrys.add(new ClientsView());
		menuEntrys.add(new ClientView());
		menuEntrys.add(new JournalView());
		
		
		for (IMenuListable menuItem : menuEntrys) {
			final String subpath = menuItem.getURISubpath();
			Button button = new Button(menuItem.getMenuDisplayName(), new Button.ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					((MainUI) UI.getCurrent()).navigator.navigateTo(subpath);
				}

			});
			
			button.setWidth("160px");
			
			if(menuItem.displayInSection() == Section.PATIENT) {
				clientEntrys.add(button);
			} else if(menuItem.displayInSection() == Section.MAIN && menuItem.shouldDisplayWithState(State.LOGGEDIN)) {
				internalEntrys.add(button);
			} else {
				externalEntrys.add(button);
			}
		}
	}
	
	public void prepareToDisplay() {
		State lState;
		boolean loggedIn = ((MainUI)UI.getCurrent()).isLoggedIn();
		boolean selectedClient = ((MainUI)UI.getCurrent()).hasSelectedClient();
		if(loggedIn && selectedClient) {
			lState = State.CLIENTACTIVE;
		} else if(loggedIn) {
			lState = State.LOGGEDIN;
		} else {
			lState = State.LOGGEDOUT;
		}
		
		changeToState(lState);
	}
	
	private void changeToState(State st) {
		state = st;
		content.removeAllComponents();
		if(state == State.LOGGEDOUT) {
			displayExternalMenus();
		} else if(state == State.LOGGEDIN) {
			displayInternalMenus();
			displayLogout();
		} else {
			displayInternalMenus();
			displayClientMenus();
			displayLogout();
		}
	}
	
	private void displayClientMenus() {
		Client c = ((MainUI)UI.getCurrent()).getSelectedClient();
		content.addComponent(new Label("Client: " +c.getLastName()+" "+c.getFirstName()));
		for (Button button : clientEntrys) {
			content.addComponent(button);
		}
	}
	
	private void displayInternalMenus() {
		for (Button button : internalEntrys) {
			content.addComponent(button);
		}
	}
	
	private void displayExternalMenus() {
		content.addComponent(new Label("Please log in"));
		for (Button button : externalEntrys) {
			content.addComponent(button);
		}
	}
	
	private void displayLogout() {
		content.addComponent(new Label("System"));
		content.addComponent(logoutButton);
	}
}
