package com.company.crdu.controller;



import com.company.crdu.dao.UserDao;
import com.company.crdu.dao.UserDaoImp;
import com.company.crdu.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//此servlet是完成显示所有信息的操作，但是没有分页功能。所以并未使用，由分页查询的控制层代替。
@WebServlet(name = "findAllServlet", value = "/findallservlet")
public class findAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao=new UserDaoImp();
        List<User> users = userDao.findAll();
        request.setAttribute("users",users);
        request.getRequestDispatcher("/displayFindAllUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
