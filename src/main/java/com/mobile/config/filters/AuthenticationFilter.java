package com.mobile.config.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.config.SecurityConstants;
import com.mobile.domain.model.SecurityAccount;
import com.mobile.domain.model.dto.LoginDTO;
import com.mobile.webservices.exceptionHandlers.ErrorResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(@Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            String refreshHeader = req.getHeader(SecurityConstants.REFRESH_HEADER);
            if (refreshHeader != null) {
                return getAuthFromRefreshToken(req, res);
            }

            LoginDTO applicationUser = new ObjectMapper().readValue(req.getInputStream(), LoginDTO.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(applicationUser.getUsername(),
                                                            applicationUser.getPassword(), new ArrayList<>())
            );
        } catch (BadCredentialsException | UsernameNotFoundException ex) {
            setErrorResponse(HttpStatus.FORBIDDEN, res, ex);
            res.setStatus(403);
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private UsernamePasswordAuthenticationToken getAuthFromRefreshToken(HttpServletRequest request, HttpServletResponse resp) {
        String refreshToken = request.getHeader(SecurityConstants.REFRESH_HEADER);
        if (refreshToken != null) {
            try {
                Claims user = Jwts.parser()
                        .setSigningKey(Keys.hmacShaKeyFor(SecurityConstants.KEY.getBytes()))
                        .parseClaimsJws(refreshToken)
                        .getBody();

                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(new SecurityAccount(user.getSubject(), "", new ArrayList<>()), null,
                                                                   null);
                } else {
                    return null;
                }
            } catch (JwtException jwtException) {
                resp.setStatus(403);
            }
        }
        return null;
    }

    public void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex) {
        response.setStatus(status.value());
        response.setContentType("application/json");
        ErrorResponse apiError = new ErrorResponse(status.value(), ex.getMessage(), LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        try {
            response.getWriter().write(apiError.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) {
        Date accessExp = new Date(System.currentTimeMillis() + SecurityConstants.ACCESS_TOKEN_EXPIRATION_TIME);
        Date refreshExp = new Date(System.currentTimeMillis() + SecurityConstants.REFRESH_TOKEN_EXPIRATION_TIME);

        Key key = Keys.hmacShaKeyFor(SecurityConstants.KEY.getBytes());

        Claims claimsAccess = Jwts.claims().setSubject(((SecurityAccount) auth.getPrincipal()).getUsername());
        Claims claimsRefresh = Jwts.claims().setSubject(((SecurityAccount) auth.getPrincipal()).getUsername());
        claimsAccess.put("authorities", auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).toArray());

        String accessToken = Jwts.builder()
                .setClaims(claimsAccess)
                .signWith(SignatureAlgorithm.HS512, key)
                .setExpiration(accessExp)
                .compact();
        String refreshToken = Jwts.builder()
                .setClaims(claimsRefresh)
                .signWith(SignatureAlgorithm.HS512, key)
                .setExpiration(refreshExp)
                .compact();

        res.setHeader("accessToken", accessToken);
        res.setHeader("refreshToken", refreshToken);
    }
}
