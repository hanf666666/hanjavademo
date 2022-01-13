package com.date.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 操作Druid数据库连接池的 工具类
 */
public class DruidUtils {
    //1. 构造私有.
    private DruidUtils() {}

    //2. 定义变量, 记录数据库连接池对象.
    private static DataSource ds;

    //3. 在静态代码块中, 对数据库连接池对象进行初始化操作.
    static {
        Properties pp = new Properties();
        try {
            //获取配置文件的信息
            pp.load(new FileReader("day04_classDemo\\src\\druid.properties"));
            // 对数据库连接池对象进行初始化操作.
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //4. 对外提供方法, 用来获取连接池对象.
    public static DataSource getDataSource() {
        return ds;
    }

    //5. 对外提供丰富, 用来获取连接对象.     该连接对象是直接从数据库连接池中获取的.
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //6. 释放资源
    public static void release(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                    stat = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                        conn = null;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void release(Connection conn, Statement stat) {
        try {
            if (stat != null) {
                stat.close();
                stat = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
