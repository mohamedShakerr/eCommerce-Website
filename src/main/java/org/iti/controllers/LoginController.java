package org.iti.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.iti.dtos.CustomerDto;
import org.iti.services.LoginService;
import org.iti.services.RegistrationService;
import org.iti.utils.CookiesManager;
import org.iti.utils.UUIDProvider;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController extends HttpServlet {

    CookiesManager cookiesManager = CookiesManager.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // check cookie email
//        boolean isUIDCookieExist = cookiesManager.isCookieExists(request, "UID");
//        boolean isTokenCookieExist = cookiesManager.isCookieExists(request, "token");

//
//
//        if(cookiesManager.isCookieExists(request, "email")) {
//
//            response.sendRedirect(request.getContextPath());
//        } else {
//            response.sendRedirect("login.jsp");
//        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException             {


        LoginService loginService = new LoginService();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");


        CustomerDto customerDto = new CustomerDto(email, password);

        boolean isLoginValid = false;
        isLoginValid = loginService.isLoginCustomer(customerDto);


        if(isLoginValid) {

            HttpSession session = request.getSession();

            int userId = loginService.getUserIdByEmail(email);

            boolean isUserAdmin = loginService.isUserAdminstrator(email);

            session.setAttribute("userId", userId);
            session.setAttribute("isUserAdmin", isUserAdmin);

            if (rememberMe != null && rememberMe.equals("true")) {

                //IF remember me is enabled create the token
                String randomString = UUIDProvider.getUUID();
                String userToken = DigestUtils.sha256Hex(randomString);
                System.out.println("USER TOKEN"+userToken);

                //Save that token in DB, For Future comparison
                loginService.saveToken(userToken,userId);

                cookiesManager.addCookie(response, "UID", ""+userId);
                cookiesManager.addCookie(response, "TOKEN", userToken);

                //====Check if User is Admin
                //TODO Refactor

                //====

                session.setAttribute("rememberMe", true);
                session.setAttribute("TOKEN", userToken);
            }else {

                session.setAttribute("rememberMe", false);
            }
            response.sendRedirect(request.getContextPath());
        }
        else {

            request.setAttribute("InputError", "err");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}

