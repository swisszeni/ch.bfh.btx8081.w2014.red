package intelligentstuff;

import java.util.ArrayList;
import java.util.List;


import models.JournalEntry;


public class JournalDataHardcoded implements JournalDataSource{
	
	private static JournalDataHardcoded instance;
	private static List<JournalEntry> journalEntries;
	
	private JournalDataHardcoded() {
		journalEntries = new ArrayList<JournalEntry>();

		JournalEntry testEntry = new JournalEntry(null,null, 888, "Besuch zu Hause verlief ohne Zwischenfälle.");
		JournalEntry testEntry2 = new JournalEntry(null,null, 888, "Client hat gestern Abend und heute Morgen die Medikamente nicht eingenommen. Angeblich hat er es 'vergessen'.");		

		journalEntries.add(0, testEntry);
		journalEntries.add(1, testEntry2);

	}
	
	public static JournalDataHardcoded getInstance () {
		if(JournalDataHardcoded.instance == null) {
			JournalDataHardcoded.instance = new JournalDataHardcoded();
		}
		
		return JournalDataHardcoded.instance;
	}

	@Override
	public List<JournalEntry> getJournalEntries(int id) {
		ArrayList<JournalEntry> je = new ArrayList<JournalEntry>();
		for(JournalEntry j : journalEntries) {
			if(j.getClientId() == id) {
				je.add(j);
			}
		}
		
		return je;
	}

	@Override
	public void createJournalEntry(JournalEntry newJournalEntry) {
		// TODO Auto-generated method stub
		
	}

}
