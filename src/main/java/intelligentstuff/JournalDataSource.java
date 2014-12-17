package intelligentstuff;

import java.util.List;

import models.JournalEntry;

public interface JournalDataSource {
	public List<JournalEntry> getJournalEntries(int id);
	public void createJournalEntry(JournalEntry newJournalEntry);
}
