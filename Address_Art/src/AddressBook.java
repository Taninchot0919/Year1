
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author taninchot
 */
public class AddressBook {

    private Contact[] friends;
    private int count;

    public AddressBook(int size) {
        if (size <= 0) {
            friends = new Contact[10];
        } else {
            friends = new Contact[size];
        }
    }

    public int getCount() {
        return count;
    }

    public boolean isFull() {
        return friends.length == count;
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
                if(index == count){
                    System.out.println("No more");
                }
                return friends[index++];
            }
        };
    }

    public boolean addFriend(Contact contact) {
        if (isFull()) {
            return false;
        } else {
            friends[count++] = contact;
        }
        return true;
    }

    public int searchForName(String name) {
        if (name == null) {
            return -1;
        }
        for (int i = 0; i < count; i++) {

            if (friends[i].getType() == ContactType.PERSON) {
                if (((PersonContact) friends[i]).getPerson().getFirstName().equals(name)) {
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
