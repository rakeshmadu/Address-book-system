package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddressBookTest {
    PersonDetails person1;
    PersonDetails person2;
    @Before
    public void initialize() {
        person1 = new PersonDetails();
        person1.setFirstName("rakesh");
        person1.setLastName("madu");
        person1.setAddress("chandanagar");
        person1.setCity("hyderabad");
        person1.setState("telangana");
        person1.setPinCode(500050);
        person1.setPhoneNumber("8341041455");
        person1.setEmail("rakeshmadu24@gmail.com");

        person2 = new PersonDetails();
        person2.setFirstName("somesh");
        person2.setLastName("mamilla");
        person2.setAddress("kompally");
        person2.setCity("hyderabad");
        person2.setState("telangana");
        person2.setPinCode(500072);
        person2.setPhoneNumber("9096420943");
        person2.setEmail("somesh@gmail.com");
    }


    @Test
    public void givenAContact_WhenAddedToList_ShouldReturnCorrectSize() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(person1, IOService.LIST_DS_IO);
        addressBook.addPerson(person2, IOService.LIST_DS_IO);
        Assert.assertEquals(2,addressBook.referenceBook.size());
    }

    @Test
    public void givenAContact_WhenAddedToFile_ShouldReturnCorectSize() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(person1, IOService.TXT_FILE_IO);
        addressBook.addPerson(person2, IOService.TXT_FILE_IO);
        long size = 0;
        try {
            size = Files.lines(Paths.get("AddressBook-file.txt")).count();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2,size);
    }

    @Test
    public void whenCalled_ReadFromListMethod_ShouldPrintList() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(person1, IOService.LIST_DS_IO);
        addressBook.addPerson(person2, IOService.LIST_DS_IO);
        long size  = addressBook.readData(IOService.LIST_DS_IO);
        Assert.assertEquals(2,size);
    }

    @Test
    public void whenCalled_ReadFromFileMethod_ShouldPrintFile() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(person1, IOService.TXT_FILE_IO);
        addressBook.addPerson(person2, IOService.TXT_FILE_IO);
        long size  = addressBook.readData(IOService.TXT_FILE_IO);
        Assert.assertEquals(2,size);
    }

    @Test
    public void givenAContact_WhenAddedToCSVFile_ShouldReturnCorrectSize() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(person1, IOService.CSV_IO);
        addressBook.addPerson(person2, IOService.CSV_IO);
        long size = 0;
        try {
            size = Files.lines(Paths.get("AddressBook-file.csv")).count();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2,size-1);
    }

    @Test
    public void whenCalled_ReadFromCSVMethod_ShouldPrintFile() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(person1, IOService.CSV_IO);
        addressBook.addPerson(person2, IOService.CSV_IO);
        long size  = addressBook.readData(IOService.CSV_IO);
        Assert.assertEquals(2,size);
    }
}
