package org.iti.services;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.iti.dao.impl.CustomerDaoImpl;
import org.iti.dao.interfaces.CustomerDao;

import org.iti.db.DBSessionProvider;
import org.iti.db.domain.Customers;
import org.iti.domain.Customer;
import org.iti.dtos.CustomerDto;
import org.iti.utils.mappers.EntityDtoMapper;
import org.iti.utils.mappers.todtomappers.CustomerMapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerServices {

    public CustomerServices() {

    }



    public CustomerDto showCustomerProfile(int id) throws ServletException, IOException {

        CustomerDao customerDao=new CustomerDaoImpl();
        Customers customer= customerDao.getCustomerByID(id);
        EntityDtoMapper<Customers, CustomerDto> mapper = new CustomerMapper();

        return mapper.toDto(customer);


    }

    public boolean updateCustomer(int id,String name,String email,String password,String phone,String address) throws ServletException, IOException {

        if(name !=null && email != null && password != null && phone!= null && address != null &&
            !name.isEmpty() && !address.isEmpty() && password.length()>=6 && isPhoneNumberValid(phone) && isEmailValid(email)){

            //Update DB
            CustomerDao customerDao=new CustomerDaoImpl();
            CustomerDto customerDto=new CustomerDto();
            customerDto.setAddress(address);
            customerDto.setEmail(email);
            customerDto.setName(name);
            customerDto.setPhone(phone);
            customerDto.setPassword(password);
            customerDao.updateCustomer(id,customerDto);
            return true;
        }

       return false;
    }
   public double addMoneyToCredit(int id,double money){
       CustomerDao customerDao=new CustomerDaoImpl();
        double creditCardAmount=customerDao.addMoneyToCredit(id,money);

        return creditCardAmount;
    }
    boolean isPhoneNumberValid(String phone){
        Pattern pattern = Pattern.compile("^(011|015|012|010)[0-9]{8}");
        Matcher matcher = pattern.matcher(phone);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return true;
        } else {
            return false;
        }
    }

    boolean isEmailValid(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return true;
        } else {
            return false;
        }
    }
}