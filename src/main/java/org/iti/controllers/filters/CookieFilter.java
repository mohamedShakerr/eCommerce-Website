package org.iti.controllers.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.iti.utils.CookiesManager;

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

        if (cookies != null) {

            System.out.println("cookie is enabled");

            chain.doFilter(request, response);

        } else {

            // add checkCookies parameter at the first time
            if (req.getParameter("checkCookies") == null) {
                cookiesManager.addCookie(res, "cookieTest", "cookieCheck");
                res.sendRedirect(url + "?checkCookies=1");

            } else {
                System.out.println("sad .. cookies is blocked");

                req.setAttribute("cookiesState", "cookiesBlocked");

                if(!(url.endsWith("login.jsp"))){
                    RequestDispatcher rd = request.getRequestDispatcher("login");
                    rd.forward(request, response);
                }
                else{
                    chain.doFilter(request, response);
                }
            }
        }
    }

    public void destroy() {

        System.out.println("Filter destroyed");
    }

}
