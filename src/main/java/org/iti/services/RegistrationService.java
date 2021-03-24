package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.CustomerDaoImpl;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.db.DBSessionProvider;
import org.iti.dtos.CustomerDto;
import org.iti.utils.mappers.todtomappers.CustomerMapper;

public class RegistrationService {

    CustomerDao customerDao;
    DBSessionProvider dbSessionProvider;
    Session serviceSession;


    public RegistrationService() {

        dbSessionProvider = DBSessionProvider.getInstance();
        serviceSession = dbSessionProvider.getSession();
        customerDao =  new CustomerDaoImpl(serviceSession);


    }

    public boolean registerCustomer(CustomerDto customerDto){

        CustomerMapper customerMapper = new CustomerMapper();
        customerDao.addCustomer(customerMapper.toEntity(customerDto));

        return true;
    }
}
