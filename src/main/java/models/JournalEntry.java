package models;


public class JournalEntry {
	
	private String author;
	private String dateOfEntry;
	private String journalEntry;
	private int clientId;
	
	public JournalEntry (String author, String dateOfEntry, int clientId, String journalEntry){
		this.author = author;
		this.dateOfEntry = dateOfEntry;
		this.clientId = clientId;
		this.journalEntry = journalEntry;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDateOfEntry() {
		return dateOfEntry;
	}
	public void setDateOfEntry(String dateOfEntry) {
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
