package com.Thread.test04_DBUtils��ʹ��;

import com.it.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class Test01_����������� {
    /**
     * ��
     */
    @Test
    public void method1() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "insert into users values(?,?,?);";
        try {
            //3. ���������.
            int num = qr.update(sql, null, "admin09", "pw999");
            System.out.println( num > 0 ? "��ӳɹ�" : "���ʧ��");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��, ���
     */
    @Test
    public void method2() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner();
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "insert into users values(?,?,?);";
        try {
            //3. ���������.
            int num = qr.update(C3P0Utils.getConnection(),sql, null, "admin10", "pwss");
            System.out.println( num > 0 ? "��ӳɹ�" : "���ʧ��");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    /**
     *
     */
    @Test
    public void buduanupdate() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner();
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "insert into users values(?,?,?);";
        try {
            //3. ���������.
            int num = qr.update(C3P0Utils.getConnection(),sql, null, "admin10", "pwss");
            System.out.println( num > 0 ? "��ӳɹ�" : "���ʧ��");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
