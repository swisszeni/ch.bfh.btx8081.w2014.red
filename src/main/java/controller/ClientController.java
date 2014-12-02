package controller;

import java.util.List;
import models.Client;
import models.User;


public class ClientController {
	
	private final String PICTURE_LOCATION = "..\\clients\\picture\\";
	
	public Client getClientForID(int ClientID){
		return null;
	}
	
	public List<Client> searchClientsByLastName(String lastName, String DetailLevel){
		return null;
	}
	
	public List<Client> getClientsByUser(User user, String DetailLevel){
		return null;
	}

	public String createUriForProfilePicture(Client client){
		return PICTURE_LOCATION+client.getPictureUri();
	}
}
