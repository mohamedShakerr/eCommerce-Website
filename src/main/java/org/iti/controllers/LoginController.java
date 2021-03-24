package org.iti.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.iti.data.daoimpl.UserDaoImpl;
import org.iti.data.daos.UserDao;
import org.iti.helpers.CookiesManager;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController extends HttpServlet {

    CookiesManager cookiesManager = CookiesManager.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // check cookie email
        if(cookiesManager.isCookieExists(request, "email")) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.addHeader("Refresh", "5");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        try {
            UserDao userDao = UserDaoImpl.getUserDaoInstance();
            boolean isLoginValid = userDao.isLoginValid(email, password);
            int userId;

            if (isLoginValid) {

                HttpSession session = request.getSession(true);

                userId = userDao.getUserIdByEmail(email);
                session.setAttribute("userId", userId);

                if (rememberMe != null && rememberMe.equals("true")) {
                    cookiesManager.addCookie(response, "email", email);
                }

                response.sendRedirect("index.html");
            }
            else {

                request.setAttribute("InputError", "err");

                response.sendRedirect("login");
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}

