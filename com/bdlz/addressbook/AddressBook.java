package com.bdlz.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	/*
	 *  creating multiple addressbook with the help of HashMap
	 * 
	 */

	HashMap <String , ArrayList<ContactDetails>> hashmap = new HashMap();
	Scanner scanner = new Scanner(System.in);

	public void addAddressBook() {
		System.out.println("Enter the name of the addressBook");
		String bookName = scanner.nextLine();

		if(hashmap.containsKey(bookName)) {
			System.out.println("This BookName is already entered ! please type another name");
			addAddressBook();
		}
		else {
			List<ContactDetails> contactDetailsList = new ArrayList<ContactDetails>();
			hashmap.put(bookName, (ArrayList<ContactDetails>) contactDetailsList);
			System.out.println("AddressBook Added successfully!");

		}
		System.out.println("do you want to add more addressbook ? press 1 if yes");
		int choice = scanner.nextInt();
		if(choice == 1) {
			addAddressBook();
		}
	}
	public void addContact() {
		System.out.println("Enter the name of Address book to add the contact.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact)) {
			writeContact(hashmap.get(newContact));
		}
		else {
			System.out.println("this addressBook is not exist");
		}

	}
	// method to write the contact details
	public void writeContact(ArrayList list) {
		ContactDetails contact = new ContactDetails();
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
		contact = new ContactDetails(firstName, lastName, address, city, state, zipCode, mobileNumber, emailId);
		list.add(contact);

	}

	/*
    Declaring The Edit Contact Method
    TO Edit The Details Of Contact
    The Details Of Contact Edit By Using FirstName
    If First Name Is Match The Contact Will Edit
	 */

	public void editContact() {
		System.out.println("Enter the name of Address book to edit the contact.");
		scanner.nextLine();
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact)) {
			System.out.println("Enter the first name of person to edit contact");
			String editName = scanner.next();
			boolean edited = false;
			for (int i = 0; i < hashmap.get(newContact).size(); i++) {
				String name = hashmap.get(newContact).get(i).getFirstName();
				if (name.equalsIgnoreCase(editName)) {
					writeContact(hashmap.get(newContact));
					edited = true;
					break;
				}
			}
			if (!edited) {
				System.out.println("enter name is incorrect");
			}	

		}
		else {
			System.out.println("the entered addressbook is not in existence");
		}

	}

	/*
    Declaring Delete Contact Method
    TO delete The Details Of Contact
    The Details Of Contact Delete By Using FirstName
    If First Name Is Match Then Contact Will Delete
	 */

	public void deleteContact() {
		System.out.println("Enter the name of Address book to delete the contact.");
		scanner.nextLine();
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact)) {
			System.out.println("Enter the first name of person to delete contact");
			String deleteName = scanner.next();
			int i = 0;
			for ( ;i < hashmap.get(newContact).size(); i++) {
				String name = hashmap.get(newContact).get(i).getFirstName();
				if (name.equalsIgnoreCase(deleteName)) {
					break;
				}
			}
			if (i < hashmap.get(newContact).size()) {
				hashmap.get(newContact).remove(i);
				System.out.println("Contact Deleted");			}
			else {
				System.out.println("Contact not found");
			}
		}
		else {
			System.out.println("the entered addressbook is not in existence");
		}

	}
	public void printContact() {
		System.out.println("Enter the name of Address book to print the contact.");
		scanner.nextLine();
		String contact = scanner.nextLine();
		if(hashmap.get(contact).isEmpty()) {
			System.out.println("the entered addressbook is empty!");
		}
		if(hashmap.containsKey(contact)) {
			for (int i = 0; i < hashmap.get(contact).size(); i++) {
				System.out.println("Contact Details");
				System.out.println("Name         : " + hashmap.get(contact).get(i).getFirstName()+ " " + hashmap.get(contact).get(i).getLastName() + "\n"
						+ "Address      : " + hashmap.get(contact).get(i).getAddress()   + "\n"
						+ "City         : " + hashmap.get(contact).get(i).getCity()      + "\n"
						+ "State        : " + hashmap.get(contact).get(i).getState()     + "\n"
						+ "ZipCode      : " + hashmap.get(contact).get(i).getZipCode()   + "\n"
						+ "MobileNumber : " + hashmap.get(contact).get(i).getMobileNo()  + "\n"
						+ "EmailId      : " + hashmap.get(contact).get(i).getEmailId()   + "\n");
			}
		}

	}
}