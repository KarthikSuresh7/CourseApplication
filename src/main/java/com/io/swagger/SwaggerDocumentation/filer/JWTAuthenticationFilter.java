package com.io.swagger.SwaggerDocumentation.filer;

import com.io.swagger.SwaggerDocumentation.Service.JwtService;
import com.io.swagger.SwaggerDocumentation.Service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class JWTAuthenticationFilter extends OncePerRequestFilter {


    private final JwtService jwtService;

    private  final UserDetailsServiceImpl userDetailsservice;

    public JWTAuthenticationFilter(JwtService jwtService, UserDetailsServiceImpl userDetailsservice) {
        this.jwtService = jwtService;
        this.userDetailsservice = userDetailsservice;
    }


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull  FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = authHeader.substring(7);
        String userName = jwtService.extractUserName(token);

        if(userName != null && SecurityContextHolder.getContext().getAuthentication()==null){

            UserDetails userDetails1 = userDetailsservice.loadUserByUsername(userName);
            if(jwtService.isValid(token,  userDetails1)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails1,null,userDetails1.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

    }
}
