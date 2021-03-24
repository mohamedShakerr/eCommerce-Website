package org.iti.dao.impl;

import org.hibernate.Session;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.db.domain.Customers;
import org.iti.dtos.CustomerDto;

public class CustomerDaoImpl implements CustomerDao {

    Session hibernateSession;

    public CustomerDaoImpl() {
    }

    public CustomerDaoImpl(Session hibernateSession) {
        this.hibernateSession = hibernateSession;
    }

    @Override
    public void addCustomer(Customers customer) {

        hibernateSession.beginTransaction();

          hibernateSession.persist(customer);

          hibernateSession.getTransaction().commit();
    }
}
