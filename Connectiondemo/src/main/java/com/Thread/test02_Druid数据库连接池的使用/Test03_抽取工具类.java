package com.Thread.test02_Druid���ݿ����ӳص�ʹ��;

import com.it.utils.DruidUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test03_��ȡ������ {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. ��ȡ���Ӷ���.
            //��������Ӷ����������Լ��ֶ�������.
            //conn = JDBCUtils.getConnection();
            //��Ϊ��: ���ݿ����ӳ��л�ȡ

            //�������ݿ����ӳ�
            //DataSource ds = DruidUtils.getDataSource();
            //conn = ds.getConnection();

            //���������д�������Ż�Ϊ�±ߵ�һ�д���.
            conn = DruidUtils.getConnection();


            //2. ��ȡ����ִ��SQL���Ķ���.
            stat = conn.createStatement();
            //4. ִ��SQL���, ��ȡ�����.
            String sql = "select * from account;";
            rs = stat.executeQuery(sql);
            //5. ���������.
            while(rs.next()) {
                System.out.println(rs.getInt("aid") + "..." + rs.getString("aname") + "..." + rs.getInt("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. �ͷ���Դ.
            DruidUtils.release(conn,stat,rs);

            /*
                ������Լ����������Ӷ���, ������: ����
                ����Ǵ����ݿ����ӳػ�ȡ�Ķ���, ������: �Զ��黹.
             */
        }
    }
}
