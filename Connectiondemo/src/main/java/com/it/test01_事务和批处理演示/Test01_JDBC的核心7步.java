package com.it.test01_事务和批处理演示;

import com.it.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01_JDBC的核心7步 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. 获取连接对象.
            conn = JDBCUtils.getConnection();
            //2. 获取可以执行SQL语句的对象.
            stat = conn.createStatement();
            //4. 执行SQL语句, 获取结果集.
            String sql = "select * from account;";
            rs = stat.executeQuery(sql);
            //5. 操作结果集.
            while(rs.next()) {
                System.out.println(rs.getInt("aid") + "..." + rs.getString("aname") + "..." + rs.getInt("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. 释放资源.
            JDBCUtils.release(conn,stat,rs);
        }
    }
}
