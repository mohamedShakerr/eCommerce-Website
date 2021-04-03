package org.iti.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.PageContext;
import jakarta.ws.rs.core.Request;
import org.iti.dtos.CustomerDto;
import org.iti.services.LoginService;
import org.iti.utils.CookiesManager;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LogoutController", urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        session.invalidate();

        Cookie emailCookieRemove = new Cookie("email", "");
        emailCookieRemove.setMaxAge(-1);
        response.addCookie(emailCookieRemove);

        response.sendRedirect(request.getContextPath());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}


