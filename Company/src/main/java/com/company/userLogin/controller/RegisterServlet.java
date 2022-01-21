package com.company.userLogin.controller;

import com.company.userLogin.service.UserService;
import com.company.userLogin.service.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int id = Integer.parseInt(request.getParameter("id"));
        UserService userService=new UserServiceImp();
        int num = userService.Register(username, password,id);
        if(num!=0){
            request.setAttribute("error","注册失败，此ID已有账号");
            request.getRequestDispatcher("User/Register.jsp");
        }else {
            request.setAttribute("success","注册成功！");
            request.getRequestDispatcher("User/Register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
