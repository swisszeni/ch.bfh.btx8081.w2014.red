package intelligentstuff;

import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

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
		
		clients.add(new Client(13455, "Mosimann", "Sophie", new Address("Quellgasse", "2500", "Biel", "Schweiz"), new GregorianCalendar(1900, 01, 01), "so@gmx.ch", "002493938", "8437894839", "079585858", "www.bild.ch", false, null, null));
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
		Predicate condition = new Predicate() {
			   public boolean evaluate(Object sample) {
			        return ((Client)sample).getPersonId() == id;
			   }
			};
			@SuppressWarnings("unchecked")
			List<Client> result = (List<Client>) CollectionUtils.select( clients, condition );
			if(result.size() == 1) {
				return result.get(0);
			} else {
				return null;
			}
	}

	@Override
	public List<Client> getClients() {
		return clients;
	}

	@Override
	public List<Client> getClients(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getClientsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> searchClientsByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
