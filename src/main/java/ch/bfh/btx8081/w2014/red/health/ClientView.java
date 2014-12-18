package ch.bfh.btx8081.w2014.red.health;

import java.io.File;

import models.Address;
import models.Client;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.Theme;
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
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;

import controller.ClientController;

@Theme("mytheme")
@SuppressWarnings("serial")
public class ClientView extends CustomComponent implements View {


	@AutoGenerated
	private Button button_details, button_return, button_edit, button_save, button_cancel, button_journal;
	@AutoGenerated
	private Embedded embedded_picture;
	private TextField field_lastname, field_firstname, field_mobile,
			field_email, field_street, field_zip, field_city, field_country,
			field_showstatus;
	Label field_doctor;
	Label field_emergency;
	private DateField field_birthdate;

	private boolean isHidden = true;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

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
		
		// button for the journal
		button_journal = new Button();
		button_journal.setCaption("Journal");
		button_journal.setImmediate(true);
		button_journal.setWidth("160px");
		button_journal.setHeight("-1px");
				
		
		// button to edit
		button_edit = new Button();
		button_edit.setCaption("E");
		button_edit.setImmediate(true);
//		button_edit.setWidth("120px");
//		button_edit.setHeight("-1px");
		
		// button to save
		button_save = new Button();
		button_save.setCaption("S");
		button_save.setImmediate(true);
//		button_save.setWidth("120px");
//		button_save.setHeight("-1px");
		
		// button to cancel
		button_cancel = new Button();
		button_cancel.setCaption("C");
		button_cancel.setImmediate(true);
//		button_cancel.setWidth("120px");
//		button_cancel.setHeight("-1px");
		
		
		// return button
		button_return = new Button();
		button_return.setCaption("Return");
		button_return.setImmediate(true);
		button_return.setWidth("160px");
		button_return.setHeight("-1px");
		

		// TextFields displaying primary information as first name, last name, birthdate and status. Information can be modified.
		field_firstname = new TextField("first name");
		
		field_lastname = new TextField("last name");

		field_birthdate = new DateField("birthdate");

		field_showstatus = new TextField("status");
		field_showstatus.setImmediate(false);
		
		//TextFields displaying secondary information as address, phone and eMail
		field_street = new TextField("street");
		field_street.setVisible(false);
		field_street.setWidth("250px");

		field_zip = new TextField("zip / city");
		field_zip.setVisible(false);
		field_zip.setWidth("100px");

		field_city = new TextField(" ");
		field_city.setVisible(false);
		field_city.setWidth("150px");

		field_country = new TextField("country");
		field_country.setWidth("250px");
		field_country.setVisible(false);

		field_mobile = new TextField("phone Nr.");
		field_mobile.setWidth("250px");
		field_mobile.setVisible(false);
	
		field_email = new TextField("eMail");
		field_email.setWidth("250px");
		field_email.setVisible(false);

		// labels for secondary information displaying emergency contact and attending doctor: information is not to be modified!
		field_emergency = new Label();
		field_emergency.setCaption("emergency contact");
		field_emergency.setImmediate(false);
		field_emergency.setWidth("250px");
		field_emergency.setVisible(false);

		field_doctor = new Label();
		field_doctor.setCaption("attending doctor");
		field_doctor.setImmediate(false);
		field_doctor.setWidth("250px");
		field_doctor.setVisible(false);
		
		
		HorizontalLayout hbuttons = new HorizontalLayout();
		hbuttons.addComponents(button_edit,button_save, button_cancel);
		hbuttons.setSpacing(true);
		hbuttons.setMargin(new MarginInfo(true, true, true, false));
		hbuttons.setSizeUndefined();
		
		// Adds the components to a panel viewing them on top of each other			
		VerticalLayout v1 = new VerticalLayout();
		//v1.addComponents(button_return, embedded_picture, hbuttons);
		v1.addComponents(embedded_picture, button_journal, hbuttons);
        v1.setSpacing(true);
        v1.setMargin(new MarginInfo(true, true, true, false));
		v1.setSizeUndefined();
		
		
		
