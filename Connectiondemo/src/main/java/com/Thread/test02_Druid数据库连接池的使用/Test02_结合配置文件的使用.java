package com.Thread.test02_Druid���ݿ����ӳص�ʹ��;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.it.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Test02_��������ļ���ʹ�� {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1. ��ȡ���Ӷ���.
            //��������Ӷ����������Լ�������, �����"����"��,
            //conn = JDBCUtils.getConnection();
            //��Ϊ: �����ݿ����ӳػ�ȡ.
            Properties pp = new Properties();
            pp.load(new FileReader("src/main/resources/druid.properties"));

            //A: �������ݿ����ӳض���
            //��̬
            DataSource ds = DruidDataSourceFactory.createDataSource(pp);
            //B: �������ݿ����ӳصĲ�����Ϣ, (������DruidDataSourceFactory���Զ���ȡ: .properties�е�������Ϣ)

            //C: �����ݿ����ӳ��л�ȡ���Ӷ���.
            conn = ds.getConnection();

            //2. ��ȡ����ִ��SQL���Ķ���.
            stat = conn.createStatement();
            //4. ִ��SQL���, ��ȡ�����.
            for (int i = 0; i < 1000000; i++) {
                String sql="INSERT INTO test20210707.order_park_order SELECT * FROM meisoodev.order_park_order ORDER BY id LIMIT "+(10000+i)+",1";
                System.out.println(sql);
                stat.execute(sql);

                Thread.sleep(10000);

            }

//            String sql = "select * from account;";
//            rs = stat.executeQuery(sql);
//            //5. ���������.
//            while(rs.next()) {
//                System.out.println(rs.getInt("aid") + "..." + rs.getString("aname") + "..." + rs.getInt("money"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6. �ͷ���Դ.
            JDBCUtils.release(conn,stat,rs);
            /*
                ������Լ����������Ӷ���, conn.close()�� ����
                ����Ǵ����ݿ����ӳ��õ����Ӷ���, conn.close()�� �Զ��黹.
             */
        }
    }
}
