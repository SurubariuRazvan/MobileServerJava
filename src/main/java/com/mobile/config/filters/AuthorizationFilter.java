package com.mobile.config.filters;

import com.mobile.config.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    public AuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConstants.AUTHORIZATION_HEADER);

        if (header == null) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = authenticate(request, response);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request, HttpServletResponse resp) {
        String token = request.getHeader(SecurityConstants.AUTHORIZATION_HEADER);
        if (token != null) {
            try {
                Claims user = Jwts.parser()
                        .setSigningKey(Keys.hmacShaKeyFor(SecurityConstants.KEY.getBytes()))
                        .parseClaimsJws(token)
                        .getBody();


                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, AuthorityUtils.createAuthorityList(((ArrayList<String>) user.get("authorities")).toArray(String[]::new)));
                } else {
                    return null;
                }
            } catch (JwtException jwtException) {
                resp.setStatus(403);
            }

        }
        return null;
    }
}
