package com.apri.test.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {
        System.out.println("gagal login...");
       String msgerror = e.getMessage();
        if (msgerror.equals("Bad credentials")) {
            msgerror = "User atau password tidak ditemukan";
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login?error=true&message=" + msgerror);
    }
}
