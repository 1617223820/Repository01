package com.company.adminLogin.service;

import com.company.adminLogin.dao.Dao;
import com.company.adminLogin.dao.DaoImp;
import com.company.adminLogin.model.Login;

public class LoginServiceImp implements LoginService{
    @Override
    public Login Login(Login adminlogin) {
        Dao dao=new DaoImp();
        Login real_login = dao.Login(adminlogin);
        return real_login;
    }
}
