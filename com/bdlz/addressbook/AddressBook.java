package com.bdlz.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
	/*
	 *  creating multiple addressbook with the help of HashMap
	 * 
	 */

	static final String  FILE_PATH = "data.txt";
	HashMap <String , ArrayList<ContactDetails>> hashmap = new HashMap();
	public void addAddressBook() {
		Scanner scanner = new Scanner(System.in);
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

	// method to write contact and check if contact already exists
	public void addContact() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of Address book to add the contact.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact) ) {

			writeContact(newContact);
		}
		else {
			System.out.println("this addressBook is not exist");
		}

	}
	// method to write the contact details
	public void writeContact(String newContact) {
		Scanner scanner = new Scanner(System.in);
		ContactDetails contact = new ContactDetails();
		System.out.println("Enter First Name : ");
		String firstName = scanner.next();

		if(duplicateCheck(newContact , firstName ) == true) {    

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
			hashmap.get(newContact).add(contact);
		}
		else
		{
			System.out.println("please try another");
			writeContact(newContact);
		}
	}

	//method to check duplicate contact name
	public boolean duplicateCheck(String newContact , String firstName) {
		for ( int i=0 ; i < hashmap.get(newContact).size(); i++) {
			String name = hashmap.get(newContact).get(i).getFirstName();
			if (name.equals(firstName)) {
				System.out.println("this contact name is already present! ");
				return false;
			}
		}
		return true;

	}

	/*
    Declaring The Edit Contact Method
    TO Edit The Details Of Contact
    The Details Of Contact Edit By Using FirstName
    If First Name Is Match The Contact Will Edit
	 */

	public void editContact() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of Address book to edit the contact.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact)) {
			System.out.println("Enter the first name of person to edit contact");
			String editName = scanner.next();
			boolean edited = false;
			for (int i = 0; i < hashmap.get(newContact).size(); i++) {
				String name = hashmap.get(newContact).get(i).getFirstName();
				if (name.equalsIgnoreCase(editName)) {
					writeContact(newContact);
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of Address book to delete the contact.");
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
	//method to seacrh by state name
	public void searchByState() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of state to search contact.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact) ) {

			System.out.println("Enter State: ");
			String state = scanner.next();
			List<ContactDetails> searchData = hashmap.get(newContact).stream().filter(contactInfo -> contactInfo.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
			for (ContactDetails contact : searchData) {
				System.out.println("Search result: " + contact);
			}
		}
	}

	//method to seacrh by city name
	public void searchByCity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of city  to search the contact in the addressbook.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact) ) {

			System.out.println("Enter city: ");
			String city = scanner.next();
			List<ContactDetails> searchData = hashmap.get(newContact).stream().filter(contactInfo -> contactInfo.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
			for (ContactDetails contact : searchData) {
				System.out.println("Search result: " + contact);
			}
		}
	}

	//count contact by city name
	public void countByCity(String cityName) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the addressbook.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact) ) {
			long count = hashmap.get(newContact).stream().filter(g -> g.getCity().equalsIgnoreCase(cityName)).count();
			System.out.println("Total Number of Contact from '" + cityName + "' city is " + count);
		}
	}

	//count contact by state name
	public void countByState(String stateName) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the addressbook.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact) ) {
			long count = hashmap.get(newContact).stream().filter(g -> g.getState().equalsIgnoreCase(stateName)).count();
			System.out.println("Total Number of Contact from '" + stateName + "' state is " + count);
		}
	}
	//method to sort by state city or zip
	public void sortBy() {
		System.out.println("press \n 1 to sort b city \n 2 to sort by state \n 3 to sort by zip");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch(choice) {
		case 1 :
			sortByCity();
			break;
		case 2 :
			sortByState();
			break;
		case 3 :
			sortByZip();
			break;
		}
	}

	public void sortByCity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the addressbook.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact) ) {
			hashmap.get(newContact).stream().sorted((g1, g2) -> ((String)g1.getCity()).compareTo(g2.getCity())).forEach(contact -> System.out.println(contact));
		}	
	}
	public void sortByState() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the addressbook.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact) ) {
			hashmap.get(newContact).stream().sorted((g1, g2) -> ((String)g1.getState()).compareTo(g2.getState())).forEach(contact -> System.out.println(contact));
		}	
	}
	public void sortByZip() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the addressbook.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact) ) {
			hashmap.get(newContact).stream().sorted((g1, g2) -> ((Integer)g1.getZipCode()).compareTo(g2.getZipCode())).forEach(contact -> System.out.println(contact));
		}	
	}
	public void sortByName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the addressbook.");
		String newContact = scanner.nextLine();
		if(hashmap.containsKey(newContact) ) {
			hashmap.get(newContact).stream().sorted((g1, g2) -> ((String)g1.getFirstName()).compareTo(g2.getFirstName())).forEach(contact -> System.out.println(contact));
		}
	}


	//method to print contacts in provided addressbook
	public void printContact() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of Address book to print the contact.");
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

	//method to write into JSON file
	public void writeToJSON() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of Address book to print the contact.");
		String contact = scanner.nextLine();
		if(hashmap.containsKey(contact) ) {
			FileWriter fw = new FileWriter("data2.json");
			for(int i=0;i<hashmap.get(contact).size();i++) {
				fw.write(
						"first name :"+ hashmap.get(contact).get(i).getFirstName() + 
						"last name :" + hashmap.get(contact).get(i).getLastName() + 
						"address :" + hashmap.get(contact).get(i).getAddress() +
						"city :" + hashmap.get(contact).get(i).getCity() +
						"state :" + hashmap.get(contact).get(i).getState() + 
						"zip :" + hashmap.get(contact).get(i).getZipCode() + 
						"mobike :" + hashmap.get(contact).get(i).getMobileNo() +
						"email :" + hashmap.get(contact).get(i).getEmailId()+"\n");
			}
			fw.close();
		}
		System.out.println("File Writing to JSON is now Stopped");

	}
	public void writeToCSV() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of Address book to print the contact.");
		String contact = scanner.nextLine();
		if(hashmap.containsKey(contact) ) {
			FileWriter fw = new FileWriter("data2.csv");
			for(int i=0;i<hashmap.get(contact).size();i++) {
				fw.write(
						hashmap.get(contact).get(i).getFirstName() + 
						"," + hashmap.get(contact).get(i).getLastName() + 
						"," + hashmap.get(contact).get(i).getAddress() +
						"," + hashmap.get(contact).get(i).getCity() +
						"," + hashmap.get(contact).get(i).getState() + 
						"," + hashmap.get(contact).get(i).getZipCode() + 
						"," + hashmap.get(contact).get(i).getMobileNo() +
						"," + hashmap.get(contact).get(i).getEmailId()+"\n");
			}
			fw.close();
		}
		System.out.println("File Writing to csv is now Stopped");
	}

	public void readCSVFile(String filePath) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filePath));
		while(scanner.hasNext()) {
			System.out.println(scanner.next().toString());
		}
	}
	public void writeToFile() throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of Address Book to print the contact.");
		String contact = scanner.nextLine();
		if(hashmap.containsKey(contact) ) {
			FileWriter fw = new FileWriter(FILE_PATH);
			for(int i=0;i<hashmap.get(contact).size();i++) {
				fw.write(" contact "+ i
						+ "\n \n First Name :" + hashmap.get(contact).get(i).getFirstName() + 
						", \n Last Name :" + hashmap.get(contact).get(i).getLastName() + 
						", \n Address : " + hashmap.get(contact).get(i).getAddress() +
						", \n City : " + hashmap.get(contact).get(i).getCity() +
						", \n State : " + hashmap.get(contact).get(i).getState() + 
						", \n ZipCode : " + hashmap.get(contact).get(i).getZipCode() + 
						", \n Mobile Number : " + hashmap.get(contact).get(i).getMobileNo() +
						", \n EmailID : " + hashmap.get(contact).get(i).getEmailId()+"\n\n");

			}
			fw.close();
			System.out.println("File Writing Stopped");
		}
	}
}