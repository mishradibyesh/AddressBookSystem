package com.bdlz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	static ContactDetails person ;
	static List<ContactDetails> contactDetailsList = new ArrayList<>();

	public static void addNewContact() {
		Scanner scanner = new Scanner(System.in);
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
	// method to print 
	public static void printContact() {
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

	//main method
	public static void main(String[] args) {
		addNewContact();
	}
}
