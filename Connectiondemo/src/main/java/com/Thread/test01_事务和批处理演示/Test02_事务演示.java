package com.Thread.test01_�������������ʾ;

import com.it.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Test02_������ʾ {
    public static void main(String[] args) {
        //����: ���� �� ���� ת1000
        Connection conn = null;
        Statement stat = null;

        try {
            //1. ��ȡ���Ӷ���.
            conn = JDBCUtils.getConnection();
            //2. ��ȡ����ִ��SQL���Ķ���.
            stat = conn.createStatement();
            //4. ִ��SQL���, ��ȡ�����.
            //���� - 1000
            String sql1 = "update account set money = money - 1000 where aid = 1;";
            //���� + 1000
            String sql2 = "update account set money = money + 1000 where aid = 2;";

            //��������(�ر�������Զ��ύ����, ��ΪMySQLĬ�Ͽ�����������Զ��ύ����)
            conn.setAutoCommit(false);
            //ִ��SQL1
            int num1 = stat.executeUpdate(sql1);

            System.out.println(1/0);

            //ִ��SQL2
            int num2 = stat.executeUpdate(sql2);
            //5. ���������.
            if (num1 == num2 && num1 == 1) {
                conn.commit();
                System.out.println("ת�˳ɹ�");
            } else {
                conn.rollback();
                System.out.println("ת��ʧ��");
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("ת��ʧ��");
            e.printStackTrace();
        }finally {
            //6. �ͷ���Դ.
            JDBCUtils.release(conn,stat);
        }
    }
}
