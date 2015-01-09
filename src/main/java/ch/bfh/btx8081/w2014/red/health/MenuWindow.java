package ch.bfh.btx8081.w2014.red.health;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class MenuWindow extends Window {
	public enum State {
			LOGGEDOUT, LOGGEDIN, PATIENTACTIVE
		 };
	
	private State state;
	
	public MenuWindow() {
		


	}
	
	public void prepareToDisplay() {
		// Definde the State based on Session-Vars
	}
	
	private void changeToState(State st) {
		state = st;
		if(state == State.LOGGEDOUT) {
			displayPatientMenus(false);
			displayInternalMenus(false);
		} else if(state == State.LOGGEDIN) {
			displayPatientMenus(false);
			displayInternalMenus(true);
		} else {
			displayPatientMenus(true);
			displayInternalMenus(true);
		}
	}
	
	private void displayPatientMenus(boolean display) {
		// DISPLAY/HIDE YO WIFES!
	}
	
	private void displayInternalMenus(boolean display) {
		// DISPLAY/HIDE YO CHILDRENS!
	}
}
