package com.Thread.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����C3P0���ݿ����ӳصĹ�����
 */
public class C3P0Utils {
    //1. ���췽��˽�л�
    private C3P0Utils() {}

    //2. �������, ��¼���ݿ����ӳض���.
    private static DataSource ds = new ComboPooledDataSource();

    //3. �����ṩ����, ������ȡ���ӳض���.
    public static DataSource getDataSource() {
        return ds;
    }

    //4. �����ṩ����, ������ȡ���Ӷ���.     �����Ӷ�����ֱ�Ӵ����ݿ����ӳ��л�ȡ��.
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //5. �ͷ���Դ
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
