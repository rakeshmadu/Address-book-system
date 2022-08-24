package com.address.entity;

import java.util.HashSet;

public class AddressBookRegistry {

	private static HashSet<AddressBook> AddressBookList = new HashSet<>();

	public static  HashSet<AddressBook> getAddressBookList() {
		return AddressBookList;
	}

	public static void setAddressBookList(HashSet<AddressBook> addressBookList) {
		AddressBookList = addressBookList;
	}
	
	
}
