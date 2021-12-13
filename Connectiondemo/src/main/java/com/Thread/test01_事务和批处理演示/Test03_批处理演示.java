package com.Thread.test01_�������������ʾ;

import com.it.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Test03_��������ʾ {
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
            String sql1 = "insert into users values(null,'admin03','pw333'),(null,'admin04','pw444');";
            String sql2 = "delete from users where uid = 1;";
            String sql3 = "insert into account values(null,'����',20000),(null,'����',20000),(null,'����',20000);";
            String sql4 = "update account set money=50001 where aid=2;";

           // String sql5 = "select * from account,users;";
            //��ʽһ: ��ͨ����
            /*int num1 = stat.executeUpdate(sql1);
            int num2 = stat.executeUpdate(sql2);
            int num3 = stat.executeUpdate(sql3);
            int num4 = stat.executeUpdate(sql4);*/

            //��ʽ��: ������.
            //��SQL�����ӵ�������
            stat.addBatch(sql1);
            stat.addBatch(sql2);
            stat.addBatch(sql3);
            stat.addBatch(sql4);
           // stat.addBatch(sql5);

            //ִ��������
            //�����¼����: �������и���SQL���ִ�к󷵻صĽ��(��Ӱ�������)
            int[] arr = stat.executeBatch();

            //���������(��ѡ)
            stat.clearBatch();

            //5. ���������.
            System.out.println(Arrays.toString(arr));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. �ͷ���Դ.
            JDBCUtils.release(conn,stat);
        }
    }
}
