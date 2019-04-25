package com.project.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "aloginFilter",value ={ "/servlet/*","/dataManagement/*","/disasterPrevent/*","/expertConsultation/*","/potionMechanicalOutboundManagement/*","/userManagement/*","/main.html"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (session.getAttribute(session.getId()) != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("111");
        }else{
            response.sendRedirect("login.html");
            System.out.println("222");
        }

    }

    @Override
    public void destroy() {

    }
}
