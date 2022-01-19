package com.date.test01_事务和批处理演示;

import com.date.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/19
 */
public class Test04_Batch {
    public static void main(String[] args) {
        /*
            需求:
                1. 往users表中添加2条数据.
                2. 把users表中id为1的数据删掉.
                3.往account表中添加3条数据.
                4.把account表中id为2的钱改为: 50000
         */
        Connection conn = null;
        PreparedStatement insertPreparedStatement = null;
        PreparedStatement deletePreparedStatement = null;

        try {
            //1. 获取连接对象.
            conn = JDBCUtils.getConnection();
            deletePreparedStatement = conn.prepareStatement("DELETE FROM USER WHERE id=?;");
            deletePreparedStatement.setString(1,"2");
            deletePreparedStatement.addBatch();
            deletePreparedStatement.setString(1,"3");
            deletePreparedStatement.addBatch();
            int[] arr = deletePreparedStatement.executeBatch();

            //2. 获取可以执行SQL语句的对象.
            insertPreparedStatement = conn.prepareStatement("INSERT INTO `test`.`user`(`id`,`username`,`password`)VALUES(?,?,?);");
            insertPreparedStatement.setString(1,"2");
            insertPreparedStatement.setString(2,"静");
            insertPreparedStatement.setString(3,"123456");
            insertPreparedStatement.addBatch();
            insertPreparedStatement.setString(1,"3");
            insertPreparedStatement.setString(2,"静");
            insertPreparedStatement.setString(3,"123456");
            insertPreparedStatement.addBatch();


            int[] arr2 = insertPreparedStatement.executeBatch();

            int[] arr3 = insertPreparedStatement.executeBatch();





            //清空批处理(可选)
            insertPreparedStatement.clearBatch();

            //5. 操作结果集.
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(arr2));
            System.out.println(Arrays.toString(arr3));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. 释放资源.
            JDBCUtils.release(conn,insertPreparedStatement);
            JDBCUtils.release(conn,deletePreparedStatement);
        }
    }
}
