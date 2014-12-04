package models;

import java.util.ArrayList;
import java.util.List;

public class Journal {

	private List<JournalEntry> journalEntries;
	
	public Journal(){
		journalEntries = new ArrayList<JournalEntry>();
	}
	
	public void addJournalEntry(JournalEntry journalEntry){
		
		journalEntries.add(journalEntry);
		
	}

	public List<JournalEntry> getJournalEntries() {
		return journalEntries;
	}
	
	
}
