package com.company.crdu.service;



import com.company.crdu.dao.UserDao;
import com.company.crdu.dao.UserDaoImp;
import com.company.crdu.model.PageBean;
import com.company.crdu.model.User;

import java.util.List;

public class UserServiceImp implements UserService{

    public PageBean<User> findUserInPage(String _currentPage, String _rows) {
        UserDao userDao=new UserDaoImp();
        int currentPage= Integer.parseInt(_currentPage);
        int rows= Integer.parseInt(_rows);

        if (currentPage<=0){
            currentPage=1;
        }//防止往第一页翻页还报错

        //设置两个参数
        PageBean<User> pb=new PageBean<User>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //调用UserDao查询总记录数和List集合
        int totalCount=userDao.findTotalCount();
        pb.setTotalCount(totalCount);

        int totalPage=(totalCount%rows)==0?totalCount/rows:(totalCount/rows)+1;
        pb.setTotalPage(totalPage);

        int start=(currentPage-1)*rows;//start为起始索引
        List<User>list=userDao.findInPage(start,rows);
        pb.setList(list);


        return pb;
    }
}
