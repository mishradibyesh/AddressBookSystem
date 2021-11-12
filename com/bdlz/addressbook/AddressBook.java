package com.bdlz.addressbook;

public class AddressBook {

	private class Contact {
		String firstName, lastName, address, city, state, emailId;
		int zipCode;
		long mobileNumber;
	}
	public void printContact() {
		Contact person = new Contact();
		person.firstName = "Dibyesh";
		person.lastName = "Mishra";
		person.address = "Sikandarpur";
		person.city = "Ballia";
		person.state = "Uttar Pradesh";
		person.zipCode = 277303;
		person.mobileNumber = 8577858332L;
		person.emailId = "dibyesh@gmail.com";
		System.out.println("Contact Details");
		System.out.println("Name         : "  + person.firstName + " " + person.lastName + "\n"
				+ "Address      : "  + person.address + "\n"
				+ "City         : "  + person.city + "\n"
				+ "State        : "  + person.state + "\n"
				+ "ZipCode      : "  + person.zipCode + "\n"
				+ "MobileNumber : "  + person.mobileNumber + "\n"
				+ "EmailId      : "  + person.emailId + "\n" );
	}
	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		addressBook.printContact();
	}
}
