/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_Model;

import cinema.Person;

/**
 *
 * @author ASUS
 */
public class Manager extends Person{
    private String username;
    private long password;

    public Manager(String username, long password, long personId, String firstname, String lastname) {
        super(personId, firstname, lastname);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public long getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(long password) {
        this.password = password;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Manager's name : "+super.getFirstname());
        sb.append(" "+ super.getLastname());
        return sb.toString();
    }
}
