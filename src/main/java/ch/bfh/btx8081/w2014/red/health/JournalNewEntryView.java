package ch.bfh.btx8081.w2014.red.health;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import intelligentstuff.JournalDataHardcoded;
import models.Client;
import models.JournalEntry;
import models.User;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import controller.ClientController;

/**
 * View for creating new journal entries.
 * 
 * @author David
 *
 */
@SuppressWarnings("serial")
public class JournalNewEntryView extends CustomComponent implements View {

	private final Button button_return, button_save, button_cancel;
	private int currentClientNr;
	private final Label label_clientInfo;
	private TextArea textArea;
	
	public JournalNewEntryView(){
		
		// clientInfo label
		label_clientInfo = new Label();
		
		// textArea
		textArea = new TextArea();
		textArea.setColumns(50);
		
		// return button
		button_return = new Button("Return");
		button_return.setImmediate(true);
		
		// save button
		button_save = new Button("Save");
		button_save.setImmediate(true);
		
		// cancel button
		button_cancel = new Button("Cancel");
		button_cancel.setImmediate(true);
		
		 //layouts
		HorizontalLayout buttons = new HorizontalLayout(button_save, button_cancel);
		buttons.setSpacing(true);
		buttons.setMargin(true);
		buttons.setSizeUndefined();
		
		VerticalLayout verticalLayout = new VerticalLayout(label_clientInfo, textArea, buttons);
		verticalLayout.setSpacing(true);
		verticalLayout.setMargin(true);
		verticalLayout.setSizeUndefined();
		
		VerticalLayout viewLayout = new VerticalLayout(verticalLayout);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(verticalLayout, Alignment.TOP_CENTER);
		setCompositionRoot(viewLayout);
		
		
		//event listener return button
		button_return.addClickListener(new Button.ClickListener() {
			// returns to the journal view
			@Override
			public void buttonClick(ClickEvent event) {

				((MainUI) UI.getCurrent()).navigator
						.navigateTo(MainUI.JOURNALVIEW + "/" + currentClientNr);
			}
		});
		
		//event listener cancel button
		button_cancel.addClickListener(new Button.ClickListener() {
			// returns to the journal view
			@Override
			public void buttonClick(ClickEvent event) {

				((MainUI) UI.getCurrent()).navigator
						.navigateTo(MainUI.JOURNALVIEW + "/" + currentClientNr);
			}
		});
		
		//event listener save button
		button_save.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {

				//just do something if textarea is not empty
				if(!textArea.getValue().equals("")){
					
					//get date and time and save it in specific format
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					Date now = Calendar.getInstance().getTime();        
					String dateOfEntry = df.format(now);
					
					//get logged in user
					User loggedInUser = (User) getSession().getAttribute("user");
					
					//create the new journal entry
					JournalEntry newEntry = new JournalEntry(loggedInUser.getLastName()+" "+loggedInUser.getFirstName(),
							dateOfEntry, currentClientNr, textArea.getValue() );
					JournalDataHardcoded.getInstance().createJournalEntry(newEntry);
					
					//go back to journal view
					((MainUI) UI.getCurrent()).navigator
					.navigateTo(MainUI.JOURNALVIEW + "/" + currentClientNr);
					
				}
				
			}
		});

	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
		//get current client from URI
		currentClientNr = Integer.parseInt(event.getParameters());
		loadClientData(currentClientNr);		
		
		// add return button to menu
		((MainUI) UI.getCurrent()).addMenuElement(button_return);	
		
	}
	

	/**
	 * Gets the data of the current client by the given ID. Puts first name, name and birthday in given label.
	 * 
	 * 
	 * @param currentClient : int - ID of the current client
	 */
	private void loadClientData(int currentClient){
		
		//get current client to show in label
		currentClientNr = currentClient;
		Client client = ClientController.getClientForID(currentClientNr);
		label_clientInfo.setValue("New journal entry for "+client.getFirstName()+" "+client.getLastName());
	}

}
