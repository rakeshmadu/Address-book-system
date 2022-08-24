package com.address.service;

import java.util.HashSet;
import java.util.Scanner;

import com.address.entity.AddressBook;
import com.address.entity.AddressBookRegistry;

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

}
