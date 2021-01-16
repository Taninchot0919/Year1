/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Account;

import java.sql.Connection;
import Controller.DatabaseController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laptop
 */
public class AccountDaoImpl implements AccountDao {

    private final Connection conn = DatabaseController.connectDB();
    private final String SQL_CREATE_ACCOUNT = "INSERT INTO account (username, password, personID, privilege) VALUES ( ?, ?, ?, ?)";
    private final String SQL_GET_ACCOUNT_BY_ID = "SELECT * FROM account WHERE AccuntID=?";
    private final String SQL_GET_ALL_ACCOUNT = "SELECT * FROM account";
    private final String SQL_UPDATE_ACCOUNT = "UPDATE account SET username=?, password=?, personID=?, privilege=? WHERE AccuntID=?";
    private final String SQL_DELETE_ACCOUNT = "DELETE FROM account WHERE AccuntID=?";

    @Override
    public int createAccount(Account account) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_ACCOUNT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, account.getUsername());
            pstmt.setString(2, account.getPassword());
            pstmt.setInt(3, account.getPersonID());
            pstmt.setInt(4, account.getPrivilege());
            row = pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    account.setAccountId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public Account getAccountById(int accountId) {
        Account account = new Account();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ACCOUNT_BY_ID)) {
            pstmt.setInt(1, accountId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    account.setAccountId(rs.getInt(1));
                    account.setUsername(rs.getString(2));
                    account.setPassword(rs.getString(3));
                    account.setPersonID(rs.getInt(4));
                    account.setPrivilege(rs.getInt(5));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    @Override
    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> allAccount = new ArrayList();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ALL_ACCOUNT);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setPersonID(rs.getInt(4));
                account.setPrivilege(rs.getInt(5));
                allAccount.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allAccount;
    }

    @Override
    public int updateAccount(Account account) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_ACCOUNT)) {
            pstmt.setString(1, account.getUsername());
            pstmt.setString(2, account.getPassword());
            pstmt.setDouble(3, account.getPersonID());
            pstmt.setDouble(4, account.getPrivilege());
            pstmt.setDouble(5, account.getAccountId());
            row = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int deleteAccount(int accountId) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE_ACCOUNT)) {
            pstmt.setInt(1, accountId);
            row = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

}
