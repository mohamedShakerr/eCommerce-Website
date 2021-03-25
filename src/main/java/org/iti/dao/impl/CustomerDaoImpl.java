package org.iti.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.Customers;
import org.iti.dtos.CustomerDto;

public class CustomerDaoImpl implements CustomerDao {

    DBSessionProvider dbSessionProvider;


    public CustomerDaoImpl() {
        dbSessionProvider = DBSessionProvider.getInstance();
    }

    @Override
    public void addCustomer(Customers customer) {

        Session hibernateSession = dbSessionProvider.getSession();

        hibernateSession.persist(customer);

        hibernateSession.getTransaction().commit();

        hibernateSession.close();

    }

    @Override
    public Customers getCustomerByUserName(String userName) {
        Session hibernateSession = dbSessionProvider.getSession();

        Query q = hibernateSession.
                createQuery("from Customers c where c.name = :name")
                .setParameter("name", userName);


        Customers result = (Customers) q.uniqueResult();

        hibernateSession.close();
        return result;


    }

    @Override
    public Customers getCustomerByUserEmail(String email) {

        Session hibernateSession = dbSessionProvider.getSession();

        Query q = hibernateSession.
                createQuery("from Customers c where c.email = :email")
                .setParameter("email", email);


        Customers result = (Customers) q.uniqueResult();
        hibernateSession.close();
        return result;

    }
}
