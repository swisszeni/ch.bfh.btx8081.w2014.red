package tester;

import static org.junit.Assert.*;
import intelligentstuff.ClientDataHardcoded;
import intelligentstuff.JournalDataHardcoded;
import intelligentstuff.UserDataHardcoded;

import java.util.ArrayList;
import java.util.List;

import models.Client;
import models.JournalEntry;
import models.User;

import org.junit.Test;

public class tester {
	
	List<JournalEntry> journalEntries;
	List<Client> clients;
	Client client;
	User user;

	@Test
	public void test() {
		
		//Tests for client
		
		//Get a list of all clients (has
		clients = ClientDataHardcoded.getInstance().getClients();
		assertEquals(4, clients.size());
		
		//Get a client by id and check if right name (name is Heinzmann)
		client = ClientDataHardcoded.getInstance().getClientForId(13455);
		assertEquals("Heinzmann", client.getLastName());
		
		//Chance last name and check for new name (since she married it should be Müller-Heinzmann now)
		client.setLastName("Müller-Heinzmann");
		assertEquals("Müller-Heinzmann", client.getLastName());
		
		
		//Tests for journal entry
		
		//Get journal entries for client with id 888 and check the amount of entries (has 2 entries)
		journalEntries = new ArrayList<JournalEntry>(JournalDataHardcoded.getInstance().getJournalEntries(888));
		assertEquals(2, journalEntries.size());
		
		//Add an entry and check amount again (should have 3 entries then)
		JournalDataHardcoded.getInstance().createJournalEntry(new JournalEntry("Author", "Datum", 888, "Test Entry"));
		journalEntries = new ArrayList<JournalEntry>(JournalDataHardcoded.getInstance().getJournalEntries(888));
		assertEquals(3, journalEntries.size());
		
		
		//Tests for User
		
//		//Check login with user (check a match for given user name and password)
//		user = UserDataHardcoded.getInstance().getUserForUsernameAndPassword("test@test.com", "passw0rd");
//		assertFalse(user == null);
		
		//Same check but with wrong password
		user = UserDataHardcoded.getInstance().getUserForUsernameAndPassword("test@test.com", "wrong password");
		assertTrue(user == null);
		
	}

}
