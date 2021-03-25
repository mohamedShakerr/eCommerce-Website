package org.iti.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.db.domain.Customers;
import org.iti.dtos.CustomerDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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


    @Override
    public boolean isCustomerExist(Customers customer){

        String queryString = "FROM Customers c WHERE c.email = ?0 AND c.password = ?1" ;
        List<Customers> customerList = hibernateSession.createQuery(queryString, Customers.class)
                .setParameter( 0, customer.getEmail())
                .setParameter( 1, customer.getPassword()).list();

        if (customerList.isEmpty()){
            return false;
        }

        return true;
    }

    @Override
    public int getUserIdByEmail(String email) {

        String queryString = "from Customers c WHERE c.email=?0";
        Query query = hibernateSession.createQuery(queryString, Customers.class).setParameter(0, email);
        System.out.println(query.getResultList());
        System.out.println(query.getSingleResult());

        return ((Customers)query.getResultList().get(0)).getCustomerId();
    }

}
