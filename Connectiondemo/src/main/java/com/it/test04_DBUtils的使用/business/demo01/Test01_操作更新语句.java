package com.it.test04_DBUtils的使用.business.demo01;

import com.it.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class Test01_操作更新语句 {


    /**
     * 不断的更新,测试flink的乱序问题
     */
    @Test
    public void buduanupdate() {
        //1. 获取可以执行SQL语句的对象.
        QueryRunner qr = new QueryRunner();
        //2. 执行SQL语句, 获取结果集.
        String sql = "update student set sname=? where sid=03  ;";
        try {
            //3. 操作结果集.
            int num = qr.update(C3P0Utils.getConnection(), sql,"钱电2");
            System.out.println(num > 0 ? "添加成功" : "添加失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
