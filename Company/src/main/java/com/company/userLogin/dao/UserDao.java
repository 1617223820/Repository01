package com.company.userLogin.dao;


import com.company.userLogin.model.UserLogin;

public interface UserDao {
    public UserLogin userLogin(String username, String password);//查询登录
    public int UserUpdate(UserLogin userLogin);//修改信息
    public int Register(String username,String password,int id);//注册
}
