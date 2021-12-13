package com.Thread.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ����Druid���ݿ����ӳص� ������
 */
public class DruidUtils {
    //1. ����˽��.
    private DruidUtils() {}

    //2. �������, ��¼���ݿ����ӳض���.
    private static DataSource ds;

    //3. �ھ�̬�������, �����ݿ����ӳض�����г�ʼ������.
    static {
        Properties pp = new Properties();
        try {
            //��ȡ�����ļ�����Ϣ
            pp.load(new FileReader("day04_classDemo\\src\\druid.properties"));
            // �����ݿ����ӳض�����г�ʼ������.
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //4. �����ṩ����, ������ȡ���ӳض���.
    public static DataSource getDataSource() {
        return ds;
    }

    //5. �����ṩ�ḻ, ������ȡ���Ӷ���.     �����Ӷ�����ֱ�Ӵ����ݿ����ӳ��л�ȡ��.
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //6. �ͷ���Դ
    public static void release(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                    stat = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                        conn = null;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void release(Connection conn, Statement stat) {
        try {
            if (stat != null) {
                stat.close();
                stat = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
