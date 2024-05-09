package com.patika.cohort3.dao.abstracts;

import com.patika.cohort3.entity.Customer;

import java.util.List;

/**
 * @author Nida Başer
 * May 2024
 */

public interface ICustomerDao {

    void save(Customer customer);
    Customer findById(int id);
    void update(Customer customer);
    void delete(Customer customer);
    List<Customer> findAll();
    Customer findByMail(String mail);

}
