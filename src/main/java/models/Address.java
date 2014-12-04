package models;

/* Defines street, zipcode, city, country of a specified Address */

public class Address {

	private String street;
	private String zip;
	private String city;
	private String country;

	public Address(String street, String zip, String city, String country)

	{
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.country = country;

	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString(){
		return this.street + ", " + this.zip + " " + this.city + ", " + this.country;
		
	}

}
