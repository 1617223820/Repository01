package com.company.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//登录权限过滤器
@WebFilter(filterName = "Filter02",value = "/*")
public class Filter02 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        String requestURI = request.getRequestURI();//获取资源请求路径
        //判断是否包含登录相关资源路径
        if(requestURI.contains("/adminLogin.jsp")||requestURI.contains("/CheckServlet")|| requestURI.contains("/loginServlet")
                ||requestURI.contains("/MainMenu.jsp")||requestURI.contains("User/userLogin.jsp")||requestURI.contains("/userLoginServlet")
                ||requestURI.contains("User/Register.jsp")||requestURI.contains("/registerServlet")){
            chain.doFilter(req, resp);//包含就放行
        }else {
            //不包含，就验证用户是否登录
            Object real_login = request.getSession().getAttribute("real_login");
            Object realUser = request.getSession().getAttribute("realUser");
            if(real_login!=null||realUser!=null){
                chain.doFilter(req, resp);//登录了就放
            }else {
                request.setAttribute("loginerror","您未登录，登录才能进行相关操作");
                request.getRequestDispatcher("/MainMenu.jsp").forward(request,resp);
            }
        }

    }
}
