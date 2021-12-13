package com.Thread.test03_c3p0���ݿ����ӳص�ʹ��;

import com.it.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test01_�ֶ����ò��� {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. ��ȡ���Ӷ���.
            //��������Ӷ����������Լ�������
            //conn = JDBCUtils.getConnection();
            //��Ϊ: �����ݿ����ӳػ�ȡ.
            //A: �������ݿ����ӳ�
            ComboPooledDataSource cpds = new ComboPooledDataSource();

            //B: ���ò���.
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql:///web04");
            cpds.setUser("root");
            cpds.setPassword("123");

            //C: �����ݿ����ӳػ�ȡ���Ӷ���
            conn = cpds.getConnection();

            //2. ��ȡ����ִ��SQL���Ķ���.
            stat = conn.createStatement();
            //4. ִ��SQL���, ��ȡ�����.
            String sql = "select * from account;";
            rs = stat.executeQuery(sql);
            //5. ���������.
            while(rs.next()) {
                System.out.println(rs.getInt("aid") + "..." + rs.getString("aname") + "..." + rs.getInt("money"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6. �ͷ���Դ.
            JDBCUtils.release(conn,stat,rs);
        }
    }
}
