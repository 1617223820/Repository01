package com.company.crdu.controller;

import com.company.crdu.dao.UserDaoImp;
import com.company.crdu.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//作为回显功能的控制层，通过id号将查询到的信息传给updateUser.jsp
@WebServlet(name = "updateByIdServlet", value = "/updatebyidservlet")
public class updateByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDaoImp userDaoImp=new UserDaoImp();
        User user = userDaoImp.displayUser(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/updateUser.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
