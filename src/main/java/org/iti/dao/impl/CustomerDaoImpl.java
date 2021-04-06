package org.iti.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.Customers;
import org.iti.db.domain.Orders;
import org.iti.dtos.CustomerDto;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    // Session session = null;
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
    public Customers getCustomerByUserId(Integer customerId) {

        Session hibernateSession = dbSessionProvider.getSession();

        Query q = hibernateSession.
                createQuery("from Customers c where c.customerId = :customerId")
                .setParameter("customerId", customerId);

        Customers result = (Customers) q.uniqueResult();
        hibernateSession.close();

        return result;
    }

    public List<Orders> getOrdersByUserId(Integer customerId){

        Session hibernateSession = dbSessionProvider.getSession();

        String queryString = "from Orders o where o.customers.customerId= :id " ;
        Query query = hibernateSession.createQuery(queryString).setParameter("id",customerId);

        List<Orders> orders = query.getResultList();
        hibernateSession.close();

        return orders;
    }

    @Override
    public boolean isCustomerExist(Customers customer){
        Session hibernateSession = dbSessionProvider.getSession();

        String queryString = "FROM Customers c WHERE c.email = ?0 AND c.password = ?1" ;
        List<Customers> customerList = hibernateSession.createQuery(queryString, Customers.class)
                .setParameter( 0, customer.getEmail())
                .setParameter( 1, customer.getPassword()).list();

        if (customerList.isEmpty()){
            hibernateSession.close();
            return false;
        }
        hibernateSession.close();
        return true;
    }

    @Override
    public int getUserIdByEmail(String email) {

        Session hibernateSession = dbSessionProvider.getSession();

        String queryString = "from Customers c WHERE c.email=?0";
        Query query = hibernateSession.createQuery(queryString, Customers.class).setParameter(0, email);
        System.out.println(query.getResultList());
        System.out.println(query.getSingleResult());
        int userId = ((Customers)query.getResultList().get(0)).getCustomerId();
        hibernateSession.close();
        return userId;
    }


    // Todo make the session creation and usage consistant with the rest of the application
    @Override
    public List<Customers> getAllCustomers() {

        Session hibernateSession = dbSessionProvider.getSession();
        Query query = hibernateSession.createQuery("from Customers", Customers.class);

        List<Customers> customers = query.getResultList();
        hibernateSession.close();
        return customers;
    }

    @Override
    public Customers getCustomerByID(int id){
        Session hibernateSession = dbSessionProvider.getSession();

        Query q = hibernateSession.
                createQuery("from Customers c where c.customerId = :id")
                .setParameter("id", id);

        Customers result = (Customers) q.uniqueResult();
        hibernateSession.close();

        return result;
    }

    public void updateCustomer(int id,CustomerDto customerDto){
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        javax.persistence.Query q = session.createQuery("update Customers c set c.name =:name , c.email =:email "+
                " , c.password =:password ,c.phone =:phone , c.address =:address where c.customerId = :id")
                .setParameter("id", id)
                .setParameter("name", customerDto.getName())
                .setParameter("email", customerDto.getEmail())
                .setParameter("password", customerDto.getPassword())
                .setParameter("phone", customerDto.getPhone())
                .setParameter("address", customerDto.getAddress());

        q.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public double addMoneyToCredit(int id,double money){
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        javax.persistence.Query q = session.createQuery("update Customers c set c.credit = c.credit+:qty where c.customerId = :id")
                .setParameter("id", id)
                .setParameter("qty", money);

        q.executeUpdate();

        session.getTransaction().commit();
        session.close();

        Customers result = getCustomerByID(id);

        return result.getCredit();
    }

    public double subMoneyToCredit(int id,double money){
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        javax.persistence.Query q = session.createQuery("update Customers c set c.credit = c.credit-:qty where c.customerId = :id")
                .setParameter("id", id)
                .setParameter("qty", money);

        q.executeUpdate();

        session.getTransaction().commit();
        session.close();

        Customers result = getCustomerByID(id);

        return result.getCredit();
    }




    public void updateCustomerAvatar(int id,String url){
        Session session = dbSessionProvider.getSession();

        session.beginTransaction();

        javax.persistence.Query q = session.createQuery("update Customers c set c.image =:image where c.customerId = :id")
                .setParameter("id", id)
                .setParameter("image", url);
        q.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public double getCreditLimit(int id){
        Session hibernateSession = dbSessionProvider.getSession();

        Query q = hibernateSession.
                createQuery("from Customers c where c.customerId = :id")
                .setParameter("id", id);

        Customers customer = (Customers) q.uniqueResult();
        hibernateSession.close();

        return customer.getCredit();
    }

    public String getUserTokenById(int userId) {

        Session hibernateSession = dbSessionProvider.getSession();

        Customers customers = hibernateSession.find(Customers.class, userId);

        if(customers == null){
            hibernateSession.close();
            return null;
        }else {
            hibernateSession.close();
            return customers.getCookieToken();
        }
    }

    @Override
    public void saveTokenbyUserId(String token, int userId) {
        Session hibernateSession = dbSessionProvider.getSession();
        hibernateSession.beginTransaction();

        Customers customers = hibernateSession.find(Customers.class, userId);

        if(customers != null){
            customers.setCookieToken(token);
        }

        hibernateSession.getTransaction().commit();

        hibernateSession.close();
    }

//    @Override
//    public Customers getCustomerById(int userId) {
//        Session hibernateSession = dbSessionProvider.getSession();
//
//        Customers customer = hibernateSession.find(Customers.class, userId);
//
//        hibernateSession.close();
//        return  customer;
//    }



}
