package com.company.crdu.dao;


import com.company.crdu.model.User;
import com.company.crdu.util.Druid_Tool;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoImp implements UserDao{
    //调用template对象
    private JdbcTemplate template=new JdbcTemplate(Druid_Tool.getDataSource());


    public int findTotalCount() {
        String sql="select count(*) from users";
        Integer count = template.queryForObject(sql, Integer.class);
        return count;
    }


    public List<User> findInPage(int start, int rows) {
        String sql="select * from users limit ?,?";
        List<User> user = template.query(sql, new BeanPropertyRowMapper<User>(User.class), start, rows);
        return user;
    }

    public int addUser(User user){
        String sql="insert into users(id,name,age,sex,email) value(?,?,?,?,?);";
        int num=0;
        try{
            num=template.update(sql,user.getId(),user.getName(),user.getAge(),user.getSex(), user.getEmail());
        }catch (DuplicateKeyException e){
            return 0;
        }
        return num;
    }

    public int deleteUser(int id){
        String sql="delete from users where id=?";
        int count=template.update(sql,id);
        return count;
    }

    public int updateUser(User user){
        String sql="update users set name = ?,age = ?,sex = ?,email = ? where id = ?";
        int num=template.update(sql,user.getName(),user.getAge(),user.getSex(), user.getEmail(),user.getId());
        return num;
    }

    public User displayUser(int id){
        String sql="select * from users where id=?";
        User user = null;
        try {
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return user;
    }

    public List<User> findAll() {
        String sql="select * from users";
        List<User> user = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return user;
    }

}
