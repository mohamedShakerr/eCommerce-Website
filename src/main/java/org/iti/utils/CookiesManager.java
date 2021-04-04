package org.iti.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.Optional;

public class CookiesManager {

    private static volatile CookiesManager cookiesInstance = null;

    private CookiesManager() {
        if (cookiesInstance != null)
            throw new RuntimeException();
    }

    public static CookiesManager getInstance() {
        if (cookiesInstance == null) {
            synchronized (CookiesManager.class) {
                if (cookiesInstance == null) {
                    cookiesInstance = new CookiesManager();
                }
            }
        }
        return cookiesInstance;
    }

    public void addCookie(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(7*24*60*60);
        response.addCookie(cookie);
    }


    public Cookie[] getCookies(HttpServletRequest request) {
        return request.getCookies();
    }

    public boolean isCookieExists(HttpServletRequest request, String key){

        Cookie[] cookies = getCookies(request);
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("after check : cookies is " + cookie.getName());
                if (cookie.getName().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public  String readCookie(HttpServletRequest request, String key){
        Optional<String> optionalS =  Arrays.stream(request.getCookies())
                .filter(c -> key.equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();

        return optionalS.orElse(null);
    }




}
