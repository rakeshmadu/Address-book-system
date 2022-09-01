package com.address.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AddressBookRegistry {

	public static HashMap<String, ArrayList<ContactPerson>> CityPersonMap = new HashMap<>();
	public static HashMap<String, ArrayList<ContactPerson>> StatePersonMap = new HashMap<>();

	public static HashMap<String, ArrayList<ContactPerson>> getCityPersonMap() {
		return CityPersonMap;
	}

	public static void setCityPersonMap(HashMap<String, ArrayList<ContactPerson>> cityPersonMap) {
		CityPersonMap = cityPersonMap;
	}

	public static HashMap<String, ArrayList<ContactPerson>> getStatePersonMap() {
		return StatePersonMap;
	}

	public static void setStatePersonMap(HashMap<String, ArrayList<ContactPerson>> statePersonMap) {
		StatePersonMap = statePersonMap;
	}

	private static HashSet<AddressBook> AddressBookList = new HashSet<>();

	public static HashSet<AddressBook> getAddressBookList() {
		return AddressBookList;
	}

	public static void setAddressBookList(HashSet<AddressBook> addressBookList) {
		AddressBookList = addressBookList;
	}
	
	

}
