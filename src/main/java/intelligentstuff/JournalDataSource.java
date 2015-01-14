package intelligentstuff;

import java.util.List;

import models.JournalEntry;

public interface JournalDataSource {
	/**
	 * Gets a list of journal entries for one client defined by given id.
	 * 
	 * @param id : int - Client id to get journal entries from.
	 * @return List<JournalEntry>
	 */
	public List<JournalEntry> getJournalEntries(int id);
	
	/**
	 * Creates a new journal entry for client defined in the JournalEntry object.
	 * 
	 * @param newJournalEntry : JournalEntry
	 */
	public void createJournalEntry(JournalEntry newJournalEntry);
}
