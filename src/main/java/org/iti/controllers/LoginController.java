package org.iti.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.iti.dtos.CustomerDto;
import org.iti.services.LoginService;
import org.iti.services.RegistrationService;
import org.iti.utils.CookiesManager;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController extends HttpServlet {

    CookiesManager cookiesManager = CookiesManager.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // check cookie email
        if(cookiesManager.isCookieExists(request, "email")) {
            //INTRO VALIDATION
            //Filter
            //
            response.sendRedirect(request.getContextPath());
        } else {
            response.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LoginService loginService = new LoginService();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        try {

            CustomerDto customerDto = new CustomerDto(email, password);

            boolean isLoginValid = loginService.isLoginCustomer(customerDto);


            if(isLoginValid) {

                HttpSession session = request.getSession(true);

                int userId = loginService.getUserIdByEmail(email);
                session.setAttribute("userId", userId);

                if (rememberMe != null && rememberMe.equals("true")) {
                    cookiesManager.addCookie(response, "email", email);
                    session.setAttribute("rememberMe", true);
                }

                response.sendRedirect(request.getContextPath());
            }
            else {

                request.setAttribute("InputError", "err");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}

