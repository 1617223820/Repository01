package com.company.crdu.controller;



import com.company.crdu.dao.UserDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//删除用户信息的控制层
@WebServlet(name = "deleteUserServlet", value = "/deleteuserservlet")
public class deleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));

        UserDaoImp userDaoImp=new UserDaoImp();
        int i = userDaoImp.deleteUser(id);
        if(i==0)
        {
            request.setAttribute("erroid","id不存在！删除失败！");
            request.getRequestDispatcher("deleteUser.jsp").forward(request,response);
        }else
        request.getRequestDispatcher("/deletesuccess.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
