package com.bridgelabz.AddressBook;

import java.util.Scanner;

public class AddressBookProgram {
    //	Take input from users to create Contact
    public static void address() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your First Name: ");
        String first_name = sc.next();


        System.out.print("Enter Your Last Name: ");
        String last_name = sc.next();


        System.out.print("Enter Your Address: ");
        String address = sc.next();


        System.out.print("Enter Your City: ");
        String city = sc.next();


        System.out.print("Enter Your State Name: ");
        String state = sc.next();


        System.out.print("Enter Your Zip Code: ");
        int zip_code = sc.nextInt();


        System.out.print("Enter Your Phone Number: ");
        long phone_number = sc.nextLong();


        System.out.print("Enter Your Email Id: ");
        String email_id = sc.next();

        System.out.println("First Name: " + first_name);
        System.out.println("Last Name : " + last_name);
        System.out.println("Last Name : " + address);
        System.out.println("City : " + city);
        System.out.println("State Name : " + state);
        System.out.println("Zip Code : " + zip_code);
        System.out.println("Phone Number : " + phone_number);
        System.out.println("Email Id : " + email_id);

    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        address();
    }

}