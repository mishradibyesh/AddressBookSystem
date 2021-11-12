package com.bdlz.addressbook;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		Scanner scanner = new Scanner(System.in);
		addressBook.addContact();
		System.out.println("Enter Y To Edit The Contact");
		String choice = scanner.nextLine();
		if (choice.equals("y") || choice.equals("Y")) {
			addressBook.editContact();
		}
	}
}
