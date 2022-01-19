package com.date.test03_c3p0数据库连接池的使用;

import com.date.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test01_手动设置参数 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. 获取连接对象.
            //这里的连接对象是我们自己创建的
            //conn = JDBCUtils.getConnection();
            //改为: 从数据库连接池获取.
            //A: 创建数据库连接池
            ComboPooledDataSource cpds = new ComboPooledDataSource();

            //B: 设置参数.
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql:///web04");
            cpds.setUser("root");
            cpds.setPassword("123456");

            //C: 从数据库连接池获取连接对象
            conn = cpds.getConnection();

            //2. 获取可以执行SQL语句的对象.
            stat = conn.createStatement();
            //4. 执行SQL语句, 获取结果集.
            String sql = "select * from account;";
            rs = stat.executeQuery(sql);
            //5. 操作结果集.
            while(rs.next()) {
                System.out.println(rs.getInt("aid") + "..." + rs.getString("aname") + "..." + rs.getInt("money"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6. 释放资源.
            JDBCUtils.release(conn,stat,rs);
        }
    }
}
