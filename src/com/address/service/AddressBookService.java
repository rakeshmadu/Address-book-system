package com.address.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.address.entity.AddressBook;
import com.address.entity.AddressBookRegistry;
import com.address.entity.ContactPerson;

public class AddressBookService {

//	AddressBook adBook;
	Scanner scan = new Scanner(System.in);

	public AddressBookService() {
		super();
		scan.useDelimiter("\r?\n");
	}

	public void printSortedContacts(String ch) {
		AddressBook adBook = findAddressBook();

		switch (ch) {
		case "name":
		case "n":
			adBook.getContacts().stream()
					.sorted((contact1, contact2) -> contact1.getFirstName().compareTo(contact2.getFirstName()))
					.forEach(contact -> System.out.println(contact));
			break;
		case "state":
		case "s":
			adBook.getContacts().stream()
					.sorted((contact1, contact2) -> contact1.getState().compareTo(contact2.getState()))
					.forEach(contact -> System.out.println(contact));
			break;
		case "city":
		case "c":
			adBook.getContacts().stream()
			.sorted((contact1, contact2) -> contact1.getCity().compareTo(contact2.getCity()))
			.forEach(contact -> System.out.println(contact));
			break;
		case "zip":
		case "z":
			adBook.getContacts().stream()
			.sorted((contact1, contact2) -> Integer.valueOf(contact1.getZip()).compareTo(contact2.getZip()))
			.forEach(contact -> System.out.println(contact));
			break;
		}
	}

	public void addContact(ContactPerson contactPerson) {

		AddressBook adBook = findAddressBook();

		if (adBook == null) {
			return;
		}

		HashMap<String, ArrayList<ContactPerson>> cityPersonMap = AddressBookRegistry.getCityPersonMap();
		HashMap<String, ArrayList<ContactPerson>> statePersonMap = AddressBookRegistry.getStatePersonMap();

		if (!cityPersonMap.containsKey(contactPerson.getCity()))
			cityPersonMap.put(contactPerson.getCity(), new ArrayList<ContactPerson>());
		cityPersonMap.get(contactPerson.getCity()).add(contactPerson);

		if (!statePersonMap.containsKey(contactPerson.getState()))
			statePersonMap.put(contactPerson.getState(), new ArrayList<ContactPerson>());
		statePersonMap.get(contactPerson.getState()).add(contactPerson);

		HashSet<ContactPerson> contacts = adBook.getContacts();

		ContactPerson newContact = contactPerson;
		if (!contacts.add(newContact))
			System.out.println(" A contact of this name already exists!");

		adBook.setContacts(contacts);

		System.out.println(newContact);
	}

	public void printContacts() {

		HashSet<AddressBook> temp = AddressBookRegistry.getAddressBookList();

		for (AddressBook addressBook : temp) {
			System.out.println(" ******** " + addressBook.getName() + " ********");
			for (ContactPerson contactPerson : addressBook.getContacts()) {
				System.out.println(contactPerson);
			}
		}
	}

	private ContactPerson findContact(AddressBook adBook) {

		System.out.print(" Please enter the name of the contact: ");
		String name = scan.next();

		HashSet<ContactPerson> contacts = adBook.getContacts();
		int count = 0;
		ContactPerson temp = null;

		for (ContactPerson contactPerson : contacts) {
			if (contactPerson.getFirstName().equals(name)) {
				count++;
				temp = contactPerson;
			}
		}

		if (count < 2) {
			return temp;
		}

		System.out.print(" There are multiple contacts with that name.\n Please enter their email id to confirm: ");
		String checkEmail = scan.next();
		for (ContactPerson contactPerson : contacts) {
			if (contactPerson.getFirstName().equals(name) && contactPerson.getEmail().equals(checkEmail)) {
				return contactPerson;
			}
		}

		return null;
	}

	private AddressBook findAddressBook() {

		HashSet<AddressBook> temp = AddressBookRegistry.getAddressBookList();

		if (temp.size() == 0) {
			System.out.println(" Please create an address book first!");
			return null;
		}

		System.out.print(" Please enter the name of the address book: ");
		String adBookName = scan.next();

		for (AddressBook addressBook : temp) {
			if (addressBook.getName().equals(adBookName)) {
				return addressBook;
			}
		}

		System.out.println(" Address book does not exist!");
		return null;
	}

	public void editContact() {

		AddressBook adBook = findAddressBook();

		if (adBook == null) {
			return;
		}

		ContactPerson obj = findContact(adBook);
		if (obj == null) {
			System.out.println(" Couldn't find contact");
			return;
		}

		System.out.println(" Please enter which detail you want to edit: ");
		System.out.print(" 1. Address\n 2. City\n 3. State\n 4. Zip\n 5. Phone number\n Choice: ");
		int ch = scan.nextInt();

		switch (ch) {
		case 1:
			System.out.print(" Please enter the new address: ");
			String newAddress = scan.next();
			obj.setAddress(newAddress);
			break;
		case 2:
			System.out.print(" Please enter the new city: ");
			String newCity = scan.next();
			obj.setCity(newCity);
			break;
		case 3:
			System.out.print(" Please enter the name of the new state: ");
			String newState = scan.next();
			obj.setState(newState);
			break;
		case 4:
			System.out.print(" Please enter the new zip code: ");
			int newZip = scan.nextInt();
			obj.setZip(newZip);
			break;
		case 5:
			System.out.println(" Please enter the new phone number: ");
			int newPhone = scan.nextInt();
			obj.setPhoneNumber(newPhone);
			break;
		default:
			System.out.println(" Please enter a valid choice!");

		}
		System.out.println(" the new contact is : ");
		System.out.println(obj);
	}

	public void deleteContact() {

		AddressBook adBook = findAddressBook();

		if (adBook == null) {
			return;
		}

		ContactPerson obj = findContact(adBook);
		if (obj == null) {
			System.out.println(" Couldn't find contact");
			return;
		}

		HashSet<ContactPerson> contacts = adBook.getContacts();
		contacts.remove(obj);
	}

}
