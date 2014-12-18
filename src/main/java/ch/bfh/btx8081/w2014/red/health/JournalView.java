package ch.bfh.btx8081.w2014.red.health;

import models.Client;

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

@SuppressWarnings("serial")
public class JournalView extends CustomComponent implements View{
	

	private final Label label_clientInfo;
	private final Button button_newEntry;
	private final Table table;
	private Client client;
	
	
	public JournalView(){
		setSizeFull();	
		
		// clientInfo label
		label_clientInfo = new Label();
		
		// newEntry button
		button_newEntry = new Button("New entry");
		button_newEntry.setImmediate(true);
		
		// table
		table = new Table();
		
		HorizontalLayout fields = new HorizontalLayout(label_clientInfo, button_newEntry);
		fields.setSpacing(true);
		fields.setMargin(true);
		fields.setSizeUndefined();
		
		VerticalLayout viewLayout = new VerticalLayout(fields, table);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(fields, Alignment.TOP_CENTER);
		setCompositionRoot(viewLayout);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		int clientNr = Integer.parseInt(event.getParameters());
		client = ClientController.getClientForID(clientNr);
		label_clientInfo.setValue(client.getFirstName()+" "+client.getLastName()+", "+client.getBirthday());
	}
	

}
