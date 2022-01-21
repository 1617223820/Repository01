package com.company.userLogin.service;

import com.company.userLogin.dao.UserDao;
import com.company.userLogin.dao.UserDaoImp;
import com.company.userLogin.model.UserLogin;

public class UserServiceImp implements UserService{
    @Override
    public UserLogin userLogin(String username,String password) {
        UserDao userDao=new UserDaoImp();
        UserLogin realUser = userDao.userLogin(username,password);
        return realUser;
    }

    @Override
    public int UserUpdate(UserLogin userLogin) {
        UserDao userDao=new UserDaoImp();
        int i = userDao.UserUpdate(userLogin);
        return i;
    }

    @Override
    public int Register(String username, String password,int id) {
        UserDao userDao=new UserDaoImp();
        int num = userDao.Register(username, password,id);
        return num;
    }

}
