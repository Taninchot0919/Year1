/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Account.Account;
import Model.Account.AccountDao;
import Model.Account.AccountDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author Laptop
 */
public class AccountService {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     *
     * @author Laptop
     */
    private final AccountDao accountDaoImpl = new AccountDaoImpl();
    
    public int createAccount(Account account) {
        return accountDaoImpl.createAccount(account);
    }
    
    public Account getAccountById(int accountId) {
        return accountDaoImpl.getAccountById(accountId);
    }
    
    public ArrayList<Account> getAllAccount() {
        return accountDaoImpl.getAllAccount();
    }
    
    public int updateAccount(Account account) {
        return accountDaoImpl.updateAccount(account);
    }
    
    public int deleteAccount(int accountId) {
        return accountDaoImpl.deleteAccount(accountId);
    }
    
}
