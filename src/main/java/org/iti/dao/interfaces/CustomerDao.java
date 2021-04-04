package org.iti.dao.interfaces;

import org.iti.db.domain.Customers;
import org.iti.db.domain.FeaturedProds;
import org.iti.domain.Customer;
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

    String getUserTokenById(int userId);

    void saveTokenbyUserId(String token, int userId);

    Customers getCustomerById(int userId);

}
