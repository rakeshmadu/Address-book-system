package com.address.entity;

import java.util.HashSet;
import java.util.Objects;

public class AddressBook {

	private HashSet<ContactPerson> contacts = new HashSet<>();
	private String name;

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressBook other = (AddressBook) obj;
		return Objects.equals(name, other.name);
	}

	public HashSet<ContactPerson> getContacts() {
		return contacts;
	}

	public void setContacts(HashSet<ContactPerson> contacts) {
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressBook(String name) {
		super();
		this.name = name;
	}

}
