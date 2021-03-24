package org.iti.data.daoimpl;

import org.iti.data.daos.CustomerDao;
import org.iti.db.DBConnectionFactory;
import org.iti.dto.CustomerDto;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    private static volatile CustomerDaoImpl customerDao = null;

    private CustomerDaoImpl() {
    }

    public static CustomerDaoImpl getInstance() {
        if(customerDao == null){
            synchronized (CustomerDaoImpl.class){
                if(customerDao == null){
                    customerDao = new CustomerDaoImpl();
                }
            }
        }
        return customerDao;
    }


    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        return null;
    }
}
