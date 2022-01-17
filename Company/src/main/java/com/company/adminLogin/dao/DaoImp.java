package com.company.adminLogin.dao;

import com.company.adminLogin.model.Login;
import com.company.crdu.util.Druid_Tool;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DaoImp implements Dao{
    private JdbcTemplate template=new JdbcTemplate(Druid_Tool.getDataSource());
    @Override
    public Login Login(Login adminlogin) {
        try {
            String sql="select * from admin where username=? and password=?";
            Login real_login = template.queryForObject(sql, new BeanPropertyRowMapper<Login>(Login.class),
                    adminlogin.getUsername(), adminlogin.getPassword());
            return real_login;
        } catch (DataAccessException e) {//处理查询不到的异常，查询不到返回null
            e.printStackTrace();
            return null;
        }
    }
}
