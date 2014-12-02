package controller;

import intelligentstuff.ClientDataHardcoded;
import intelligentstuff.ClientDataSource;

import java.util.List;

import models.Client;
import models.User;


public class ClientController {
	
	private static final String PICTURE_LOCATION = "..\\clients\\picture\\";
	private static ClientDataSource dataSource;
	
	static {
		dataSource = ClientDataHardcoded.getInstance();
	}
	
	public static Client getClientForID(int clientID){
		return dataSource.getClientForId(clientID);
	}
	
	public static List<Client> searchClientsByLastName(String lastName, String DetailLevel){
		return dataSource.searchClientsByLastName(lastName);
	}
	
	public static List<Client> getClientsByUser(User user, String DetailLevel){
		return dataSource.getClientsByUser(user);
	}

	public static String createUriForProfilePicture(Client client){
		return PICTURE_LOCATION+client.getPictureUri();
	}
}
