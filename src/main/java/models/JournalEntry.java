package models;

import java.util.GregorianCalendar;

public class JournalEntry {
	
	private User author;
	private GregorianCalendar dateOfEntry;
	private String journalEntry;
	private int clientId;
	
	public JournalEntry (User author, GregorianCalendar dateOfEntry, int clientId, String journalEntry){
		this.author = author;
		this.dateOfEntry = dateOfEntry;
		this.clientId = clientId;
		this.journalEntry = journalEntry;
	}
	
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public GregorianCalendar getDateOfEntry() {
		return dateOfEntry;
	}
	public void setDateOfEntry(GregorianCalendar dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}
	public String getJournalEntry() {
		return journalEntry;
	}
	public void setJournalEntry(String journalEntry) {
		this.journalEntry = journalEntry;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
}
