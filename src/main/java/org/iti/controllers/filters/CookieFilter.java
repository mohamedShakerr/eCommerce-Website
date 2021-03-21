package org.iti.controllers.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iti.helpers.CookiesManager;

import java.io.IOException;

public class CookieFilter implements Filter {

    public void init(FilterConfig filterConfig) {

        System.out.println("Filter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        var req = (HttpServletRequest) request;
        var res = (HttpServletResponse) response;

        String url = req.getRequestURL().toString();

        CookiesManager cookiesManager = CookiesManager.getInstance();
        Cookie[] cookies = cookiesManager.getCookies(req);

        if (cookies == null) {
            if (req.getParameter("checkCookies") == null) {
                cookiesManager.writeCookie(res, "cookieTest", "cookieCheck");

                System.out.println("wow .. we added cookies");

                res.sendRedirect(url + "?checkCookies=1");
            } else {
                System.out.println("sad .. cookies is blocked");
                if(url.endsWith("login.jsp")){
                    RequestDispatcher rd = request.getRequestDispatcher("alertCookies.jsp");
                    rd.include(request, response);
                }
                else {
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.include(request, response);
                }

            }
        } else {
            System.out.println("cookie is enabled");
            String email = request.getParameter("email");
//            for(Cookie cookie : cookies){
//
//                if(cookie.getName().equals("email") && cookie.getValue().equals(email)){
//                    ((HttpServletResponse) response).sendRedirect("index.html");
//                }
//            }
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

        System.out.println("Filter destroyed");
    }

}
