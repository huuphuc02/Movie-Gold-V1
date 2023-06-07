package dev.phc.movies.config;

import dev.phc.movies.model.User;
import dev.phc.movies.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private UserService userService;
    private JWTTokenHelper jwtTokenHelper;
    public JWTAuthenticationFilter(UserService userService, JWTTokenHelper jwtTokenHelper){
        this.userService = userService;
        this.jwtTokenHelper = jwtTokenHelper;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authToken = jwtTokenHelper.getToken(httpServletRequest);

        if(null != authToken){
            String username = jwtTokenHelper.getUsernameFromToken(authToken);

            if(username != null){
                UserDetails user =  userService.loadUserByUsername(username);
                if(jwtTokenHelper.validateToken(authToken, user)){
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetails(httpServletRequest));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
