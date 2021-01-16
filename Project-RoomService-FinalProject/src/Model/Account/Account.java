/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Account;

import Controller.DatabaseController;
import Model.Person.Person;
import java.util.Objects;

/**
 *
 * @author Laptop
 */

public class Account {

    private int AccountId;
    private String username;
    private String password;
    private int personID;
    private int privilege;

    public Account() {
    }

    public Account(String username, String password, int personID, int privilege) {
        this.username = username;
        this.password = password;
        this.personID = personID;
        this.privilege = privilege;
    }

    public int getAccountId() {
        return AccountId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPersonID() {
        return personID;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setAccountId(int AccountId) {
        this.AccountId = AccountId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "Account{" + "AccountId=" + AccountId + ", username=" + username + ", password=" + password + ", personID=" + personID + ", privilege=" + privilege + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.AccountId != other.AccountId) {
            return false;
        }
        if (this.personID != other.personID) {
            return false;
        }
        if (this.privilege != other.privilege) {
            return false;
        }
        
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    

}
