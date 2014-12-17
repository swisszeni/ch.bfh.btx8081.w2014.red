package ch.bfh.btx8081.w2014.red.health;

import intelligentstuff.ClientDataHardcoded;
import models.Client;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/** Main view with a menu */
@SuppressWarnings("serial")
public class ClientsView extends VerticalLayout implements View {
	
	private final Table table;

	public ClientsView() {
        setSizeFull();
        
        BeanContainer<Integer, Client> clients = new BeanContainer<Integer, Client>(Client.class);
        clients.setBeanIdProperty("personId");

        	clients.addAll(ClientDataHardcoded.getInstance().getClients());

        
        table = new Table(null, clients);
        table.setSizeFull();
        table.setVisibleColumns(new Object[]{"personId", "firstName", "lastName"});
        table.setColumnHeader("personId", "ID");
        table.setColumnHeader("firstName", "Vorname");
        table.setColumnHeader("lastName", "Nachname");
        
        table.setPageLength(table.size());
        
        table.setSelectable(true);
        table.setImmediate(true);
        
        table.addValueChangeListener(new ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
            	Object id = table.getValue();
            	if(id != null) {
            		table.unselect(table.getValue());
            		MainUI.navigator.navigateTo(MainUI.CLIENTVIEW + "/" + id);
            	}
            }
        });

        addComponent(table);
    }        
    
    @Override
    public void enter(ViewChangeEvent event) {
    	
    }
}