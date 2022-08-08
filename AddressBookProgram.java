package com.bridgelabz.AddressBook;

import java.util.Scanner;

public class AddressBookProgram {
    //variables
    private String FirstName;
    private String LastName;
    private String Address;
    private String State;
    private String City;
    private long ZipCode;
    private long PhoneNO;
    private String Email;
    //getters abd setters  for  each variable

    Scanner sc = new Scanner(System.in);

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        this.State = state;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public Long getZipCode() {
        return ZipCode;
    }

    public void setZipCode(Long zipCode) {
        ZipCode = zipCode;
    }

    public Long getPhoneNO() {
        return PhoneNO;
    }

    public void setPhoneNO(Long phoneNO) {
        PhoneNO = phoneNO;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public void display() {
        System.out.println("Enter a First name: ");
        setFirstName(sc.nextLine());

        System.out.println("Enter a Last name: ");
        setLastName(sc.nextLine());

        System.out.println("Enter a Address: ");
        setAddress(sc.next());

        System.out.println("Enter a State: ");
        setState(sc.next());

        System.out.println("Enter a City: ");
        setCity(sc.next());


        System.out.println("Enter a Zipcode: ");
        setZipCode(sc.nextLong());


        System.out.println("Enter a Phone NUmber: ");
        setPhoneNO(sc.nextLong());

        System.out.println("Enter a Email: ");
        setEmail(sc.next());


        System.out.println("First Name:\t" + this.getFirstName());
        System.out.println("last name:\t" + this.getLastName());
        System.out.println("Address:\t" + this.getAddress());
        System.out.println("State:\t" + this.getState());
        System.out.println("Zipcode:\t" + this.getZipCode());
        System.out.println("City:\t" + this.getCity());
        System.out.println("Phone Number:\t" + this.getPhoneNO());
        System.out.println("Email:\t" + this.getEmail());



    }

    public static void main(String[] args) {

        AddressBookProgram Contact1 = new AddressBookProgram();
        System.out.println("Enter The Details of Contact1:");
        Contact1.display();

        // uc_2  added 2 more  contats in AddressBook
        AddressBookProgram Contact2 = new AddressBookProgram();
        System.out.println("Enter The Details of Contact2:");
        Contact2.display();


        AddressBookProgram Contact3 = new AddressBookProgram();
        System.out.println("Enter The Details of Contact3:");
        Contact3.display();


    }
}
