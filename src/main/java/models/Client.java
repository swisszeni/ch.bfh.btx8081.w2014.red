package models;

import java.util.GregorianCalendar;

/* Defines a Client that extends all attributes of the Person class. Additional, there are the attributes harmless, an emergency contact of the client and the clients doctor*/

public class Client extends Person {

	/* this attribute shows if the patient is dangerous or not */
	private boolean harmless;
	private Person emergencyContact;
	private Doctor doc;
	private Journal journal;

	public Client(int personId, String lastName, String firstName, Address address,
			GregorianCalendar birthday, String email, String businessNr,
			String privateNr, String mobileNr, String pictureUri,
			boolean harmless, Person emergencyContact, Doctor doc) {
		super(personId, lastName, firstName, address, birthday, email, businessNr,
				privateNr, mobileNr, pictureUri);

		this.harmless = harmless;
		this.emergencyContact = emergencyContact;
		this.doc = doc;
		journal = new Journal();

	}

	public boolean isHarmless() {
		return harmless;
	}

	public void setHarmless(boolean harmless) {
		this.harmless = harmless;
	}

	public Person getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(Person emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public Doctor getDoc() {
		return doc;
	}

	public void setDoc(Doctor doc) {
		this.doc = doc;
	}

	public Journal getJournal() {
		return journal;
	}


}
