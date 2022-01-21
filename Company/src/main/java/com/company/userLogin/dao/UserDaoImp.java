package com.company.userLogin.dao;


import com.company.userLogin.model.UserLogin;
import com.company.util.Druid_Tool;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class UserDaoImp implements UserDao{
    private JdbcTemplate template=new JdbcTemplate(Druid_Tool.getDataSource());
    @Override
    public UserLogin userLogin(String username,String password) {
        try {
            String sql="select * from user where username=? and password=?";
            UserLogin realUser = template.queryForObject(sql, new BeanPropertyRowMapper<UserLogin>(UserLogin.class),username,password);
            return realUser;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }catch (IncorrectResultSizeDataAccessException e1){
            return null;
        }
    }

    @Override
    public int UserUpdate(UserLogin userLogin) {
        String sql="update user set name = ?,age = ?,sex = ?,email = ?,username= ?,password= ? where id = ?";
        int num = template.update(sql, userLogin.getName(), userLogin.getAge(), userLogin.getSex(), userLogin.getEmail(), userLogin.getUsername(), userLogin.getPassword(), userLogin.getId());
        return num;
    }

    @Override
    public int Register(String username, String password,int id) {
        int num;
        try {
            String sql="update user set username = ?,password = ? where id = ?";
            num = template.update(sql, username, password,id);
            return num;
        } catch (Exception e){
            return 0;
        }

    }
}
