package com.date.test02_Druid���ݿ����ӳص�ʹ��;

import com.date.utils.DruidUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test03_��ȡ������2 {
    private volatile static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(30);


        for (int i = 0; i < 200; i++) {
            executorService.submit(() -> {
                Connection conn = null;
                Statement stat = null;
                ResultSet rs = null;
                try {
                    //���������д�������Ż�Ϊ�±ߵ�һ�д���.
                    conn = DruidUtils.getConnection();
//                    Thread.sleep(30000);
                    //2. ��ȡ����ִ��SQL���Ķ���.
                    stat = conn.createStatement();
                    //4. ִ��SQL���, ��ȡ�����.
                    String sql = "select * from student limit 1;";
                    rs = stat.executeQuery(sql);
                    //5. ���������.
                    while (rs.next()) {
                        System.out.println((count++)+rs.getInt("id") + "..." + rs.getString("name") + "..." + rs.getString("name2"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
//
                    //6. �ͷ���Դ.
                    DruidUtils.release(conn, stat, rs);

            /*
                ������Լ����������Ӷ���, ������: ����
                ����Ǵ����ݿ����ӳػ�ȡ�Ķ���, ������: �Զ��黹.
             */
                }
            });

        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
