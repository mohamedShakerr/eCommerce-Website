package org.iti.services;

import org.hibernate.Session;
import org.iti.dao.impl.CustomerDaoImpl;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.db.DBSessionProvider;
import org.iti.db.domain.Customers;
import org.iti.dtos.CustomerDto;
import org.iti.utils.mappers.todtomappers.CustomerMapper;

public class RegistrationService {

    CustomerDao customerDao;

    public RegistrationService() {

        customerDao = new CustomerDaoImpl();


    }

    public boolean registerCustomer(CustomerDto customerDto) {

        CustomerMapper customerMapper = new CustomerMapper();
        customerDao.addCustomer(customerMapper.toEntity(customerDto));

        return true;
    }

/*    public boolean checkIfCustomerExistsByName(String userName) {

        Customers customer = customerDao.getCustomerByUserName(userName);

        return customer != null;
    }*/

    public boolean checkIfCustomerExistsByEmail(String email) {
        Customers customer = customerDao.getCustomerByUserEmail(email);

        return customer != null;
    }
}
