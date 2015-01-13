package intelligentstuff;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;




import models.JournalEntry;
import models.User;


public class JournalDataHardcoded implements JournalDataSource{
	
	private static JournalDataHardcoded instance;
	private static List<JournalEntry> journalEntries;
	
	private JournalDataHardcoded() {
		journalEntries = new ArrayList<JournalEntry>();

		JournalEntry testEntry = new JournalEntry(null, null, 888, "Besuch zu Hause verlief ohne Zwischenfälle.");
		JournalEntry testEntry2 = new JournalEntry(null,null, 888, "Client hat gestern Abend und heute Morgen die Medikamente nicht eingenommen. Angeblich hat er es 'vergessen'.");		
		JournalEntry testEntry3 = new JournalEntry(null, null, 1, "Keine Probleme. Hat Medikamente genommen.");
		JournalEntry testEntry4 = new JournalEntry(null, null, 6, "War etwas verwirrt.");
		JournalEntry testEntry5 = new JournalEntry(null, null, 6, "Familie war auch da beim Besuch. Die scheint ihm sehr gut zu tun.");
		JournalEntry testEntry6 = new JournalEntry(null, null, 6, "Alles ok.");
		JournalEntry testEntry7 = new JournalEntry(null, null, 13455, "Klienten neigt dazu, die ganze Zeit zu singen. Sie hält sich wohl für eine Sängerin oder so.");
		
		
		
		journalEntries.add(0, testEntry);
		journalEntries.add(1, testEntry2);
		journalEntries.add(2, testEntry3);
		journalEntries.add(3, testEntry4);
		journalEntries.add(4, testEntry5);
		journalEntries.add(5, testEntry6);
		journalEntries.add(6, testEntry7);

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
		journalEntries.add(newJournalEntry);
		
	}

}
