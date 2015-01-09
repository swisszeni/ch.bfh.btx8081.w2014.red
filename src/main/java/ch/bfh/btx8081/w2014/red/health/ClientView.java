package ch.bfh.btx8081.w2014.red.health;

import java.io.File;

import models.Client;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.Theme;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import controller.ClientController;

@Theme("mytheme")
@SuppressWarnings("serial")
public class ClientView extends CustomComponent implements View {

	private FieldGroup binder;
	private int currentClientNr;

	@AutoGenerated
	private Button button_details, button_return, button_journal, button_edit, button_save,
			button_cancel;
	@AutoGenerated
	private Embedded embedded_picture;
	private TextField field_lastname, field_firstname;
	private NativeSelect field_showstatus;
	private DateField field_birthdate;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public ClientView() {
		setSizeFull();

		// add a hardcoded picture to Embedded element
		FileResource res = new FileResource(new File(
				"C:\\Users\\florian\\Desktop\\feeeeeediii.jpg"));

		// sets size ans type of embedded picture
		embedded_picture = new Embedded();
		embedded_picture.setImmediate(false);
		embedded_picture.setWidth("160px");
		embedded_picture.setHeight("200px");
		embedded_picture.setSource(res);
		embedded_picture.setType(1);
		embedded_picture.setMimeType("image/png");

		// button for details
		button_details = new Button();
		button_details.setCaption("Details");
		button_details.setImmediate(true);
		button_details.setWidth("185px");
		button_details.setHeight("-1px");

		// button to edit
		button_edit = new Button();
		button_edit.setCaption("Edit");
		button_edit.setImmediate(true);

		// button to save
		button_save = new Button();
		button_save.setCaption("Save");
		button_save.setImmediate(true);

		// button to cancel
		button_cancel = new Button();
		button_cancel.setCaption("Cancel");
		button_cancel.setImmediate(true);

		// return button
		button_journal = new Button();
		button_journal.setCaption("Journal");
		button_journal.setImmediate(true);
				
		// return button
		button_return = new Button();
		button_return.setCaption("Return");
		button_return.setImmediate(true);
		button_return.setWidth("160px");
		button_return.setHeight("-1px");

		// TextFields displaying primary information as first name, last name,
		// birthdate and status. Information can be modified.
		field_firstname = new TextField("first name");

		field_lastname = new TextField("last name");

		field_birthdate = new DateField("birthdate");

		field_showstatus = new NativeSelect();
		field_showstatus.addItem("harmless");
		field_showstatus.addItem("harmful");
		field_showstatus.setCaption("status");
		field_showstatus.setImmediate(false);

		HorizontalLayout hbuttons = new HorizontalLayout();
		hbuttons.addComponents(button_edit, button_save, button_cancel);
		hbuttons.setSpacing(true);
		hbuttons.setMargin(new MarginInfo(true, true, true, false));
		hbuttons.setSizeUndefined();

		// Adds the components to a panel viewing them on top of each other
		VerticalLayout v1 = new VerticalLayout();
		v1.addComponents(embedded_picture, hbuttons);
		v1.setSpacing(true);
		v1.setMargin(new MarginInfo(true, true, true, false));
		v1.setSizeUndefined();

		VerticalLayout v2 = new VerticalLayout();
		v2.addComponents(button_details, field_firstname, field_lastname,
				field_birthdate, field_showstatus);
		v2.setSpacing(true);
		v2.setMargin(new MarginInfo(true, true, true, false));
		v2.setSizeUndefined();

		// Combines both the VerticalLayouts v1 and v2 into one HorizontalLayout
		// viewing the upper Information next to each other
		HorizontalLayout h1 = new HorizontalLayout();
		h1.addComponents(v1, v2);
		h1.setSizeUndefined();

		// and the VerticalLAyout v4 into another VerticalLayout for formatting
		// and sets the Alignment to Middle Center
		VerticalLayout viewLayout = new VerticalLayout(h1);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(h1, Alignment.TOP_CENTER);
		setCompositionRoot(viewLayout);

		// navigates the user to a new detail view
		button_details.addClickListener(new Button.ClickListener() {
			// returns to the Clients List
			@Override
			public void buttonClick(ClickEvent event) {

				((MainUI) UI.getCurrent()).navigator
						.navigateTo(MainUI.DETAILSVIEW + "/" + currentClientNr);
			}
		});

		// the action when the "Edit" button has been clicked. Enables
		// textfields to enter information from details
		button_edit.addClickListener(new Button.ClickListener() {

			// Enables textfields to enter information from details
			@Override
			public void buttonClick(ClickEvent event) {

				setClientDataToReadOnly(false);

				button_save.setVisible(true);
				button_cancel.setVisible(true);
				button_edit.setVisible(false);

			}
		});

		// the action when the "Save" button has been clicked. Save textfields
		// from details
		button_save.addClickListener(new Button.ClickListener() {

			// Save textfields from details
			@Override
			public void buttonClick(ClickEvent event) {

				try {
					binder.commit();
				} catch (CommitException e) {

					e.printStackTrace();
				}

				setClientDataToReadOnly(true);

				button_save.setVisible(false);
				button_cancel.setVisible(false);
				button_edit.setVisible(true);

			}
		});

		// the action when the "Cancel" button has been clicked. Cancel edit
		// textfields from details
		button_cancel.addClickListener(new Button.ClickListener() {

			// Cancel edit textfields from details
			@Override
			public void buttonClick(ClickEvent event) {

				binder.discard();

				setClientDataToReadOnly(true);

				button_save.setVisible(false);
				button_cancel.setVisible(false);
				button_edit.setVisible(true);

			}
		});

		button_return.addClickListener(new Button.ClickListener() {
			// returns to the Clients List
			@Override
			public void buttonClick(ClickEvent event) {
				((MainUI) UI.getCurrent()).navigator
						.navigateTo(MainUI.CLIENTSVIEW);
			}
		});
		
		button_journal.addClickListener(new Button.ClickListener() {
			// returns to the Clients List
			@Override
			public void buttonClick(ClickEvent event) {
				showJournalviewForDisplayingClient();
			}
		});

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// Check if valid client
		if (event.getParameters() == null || event.getParameters().isEmpty()) {
			setCaption("Kein Klient übermittelt");
			return;
		}

		currentClientNr = Integer.parseInt(event.getParameters());
		Client client = ClientController.getClientForID(currentClientNr);
		if (client == null) {
			setCaption("Kein gültiger Klient");
			return;
		}

		setClientDataToReadOnly(false);
		loadClientData(client);
		setClientDataToReadOnly(true);

		// add return button
		((MainUI) UI.getCurrent()).addMenuElement(button_journal);
		((MainUI) UI.getCurrent()).addMenuElement(button_return);
	}
	
	
	private void showJournalviewForDisplayingClient() {
		((MainUI)UI.getCurrent()).navigator.navigateTo(MainUI.JOURNALVIEW + "/" + currentClientNr);
	}

