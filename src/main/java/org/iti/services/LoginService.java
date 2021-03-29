package org.iti.services;

import org.iti.dao.impl.CustomerDaoImpl;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.dtos.CustomerDto;
import org.iti.utils.mappers.todtomappers.CustomerMapper;

import java.sql.SQLException;

public class LoginService {

    // Todo make session management mechanisim consistant just like product
    CustomerDao customerDao;

    public LoginService() {
        customerDao =  new CustomerDaoImpl();
    }


    public boolean isLoginCustomer(CustomerDto customerDto) throws SQLException {

        CustomerMapper customerMapper = new CustomerMapper();
        return customerDao.isCustomerExist(customerMapper.toEntity(customerDto));
    }

    public int getUserIdByEmail(String email){
        return customerDao.getUserIdByEmail(email);
    }

}
