package com.hackathon.ilac.auth;



import com.hackathon.ilac.error.CustomError;
import com.hackathon.ilac.error.ErrorConstans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TokenFilter extends OncePerRequestFilter {
    @Autowired
    private AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization=request.getHeader("Authorization");
        if (authorization!=null){
            try {
                String tokens=authorization.split(" ")[1];
                String type=tokens.split("/")[0];
                String token=tokens.split("/")[1];
                UserDetails userDetails=null;
                if (type.equals("USER")){
                    userDetails=authService.getUser(token);
                }else if(type.equals("PHARMACY")){
                    userDetails=authService.getPharmacy(token);
                }else if(type.equals("KBB")){
                    System.out.println(token);
                    userDetails=authService.getKomek(token);
                    System.out.println(userDetails.getUsername());
                }else{
                    //ERROR
                    throw new CustomError(ErrorConstans.LOGIN);
                }
                UsernamePasswordAuthenticationToken authentication=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }catch (CustomError exception){
                System.out.println("--------->");
            }
        }
        filterChain.doFilter(request,response);

    }

}
