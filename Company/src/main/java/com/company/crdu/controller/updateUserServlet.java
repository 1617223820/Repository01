package com.company.crdu.controller;


import com.company.crdu.dao.UserDaoImp;
import com.company.crdu.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//修改用户信息的控制层
@WebServlet(name = "updateUserServlet", value = "/updateuserservlet")
public class updateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");

        User user=new User(id,name,age,sex,email);
        UserDaoImp userDaoImp=new UserDaoImp();
        int num = userDaoImp.updateUser(user);
        if(num==0){
            request.setAttribute("erroid","id不存在，无法修改信息！");
            request.getRequestDispatcher("updateUser.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/updatesuccess.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
