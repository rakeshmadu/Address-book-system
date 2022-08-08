package com.blz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	private static final Scanner SC = new Scanner(System.in);
	public static Map<String, ArrayList<Contact>> map = new HashMap<>();

	public static void main(String[] args) {
		addressBook();
	}

	public static void addressBook() {
		int choose = 0;

		do {
			Contact add;
			System.out.println("1.addAddressBook \n 2.display\n3.exit");

			choose = SC.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Give unique address book name");
				String addressBookName = SC.next();
				if (map.containsKey(addressBookName)) {
					System.out.println("Please enter unique address book name");
				} else {
					ArrayList<Contact> contactList = new ArrayList<>();
					int choice = 0;
					do {
						System.out.println("1.add\n2.display\n3.exit\n 4.update\n5.delete contact");
						System.out.println("Enter choice");
						choice = SC.nextInt();
						switch (choice) {
						case 1:
							add = addInputs();
							contactList.add(add);
							map.put(addressBookName, contactList);
							break;

						case 2:
							for (Contact items : contactList) {
								System.out.println(items.toString());
							}
							break;

						case 3:
							System.out.println("Thank You..");
							break;

						case 4:
							System.out.println("Enter name which you want to replace: ");
							String nameReplace = SC.next();
							for (int i = 0; i < contactList.size(); i++) {
								System.out.println(contactList.get(i));
								Contact editContact = contactList.get(i);
								if (nameReplace.equals(editContact.getFirstName())) {
									System.out.println("Enter a first name: ");
									editContact.setFirstName(SC.next());
									System.out.println("Enter a last name: ");
									editContact.setLastName(SC.next());
									System.out.println("Enter an address: ");
									editContact.setAddress(SC.next());
									System.out.println("Enter a city: ");
									editContact.setCity(SC.next());
									System.out.println("Enter a state: ");
									editContact.setState(SC.next());
									System.out.println("Enter a zip: ");
									editContact.setZip(SC.nextInt());
									System.out.println("Enter a phone number: ");
									editContact.setPhoneNumber(SC.nextLong());
									System.out.println("Enter an email ID: ");
									editContact.setEmailID(SC.next());
									contactList.set(i, editContact);
								}
							}
							break;

						case 5:
							System.out.println("Enter name which you want to delete: ");
							String nameDelete = SC.next();
							for (int i = 0; i < contactList.size(); i++) {
								System.out.println(contactList.get(i));
								Contact editContact = contactList.get(i);
								if (nameDelete.equals(editContact.getFirstName())) {
									contactList.remove(i);
								}
							}
							break;

						default:
							System.out.println("Please Enter from choice ");
							break;

						}
					} while (choice != 3);
					break;

				}

			case 2:
				for (Map.Entry contact : map.entrySet()) {
					System.out.println(contact.getKey() + ": " + contact.getValue());
				}
				break;

			case 3:
				System.out.println("Thank you!!!");
				break;

			default:
				System.out.println("Choose from options");
				break;
			}

		} while (choose != 3);
	}

	public static Contact addInputs() {
		Contact add;
		add = new Contact();
		System.out.println("Enter a first name: ");
		add.setFirstName(SC.next());
		System.out.println("Enter a last name: ");
		add.setLastName(SC.next());
		System.out.println("Enter an address: ");
		add.setAddress(SC.next());
		System.out.println("Enter a city: ");
		add.setCity(SC.next());
		System.out.println("Enter a state: ");
		add.setState(SC.next());
		System.out.println("Enter a zip: ");
		add.setZip(SC.nextInt());
		System.out.println("Enter a phone number: ");
		add.setPhoneNumber(SC.nextLong());
		System.out.println("Enter an email ID: ");
		add.setEmailID(SC.next());
		return add;
	}
}
