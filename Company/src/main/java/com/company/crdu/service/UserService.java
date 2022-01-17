package com.company.crdu.service;


import com.company.crdu.model.PageBean;
import com.company.crdu.model.User;

public interface UserService {
    PageBean<User> findUserInPage(String currentPage, String rows);//分页查询
}
