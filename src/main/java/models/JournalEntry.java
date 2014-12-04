package models;

import java.util.GregorianCalendar;

public class JournalEntry {
	
	private User author;
	private GregorianCalendar dateOfEntry;
	private String journalEntry;
	
	public JournalEntry (User author, GregorianCalendar dateOfEntry, String journalEntry){
		this.author = author;
		this.dateOfEntry = dateOfEntry;
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

}
