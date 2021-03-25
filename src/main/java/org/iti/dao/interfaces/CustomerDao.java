package org.iti.dao.interfaces;

import org.iti.db.domain.Customers;
import org.iti.db.domain.FeaturedProds;
import org.iti.dtos.CustomerDto;

import java.sql.SQLException;

public interface CustomerDao {

    void addCustomer(Customers customerDto);

    boolean isCustomerExist(Customers customerDto);

    int getUserIdByEmail(String email);

}
