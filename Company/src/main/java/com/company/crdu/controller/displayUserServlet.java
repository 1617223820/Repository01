package com.company.crdu.controller;



import com.company.crdu.dao.UserDaoImp;
import com.company.crdu.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//查询单个用户的控制层
@WebServlet(name = "displayUserServlet", value = "/displayuserservlet")
public class displayUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));

        UserDaoImp userDaoImp=new UserDaoImp();
        User user = userDaoImp.displayUser(id);
        HttpSession session = request.getSession();
        synchronized (session){
            session.setAttribute("user",user);
        }
        if(user==null){
            request.setAttribute("error","id不存在，查询不到信息！");
            request.getRequestDispatcher("displayUser.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/displaysuccess.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