	// Set for all client information fields the ReadOnly state
	private void setClientDataToReadOnly(boolean readOnly) {
		field_lastname.setReadOnly(readOnly);
		field_firstname.setReadOnly(readOnly);
		field_birthdate.setReadOnly(readOnly);
		field_showstatus.setReadOnly(readOnly);
	}

	// loads the client data to the related variables
	private void loadClientData(Client c) {

		field_showstatus.setValue(c.isHarmless() ? "harmless" : "harmful");

		addItemPropertyToField(c);

		button_save.setVisible(false);
		button_cancel.setVisible(false);
		button_edit.setVisible(true);

	}

	// binds the client datas to the related field.

	private void addItemPropertyToField(Client c) {
		
		BeanItem<Client> item = new BeanItem<Client>(c);

		field_firstname
				.setPropertyDataSource(item.getItemProperty("firstName"));

		field_lastname.setPropertyDataSource(item.getItemProperty("lastName"));

		field_birthdate.setPropertyDataSource(item.getItemProperty("birthday"));

		// the binder object is responsible for the save/cancel handling
		binder = new FieldGroup(item);

		binder.bind(field_firstname, "firstName");
		binder.bind(field_lastname, "lastName");
		binder.bind(field_birthdate, "birthday");

		binder.setBuffered(true);

	}
}
