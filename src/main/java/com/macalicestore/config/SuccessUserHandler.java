package com.macalicestore.config;

import jakarta.servlet.ServletException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("USER") && roles.contains("ADMIN")) {
            response.sendRedirect("/admin");
        } else if (roles.contains("ADMIN")) {
            response.sendRedirect("/admin");
        } else if (roles.contains("USER")) {
            response.sendRedirect("/user");
        }
    }
}