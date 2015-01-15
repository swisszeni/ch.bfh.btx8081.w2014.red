package intelligentstuff;

import java.util.List;

import models.Client;
import models.User;

/**
 * this interface has 5 methods. One returns a client by id. 4 methods return a list of clients
 * 
 * @author raphael
 *
 */
public interface ClientDataSource {
	
	/**
	 * Returns a client for the given id
	 * 
	 * @param id : int - clients id number
	 * @return Client
	 */	
	public Client getClientForId(int id);
	
	/**
	 * Returns a list of all clients
	 * 
	 * @return a list of clients
	 */
	public List<Client> getClients();
	
	/**
	 * Returns a list of clients for a given start and endpoint
	 * 
	 * @param offset : int - startpoint for the list
	 * @param limit: int - endpoint
	 * @return a list of clients
	 */
	public List<Client> getClients(int offset, int limit);
	
	/**
	 * Returns a list of all clients form a given user
	 * 
	 * @param user : user for whom all clients are needed
	 * @return a list of clients
	 */
	public List<Client> getClientsByUser(User user);
	
	/**
	 * Returns a list for all clients with the given last name
	 * 
	 * @param lastName
	 * @return a list of clients
	 */
	public List<Client> searchClientsByLastName(String lastName);
}
