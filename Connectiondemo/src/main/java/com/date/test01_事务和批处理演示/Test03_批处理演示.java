package com.date.test01_事务和批处理演示;

import com.date.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Test03_批处理演示 {
    public static void main(String[] args) {
        /*
            需求:
                1. 往users表中添加2条数据.
                2. 把users表中id为1的数据删掉.
                3.往account表中添加3条数据.
                4.把account表中id为2的钱改为: 50000
         */
        Connection conn = null;
        Statement stat = null;

        try {
            //1. 获取连接对象.
            conn = JDBCUtils.getConnection();
            //2. 获取可以执行SQL语句的对象.
            stat = conn.createStatement();
            //4. 执行SQL语句, 获取结果集.
            String sql1 = "insert into users values(null,'admin03','pw333'),(null,'admin04','pw444');";
            String sql2 = "delete from users where uid = 1;";
            String sql3 = "insert into account values(null,'王五',20000),(null,'赵六',20000),(null,'田七',20000);";
            String sql4 = "update account set money=50001 where aid=2;";

           // String sql5 = "select * from account,users;";
            //方式一: 普通做法
            /*int num1 = stat.executeUpdate(sql1);
            int num2 = stat.executeUpdate(sql2);
            int num3 = stat.executeUpdate(sql3);
            int num4 = stat.executeUpdate(sql4);*/

            //方式二: 批处理.
            //把SQL语句添加到批处理
            stat.addBatch(sql1);
            stat.addBatch(sql2);
            stat.addBatch(sql3);
            stat.addBatch(sql4);
           // stat.addBatch(sql5);

            //执行批处理
            //数组记录的是: 批处理中各个SQL语句执行后返回的结果(受影响的行数)
            int[] arr = stat.executeBatch();

            //清空批处理(可选)
            stat.clearBatch();

            //5. 操作结果集.
            System.out.println(Arrays.toString(arr));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. 释放资源.
            JDBCUtils.release(conn,stat);
        }
    }
}
