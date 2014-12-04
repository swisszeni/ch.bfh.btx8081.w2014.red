package intelligentstuff;

import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

import models.Address;
import models.Client;
import models.Person;
import models.User;

public class ClientDataHardcoded implements ClientDataSource {

	private static ClientDataHardcoded instance;
	private static List<Client> clients;
	
	private ClientDataHardcoded() {
		clients = new ArrayList<Client>();
		clients.add(new Client(1, "Muster", "Hans", null,
				null, "muster@mail.ch", null,
				null, null, null,
				true, null, null));
		
		clients.add(new Client(13455, "Heinzmann", "Steffie", new Address("Penisstrasse", "9001", "Bern", "Schweiz"), new GregorianCalendar(1900, 01, 01), "sokm@gmx.ch", "002493938", "8437894839", "079585858", "www.bild.ch", false, null, null));
		clients.add(new Client(888, "Mosimann", "Sophie", new Address("Quellgasse", "2500", "Biel", "Schweiz"), new GregorianCalendar(1990, 01, 01), "so@gmx.ch", "002493938", "8437894839", "079585858", "www.bild.ch",true, new Person(889, "Notfall", "Kontakt", new Address("Strasse", "Z1P", "Staaadt", "Laaaand"), null, null, null, null, null, null), null));
	}
	
	public static ClientDataHardcoded getInstance () {
		if(ClientDataHardcoded.instance == null) {
			ClientDataHardcoded.instance = new ClientDataHardcoded();
		}
		
		return ClientDataHardcoded.instance;
	}

	  
	
	@Override
	public Client getClientForId(final int id) {
		for(Client c : clients) {
			if(c.getPersonId() == id) {
				return c;
			}
		}
		
		return null;
	}

	@Override
	public List<Client> getClients() {
		return clients;
	}

	@Override
	public List<Client> getClients(int offset, int limit) {
		List<Client> cs = clients.subList(offset, limit);
		return cs;
	}

	@Override
	public List<Client> getClientsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> searchClientsByLastName(String lastName) {
		ArrayList<Client> cs = new ArrayList<Client>();
		for(Client c : clients) {
			if(c.getLastName().equals(lastName)) {
				cs.add(c);
			}
		}
		
		return cs;
	}

}
