package com.date.test01_事务和批处理演示;

import com.date.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * to do
 *Test01_JDBC的核心7步
 * @author Hj
 * @date 2022/1/19
 */
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
            String sql = "SELECT * FROM USER;";
            rs = stat.executeQuery(sql);
            //5. 操作结果集.
            while(rs.next()) {
                System.out.println(rs.getInt("id") + "..." + rs.getString("username") + "..." + rs.getInt("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. 释放资源.
            JDBCUtils.release(conn,stat,rs);
        }
    }
}
