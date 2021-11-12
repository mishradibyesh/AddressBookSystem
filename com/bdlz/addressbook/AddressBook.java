package com.bdlz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	/*
   Declaring The Add Contact Method
   And Entering The Contact Details By Using Scanner Class
   And Printing The Contact Details Of Person
	 */

	ContactDetails person = new ContactDetails();
	List<ContactDetails> contactDetailsList = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	public void addContact() {
		System.out.println("Enter First Name : ");
		String firstName = scanner.next();
		System.out.println("Enter Last Name : ");
		String lastName = scanner.next();
		System.out.println("Enter Address : ");
		String address = scanner.next();
		System.out.println("Enter City : ");
		String city = scanner.next();
		System.out.println("Enter State : ");
		String state = scanner.next();
		System.out.println("Enter ZipCode : ");
		int zipCode = scanner.nextInt();
		System.out.println("Enter Mobile Number : ");
		long mobileNumber = scanner.nextLong();
		System.out.println("Enter EmailId : ");
		String emailId = scanner.next();
		person = new ContactDetails(firstName, lastName, address, city, state, zipCode, mobileNumber, emailId);
		contactDetailsList.add(person);
		printContact();
	}

	/*
    Declaring The Edit Contact Method
    TO Edit The Details Of Contact
    The Details Of Contact Edit By Using FirstName
    If First Name Is Match The Contact Will Edit
	 */

	public void editContact() {
		System.out.println("Enter the first name of person to edit contact");
		String firstName = scanner.next();
		if (firstName.equalsIgnoreCase(person.getFirstName())) {
			contactDetailsList.remove(contactDetailsList.indexOf(person)); 
			addContact();
		} else {
			System.out.println("The Entered First Name Is Not Match");
			editContact();
		}
	}
	public void printContact() {
		for (int i = 0; i < contactDetailsList.size(); i++) {
			person = contactDetailsList.get(i);
			System.out.println("Contact Details");
			System.out.println("Name         : " + person.getFirstName() + " " + person.getLastName() + "\n"
					+ "Address      : " + person.getAddress()   + "\n"
					+ "City         : " + person.getCity()      + "\n"
					+ "State        : " + person.getState()     + "\n"
					+ "ZipCode      : " + person.getZipCode()   + "\n"
					+ "MobileNumber : " + person.getMobileNo()  + "\n"
					+ "EmailId      : " + person.getEmailId()   + "\n");
		}
	}
}
