package org.iti.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.Customers;
import org.iti.dtos.CustomerDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    DBSessionProvider dbSessionProvider;


    public CustomerDaoImpl() {
        dbSessionProvider = DBSessionProvider.getInstance();
    }

    @Override
    public void addCustomer(Customers customer) {

        dbSessionProvider = DBSessionProvider.getInstance();
        Session hibernateSession = dbSessionProvider.getSession();

        hibernateSession.beginTransaction();

        hibernateSession.save(customer);

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
