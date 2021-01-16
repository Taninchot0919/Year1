/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

import java.util.ArrayList;

/**
 *
 * @author TANINCHOTPHUWALOERTT
 */
public interface PersonDao {

    public int createPerson (Person person);

    public Person getPersonById(int personId);

    public ArrayList<Person> getAllPerson();

    public int updatePerson(Person person);

    public int deletePerson(int personId);
}
