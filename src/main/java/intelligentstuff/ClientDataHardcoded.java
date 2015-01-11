package intelligentstuff;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import models.Address;
import models.Client;
import models.Doctor;
import models.Person;
import models.User;

public class ClientDataHardcoded implements ClientDataSource {

	private static ClientDataHardcoded instance;
	private static List<Client> clients;
	
	@SuppressWarnings("deprecation")
	private ClientDataHardcoded() {
		clients = new ArrayList<Client>();
		
		
		Doctor zoid = new Doctor(1987345, "Zoidberg", "Dr John A.", null, null, "zoidberg@planetexpress.com", null, null, null, null, null, null, null);
		Doctor fry = new Doctor(122345, "Fry", "Philip J.", null, null, "fry@planetexpress.com", null, null, null, null, null, null, null);
		
		Person emer1 = new Person(889, "Notfall", "Kontakt", new Address("Strasse", "Z1P", "Staaadt", "Laaaand"), null, null, null, null, null, null);
		Person emer2 = new Person(756769, "Leela", "Turanga", null, null, "leela@deliveryexpress.com", null, null, null, null);
		
		clients.add(new Client(1, "Muster", "Hans", null,null, "muster@mail.ch", null, null, null, "http://raw.githubusercontent.com/swisszeni/ch.bfh.btx8081.w2014.red/master/doc/task11/f.jpg", true, fry, zoid));
		clients.add(new Client(13455, "Heinzmann", "Steffie", new Address("Münstergasse 34", "9001", "Bern", "Schweiz"), new Date(1900, 01, 01), "sokm@gmx.ch", "002493938", "8437894839", "079585858", "https://raw.githubusercontent.com/swisszeni/ch.bfh.btx8081.w2014.red/master/doc/task11/s.jpg", false, emer2, zoid));
		clients.add(new Client(888, "Mosimann", "Sophie", new Address("Quellgasse", "2500", "Biel", "Schweiz"), new Date(1990, 01, 01), "so@gmx.ch", "002493938", "8437894839", "079585858", "https://raw.githubusercontent.com/swisszeni/ch.bfh.btx8081.w2014.red/master/doc/task11/m.jpg",true, emer1, fry));
		clients.add(new Client(6, "Sasha", "Grey", new Address("Tubestreet", "6666", "Interwebs", "United States"), new Date(1988, 01, 01), "sg@gmx.ch", "002493938", "8437894839", "079585858", "",true, emer1, zoid));
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
