package org.iti.services;

import org.iti.data.daoimpl.CustomerDaoImpl;
import org.iti.data.daos.CustomerDao;
import org.iti.dto.CustomerDto;

public class RegistrationService {

    CustomerDao customerDao;

    public RegistrationService() {

        customerDao = CustomerDaoImpl.getInstance();
    }

    public boolean registerCustomer(CustomerDto customerDto){

        //todo Add real implementation

        return true;
    }
}
