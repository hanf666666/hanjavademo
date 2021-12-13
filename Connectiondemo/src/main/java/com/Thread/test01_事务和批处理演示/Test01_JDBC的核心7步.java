package com.Thread.test01_�������������ʾ;

import com.it.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01_JDBC�ĺ���7�� {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. ��ȡ���Ӷ���.
            conn = JDBCUtils.getConnection();
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
