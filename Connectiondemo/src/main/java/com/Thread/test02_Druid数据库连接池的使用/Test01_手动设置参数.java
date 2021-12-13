package com.Thread.test02_Druid���ݿ����ӳص�ʹ��;

import com.alibaba.druid.pool.DruidDataSource;
import com.it.utils.JDBCUtils;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ����ӳ�(DBCP)��������: �����Ӷ����"����"��Ϊ"�Զ��黹".
 */
public class Test01_�ֶ����ò��� {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. ��ȡ���Ӷ���.
            //������Ӷ����������Լ�������, �����"����"��.
            //conn = JDBCUtils.getConnection();

            //��Ϊ: �����ݿ����ӳػ�ȡ���Ӷ���, ����֮��, ���Զ��黹��"���ݿ����ӳ�"��
            //A: �������ݿ����ӳ�.
            DruidDataSource dds = new DruidDataSource();
            dds.setInitialSize(10);
            dds.setMaxIdle(1);
            dds.setMaxActive(2000);
//            dds.ser(2000);
            System.out.println("1==========================="+dds);
            //��̬
            //DataSource dds2 = new DruidDataSource();

            //B: �������ݿ����ӳصĲ�����Ϣ
            //��Ҫ����
            dds.setDriver(new Driver());
            dds.setUrl("jdbc:mysql:///connectiondemo");
            dds.setUsername("root");
            dds.setPassword("123456");

            //��ѡ����

            //C: �����ݿ����ӳ��л�ȡ���Ӷ���.
            conn = dds.getConnection();
            Connection  conn2 = dds.getConnection();
            Connection  conn3 = dds.getConnection();
            Connection  conn4 = dds.getConnection();
            //2. ��ȡ����ִ��SQL���Ķ���.
            stat = conn.createStatement();

            try {
                int i=0;
                while (true){
                    System.out.println(i+++"==========================="+dds);
                    Thread.sleep(5000);
                    conn3.close();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //4. ִ��SQL���, ��ȡ�����.
            String sql = "select * from account;";
            rs = stat.executeQuery(sql);
            //5. ���������.
            while(rs.next()) {
                System.out.println(rs.getInt("aid") + "..."
                        + rs.getString("aname") + "..." +
                        rs.getInt("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6. �ͷ���Դ.
            JDBCUtils.release(conn,stat,rs);
            /*
                Сϸ��: ����conn.close()
                    ���conn����(���Ӷ���)�������Լ�������, ����close()������ʱ��, �ǽ����Ӷ���"����"
                    ���conn����(���Ӷ���)�����Ǵ����ݿ����ӳػ�ȡ��, ����close()������ʱ��, �ǽ����Ӷ���"�黹�����ݿ����ӳ�"
             */
        }
    }
}
