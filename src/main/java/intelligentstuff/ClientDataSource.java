package intelligentstuff;

import java.util.List;

import models.Client;
import models.User;

public interface ClientDataSource {

	public Client getClientForId(int id);
	public List<Client> getClients();
	public List<Client> getClients(int offset, int limit);
	public List<Client> getClientsByUser(User user);
	public List<Client> searchClientsByLastName(String lastName);
}