		VerticalLayout v2 = new VerticalLayout();
		v2.addComponents(field_firstname, field_lastname, field_birthdate, field_showstatus, button_details);
		v2.setSpacing(true);
		v2.setMargin(new MarginInfo(true, true, true, false));
		v2.setSizeUndefined();
		
		HorizontalLayout h2 = new HorizontalLayout();
		h2.addComponents(field_zip, field_city);
		h2.setMargin(new MarginInfo(false, false, false, false));
		h2.setSizeUndefined();
		
		VerticalLayout v3 = new VerticalLayout();
		v3.addComponents(field_street, h2, field_country, field_mobile, field_email, field_emergency, field_doctor);
        //v3.setSpacing(true);
        //v3.setMargin(new MarginInfo(true, true, true, false));
		v3.setSizeUndefined();
		
		// Combines both the VerticalLayouts v1 and v2 into one HorizontalLayout viewing the upper Information next to eaxh other
		HorizontalLayout h1 = new HorizontalLayout();
		h1.addComponents(v1, v2);
		h1.setSizeUndefined();
		
		// Adds all the HorizontalLayout and the VerticalLayout into another VerticalLayout
		VerticalLayout v4 = new VerticalLayout();
		v4.addComponents(h1, v3);
		v4.setSizeUndefined();
		
		Panel p = new Panel ("ClientView");
//		p.addStyleName("panel_clientView");
		p.setWidth("");;
		p.setSizeFull();
//	    p.getContent().setSizeUndefined();
	  
	 // Create a layout inside the panel
	    final FormLayout form = new FormLayout();
	    form.setSizeFull();
	    

	    // Have some margin around it.
	    form.setMargin(true);

	    // Add some components
	    form.addComponents(v4);
//	    form.addComponent(new HorizontalLayout());

	    // Set the layout as the root layout of the panel
	    p.setContent(form);
		
		
	
