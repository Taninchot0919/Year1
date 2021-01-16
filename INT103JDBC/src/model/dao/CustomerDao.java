/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.Customer;
import model.GeneralList;

/**
 *
 * @author TANINCHOTPHUWALOERTT
 */
public interface CustomerDao {

    int insert(Customer customer);

    int delete(int customer);

    int update(Customer customer);

    Customer findById(int id);

    GeneralList<Customer> findByName(String name);

    GeneralList<Customer> getAll();

}
