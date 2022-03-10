package com.date.test01_事务和批处理演示;

import com.date.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * to do
 * Test03_批处理演示
 *
 * @author Hj
 * @date 2022/1/19
 */
public class Test03_批处理演示2 {
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
            String sql1 = "insert into s_user values";
            String valuesql = "";
            for (int i = 30000000; i < 1000000000; i++) {
                valuesql += "(" + i + ",3,1),";
                if (i % 50000 == 0) {
                    valuesql = valuesql.substring(0, valuesql.length() - 1);
                    final String s = sql1 + valuesql;
//                    System.out.println(s);
                    stat.execute(s);
                    valuesql="";
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6. 释放资源.
            JDBCUtils.release(conn, stat);
        }
    }
}
