package com.bdlz.addressbook;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter \n 0 To add The AddressBook \n 1 To add The contact \n 2 To edit the contact \n 3 To delete the contact  \n 4 To print the contact  \n 5 To search by state \n 6 To search by city \n 7 To Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 0:
				addressBook.addAddressBook();
				break;
			case 1:
				addressBook.addContact();
				break;
			case 2:
				addressBook.editContact();
				break;
			case 3:
				addressBook.deleteContact();
				break;
			case 4:
				addressBook.printContact();
				break;
			case 5:
				addressBook.searchByState();
				break;
			case 6:
				addressBook.searchByCity();
				break;
			case 7:
				System.out.println("Exit successfully!");
				System.exit(0);
				break;
			default:
				System.out.println(" you Entered the wrong input");
				continue;
			}

		}
	}
}
