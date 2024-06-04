package edu.sylymonka.theater.config;/*
  @author   silim
  @project   theater
  @class  JwtAuthFilter
  @version  1.0.0 
  @since 03.06.2024 - 16.58
*/

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private UserAuthProvider userAuthProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            String [] elems = authHeader.split(" ");
            if (elems.length == 2 && elems[0].equals("Bearer")) {
                try{
                    SecurityContextHolder.getContext().setAuthentication(
                            userAuthProvider.validateToken(elems[1])
                    );
                }catch (RuntimeException e){
                    SecurityContextHolder.clearContext();
                    throw e;
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
