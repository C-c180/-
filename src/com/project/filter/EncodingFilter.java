package com.project.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",value = "/*")
public class EncodingFilter implements Filter {
    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println("进入字符过滤");
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        if (!request.getRequestURI().contains(".")) {
            System.out.println(request.getRequestURI());
            request.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            servletResponse.setContentType("text/html;charset=utf-8");
        }
        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("从过滤器字符过滤器出去");
    }
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
