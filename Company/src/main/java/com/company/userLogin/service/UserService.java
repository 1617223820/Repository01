package com.company.userLogin.service;

import com.company.userLogin.model.UserLogin;

public interface UserService {
    public UserLogin userLogin(String username,String password);//登录操作返回所有信息
    public int UserUpdate(UserLogin userLogin);//修改信息
    public int Register(String username,String password,int id);//注册
}
