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
            System.out.println("inside mail validation");
            String email = req.getParameter("email");
            System.out.println(email);
            boolean exists = registrationService.checkIfCustomerExistsByEmail(email);

            System.out.println("returned exist out of checking of service" + exists);
            writer.print(exists);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {


    }
}
