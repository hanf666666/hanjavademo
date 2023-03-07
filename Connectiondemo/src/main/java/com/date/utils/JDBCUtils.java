package com.date.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //1. 构造方法私有
    private JDBCUtils() {
    }

    //2. 定义变量,记录配置文件的信息
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    //3. 定义方法, 读取配置文件.
    public static void readConfig() {
        FileInputStream fileInputStream = null;
        Properties pp = new Properties();
        try {
            fileInputStream = new FileInputStream("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\Connectiondemo\\src\\splicingSqlmain\\resources\\config.properties");
            pp.load(fileInputStream);
            driverClass = pp.getProperty("driverClass");
            url = pp.getProperty("url");
            username = pp.getProperty("username");
            password = pp.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //4. 调用方法, 还要注册驱动
    static {
        readConfig();
        //注册驱动
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //5. 对外提供公共的访问方式, 用于获取连接对象
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
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
