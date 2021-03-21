package org.iti.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iti.data.daoimpl.UserDaoImpl;
import org.iti.data.daos.UserDao;
import org.iti.helpers.CookiesManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;


public class LoginController extends HttpServlet {

    CookiesManager cookiesManager = CookiesManager.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        cookiesManager.readCookie(request);

        response.sendRedirect("login.jsp");
//        RequestDispatcher rd = request.getRequestDispatcher("index.html");
//        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        try {
            UserDao userDao = UserDaoImpl.getUserDaoInstance();
            boolean isLoginValid = userDao.isLoginValid(email, password);
            int userId;

            if (isLoginValid) {
                userId = userDao.getUserIdByEmail(email);

//                if (rememberMe != null && rememberMe.equals("true")) {
                    cookiesManager.writeCookie(response, "email", email);
                    System.out.println("cookies" + Arrays.toString(cookiesManager.getCookies(request)));
//                }

                HttpSession session = request.getSession(true);
                session.setAttribute("userId", userId);

                response.sendRedirect("index.html");
                return;
            }

            RequestDispatcher rd = request.getRequestDispatcher("err404.jsp");
            rd.include(request, response);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}

