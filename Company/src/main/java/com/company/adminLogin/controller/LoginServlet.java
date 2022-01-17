package com.company.adminLogin.controller;

import com.company.adminLogin.model.Login;
import com.company.adminLogin.service.LoginService;
import com.company.adminLogin.service.LoginServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password = request.getParameter("password");
        Login login =new Login(username,password);
        LoginService loginService=new LoginServiceImp();
        Login real_login = loginService.Login(login);

        String check = request.getParameter("check");
        String savecode=(String) request.getSession().getAttribute("checkcode");//服务器端取出验证码
        if (!check.equalsIgnoreCase(savecode)){
            request.setAttribute("checkerror","验证码错误请重新输入");
            request.getRequestDispatcher("adminLogin.jsp").forward(request,response);
        }else if(real_login==null){
            request.setAttribute("error","用户名或密码错误请重新输入");
            request.getRequestDispatcher("adminLogin.jsp").forward(request,response);
        }else {
            request.getSession().setAttribute("real_login",real_login);
            request.getRequestDispatcher("ManageUser.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
