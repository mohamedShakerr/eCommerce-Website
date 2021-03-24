package org.iti.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.dtos.CustomerDto;
import org.iti.services.RegistrationService;

import java.io.IOException;


public class RegistrationController extends HttpServlet {

    // Todo : let's talk about how we are going to provide services

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.html");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RegistrationService registrationService = new RegistrationService();

        // Todo maybe I should validate these data using ajax to check if They excited before.
        // or I can use a validation filter for this request, but the ajax Way would be more
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String job = req.getParameter("job");
        String interests = req.getParameter("interests");

        CustomerDto customerDto = new CustomerDto(userName,email,password,address,1000L,phone);
        customerDto.setUrl("/imageurl/");

        registrationService.registerCustomer(customerDto);

        resp.sendRedirect("index.jsp");

    }
}