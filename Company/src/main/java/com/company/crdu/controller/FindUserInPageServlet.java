package com.company.crdu.controller;



import com.company.crdu.model.PageBean;
import com.company.crdu.model.User;
import com.company.crdu.service.UserService;
import com.company.crdu.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//分页查询所有用户的控制层
@WebServlet(name = "FindUserInPageServlet", value = "/finduserinpageservlet")
public class FindUserInPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        if(rows==null||"".equals(rows)){
            rows="5";
        }//初始化
        UserService service=new UserServiceImp();
        PageBean<User> pb=service.findUserInPage(currentPage,rows);

        request.setAttribute("pb",pb);
        request.getRequestDispatcher("/displayFindAllUser.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
