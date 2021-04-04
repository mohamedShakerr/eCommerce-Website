package org.iti.services;

import org.iti.dao.impl.CustomerDaoImpl;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.db.domain.Customers;
import org.iti.domain.Customer;
import org.iti.dtos.CustomerDto;
import org.iti.utils.mappers.todtomappers.CustomerMapper;

import java.sql.SQLException;

public class LoginService {

    // Todo make session management mechanisim consistant just like product
    CustomerDao customerDao;

    public LoginService() {
        customerDao =  new CustomerDaoImpl();
    }


    public boolean isLoginCustomer(CustomerDto customerDto) {

        CustomerMapper customerMapper = new CustomerMapper();
        return customerDao.isCustomerExist(customerMapper.toEntity(customerDto));
    }

    public int getUserIdByEmail(String email){
        return customerDao.getUserIdByEmail(email);
    }

    public void saveToken(String token, int userId){

        CustomerDao dao = new CustomerDaoImpl();
        dao.saveTokenbyUserId(token, userId);

    }

    public  String getUserToken(int userId){
         return customerDao.getUserTokenById(userId);
    }


    public boolean validateToken(String token, int userId){
        boolean result;

        CustomerDao dao = new CustomerDaoImpl();

        Customers customer = dao.getCustomerById(userId);

        if(customer == null){
            return  false;
        }

        String customerToken = customer.getCookieToken();

        if( token.equals(customerToken) ){
            return true;
        }else {
            return  false;
        }
    }

}
