package com.patika.cohort3.business.concrete;

import com.patika.cohort3.business.abstracts.ICustomerService;
import com.patika.cohort3.dao.abstracts.ICustomerDao;
import com.patika.cohort3.entity.Customer;

import java.util.List;

/**
 * @author Nida Başer
 * May 2024
 */

public class CustomerManager implements ICustomerService {

    private ICustomerDao customerDao;

    // DEPENDENCY INJECTION
    public CustomerManager(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        Customer checkMailCustomer = this.customerDao.findByMail(customer.getMail());
        if (checkMailCustomer != null) {
            throw new RuntimeException(customer.getMail() + " this mail is already added ! ");
        }
        this.customerDao.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.customerDao.findById(id);
    }

    @Override
    public void update(Customer customer) {
        Customer checkMailCustomer = this.customerDao.findByMail(customer.getMail());
        if (checkMailCustomer != null && checkMailCustomer.getId() != customer.getId()) { // UPDATE DE EKSTRA KONTROL ID'ler de eşit olmamalı !
            throw new RuntimeException(customer.getMail() + " this mail is already added ! ");
        }
        this.customerDao.save(customer);

    }

    @Override
    public void deleteById(int id) {
        //Customer customer = this.customerDao.findById(id);
        this.customerDao.delete(this.findById(id)); // customer nesnesi oluşturup içine atmak yerine metodu içine atabilirsin :D
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDao.findAll();
    }
}
