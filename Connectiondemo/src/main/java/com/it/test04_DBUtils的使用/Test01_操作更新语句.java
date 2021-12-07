package com.it.test04_DBUtils的使用;

import com.it.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class Test01_操作更新语句 {
    /**
     * 增
     */
    @Test
    public void method1() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //2. 执行SQL语句, 获取结果集.
        String sql = "insert into users values(?,?,?);";
        try {
            //3. 操作结果集.
            int num = qr.update(sql, null, "admin09", "pw999");
            System.out.println( num > 0 ? "添加成功" : "添加失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增, 理解
     */
    @Test
    public void method2() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner();
        //2. 执行SQL语句, 获取结果集.
        String sql = "insert into users values(?,?,?);";
        try {
            //3. 操作结果集.
            int num = qr.update(C3P0Utils.getConnection(),sql, null, "admin10", "pwss");
            System.out.println( num > 0 ? "添加成功" : "添加失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
