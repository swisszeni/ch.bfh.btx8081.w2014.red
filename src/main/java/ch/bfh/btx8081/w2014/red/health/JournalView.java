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
	private final Button button_newEntry;
	//private final Table table;
	private Client client;
	private int clientNr;
	
	
	public JournalView(){
		setSizeFull();	
		
		// clientInfo label
		label_clientInfo = new Label();
		
		// newEntry button
		button_newEntry = new Button("New entry");
		button_newEntry.setImmediate(true);
		
		/*//label
		 BeanContainer<Integer, JournalEntry> journalEntries = new BeanContainer<Integer, JournalEntry>(JournalEntry.class);
		 journalEntries.setBeanIdProperty("personId");

		 journalEntries.addAll(JournalDataHardcoded.getInstance().getJournalEntries(clientNr));

	        
	        table = new Table(null, journalEntries);
	        table.setSizeFull();
	        table.setVisibleColumns(new Object[]{"personId","author", "dateOfEntry", "JournalEntry"});
	        table.setColumnHeader("author", "Author");
	        table.setColumnHeader("dateOfEntry", "Date");
	        table.setColumnHeader("JournalEntry", "Text");
	        
	        table.setPageLength(table.size());
	        
	        table.setSelectable(false);
	        table.setImmediate(true); 
		*/
	     //layouts
		HorizontalLayout fields = new HorizontalLayout(label_clientInfo, button_newEntry);
		fields.setSpacing(true);
		fields.setMargin(true);
		fields.setSizeUndefined();
		
		VerticalLayout viewLayout = new VerticalLayout(fields);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(fields, Alignment.TOP_CENTER);
		setCompositionRoot(viewLayout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		clientNr = Integer.parseInt(event.getParameters());
		client = ClientController.getClientForID(clientNr);
		label_clientInfo.setValue(client.getFirstName()+" "+client.getLastName()+", "+client.getBirthday());
	}
	

}
