package com.javadevs.JavaDevs.filter;

import com.javadevs.JavaDevs.exception.ExpiredTokenException;
import com.javadevs.JavaDevs.exception.InvalidTokenException;
import com.javadevs.JavaDevs.service.TokenService;
import io.jsonwebtoken.Claims;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Component
@Order(1)
public class LoginFilter implements Filter  {

    private final TokenService tokenService;

    public LoginFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpServletRequest httpRequest = (HttpServletRequest)request;

        if (!httpRequest.getServletPath().startsWith("/api")) {
            chain.doFilter(request, response);
            return;
        }

        if (httpRequest.getServletPath().startsWith("/api/admin/signup")) {
            chain.doFilter(request, response);
            return;
        }

        if (httpRequest.getServletPath().startsWith("/api/actor/signup")) {
            chain.doFilter(request, response);
            return;
        }

        if (httpRequest.getServletPath().startsWith("/api/login")) {
            chain.doFilter(request, response);
            return;
        }

        Cookie token = WebUtils.getCookie(httpRequest, "token");
        if (token == null) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        try {
            String jwt = token.getValue();

            String bearerToken = jwt.replace("Bearer ", "");
            Claims claims = tokenService.decodedToken(bearerToken);

            Integer idUser = (Integer) claims.get("idUser");

            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();

            httpRequest.setAttribute("idUser", idUser);

            chain.doFilter(request, response);
        } catch (ExpiredTokenException et) {
            et.printStackTrace();
            throw new ExpiredTokenException();
        } catch (Exception e) {
            e.printStackTrace();
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
