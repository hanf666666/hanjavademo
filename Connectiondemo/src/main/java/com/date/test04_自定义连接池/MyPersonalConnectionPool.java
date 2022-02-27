package com.date.test04_自定义连接池;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/23
 */
public class MyPersonalConnectionPool {

    /**
     * 用户名
     */
    private static String user;
    /**
     * 密码
     */
    private static String password;
    /**
     * 连接数据库的URL
     */
    private static String url;


    /**
     * 连接池
     * 规定最大连接数为3
     */
    private static LinkedList<Connection> pool;

    /**
     * 从属性文件中加载数据库驱动，初始化连接池
     */
    static{
        try {
            Properties properties = new Properties();
            pool = new LinkedList<Connection>();
            Class.forName("com.mysql.jdbc.Driver");
            ClassLoader classLoader = MyPersonalConnectionPool.class.getClassLoader();
            InputStream iStream = classLoader.getResourceAsStream("mysqlCongfig.properties");
            properties.load(iStream);
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            //创建三个连接对象（包装类对象）放到池子中
            for (int i = 0; i < 3; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                Connection connectionWrapper = new MyConnectionWapper(connection,pool);
                pool.add(connectionWrapper);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * @throws SQLException
     * @method 向外提供连接对象
     */
    public Connection getConnection() throws SQLException {

        Connection connection;
        if(pool.size()>0)
        {
            connection = pool.removeFirst();
        }
        else
        {
            //等待超时，返回一个新创建的对象
            connection = DriverManager.getConnection(url, user, password);
        }
        System.out.println("当前池子中有  "+pool.size()+" 个对象");
        return connection;
    }

    /**
     * 归还连接对象
     * 直接简化在包装类的close方法中
     */
}
