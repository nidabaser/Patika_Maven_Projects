package com.patika.cohort3.core;

import com.patika.cohort3.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Nida Başer
 * May 2024
 */

public class HibernateSession {

    // Singleton Design Pattern

    public static Session session = null;

    public static Session getSession() {
        if (session == null) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Customer.class)
                    .buildSessionFactory();

            session = factory.openSession();
        }
        return session;
    }
}
