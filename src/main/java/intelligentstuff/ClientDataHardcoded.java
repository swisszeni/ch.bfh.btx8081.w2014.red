package intelligentstuff;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import models.Address;
import models.Client;
import models.Doctor;
import models.Person;
import models.User;

public class ClientDataHardcoded implements ClientDataSource {

	private static ClientDataHardcoded instance;
	private static ArrayList<Client> clients;
	
	private ClientDataHardcoded() {
		clients = new ArrayList<Client>();
		clients.add(new Client("Muster", "Hans", null,
				null, "muster@mail.ch", null,
				null, null, null,
				true, null, null));
	}
	
	public static ClientDataHardcoded getInstance () {
		if(ClientDataHardcoded.instance == null) {
			ClientDataHardcoded.instance = new ClientDataHardcoded();
		}
		
		return ClientDataHardcoded.instance;
	}

	  
	
	@Override
	public Client getClientForId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getClients(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getClientsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> searchClientsByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
