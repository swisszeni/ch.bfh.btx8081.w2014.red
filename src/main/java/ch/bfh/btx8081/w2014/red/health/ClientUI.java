package ch.bfh.btx8081.w2014.red.health;

import java.io.File;
import java.net.URL;

import javax.servlet.annotation.WebServlet;

import models.Client;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import controller.ClientController;

@Theme("mytheme")
@SuppressWarnings("serial")
public class ClientUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ClientUI.class, widgetset = "ch.bfh.btx8081.w2014.red.health.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label label_title;
	@AutoGenerated
	private TextField textField_details;
	@AutoGenerated
	private Label label_lastname;
	@AutoGenerated
	private Label label_firstname;
	@AutoGenerated
	private Label label_status;
	@AutoGenerated
	private Button button_details;
	@AutoGenerated
	private Embedded embedded_picture;

	private boolean isHidden = true;
	private TextField field_lastname, field_firstname;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public ClientUI() {
		buildMainLayout();
		loadClientData(ClientController.getClientForID(13455));
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	private void setCompositionRoot(AbsoluteLayout mainLayout2) {
		// TODO Auto-generated method stub
		setContent(mainLayout);
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {

		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");

		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");

		// add a hardcoded picutre to Embedded elemet
		FileResource res = new FileResource(new File(
				"C:\\Users\\florian\\Desktop\\feeeeeediii.jpg"));

		// embedded_picture
		embedded_picture = new Embedded();
		embedded_picture.setImmediate(false);
		embedded_picture.setWidth("160px");
		embedded_picture.setHeight("200px");
		embedded_picture.setSource(res);
		embedded_picture.setType(1);
		embedded_picture.setMimeType("image/png");

		mainLayout.addComponent(embedded_picture,
				"top:100.0px;right:415.0px;left:61.0px;");

		// button_details
		button_details = new Button();
		button_details.setCaption("Details");
		button_details.setImmediate(true);
		button_details.setWidth("100.0%");
		button_details.setHeight("-1px");
		mainLayout.addComponent(button_details,
				"top:280.0px;right:290.0px;left:340.0px;");

		// label_status
		label_status = new Label();
		label_status.setImmediate(false);
		label_status.setWidth("-1px");
		label_status.setHeight("-1px");
		label_status.setValue("Status :");
		mainLayout.addComponent(label_status, "top:182.0px;left:340.0px;");

		// label_firstname
		label_firstname = new Label();
		label_firstname.setImmediate(false);
		label_firstname.setWidth("-1px");
		label_firstname.setHeight("-1px");
		label_firstname.setValue("Firstname:");
		mainLayout.addComponent(label_firstname, "top:102.0px;left:340.0px;");

		// label_firstnameTextField
		field_firstname = new TextField();
		field_firstname.setImmediate(false);
		mainLayout.addComponent(field_firstname, "top:100.0px; left:450.0px");

		// label_lastname
		label_lastname = new Label();
		label_lastname.setImmediate(false);
		label_lastname.setWidth("-1px");
		label_lastname.setHeight("-1px");
		label_lastname.setValue("Lastname:");
		mainLayout.addComponent(label_lastname, "top:142.0px;left:340.0px;");

		// label_lastnameTextField
		field_lastname = new TextField();
		field_lastname.setImmediate(false);
		mainLayout.addComponent(field_lastname, "top:140.0px; left:450.0px");

		// textField_details
		textField_details = new TextField();
		textField_details.setCaption("Details");
		textField_details.setImmediate(false);
		textField_details.setWidth("600px");
		textField_details.setHeight("160px");
		mainLayout.addComponent(textField_details, "top:360.0px;left:60.0px;");
		textField_details.setVisible(false);

		// label_title
		label_title = new Label();
		label_title.setImmediate(false);
		label_title.setWidth("-1px");
		label_title.setHeight("-1px");
		label_title.setValue("Client View");
		mainLayout.addComponent(label_title, "top:40.0px;left:61.0px;");

		// the action when the "Detail" button has been clicked. Shows and hides
		// the detail view
		button_details.addClickListener(new Button.ClickListener() {

			// this method adds or hides the client details to the ClientUI
			// after clicking the button "details"
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if (isHidden == true) {
					isHidden = false;
					textField_details.setVisible(true);

				} else {
					isHidden = true;
					textField_details.setVisible(false);
				}

			}
		});

		return mainLayout;
	}

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub

	}

	private void loadClientData(Client c) {
		field_lastname.setValue(c.getLastName());
		field_firstname.setValue(c.getFirstName());

		// FileResource res = new FileResource(new File(c.getPictureUri()));

	}

}
