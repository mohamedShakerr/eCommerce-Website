package org.iti.controllers.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.iti.dtos.CustomerDto;
import org.iti.services.CustomerServices;

import java.io.IOException;

public class EditProfileServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        CustomerServices customerServices=new CustomerServices();
        /**********XXXXXXXXXXXXXXXXXXXXXXXXX*************/
        int id=1;
        if(customerServices.updateCustomer(1,name,email,password,phone,address)){
            HttpSession session = request.getSession();
            CustomerDto customerDto=(CustomerDto) session.getAttribute("customerDto");
            customerDto.setPassword(password);
            customerDto.setPhone(phone);
            customerDto.setName(name);
            customerDto.setEmail(email);
            customerDto.setAddress(address);
            request.setAttribute("success",true);
        }else{
            request.setAttribute("success",false);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/edit_profile.jsp");
        rd.forward(request, response);


    }



}