		// add the Panel into another VerticalLayout for formatting and sets the Alignment to Middle Center
		VerticalLayout viewLayout = new VerticalLayout(form);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(form, Alignment.TOP_CENTER);
		setCompositionRoot(viewLayout);
				
		
		// the action when the "Detail" button has been clicked. Shows and hides
		// the detail view
		button_details.addClickListener(new Button.ClickListener() {

			// this method adds or hides the client details to the ClientUI
			// after clicking the button "details"
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hideOrShowDetails();

			}
		});
		
		// the action when the "Edit" button has been clicked. Enables textfields to enter information from details
				button_edit.addClickListener(new Button.ClickListener() {

					// Enables textfields to enter information from details
					@Override
					public void buttonClick(ClickEvent event) {
						
						field_lastname.setReadOnly(false);
						field_showstatus.setReadOnly(false);
						field_street.setReadOnly(false);
						field_zip.setReadOnly(false);
						field_city.setReadOnly(false);
						field_country.setReadOnly(false);
						field_mobile.setReadOnly(false);
						field_email.setReadOnly(false);
						
						button_save.setEnabled(true);
						button_cancel.setEnabled(true);

					}
				});
				
		// the action when the "Save" button has been clicked. Save textfields from details
				button_save.addClickListener(new Button.ClickListener() {

					// Save textfields from details
					@Override
					public void buttonClick(ClickEvent event) {
					
						field_lastname.setReadOnly(true);
						field_showstatus.setReadOnly(true);
						field_street.setReadOnly(true);
						field_zip.setReadOnly(true);
						field_city.setReadOnly(true);
						field_country.setReadOnly(true);
						field_mobile.setReadOnly(true);
						field_email.setReadOnly(true);
						
						button_cancel.setEnabled(false);

					}
				});
		
		// the action when the "Cancel" button has been clicked. Cancel edit textfields from details
				button_cancel.addClickListener(new Button.ClickListener() {

					// Cancel edit textfields from details
					@Override
					public void buttonClick(ClickEvent event) {
						
						// TODO

					}
				});		
		
		
		button_return.addClickListener(new Button.ClickListener() {
			// returns to the Clients List
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				((MainUI)UI.getCurrent()).navigator.navigateTo(MainUI.CLIENTSVIEW);
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

		int clientNr = Integer.parseInt(event.getParameters());
		Client client = ClientController.getClientForID(clientNr);
		if (client == null) {
			setCaption("Kein gültiger Klient");
			return;
		}

		setClientDataToReadOnly(false);
		loadClientData(client);
		setClientDataToReadOnly(true);

		// add return button
		((MainUI)UI.getCurrent()).addMenuElement(button_return);
	}
	

	// Hide or show the attributes of the detail part (street, zip, city,
	// country, mobile, email, emergency contact and doctor of the ClientUI
	private void hideOrShowDetails() {
		if (isHidden == true) {
			isHidden = false;

			field_street.setVisible(true);
			field_zip.setVisible(true);
			field_city.setVisible(true);
			field_country.setVisible(true);
			field_mobile.setVisible(true);
			field_email.setVisible(true);
			field_emergency.setVisible(true);
			field_doctor.setVisible(true);

		} else {
			isHidden = true;

			field_mobile.setVisible(false);
			field_email.setVisible(false);
			field_emergency.setVisible(false);
			field_doctor.setVisible(false);
			field_street.setVisible(false);
			field_zip.setVisible(false);
			field_city.setVisible(false);
			field_country.setVisible(false);
		}

	}

	// Set for all client information fields the ReadOnly state
	private void setClientDataToReadOnly(boolean readOnly) {
		field_lastname.setReadOnly(readOnly);
		field_firstname.setReadOnly(readOnly);
		field_birthdate.setReadOnly(readOnly);
		field_street.setReadOnly(readOnly);
		field_zip.setReadOnly(readOnly);
		field_city.setReadOnly(readOnly);
		field_country.setReadOnly(readOnly);
		field_mobile.setReadOnly(readOnly);
		field_mobile.setReadOnly(readOnly);
		field_email.setReadOnly(readOnly);
		field_emergency.setReadOnly(readOnly);
		field_doctor.setReadOnly(readOnly);
		field_showstatus.setReadOnly(readOnly);
	}

	// loads the client data to the related variables
	private void loadClientData(Client c) {

		field_emergency.setValue(c.getEmergencyContact().getFirstName() + " "
				+ c.getEmergencyContact().getLastName());
		field_doctor.setValue(c.getDoc().getFirstName() + " "
				+ c.getDoc().getLastName());
		field_showstatus.setValue(c.isHarmless() ? "harmless" : "harmful");

		addItemPropertyToField(c);

	}

	// binds the client datas to the related field

	private void addItemPropertyToField(Client c) {

		BeanItem<Client> item = new BeanItem<Client>(c);

		if (c.getAddress() == null) {
			Address defaultAddress = new Address(null, null, null, null);
			c.setAddress(defaultAddress);
		}

		BeanItem<Address> itemAddress = new BeanItem<Address>(c.getAddress());

		field_firstname
				.setPropertyDataSource(item.getItemProperty("firstName"));

		field_lastname.setPropertyDataSource(item.getItemProperty("lastName"));

		field_birthdate.setPropertyDataSource(item.getItemProperty("birthday"));

		field_street.setPropertyDataSource(itemAddress
				.getItemProperty("street"));

		field_zip.setPropertyDataSource(itemAddress.getItemProperty("zip"));

		field_city.setPropertyDataSource(itemAddress.getItemProperty("city"));

		field_country.setPropertyDataSource(itemAddress
				.getItemProperty("country"));

		field_mobile.setPropertyDataSource(item.getItemProperty("mobileNr"));

		field_email.setPropertyDataSource(item.getItemProperty("email"));

		isHidden = false;
		hideOrShowDetails();

	}
}
