package com.company.crdu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Druid_Tool {
    //1.定义成员变量 DataSource
    private static DataSource dataSource = null;

    static {
        try {
            //1.加载配置文件
            Properties p = new Properties();
            p.load(Druid_Tool.class.getClassLoader().getResourceAsStream("druid.properties"));//流的形式加载文件
            //2.获取DataSource
            DruidDataSourceFactory druidDataSourceFactory = new DruidDataSourceFactory();
            dataSource = druidDataSourceFactory.createDataSource(p);
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //释放资源
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        // 代码的严谨性
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();//归还连接
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取连接池方法
    public static DataSource getDataSource(){
        return dataSource;
    }
}
