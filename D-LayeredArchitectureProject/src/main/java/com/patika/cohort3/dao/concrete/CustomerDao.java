package com.patika.cohort3.dao.concrete;

import com.patika.cohort3.core.HibernateSession;
import com.patika.cohort3.dao.abstracts.ICustomerDao;
import com.patika.cohort3.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

/**
 * @author Nida Başer
 * May 2024
 */

public class CustomerDao implements ICustomerDao {

    private final Session session;

    public CustomerDao(){
        this.session = HibernateSession.getSession();
    }

    @Override
    public void save(Customer customer) {
        this.session.beginTransaction();
        this.session.persist(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public Customer findById(int id) {
        return this.session.get(Customer.class, id);
    }

    @Override
    public void update(Customer customer) {
        this.session.beginTransaction();
        this.session.persist(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public void delete(Customer customer) {
        this.session.beginTransaction();
        this.session.remove(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public List<Customer> findAll() {
       return this.session.createSelectionQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public Customer findByMail(String mail) {
        SelectionQuery<Customer> query = this.session.createSelectionQuery("FROM Customer WHERE mail = :mail", Customer.class);
        query.setParameter("mail", mail);
        return query.getSingleResultOrNull(); // Burada veri boş gelirse hata vermesin diye
    }
}
