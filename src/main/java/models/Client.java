package models;

import java.util.GregorianCalendar;

public class Client extends Person {

	private boolean harmless;
	private Person emergencyContact;
	private Doctor doc;

	public Client(String lastName, String firstName, Address address,
			GregorianCalendar birthday, String email, String businessNr,
			String privateNr, String mobileNr, String pictureUri,
			boolean harmless, Person emergencyContact, Doctor doc) {
		super(lastName, firstName, address, birthday, email, businessNr,
				privateNr, mobileNr, pictureUri);


		this.harmless = harmless;
		this.emergencyContact = emergencyContact;
		this.doc = doc;

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

}
