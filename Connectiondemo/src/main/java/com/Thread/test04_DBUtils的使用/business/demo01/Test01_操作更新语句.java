package com.Thread.test04_DBUtils��ʹ��.business.demo01;

import com.it.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class Test01_����������� {


    /**
     * ���ϵĸ���,����flink����������
     */
    @Test
    public void buduanupdate() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner();
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "update student set sname=? where sid=03  ;";
        try {
            //3. ���������.
            int num = qr.update(C3P0Utils.getConnection(), sql,"Ǯ��2");
            System.out.println(num > 0 ? "��ӳɹ�" : "���ʧ��");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
