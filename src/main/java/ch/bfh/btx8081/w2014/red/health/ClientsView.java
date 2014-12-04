package ch.bfh.btx8081.w2014.red.health;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/** Main view with a menu */
public class ClientsView extends VerticalLayout implements View {

    public ClientsView() {
        setSizeFull();

    }        
    
    @Override
    public void enter(ViewChangeEvent event) {

    }
}