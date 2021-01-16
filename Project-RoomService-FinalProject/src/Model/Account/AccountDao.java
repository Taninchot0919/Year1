/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Account;

import java.util.ArrayList;

/**
 *
 * @author Laptop
 */

//DAO = Database Access Object
public interface AccountDao {

    public int createAccount(Account account);

    public Account getAccountById(int accountId);

    public ArrayList<Account> getAllAccount();

    public int updateAccount(Account account);

    public int deleteAccount(int accountId);
}
