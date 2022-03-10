package com.date.test01_�������������ʾ;

import com.date.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * to do
 * Test03_��������ʾ
 *
 * @author Hj
 * @date 2022/1/19
 */
public class Test03_��������ʾ2 {
    public static void main(String[] args) {
        /*
            ����:
                1. ��users�������2������.
                2. ��users����idΪ1������ɾ��.
                3.��account�������3������.
                4.��account����idΪ2��Ǯ��Ϊ: 50000
         */
        Connection conn = null;
        Statement stat = null;

        try {
            //1. ��ȡ���Ӷ���.
            conn = JDBCUtils.getConnection();
            //2. ��ȡ����ִ��SQL���Ķ���.
            stat = conn.createStatement();
            //4. ִ��SQL���, ��ȡ�����.
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
            //6. �ͷ���Դ.
            JDBCUtils.release(conn, stat);
        }
    }
}
