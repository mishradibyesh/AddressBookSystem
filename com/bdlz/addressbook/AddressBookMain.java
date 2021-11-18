package com.bdlz.addressbook;

import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) throws IOException {
		AddressBook addressBook = new AddressBook();
		while (true) {
			System.out.println("Enter \n 0 To add The AddressBook \n 1 To add The contact \n 2 To edit the contact \n 3 To delete the contact "
					+ " \n 4 To print the contact  \n 5 To search by state \n 6 To search by city \n 7 to count by state or city"
					+ " \n 8 for sort by name \n 9 to sort by state city and zip \n 10 to write the contacts in file \n 11  to write into csv file "
					+ " \n 12 to  write into json file \n 13 to exit");
			Scanner scanner = new Scanner(System.in);
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
				Scanner scanner1 = new Scanner(System.in);
				System.out.println("press 1 to count by city /n press 2 to count bt state ");
				int selection = scanner1.nextInt();
				if(selection == 1) {
					System.out.println("enter City");
					scanner1.nextLine();
					String city = scanner1.nextLine();
					addressBook.countByCity(city);
				}
				else
					System.out.println("enter state");
				scanner1.nextLine();
				String state = scanner.nextLine();
				addressBook.countByState(state);
				break;
			case 8:
				addressBook.sortByName();
				break;
			case 9:
				addressBook.sortBy();
				break;
			case 10:
				addressBook.writeToFile();
				break;
			case 11:
				addressBook.writeToCSV();
				break;
			case 12:
				addressBook.writeToJSON();
				break;
			case 13:
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
