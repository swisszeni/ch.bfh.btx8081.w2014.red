package models;

import java.util.GregorianCalendar;

public class Doctor extends Person {

	private String zsrNr;
	private String specialication;
	private Address workingAddress;

	public Doctor(String lastName, String firstName, Address address,
			GregorianCalendar birthday, String email, String businessNr,
			String privateNr, String mobileNr, String pictureUri, String zsrNr,
			String specialication, Address workingAddress) {
		super(lastName, firstName, address, birthday, email, businessNr,
				privateNr, mobileNr, pictureUri);

		this.zsrNr = zsrNr;
		this.specialication = specialication;
		this.workingAddress = workingAddress;

	}

	public String getZsrNr() {
		return zsrNr;
	}

	public void setZsrNr(String zsrNr) {
		this.zsrNr = zsrNr;
	}

	public String getSpecialication() {
		return specialication;
	}

	public void setSpecialication(String specialication) {
		this.specialication = specialication;
	}

	public Address getWorkingAddress() {
		return workingAddress;
	}

	public void setWorkingAddress(Address workingAddress) {
		this.workingAddress = workingAddress;
	}

}
