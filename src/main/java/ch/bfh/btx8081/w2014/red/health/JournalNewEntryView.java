package ch.bfh.btx8081.w2014.red.health;

import models.Client;

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
		
		// return button
		button_save = new Button("Save");
		button_save.setImmediate(true);
		
		// return button
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
			// returns to the Clients List
			@Override
			public void buttonClick(ClickEvent event) {

				((MainUI) UI.getCurrent()).navigator
						.navigateTo(MainUI.JOURNALVIEW + "/" + currentClientNr);
			}
		});
		
		//event listener return button
		button_cancel.addClickListener(new Button.ClickListener() {
			// returns to the Clients List
			@Override
			public void buttonClick(ClickEvent event) {

				((MainUI) UI.getCurrent()).navigator
						.navigateTo(MainUI.JOURNALVIEW + "/" + currentClientNr);
			}
		});

	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
		currentClientNr = Integer.parseInt(event.getParameters());
		loadClientData(currentClientNr);		
		// add return button
		((MainUI) UI.getCurrent()).addMenuElement(button_return);	
		
	}
	
	private void loadClientData(int currentClient){
		currentClientNr = currentClient;
		Client client = ClientController.getClientForID(currentClientNr);
		label_clientInfo.setValue("New journal entry for "+client.getFirstName()+" "+client.getLastName()+":");
	}

}
