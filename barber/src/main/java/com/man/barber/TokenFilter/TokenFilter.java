package com.man.barber.TokenFilter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.man.barber.service.TokenService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenFilter extends GenericFilterBean {
    private TokenService tokenService;
    public TokenFilter(TokenService service) {
        this.tokenService = service;
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorization = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(authorization)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!authorization.startsWith("Bearer ")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String token = authorization.substring(7);
        DecodedJWT decoded = tokenService.verify(token);

        if (decoded == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // user id
        Long principal = decoded.getClaim("principal").asLong();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal, "(protected)", null);
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(authentication);
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
