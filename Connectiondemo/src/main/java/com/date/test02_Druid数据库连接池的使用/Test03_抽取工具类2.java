package com.date.test02_Druid���ݿ����ӳص�ʹ��;

import com.date.utils.DruidUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test03_��ȡ������2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {

            //���������д�������Ż�Ϊ�±ߵ�һ�д���.
            conn = DruidUtils.getConnection();


            //2. ��ȡ����ִ��SQL���Ķ���.
            stat = conn.createStatement();
            //4. ִ��SQL���, ��ȡ�����.
            String sql = "select * from student;";
            rs = stat.executeQuery(sql);
            //5. ���������.
            while(rs.next()) {
                System.out.println(rs.getInt("id") + "..." + rs.getString("name") + "..." + rs.getString("name2"));
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
