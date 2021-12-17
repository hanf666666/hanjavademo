package com.it.test02_Druid数据库连接池的使用;

import com.it.utils.DruidUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test03_抽取工具类 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. 获取连接对象.
            //这里的连接对象是我们自己手动创建的.
            //conn = JDBCUtils.getConnection();
            //改为从: 数据库连接池中获取

            //创建数据库连接池
            //DataSource ds = DruidUtils.getDataSource();
            //conn = ds.getConnection();

            //上述的两行代码可以优化为下边的一行代码.
            conn = DruidUtils.getConnection();


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
            DruidUtils.release(conn,stat,rs);

            /*
                如果是自己创建的连接对象, 这里是: 销毁
                如果是从数据库连接池获取的对象, 这里是: 自动归还.
             */
        }
    }
}
