package org.iti.services;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iti.data.daoimpl.CustomerDAO;
import org.iti.domain.Customer;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerServices {
    private CustomerDAO customerDao = new CustomerDAO();
    private HttpServletRequest request;
    private HttpServletResponse response;
    public CustomerServices(){}
    public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void showCustomerProfile(int id) throws ServletException, IOException {
        Customer customer = customerDao.getCustomer(id);
        HttpSession session = request.getSession();
        session.setAttribute("customer", customer);
        RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
        rd.forward(request, response);
    }

    public void updateCustomer() throws ServletException, IOException {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        if(name !=null && email != null && password != null && phone!= null && address != null &&
            !name.isEmpty() && !address.isEmpty() && password.length()>=6 && isPhoneNumberValid(phone) && isEmailValid(email)){
            HttpSession session = request.getSession();
            Customer customer=(Customer) session.getAttribute("customer");
            customer.setPassword(password);
            customer.setPhone(phone);
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            request.setAttribute("success",true);
            //Update DB
            customerDao.updateCustomer(customer);
        }else{
            request.setAttribute("success",false);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/edit_profile.jsp");
        rd.forward(request, response);
    }
   public double addMoneyToCredit(double money,int id){
        Customer customer=customerDao.getCustomer(id);
        //update DB
        customer.setCredit(money+customer.getCredit());
        return customer.getCredit();
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