
import int105.addressbook.AddressBook;
import int105.base.Address;
import int105.base.Company;
import int105.base.Person;
import int105.contact.BusinessContact;
import int105.contact.Contact;
import int105.contact.ContactType;
import int105.contact.PersonContact;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Umaporn
 */
public class TestAddressBook {
    

    public static void testCreatePersonContact() {
        Person p1 = new Person("Danai", "Lee");
        Person p2 = new Person("Pat", "dee");
       
        Address ad1 = new Address("126", "PrachaUthid", "Bangkok", "10140");
        Address ad2 = new Address("111", "Rachada", "Bangkok", "10160");
        
        LocalDate ld1=LocalDate.of(2000, 1, 2);
        
        Contact pc1=new PersonContact(ad1, "danai@sit.kmutt.ac.th", "0-2470-9810", ContactType.PERSON,p1, ld1);
        Contact pc2=new PersonContact(ad2,"pat@sit.kmutt.ac.th", "0-2470-9857",ContactType.PERSON, p2, LocalDate.now());
        
        System.out.println("PersonContact 1: "+pc1);
        System.out.println("PersonContact 2: "+pc2);
    }

    public static void testCreateBusinessContact() {
        Company cp1=new Company("ABC");
        Company cp2=new Company("abd");
        
        Address ad3 = new Address("124", "Thonburi", "Bangkok", "10600");
        Address ad4 = new Address("11/12", "Petcha", "Bangkok", "10150");
        
        Contact bc1=new BusinessContact(ad3, "ABC@sit.kmutt.ac.th", "0-2470-9800", ContactType.BUSINESS,cp1,"Business Director");
        Contact bc2=new BusinessContact(ad4,"abd@sit.kmutt.ac.th", "0-2470-9860",ContactType.BUSINESS, cp2, "Programmmer");
        
        System.out.println("BusinessContact 1: "+bc1);
        System.out.println("BusinessContact 2: "+bc2);
        
    }

    public static AddressBook testAddContact() {
       
        //Person Contact
        Person p1 = new Person("Danai", "Lee");
        Person p2 = new Person("Pat", "dee");
       
        Address ad1 = new Address("126", "PrachaUthid", "Bangkok", "10140");
        Address ad2 = new Address("111", "Rachada", "Bangkok", "10160");
        
        LocalDate ld1=LocalDate.of(2000, 1, 2);
        
        Contact pc1=new PersonContact(ad1, "danai@sit.kmutt.ac.th", "0-2470-9810", ContactType.PERSON,p1, ld1);
        Contact pc2=new PersonContact(ad2,"pat@sit.kmutt.ac.th", "0-2470-9857",ContactType.PERSON, p2, LocalDate.now());
        
        //Company Contact
        Company cp1=new Company("ABC");
        Company cp2=new Company("abd");
        
        Address ad3 = new Address("124", "Thonburi", "Bangkok", "10600");
        Address ad4 = new Address("11/12", "Petcha", "Bangkok", "10150");
        
        Contact bc1=new BusinessContact(ad3, "ABC@sit.kmutt.ac.th", "0-2470-9800", ContactType.BUSINESS,cp1,"Business Director");
        Contact bc2=new BusinessContact(ad4,"abd@sit.kmutt.ac.th", "0-2470-9860",ContactType.BUSINESS, cp2, "Programmmer");
        
        AddressBook ab=new AddressBook(10);
        ab.addFriend(bc1);
        ab.addFriend(pc1);
        ab.addFriend(pc2);
        ab.addFriend(bc2);
        System.out.println("number of friends: "+ab.getCount());
        
        Iterator<Contact> iter=ab.iterator();
        System.out.println("------------Address Book Contact-------------");
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        
        System.out.println("is full? "+ab.isFull());
        
        return ab;
    }
    
    public static void testSortPersonContact(){
         //Person Contact
        PersonContact p[]=new PersonContact[3];
        Person p1 = new Person("Danai", "Lee");
        Person p2 = new Person("Rung", "Dee");
        Person p3 = new Person("Pat", "Bee");
        
        Address ad1 = new Address("126", "PrachaUthid", "Bangkok", "10140");
        Address ad2 = new Address("111", "Rachada", "Bangkok", "10160");
        
        LocalDate ld1=LocalDate.of(2000, 1, 2);
        
        p[0]=new PersonContact(ad1, "danai@sit.kmutt.ac.th", "0-2470-9810", ContactType.PERSON,p1, ld1);
        p[1]=new PersonContact(ad2,"rung@sit.kmutt.ac.th", "0-2470-9857",ContactType.PERSON, p2, LocalDate.now());
        p[2]=new PersonContact(ad1,"pat@sit.kmutt.ac.th", "0-2470-9812",ContactType.PERSON, p3, LocalDate.now());
        
       // Arrays.sort(p, PersonContact.lastnameComparator);
        Arrays.sort(p, PersonContact.firstnameComparator);
        
        System.out.println("-------------Sort Person Contact------------");
        for (Contact ct : p) {
            System.out.println(ct);
        }
    }
    
    public static void testSortContact(){
        
        AddressBook ab=testAddContact();
        int count=ab.getCount();
        Contact c[]=new Contact[count];
        Iterator<Contact> iter=ab.iterator();
        int index=0;
        while(iter.hasNext()){
            c[index++]=iter.next();
        }
        
        Arrays.sort(c, Contact.contactTypeComparator);
        
        System.out.println("-------------Sort Contact------------");
        for (Contact ct : c) {
            System.out.println(ct);
        }
        
    }
    
    public static void testSearchContact() {
        AddressBook ab=testAddContact();
        System.out.println("Search <Danai>: "+ab.searchForName("Danai"));
        System.out.println("Search <ABC>: "+ab.searchForName("ABC"));
        System.out.println("Search <Unknown>: "+ab.searchForName("Unknown"));
    }

    public static void main(String[] args) {
        testCreatePersonContact();
        testCreateBusinessContact();
        
        testAddContact();
        testSortContact();
        testSortPersonContact();
        testSearchContact();
    }
}
