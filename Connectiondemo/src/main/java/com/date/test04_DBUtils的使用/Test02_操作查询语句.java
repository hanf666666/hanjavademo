package com.date.test04_DBUtils的使用;

import com.date.domain.Users;
import com.date.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//1. 获取可以执行SQL语句的对象.
//2. 执行SQL语句, 获取结果集.
//3. 操作结果集
public class Test02_操作查询语句 {
    /*
        ArrayHandler:  把第一条数据封装到Object[]
     */
    @Test
    public void method1() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. 执行SQL语句, 获取结果集.
        String sql = "select * from users where uid = ? ;";
        try {
            Object[] arr = qr.query(sql, new ArrayHandler(), 6);
            //3. 操作结果集
            System.out.println(Arrays.toString(arr));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        ArrayListHandler:  把每一条数据封装到Object[], 整体放入: List<Object[]>
     */
    @Test
    public void method2() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. 执行SQL语句, 获取结果集.
        String sql = "select * from users ;";
        try {
            List<Object[]> list = qr.query(sql, new ArrayListHandler());
            //3. 操作结果集
            //iter: 增强for的快捷键
            for (Object[] obj : list) {
                System.out.println(Arrays.toString(obj));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     MapHandler:  把第一条数据封装到Map<String,Object>,  列名做键, 该列的值做值
   */
    @Test
    public void method3() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. 执行SQL语句, 获取结果集.
        String sql = "select * from users where uid = ? ;";
        try {
            Map<String, Object> map = qr.query(sql, new MapHandler(), 2);
            //3. 操作结果集
            System.out.println(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
       MapListHandler:  把每一条数据封装到Map, 整体放入: List<Map<String,Object>>
    */
    @Test
    public void method4() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. 执行SQL语句, 获取结果集.
        String sql = "select * from users ;";
        try {
            List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
            //3. 操作结果集
            for (Map<String, Object> map : list) {
                //接着遍历
                for (String key : map.keySet()) {
                    System.out.print(key + "..." + map.get(key) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
       BeanHandler:  把第一条数据封装成JavaBean对象.
     */
    @Test
    public void method5() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. 执行SQL语句, 获取结果集.
        String sql = "select * from users where uid = ? ;";
        try {
            // 类名.class:  可以获取该类的字节码文件对象.
            //qr.query(sql, new BeanHandler<Users>(Users.class));
            Users user = qr.query(sql, new BeanHandler<>(Users.class), 4);
            //3. 操作结果集
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
       BeanListHandler:  把每一条数据封装到JavaBean对象, 整体放入: List<JavaBean类>
     */
    @Test
    public void method6() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. 执行SQL语句, 获取结果集.
        String sql = "select * from users ;";
        try {
            List<Users> list = qr.query(sql, new BeanListHandler<>(Users.class));
            //3. 操作结果集
            for (Users users : list) {
                System.out.println(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     ScalarHandler:  用于做单值查询.
   */
    @Test
    public void method7() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. 执行SQL语句, 获取结果集.
        String sql = "select count(*) from users;";
        try {
            Object obj = qr.query(sql, new ScalarHandler());
            //3. 操作结果集
            System.out.println(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     ColumnListHandler:  用来查询某一列的数据
   */
    @Test
    public void method8() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. 执行SQL语句, 获取结果集.
        String sql = "select * from users;";
        try {
            //根据列名  获取该列的值.
//            List<Object> list = qr.query(new ColumnListHandler("password"), sql);
            List<Object> list = null;
            System.out.println(list);
            //3. 操作结果集
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     KeyedHandler:  把每一条数据封装到Map, 整体放入: Map<指定的列,<Map<String,Object>>
   */
    @Test
    public void method9() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. 执行SQL语句, 获取结果集.
        String sql = "select * from users;";
        try {
            //讲指定的列显示在该行的开头, 后边跟的是该行的信息.
//            Map<Object, Map<String, Object>> maps = qr.query(sql, new KeyedHandler("username"));
            Map<Object, Map<String, Object>> maps=null;
            //3. 操作结果集
            for (Object key : maps.keySet()) {
                Map<String, Object> value = maps.get(key);
                System.out.println(key + "..." + value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
