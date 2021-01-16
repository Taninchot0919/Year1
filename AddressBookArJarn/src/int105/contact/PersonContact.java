/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.contact;

import int105.base.Address;
import int105.base.Person;
import java.time.LocalDate;
import java.util.Comparator;

/**
 *
 * @author Umaporn
 */
public class PersonContact extends Contact {
    private Person person;
    private LocalDate dateOfBirth;

    public PersonContact(Address add, String email, String phone,
            ContactType cType, Person person, LocalDate dateOfBirth) {
        super(add, email, phone, cType);
        this.person = person;
        this.dateOfBirth = dateOfBirth;
    }
    
    
    public static Comparator<PersonContact> firstnameComparator=new Comparator<PersonContact>(){
        @Override
        public int compare(PersonContact o1, PersonContact o2) {
           return o1.person.getFirstname().compareTo(o2.person.getFirstname());
        }
        
    };
     public static Comparator<PersonContact> lastnameComparator=new Comparator<PersonContact>(){
        @Override
        public int compare(PersonContact o1, PersonContact o2) {
           return o1.person.getLastname().compareTo(o2.person.getLastname());
        }
        
    };

    public Person getPerson() {
        return person;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "PersonContact{" + "person=" + person +"\n"+ super.toString() + ", dateOfBirth=" + dateOfBirth + '}';
    }
    
    
    
    
   
}
