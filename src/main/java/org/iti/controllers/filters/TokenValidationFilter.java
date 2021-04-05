package org.iti.controllers.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iti.services.LoginService;
import org.iti.utils.CookiesManager;

import java.io.IOException;

public class TokenValidationFilter implements Filter {

    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        var  httpRequest= (HttpServletRequest) request;
        var  httpResponse= (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        LoginService loginService = new LoginService();

        System.out.println("===========? FILTER STARTED");

        CookiesManager cookiesManager = CookiesManager.getInstance();

        System.out.println("PRINTING COOKIES =>");
        System.out.println(cookiesManager.readCookie(httpRequest,"UID"));
        System.out.println(cookiesManager.readCookie(httpRequest,"UID"));

        //If These Cookies exist it means the user has his remembr me true.
        if( cookiesManager.isCookieExists(httpRequest,"UID")
                &&
            cookiesManager.isCookieExists(httpRequest,"TOKEN")
                &&
            !(cookiesManager.readCookie(httpRequest,"UID").equals(""))
                &&
            !(cookiesManager.readCookie(httpRequest,"UID").equals("")) ) {
            System.out.println("COOKIES EXIST AND OR OKAY");

            //Check if the user is already Logged in, if not we validate token and Log them
            Integer userId = (Integer) session.getAttribute("userId");
            System.out.println("USER ID FROM SESISON" + userId);

            //Get Cookie Values
            String uid = cookiesManager.readCookie(httpRequest, "UID");
            String token = cookiesManager.readCookie(httpRequest, "TOKEN");
            int cookieUID = 0;

            //Check Validity of UID, it should be numbers only
            //If Not UID is not valid
            if (  !uid.matches("[0-9]+") ){
                //UID not a valid number, invalidate Cookies and continue
                //to website normally
                //TODO IMPLEMENT HOW TO RETRIEVE FROM THIS
//                invalidateLoginCookies(httpResponse);
            }else {
                cookieUID = Integer.parseInt(uid);

            }

            //User is not logged in
            if( userId == null ){
                System.out.println("USER NOT LOGGED IN ");

                //Validate Tokens if validation passes, Log Them In
                //Will Also return false if user doesnot exist
                boolean isTokenValid =  loginService.validateToken(token, cookieUID);

                //If token is valid, and the user hasnot signed in beofre we sign him in
                if(isTokenValid){
                    //Cookies are valid, Sign the user IN
                    //Also Put the cookie TOKEN in the session so we wont hit DB with each request
                    System.out.println("USER NOT LOGGED IN...TOKEIN VALID ");
                    //Set ID From Cookie
                    session.setAttribute("userId", cookieUID);
                    //Put TOKEN in cookie as well
                    session.setAttribute("TOKEN", token);
                    String userMail = loginService.getUserMailFromId(cookieUID);
                    boolean isUserAdmin = loginService.isUserAdminstrator(userMail);
                    session.setAttribute("isUserAdmin",isUserAdmin);

                }else {
                    //The Cookies are not valid so we invalidate Them
                    System.out.println("USER NOT LOGGED IN  LTOKEN INVALID");
//                    invalidateLoginCookies(httpResponse);
                }


            }
            //User is already logged In
            //Check validity of cookie token against cookie token in session
            else {
                System.out.println("USER AREADY LOGGED IN ");

                String sessionToken = (String) session.getAttribute("TOKEN");
                int sessionUserId = (int) session.getAttribute("userId");
                //Check if both IDs match
                //Also Check if Tokens Match
                if( (cookieUID == sessionUserId) && token.equals(sessionToken) ) {
                    //If They Mactch it's OK
                    System.out.println("USER AREADY LOGGED IN  THE MATCH");
                }
                else {
                    //IF they donot match, there has ben an attempt at teampering them
                    //Invalidate Cookies + Invalidate Session, And send User to sign in Again
//                    invalidateLoginCookies(httpResponse);
                    System.out.println("USER AREADY LOGGED IN INVALID THO ");

                }

            }
        }else {
            System.out.println("COOKIES DONOT EXIST YA SA7BYY");
        }

        chain.doFilter(request, response);

    }

    public void destroy() {

    }

    private  void invalidateLoginCookies(HttpServletResponse response){

        Cookie UIDCookie = new Cookie("UID", "");
        Cookie TOKENCookie = new Cookie("TOKEN", "");

        UIDCookie.setMaxAge(-1);
        TOKENCookie.setMaxAge(-1);

        response.addCookie(UIDCookie);
        response.addCookie(TOKENCookie);

    }

}

