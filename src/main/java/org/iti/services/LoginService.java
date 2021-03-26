package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.CustomerDaoImpl;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.db.DBSessionProvider;
import org.iti.dtos.CustomerDto;
import org.iti.utils.mappers.todtomappers.CustomerMapper;

import java.sql.SQLException;

public class LoginService {

    CustomerDao customerDao;
    DBSessionProvider dbSessionProvider;
    Session serviceSession;


    public LoginService() {
        dbSessionProvider = DBSessionProvider.getInstance();
        serviceSession = dbSessionProvider.getSession();
        customerDao =  new CustomerDaoImpl(serviceSession);

    }


    public boolean isLoginCustomer(CustomerDto customerDto) throws SQLException {

        CustomerMapper customerMapper = new CustomerMapper();
        return customerDao.isCustomerExist(customerMapper.toEntity(customerDto));
    }

    public int getUserIdByEmail(String email){
        return customerDao.getUserIdByEmail(email);
    }

}
