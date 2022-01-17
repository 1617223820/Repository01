package com.company.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//设置字符编码的过滤器
@WebFilter(filterName = "Filter01",value = "/*")
public class Filter01 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1=(HttpServletRequest) request;
        HttpServletResponse response1=(HttpServletResponse)response;
        request1.setCharacterEncoding("UTF-8");
        response1.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }
}
