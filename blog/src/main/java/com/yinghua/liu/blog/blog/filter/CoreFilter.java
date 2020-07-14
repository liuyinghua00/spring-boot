package com.yinghua.liu.blog.blog.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Component
public class CoreFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println("MyFilter the Controller url:"+request.getRequestURI());
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器注销");
    }
}
