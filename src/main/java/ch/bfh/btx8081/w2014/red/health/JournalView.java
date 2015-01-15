package ch.bfh.btx8081.w2014.red.health;

import models.Client;
import models.JournalEntry;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import controller.ClientController;
import intelligentstuff.JournalDataHardcoded;

/**
 * View of the journal of one specific client.
 * 
 * @author David
 *
 */
@SuppressWarnings("serial")
public class JournalView extends CustomComponent implements View, IMenuListable {
	

	private final Label label_clientInfo;
	private final Button button_newEntry, button_return;
	private Table table_entries;
	private Client client;
	private int currentClientNr;
	private BeanItemContainer<JournalEntry> journalEntries;
	
	
	public JournalView(){
		setSizeFull();	
		
		// clientInfo label
		label_clientInfo = new Label();
		
		// newEntry button
		button_newEntry = new Button("New entry");
		button_newEntry.setImmediate(true);
		
		// return button
		button_return = new Button("Return");
		button_return.setImmediate(true);
		
		// table
		table_entries = new Table();
		journalEntries = new BeanItemContainer<JournalEntry>(JournalEntry.class);
		  
	    table_entries = new Table(null, journalEntries);
	    table_entries.setVisibleColumns(new Object[]{"author", "dateOfEntry", "journalEntry"});
	    table_entries.setColumnHeader("author", "Author");
	    table_entries.setColumnHeader("dateOfEntry", "Date");
	    table_entries.setColumnHeader("journalEntry", "Text");
	        
	    table_entries.setSelectable(false);
	    table_entries.setImmediate(true); 

	    //layouts
		HorizontalLayout fields = new HorizontalLayout(label_clientInfo);
		fields.setSpacing(true);
		fields.setMargin(true);
		fields.setSizeUndefined();
		
		VerticalLayout verticalLayout = new VerticalLayout(fields, table_entries);
		verticalLayout.setSizeUndefined();
		
		VerticalLayout viewLayout = new VerticalLayout(verticalLayout);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(verticalLayout, Alignment.TOP_CENTER);
		setCompositionRoot(viewLayout);
		
		
		
		button_return.addClickListener(new Button.ClickListener() {
			// returns to the Client
			@Override
			public void buttonClick(ClickEvent event) {

				((MainUI) UI.getCurrent()).navigator
						.navigateTo(MainUI.CLIENTVIEW + "/" + currentClientNr);
			}
		});
		
		button_newEntry.addClickListener(new Button.ClickListener() {
			// go to JournalNewEntryView
			@Override
			public void buttonClick(ClickEvent event) {

				((MainUI) UI.getCurrent()).navigator
						.navigateTo(MainUI.NEWJOURNALENTRYVIEW + "/" + currentClientNr);
			}
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		currentClientNr = Integer.parseInt(event.getParameters());
		loadClientData(currentClientNr);
		loadJournalEntries(currentClientNr);
		
		
		//add new entry button
		((MainUI) UI.getCurrent()).addMenuElement(button_newEntry);
		
		// add return button
		((MainUI) UI.getCurrent()).addMenuElement(button_return);	

	}
	
	/**
	 * Gets the data of the current client by the given ID. Puts first name, name and birthday in given label.
	 * 
	 * 
	 * @param currentClient : int - ID of the current client
	 */
	private void loadClientData(int currentClient){
		currentClientNr = currentClient;
		client = ClientController.getClientForID(currentClientNr);
		label_clientInfo.setValue(client.getFirstName()+" "+client.getLastName()+", "+client.getBirthday().toString());
	}
	
	
	/**
	 * Gets the journal entries for the current client by the given ID. Puts all found entries in the defined BeanItemContainer.
	 * 
	 * @param currentClient : int - ID of current client
	 */
	private void loadJournalEntries(int currentClient){

		 journalEntries.addAll(JournalDataHardcoded.getInstance().getJournalEntries(currentClientNr));
	}
	

}
