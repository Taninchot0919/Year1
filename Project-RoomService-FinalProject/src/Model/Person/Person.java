/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

/**
 *
 * @author Laptop
 */
public class Person {
    private int PersonID;
    private String firstname;
    private String lastname;
    private String phone;
    private String rank;

    public Person() {
    }

    public Person(String firstname, String lastname, String phone, String rank) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.rank = rank;
    }
    
    public int getPersonID() {
        return PersonID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getRank() {
        return rank;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Person{" + "PersonID=" + PersonID + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", rank=" + rank + '}';
    }

    

}
