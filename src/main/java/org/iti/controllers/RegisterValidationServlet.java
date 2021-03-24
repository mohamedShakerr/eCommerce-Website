package org.iti.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RegisterValidationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer =  response.getWriter();

        String type =req.getParameter("type");

        if(type.equals("name")){
            String userName = req.getParameter("userName");

            writer.print("Sent from server "+userName );
        }else if(type.equals("email")){

            String userName = req.getParameter("userName");

            writer.print("Sent from server "+userName );
        }


    }
}
