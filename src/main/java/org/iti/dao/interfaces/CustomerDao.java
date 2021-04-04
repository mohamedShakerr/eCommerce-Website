package org.iti.dao.interfaces;

import org.iti.db.domain.Customers;
import org.iti.db.domain.FeaturedProds;
import org.iti.dtos.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    void addCustomer(Customers customerDto);

    Customers getCustomerByUserName(String userName);

    Customers getCustomerByUserEmail(String email);

    boolean isCustomerExist(Customers customerDto);

    int getUserIdByEmail(String email);

    List<Customers> getAllCustomers();

    public Customers getCustomerByID(int id);

    public void updateCustomer(int id,CustomerDto customerDto);

    public double addMoneyToCredit(int id,double money);

    public void updateCustomerAvatar(int id,String url);

    public double getCreditLimit(int id);
    String getUserTokenById(int userId);

    void saveTokenbyUserId(String token, int userId);


}
