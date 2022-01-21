package com.company.userLogin.controller;

import com.company.adminLogin.model.Login;
import com.company.adminLogin.service.LoginService;
import com.company.adminLogin.service.LoginServiceImp;
import com.company.userLogin.model.UserLogin;
import com.company.userLogin.service.UserService;
import com.company.userLogin.service.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password = request.getParameter("password");
        UserLogin userLogin=new UserLogin();
        userLogin.setUsername(username);
        userLogin.setPassword(password);
        UserService userService=new UserServiceImp();
        UserLogin realUser = userService.userLogin(userLogin.getUsername(),userLogin.getPassword());

        String check = request.getParameter("check");
        String savecode=(String) request.getSession().getAttribute("checkcode");//服务器端取出验证码
        if (!check.equalsIgnoreCase(savecode)){
            request.setAttribute("checkerror","验证码错误请重新输入");
            request.getRequestDispatcher("User/userLogin.jsp").forward(request,response);
        }else if(realUser==null){
            request.setAttribute("error","用户名或密码错误请重新输入，如果您没有账号请注册！");
            request.getRequestDispatcher("User/userLogin.jsp").forward(request,response);
        }else {
            request.getSession().setAttribute("realUser",realUser);
            request.getRequestDispatcher("User/UserMenu.jsp").forward(request,response);
            request.getRequestDispatcher("User/Update.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
