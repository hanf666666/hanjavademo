package com.Thread.test03_c3p0���ݿ����ӳص�ʹ��;
import com.it.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test02_��ȡ�����ļ� {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. ��ȡ���Ӷ���.
            //conn = JDBCUtils.getConnection();
            //���Ӷ����Ϊ�����ݿ����ӳ��л�ȡ.
            //�������ݿ����ӳض���
            ComboPooledDataSource cpds = new ComboPooledDataSource("web03");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. �ͷ���Դ.
            JDBCUtils.release(conn,stat,rs);
        }
    }
}
