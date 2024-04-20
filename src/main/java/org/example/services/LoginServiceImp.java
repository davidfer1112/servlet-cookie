package org.example.services;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;
import jakarta.servlet.http.Cookie;
import java.util.Arrays;

public class LoginServiceImp implements LoginService{

    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];

        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("username"))
                .map(Cookie::getValue)
                .findFirst();
    }

}
