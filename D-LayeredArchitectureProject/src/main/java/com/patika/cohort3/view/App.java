package com.patika.cohort3.view;

import com.patika.cohort3.business.concrete.CustomerManager;
import com.patika.cohort3.dao.concrete.CustomerDao;
import com.patika.cohort3.entity.Customer;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Nida Başer
 * May 2024
 */

public class App {
    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager(new CustomerDao());

        // EKLEME
        /*
        Customer customer = new Customer();
        customer.setName("Spring Java");
        customer.setMail("test@patika.dev");
        customer.setGender(Customer.Gender.MALE);
        customer.setOnDate(LocalDate.now());

        customerManager.save(customer);
        */

        // LİSTELEME
        //Customer firstCustomer = customerManager.findById(1);
        //System.out.printf(firstCustomer.toString());

        // SİLME
        //customerManager.deleteById(2);

        // GÜNCELLEME
        //Customer customer = customerManager.findById(3);
        //customer.setMail("tester@patika.dev");
        //customerManager.update(customer);

        // FIND ALL
        List<Customer> customerList = customerManager.findAll();
        System.out.printf(customerList.toString());

    }
}
