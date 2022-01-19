package com.date.test01_事务和批处理演示;

import com.date.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * to do
 *Test02_事务演示
 * @author Hj
 * @date 2022/1/19
 */
public class Test02_事务演示 {
    public static void main(String[] args) {
        //案例: 张三 给 李四 转1000
        Connection conn = null;
        Statement stat = null;

        try {
            //1. 获取连接对象.
            conn = JDBCUtils.getConnection();
            //2. 获取可以执行SQL语句的对象.
            stat = conn.createStatement();
            //4. 执行SQL语句, 获取结果集.
            //张三 - 1000
            String sql1 = "update account set money = money - 1000 where aid = 1;";
            //李四 + 1000
            String sql2 = "update account set money = money + 1000 where aid = 2;";

            //开启事务(关闭事务的自动提交功能, 因为MySQL默认开启了事务的自动提交功能)
            conn.setAutoCommit(false);
            //执行SQL1
            int num1 = stat.executeUpdate(sql1);

            System.out.println(1/0);

            //执行SQL2
            int num2 = stat.executeUpdate(sql2);
            //5. 操作结果集.
            if (num1 == num2 && num1 == 1) {
                conn.commit();
                System.out.println("转账成功");
            } else {
                conn.rollback();
                System.out.println("转账失败");
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("转账失败");
            e.printStackTrace();
        }finally {
            //6. 释放资源.
            JDBCUtils.release(conn,stat);
        }
    }
}
