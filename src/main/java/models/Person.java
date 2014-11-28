package models;

import java.util.GregorianCalendar;

/* Defines an ID, lastname, firstname, address etc. from a specified Person */

public class Person {

	private String lastName;
	private String firstName;
	private Address address;
	private GregorianCalendar birthday;
	private String email;
	private String businessNr;
	private String privateNr;
	private String mobileNr;
	private String pictureUri;

	public Person(String lastName, String firstName, Address address,
			GregorianCalendar birthday, String email, String businessNr,
			String privateNr, String mobileNr, String pictureUri)

	{

		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.birthday = birthday;
		this.email = email;
		this.businessNr = businessNr;
		this.privateNr = privateNr;
		this.mobileNr = mobileNr;
		this.pictureUri = pictureUri;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public GregorianCalendar getBirthday() {
		return birthday;
	}

	public void setBirthday(GregorianCalendar birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBusinessNr() {
		return businessNr;
	}

	public void setBusinessNr(String businessNr) {
		this.businessNr = businessNr;
	}

	public String getPrivateNr() {
		return privateNr;
	}

	public void setPrivateNr(String privateNr) {
		this.privateNr = privateNr;
	}

	public String getMobileNr() {
		return mobileNr;
	}

	public void setMobileNr(String mobileNr) {
		this.mobileNr = mobileNr;
	}

	public String getPictureUri() {
		return pictureUri;
	}

	public void setPictureUri(String pictureUri) {
		this.pictureUri = pictureUri;
	}

	/*
	 * public void deletePerson (Person person) {
	 * 
	 * }
	 */
}
