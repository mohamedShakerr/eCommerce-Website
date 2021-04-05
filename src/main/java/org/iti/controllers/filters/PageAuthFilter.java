package org.iti.controllers.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iti.utils.CookiesManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PageAuthFilter implements Filter {

//    private final List<String> loggedInOnlyURLs = new ArrayList<>();

    public void init(FilterConfig filterConfig) {


    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest   = (HttpServletRequest) request;

        //Check if user is signed In
        //If Signed in Allow Them to the resource
        //If Not redirect to Login
        HttpSession session = httpRequest.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if(userId != null){
            chain.doFilter(request,response);
        }
        else {
            //User is not logged In
            //Disallow them And redirect to login
            if(isAjax(httpRequest)){
                httpResponse.getWriter().print(xmlPartialRedirectToPage(httpRequest, "/login"));
                httpResponse.flushBuffer();
            }else {
                httpResponse.sendRedirect(httpRequest.getContextPath()+"/login");
            }
            return;
        }

    }

    public void destroy() {

    }

    private boolean isAjax(HttpServletRequest request) {
        System.out.println("HEADER"+ request.getHeader("X-Requested-With"));
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    private String xmlPartialRedirectToPage(HttpServletRequest request, String page) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<partial-response><redirect url=\"").append(request.getContextPath()).append(page).append("\"/></partial-response>");
        return sb.toString();
    }

}
