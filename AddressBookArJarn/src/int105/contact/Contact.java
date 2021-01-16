/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.contact;

import int105.base.Address;
import java.util.Comparator;


/**
 *
 * @author Umaporn
 */
public abstract class Contact {
    private Address address;
    private String email;
    private String phone;
    private ContactType type;

    public Contact(Address address, String email, String phone, ContactType type) {
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }
    
   

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public ContactType getType() {
        return type;
    }

    
    @Override
    public String toString() {
        return "Contact{" + "address=" + address + ", email=" + email + ", phone=" + phone + ", type=" + type + '}';
    }
    
    public static Comparator<Contact> contactTypeComparator=new Comparator<Contact>(){
        @Override
        public int compare(Contact o1, Contact o2) {
           return o1.getType().compareTo(o2.getType());
        }
        
    };
    
    
    
    
}
