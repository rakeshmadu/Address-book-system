package com.address.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.address.entity.AddressBook;
import com.address.entity.AddressBookRegistry;
import com.address.entity.ContactPerson;

public class AddressRegistryService {

	Scanner scan = new Scanner(System.in);

	public void addAddressBook() {
		System.out.print(" Please enter the name of the new address book: ");
		String name = scan.next();

		HashSet<AddressBook> temp = AddressBookRegistry.getAddressBookList();

		if (!temp.add(new AddressBook(name)))
			System.out.println(" An address book of this name already exists! ");

		AddressBookRegistry.setAddressBookList(temp);

	}

	public void viewPersonAll(String ch) {
		switch (ch) {
		case "c":
		case "city":
			System.out.print(" Please enter the name of the city: ");
			String city = scan.next();
			AddressBookRegistry.getCityPersonMap().entrySet().stream().filter(contact -> contact.getKey().equals(city))
					.forEach(contact -> System.out.println(contact.getValue()));
			break;
		case "s":
		case "state":
			System.out.print(" Please enter the name of the state: ");
			String state = scan.next();
			AddressBookRegistry.getStatePersonMap().entrySet().stream()
					.filter(contact -> contact.getKey().equals(state))
					.forEach(contact -> System.out.println(contact.getValue()));
			break;

		default:
			System.out.println(" Please enter a valid choice!");
		}
	}

	public void searchPersonAll(String name, String ch) {

		switch (ch) {
		case "c":
		case "city":
			System.out.print(" Please enter the name of the city: ");
			String city = scan.next();
			for (AddressBook adbook : AddressBookRegistry.getAddressBookList()) {
				adbook.getContacts().stream().filter(contact -> contact.getCity().equals(city))
						.filter(contact -> contact.getFirstName().equals(name))
						.forEach(contact -> System.out.println(contact));
			}
			break;
		case "s":
		case "state":
			System.out.print(" Please enter the name of the state: ");
			String state = scan.next();
			for (AddressBook adbook : AddressBookRegistry.getAddressBookList()) {
				adbook.getContacts().stream().filter(contact -> contact.getState().equals(state))
						.filter(contact -> contact.getFirstName().equals(name))
						.forEach(contact -> System.out.println(contact));
			}
			break;
		default:
			System.out.println(" Please enter a valid choice!");

		}
	}

	public void countPersons(String ch) {
		switch (ch) {
		case "c":
		case "city":
			System.out.println(" Please enter the name of the city: ");
			String city = scan.next();
			AddressBookRegistry.getCityPersonMap().entrySet().stream().filter(contact -> contact.getKey().equals(city))
					.forEach(contact -> System.out
							.println("Number of ppl in " + city + ": " + contact.getValue().size()));
			break;
		case "s":
		case "state":
			System.out.println(" Please enter the name of the state: ");
			String state = scan.next();
			AddressBookRegistry.getStatePersonMap().entrySet().stream()
					.filter(contact -> contact.getKey().equals(state)).forEach(contact -> System.out
							.println("Number of ppl in " + state + ": " + contact.getValue().size()));
			break;
		default:
			System.out.println(" Please enter a valid choice!");
		}
	}

	public void writeIntoFile() {
		HashSet<AddressBook> temp = AddressBookRegistry.getAddressBookList();

		try {
			FileWriter fw = new FileWriter("src/output.txt");
			fw.write(temp.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readFromFile() {

		Scanner scan;
		try {
			scan = new Scanner(new File("src/output.txt"));
			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
