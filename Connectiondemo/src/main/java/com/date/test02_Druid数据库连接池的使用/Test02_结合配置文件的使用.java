package com.date.test02_Druid数据库连接池的使用;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.date.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Test02_结合配置文件的使用 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. 获取连接对象.
            //这里的连接对象是我们自己创建的, 用完就"销毁"了,
            //conn = JDBCUtils.getConnection();
            //改为: 从数据库连接池获取.
            Properties pp = new Properties();
            pp.load(new FileReader("src/main/resources/druid.properties"));

            //A: 创建数据库连接池对象
            //多态
            DataSource ds = DruidDataSourceFactory.createDataSource(pp);
            //B: 设置数据库连接池的参数信息, (工厂类DruidDataSourceFactory会自动读取: .properties中的配置信息)

            //C: 从数据库连接池中获取连接对象.
            conn = ds.getConnection();

            //2. 获取可以执行SQL语句的对象.
            stat = conn.createStatement();
            //4. 执行SQL语句, 获取结果集.
            for (int i = 0; i < 1000000; i++) {
                String sql="INSERT INTO test20210707.order_park_order SELECT * FROM meisoodev.order_park_order ORDER BY id LIMIT "+(10000+i)+",1";
                System.out.println(sql);
                stat.execute(sql);

                Thread.sleep(10000);

            }

//            String sql = "select * from account;";
//            rs = stat.executeQuery(sql);
//            //5. 操作结果集.
//            while(rs.next()) {
//                System.out.println(rs.getInt("aid") + "..." + rs.getString("aname") + "..." + rs.getInt("money"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6. 释放资源.
            JDBCUtils.release(conn,stat,rs);
            /*
                如果是自己创建的连接对象, conn.close()是 销毁
                如果是从数据库连接池拿的连接对象, conn.close()是 自动归还.
             */
        }
    }
}
