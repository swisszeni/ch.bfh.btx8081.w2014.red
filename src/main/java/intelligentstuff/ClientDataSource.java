package intelligentstuff;

import java.util.ArrayList;

import models.Client;
import models.User;

public interface ClientDataSource {

	public Client getClientForId(int id);
	public ArrayList<Client> getClients();
	public ArrayList<Client> getClients(int offset, int limit);
	public ArrayList<Client> getClientsByUser(User user);
	public ArrayList<Client> searchClientsByLastName(String lastName);
}
