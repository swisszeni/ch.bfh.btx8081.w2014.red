package models;

import java.util.Date;

/**
 * extends the Person class with the client attributes harmless, emergency
 * contact, doctor and journal
 * 
 * @author florian, aline, dominique, philipp
 *
 */
public class Client extends Person {

	/* this attribute shows if the patient is dangerous or not */
	private boolean harmless;
	private Person emergencyContact;
	private Doctor doc;
	private Journal journal;

	public Client(int personId, String lastName, String firstName,
			Address address, Date birthday, String email, String businessNr,
			String privateNr, String mobileNr, String pictureUri,
			boolean harmless, Person emergencyContact, Doctor doc) {
		super(personId, lastName, firstName, address, birthday, email,
				businessNr, privateNr, mobileNr, pictureUri);

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
