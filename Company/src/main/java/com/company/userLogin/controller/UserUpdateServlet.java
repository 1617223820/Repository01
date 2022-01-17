package com.company.userLogin.controller;

import com.company.userLogin.model.UserLogin;
import com.company.userLogin.service.UserService;
import com.company.userLogin.service.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UserUpdateServlet", value = "/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserLogin userLogin=new UserLogin(id,name,age,sex,email,username,password);
        UserService userService=new UserServiceImp();
        int i = userService.UserUpdate(userLogin);
        if(i==0){
            request.setAttribute("error","id不存在，无法修改信息！");
            request.getRequestDispatcher("User/UpdateUser.jsp").forward(request,response);
        }else {
            request.setAttribute("success","修改成功！");
            request.getRequestDispatcher("User/UpdateSuccess.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
