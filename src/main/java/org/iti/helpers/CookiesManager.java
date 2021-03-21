package org.iti.helpers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.Optional;

public class CookiesManager {

    private static volatile CookiesManager instance = null;
    private static final String defaultKey = "e-mail";

    private CookiesManager() {
        if (instance != null)
            throw new RuntimeException();
    }

    public static CookiesManager getInstance() {
        if (instance == null) {
            synchronized (CookiesManager.class) {
                if (instance == null) {
                    instance = new CookiesManager();
                }
            }
        }
        return instance;
    }

    public void writeCookie(HttpServletResponse response,String key, String value) {
        Cookie cookie = new Cookie(key, value);
        response.addCookie(cookie);
    }


    public Cookie[] getCookies(HttpServletRequest request) {
        return request.getCookies();
    }


    // generalize
    public Optional<String> readCookie(HttpServletRequest request) {
        if (request.getCookies() != null) {
            return Arrays.stream(request.getCookies())
                    .filter(c -> defaultKey.equals(c.getName()))
                    .map(Cookie::getValue)
                    .findAny();
        }
        else {
            return Optional.empty();
        }
    }

}
