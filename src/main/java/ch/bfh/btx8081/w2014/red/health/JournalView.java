package ch.bfh.btx8081.w2014.red.health;

import java.util.ArrayList;

import models.Client;
import models.JournalEntry;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import controller.ClientController;
import intelligentstuff.ClientDataHardcoded;
import intelligentstuff.JournalDataHardcoded;

@SuppressWarnings("serial")
public class JournalView extends CustomComponent implements View{
	

	private final Label label_clientInfo;
	private final Button button_newEntry, button_return;
	private Table table;
	private Client client;
	private int currentClientNr;
	
	
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
		table = new Table();

	     //layouts
		HorizontalLayout fields = new HorizontalLayout(label_clientInfo);
		fields.setSpacing(true);
		fields.setMargin(true);
		fields.setSizeUndefined();
		
		VerticalLayout viewLayout = new VerticalLayout(fields, table);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(fields, Alignment.TOP_CENTER);
		setCompositionRoot(viewLayout);
		
		
		
		button_return.addClickListener(new Button.ClickListener() {
			// returns to the Clients List
			@Override
			public void buttonClick(ClickEvent event) {

				((MainUI) UI.getCurrent()).navigator
						.navigateTo(MainUI.CLIENTVIEW + "/" + currentClientNr);
			}
		});
		
		button_newEntry.addClickListener(new Button.ClickListener() {
			// returns to the Clients List
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
	
	private void loadClientData(int currentClient){
		currentClientNr = currentClient;
		client = ClientController.getClientForID(currentClientNr);
		label_clientInfo.setValue(client.getFirstName()+" "+client.getLastName());
	}
	
	private void loadJournalEntries(int currentClient){
		/*
		 System.out.println("loadJournalEntries: "+currentClientNr);
		
		 BeanContainer<Integer, JournalEntry> journalEntries = new BeanContainer<Integer, JournalEntry>(JournalEntry.class);
		 journalEntries.setBeanIdProperty("clientId");

		 journalEntries.addAll(JournalDataHardcoded.getInstance().getJournalEntries(currentClientNr));

		 System.out.println("Anzahl Journal Entries: "+journalEntries.size());
	        
	      table = new Table(null, journalEntries);
	      table.setSizeFull();
	      table.setVisibleColumns(new Object[]{"clientId", "author", "dateOfEntry", "JournalEntry"});
	      table.setColumnHeader("clientId", "ClientId");
	      table.setColumnHeader("author", "Author");
	      table.setColumnHeader("dateOfEntry", "Date");
	      table.setColumnHeader("JournalEntry", "Text");
	        
	      table.setPageLength(table.size());
	        
	      table.setSelectable(false);
	      table.setImmediate(true); 
		*/
	}
	

}
