/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Service;

import Model.Person.Person;
import Model.Person.PersonDao;
import Model.Person.PersonDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author TANINCHOTPHUWALOERTT
 */
public class PersonService {

    private final PersonDao personDaoImpl = new PersonDaoImpl();

    public int createPerson(Person person) {
        return personDaoImpl.createPerson(person);
    }

    public Person getPersonById(int personId) {
        return personDaoImpl.getPersonById(personId);
    }

    public ArrayList<Person> getAllPerson() {
        return personDaoImpl.getAllPerson();
    }

    public int updatePerson(Person person) {
        return personDaoImpl.updatePerson(person);
    }

    public int deletePerson(int personId) {
        return personDaoImpl.deletePerson(personId);
    }
}
