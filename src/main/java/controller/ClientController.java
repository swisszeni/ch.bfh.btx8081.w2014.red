package controller;

import intelligentstuff.ClientDataHardcoded;
import intelligentstuff.ClientDataSource;

import java.util.List;

import models.Client;
import models.User;

/**
 * Handles the transfer of clients within the project. Creates the only instance
 * of the ClientDataHardcoded class
 * 
 * @author raphael
 *
 */
public class ClientController {

	private static final String PICTURE_LOCATION = "..\\clients\\picture\\";
	private static ClientDataSource dataSource;

	static {
		dataSource = ClientDataHardcoded.getInstance();
	}

	/**
	 * 
	 * Returns a client for the given id
	 * 
	 * @param id
	 *            : int - clients id number
	 * @return Client
	 *
	 */
	public static Client getClientForID(int clientID) {
		return dataSource.getClientForId(clientID);
	}

	/**
	 * 
	 * Returns a list of clients with the given last name
	 * 
	 * @param lastName :  String -  the searched last name
	 * @param DetailLevel
	 * @return list of clients
	 *
	 *	
	 */
	public static List<Client> searchClientsByLastName(String lastName,
			String DetailLevel) {
		return dataSource.searchClientsByLastName(lastName);
	}

	/**
	 * Returns a list of clients form a given user
	 * 
	 * @param user : user for whom all clients are needed
	 * @param DetailLevel
	 * @return list of clients
	 */
	public static List<Client> getClientsByUser(User user, String DetailLevel) {
		return dataSource.getClientsByUser(user);
	}

	/**
	 * Creates a link for an user picture UI
	 * 
	 * @param client : client for whom the URI is needed
	 * @return String for the picture URI
	 */
	public static String createUriForProfilePicture(Client client) {
		return PICTURE_LOCATION + client.getPictureUri();
	}
}
