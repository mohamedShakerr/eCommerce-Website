package org.iti.controllers.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.services.CustomerServices;

import java.io.IOException;

public class EditProfileServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        CustomerServices customerServices=new CustomerServices(request,response);
        customerServices.updateCustomer();



    }



}
