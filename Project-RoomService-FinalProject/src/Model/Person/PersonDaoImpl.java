/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

import Controller.DatabaseController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TANINCHOTPHUWALOERTT
 */
public class PersonDaoImpl implements PersonDao {

    private final Connection conn = DatabaseController.connectDB();
    private final String SQL_CREATE_PERSON = "INSERT INTO person (firstName, lastName, phone, rank) VALUES ( ?, ?, ?, ?)";
    private final String SQL_GET_PERSON_BY_ID = "SELECT * FROM person WHERE PersonID=?";
    private final String SQL_GET_ALL_PERSON = "SELECT * FROM person";
    private final String SQL_UPDATE_PERSON = "UPDATE person SET firstName=?, lastName=?, phone=?, rank=? WHERE PersonID=?";
    private final String SQL_DELETE_PERSON = "DELETE FROM person WHERE PersonID=?";

    @Override
    public int createPerson(Person person) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_PERSON, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, person.getFirstname());
            pstmt.setString(2, person.getLastname());
            pstmt.setString(3, person.getPhone());
            pstmt.setString(4, person.getRank());
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    row = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public Person getPersonById(int personId) {
        Person person = new Person();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_PERSON_BY_ID)) {
            pstmt.setInt(1, personId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    person.setPersonID(rs.getInt(1));
                    person.setFirstname(rs.getString(2));
                    person.setLastname(rs.getString(3));
                    person.setPhone(rs.getString(4));
                    person.setRank(rs.getString(5));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }

    @Override
    public ArrayList<Person> getAllPerson() {
        ArrayList<Person> allPerson = new ArrayList();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ALL_PERSON);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Person person = new Person();
                person.setPersonID(rs.getInt(1));
                person.setFirstname(rs.getString(2));
                person.setLastname(rs.getString(3));
                person.setPhone(rs.getString(4));
                person.setRank(rs.getString(5));
                allPerson.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allPerson;
    }

    @Override
    public int updatePerson(Person person) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_PERSON)) {
            pstmt.setInt(1, person.getPersonID());
            pstmt.setString(2, person.getFirstname());
            pstmt.setString(3, person.getLastname());
            pstmt.setString(4, person.getPhone());
            pstmt.setString(5, person.getRank());
            row = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int deletePerson(int personId) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE_PERSON)) {
            pstmt.setInt(1, personId);
            row = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
