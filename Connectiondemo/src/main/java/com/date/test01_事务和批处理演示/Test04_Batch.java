package com.date.test01_�������������ʾ;

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
            ����:
                1. ��users�������2������.
                2. ��users����idΪ1������ɾ��.
                3.��account�������3������.
                4.��account����idΪ2��Ǯ��Ϊ: 50000
         */
        Connection conn = null;
        PreparedStatement insertPreparedStatement = null;
        PreparedStatement deletePreparedStatement = null;

        try {
            //1. ��ȡ���Ӷ���.
            conn = JDBCUtils.getConnection();
            deletePreparedStatement = conn.prepareStatement("DELETE FROM USER WHERE id=?;");
            deletePreparedStatement.setString(1,"2");
            deletePreparedStatement.addBatch();
            deletePreparedStatement.setString(1,"3");
            deletePreparedStatement.addBatch();
            int[] arr = deletePreparedStatement.executeBatch();

            //2. ��ȡ����ִ��SQL���Ķ���.
            insertPreparedStatement = conn.prepareStatement("INSERT INTO `test`.`user`(`id`,`username`,`password`)VALUES(?,?,?);");
            insertPreparedStatement.setString(1,"2");
            insertPreparedStatement.setString(2,"��");
            insertPreparedStatement.setString(3,"123456");
            insertPreparedStatement.addBatch();
            insertPreparedStatement.setString(1,"3");
            insertPreparedStatement.setString(2,"��");
            insertPreparedStatement.setString(3,"123456");
            insertPreparedStatement.addBatch();


            int[] arr2 = insertPreparedStatement.executeBatch();

            int[] arr3 = insertPreparedStatement.executeBatch();





            //���������(��ѡ)
            insertPreparedStatement.clearBatch();

            //5. ���������.
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(arr2));
            System.out.println(Arrays.toString(arr3));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. �ͷ���Դ.
            JDBCUtils.release(conn,insertPreparedStatement);
            JDBCUtils.release(conn,deletePreparedStatement);
        }
    }
}
