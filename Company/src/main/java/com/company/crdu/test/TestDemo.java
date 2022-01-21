package com.company.crdu.test;


import com.company.crdu.model.User;
import com.company.crdu.util.Druid_Tool;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class TestDemo {

    private JdbcTemplate template=new JdbcTemplate(Druid_Tool.getDataSource());

    public void test1(){
        String sql="select * from users where id=?";
        User user=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),110);
        System.out.println(user);
    }
}
