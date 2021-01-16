/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.addressbook;

import int105.contact.BusinessContact;
import int105.contact.Contact;
import int105.contact.PersonContact;
import java.util.Iterator;

/**
 *
 * @author Umaporn
 */
public class AddressBook {

    private Contact[] friends;
    private int count;

    public AddressBook(int size) {
        if (size <= 0) {
            size = 10;
        }
        friends = new Contact[size];
    }

    public int getCount() {
        return count;
    }

    public boolean isFull() {
        return count == friends.length;
    }

    public Iterator<Contact> iterator() {
        return new Iterator<Contact>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public Contact next() {
                if (index == count) {
                    System.out.println("No More Contact.");
                }

                return friends[index++];
            }

        };
    }

    public boolean addFriend(Contact contact) {
        if (isFull()) {
            return false;
        }
        friends[count] = contact;
        count++;
        return true;
    }

    public int searchForName(String name) {
        if (name == null) {
            return -1;
        }
        for (int i = 0; i < count; i++) {

            if (friends[i] instanceof PersonContact) {
                if (((PersonContact) friends[i]).getPerson().getFirstname().equals(name)) {
                    return i;
                }

            } else {
                if (((BusinessContact) friends[i]).getCompany().getName().equals(name)) {
                    return i;
                }
            }

        }
        return -1;
    }
 
}
