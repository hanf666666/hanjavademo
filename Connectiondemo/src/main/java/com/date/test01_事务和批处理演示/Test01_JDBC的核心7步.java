package com.date.test01_�������������ʾ;

import com.date.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * to do
 *Test01_JDBC�ĺ���7��
 * @author Hj
 * @date 2022/1/19
 */
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
            String sql = "SELECT * FROM USER;";
            rs = stat.executeQuery(sql);
            //5. ���������.
            while(rs.next()) {
                System.out.println(rs.getInt("id") + "..." + rs.getString("username") + "..." + rs.getInt("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. �ͷ���Դ.
            JDBCUtils.release(conn,stat,rs);
        }
    }
}
