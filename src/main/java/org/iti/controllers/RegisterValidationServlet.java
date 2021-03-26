package org.iti.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.services.RegistrationService;

import java.io.IOException;
import java.io.PrintWriter;

public class RegisterValidationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RegistrationService registrationService = new RegistrationService();
        PrintWriter writer = resp.getWriter();

        String type = req.getParameter("type");

        if (type.equals("email")) {
            String email = req.getParameter("email");
            boolean exists = registrationService.checkIfCustomerExistsByEmail(email);

            writer.print(exists);
        }else if (type.equals("name")){

            String name = req.getParameter("name");
            boolean exists = registrationService.checkIfCustomerExistsByName(name);
            writer.print(exists);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {


    }
}
