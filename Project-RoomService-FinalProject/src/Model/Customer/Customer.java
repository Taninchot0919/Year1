/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Customer;

/**
 *
 * @author Laptop
 */
public class Customer {

    private int CustomerID;
    private String firstname;
    private String lastname;
    private String email;
    private int age;
    private String phone;

    public Customer() {
    }

    public Customer(String firstname, String lastname, String email, int age, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }
    
    public int getCustomerID() {
        return CustomerID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "CustomerID=" + CustomerID + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", age=" + age + ", phone=" + phone + '}';
    }

}
