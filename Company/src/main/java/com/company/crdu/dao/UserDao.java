package com.company.crdu.dao;



import com.company.crdu.model.User;

import java.util.List;

public interface UserDao {
    //定义CRUD方法的接口
    public int addUser(User user);//增
    public int deleteUser(int id);//删
    public int updateUser(User user);//改
    public User displayUser(int id);//查
    public List<User> findAll();//查询所有信息
    public int findTotalCount();//查询总记录数
    public List<User> findInPage(int start, int rows);//查询每一页的数据
}
