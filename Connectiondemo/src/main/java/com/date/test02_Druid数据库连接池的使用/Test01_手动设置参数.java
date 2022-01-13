package com.date.test02_Druid数据库连接池的使用;

import com.alibaba.druid.pool.DruidDataSource;
import com.date.utils.JDBCUtils;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接池(DBCP)的作用是: 把连接对象从"销毁"变为"自动归还".
 */
public class Test01_手动设置参数 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. 获取连接对象.
            //这个连接对象是我们自己创建的, 用完就"销毁"了.
            //conn = JDBCUtils.getConnection();

            //改为: 从数据库连接池获取连接对象, 用完之后, 会自动归还到"数据库连接池"中
            //A: 创建数据库连接池.
            DruidDataSource dds = new DruidDataSource();
            dds.setInitialSize(10);
            dds.setMaxIdle(1);
            dds.setMaxActive(2000);
//            dds.ser(2000);
            System.out.println("1==========================="+dds);
            //多态
            //DataSource dds2 = new DruidDataSource();

            //B: 设置数据库连接池的参数信息
            //必要参数
            dds.setDriver(new Driver());
            dds.setUrl("jdbc:mysql:///connectiondemo");
            dds.setUsername("root");
            dds.setPassword("123456");

            //可选参数

            //C: 从数据库连接池中获取连接对象.
            conn = dds.getConnection();
            Connection  conn2 = dds.getConnection();
            Connection  conn3 = dds.getConnection();
            Connection  conn4 = dds.getConnection();
            //2. 获取可以执行SQL语句的对象.
            stat = conn.createStatement();

            try {
                int i=0;
                while (true){
                    System.out.println(i+++"==========================="+dds);
                    Thread.sleep(5000);
                    conn3.close();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //4. 执行SQL语句, 获取结果集.
            String sql = "select * from account;";
            rs = stat.executeQuery(sql);
            //5. 操作结果集.
            while(rs.next()) {
                System.out.println(rs.getInt("aid") + "..."
                        + rs.getString("aname") + "..." +
                        rs.getInt("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. 释放资源.
            JDBCUtils.release(conn,stat,rs);
            /*
                小细节: 关于conn.close()
                    如果conn对象(连接对象)是我们自己创建的, 调用close()方法的时候, 是将连接对象"销毁"
                    如果conn对象(连接对象)是我们从数据库连接池获取的, 调用close()方法的时候, 是将连接对象"归还给数据库连接池"
             */
        }
    }
}
