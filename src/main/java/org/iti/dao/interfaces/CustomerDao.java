package org.iti.dao.interfaces;

import org.iti.db.domain.Customers;
import org.iti.dtos.CustomerDto;

public interface CustomerDao {

    void addCustomer(Customers customerDto);
}
