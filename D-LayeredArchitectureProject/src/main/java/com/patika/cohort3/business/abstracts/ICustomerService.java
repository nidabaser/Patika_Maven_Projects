package com.patika.cohort3.business.abstracts;

import com.patika.cohort3.entity.Customer;

import java.util.List;

/**
 * @author Nida Başer
 * May 2024
 */

public interface ICustomerService {
    void save(Customer customer);
    Customer findById(int id);
    void update(Customer customer);
    void deleteById(int id);
    List<Customer> findAll();
}
