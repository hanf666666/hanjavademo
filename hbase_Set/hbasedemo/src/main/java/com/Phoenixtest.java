package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * to do
 *
 * @author Hj
 * @date 2021/5/21
 */
public class Phoenixtest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("phoenix.query.timeoutMs", "1200000");
        props.setProperty("hbase.rpc.timeout", "1200000");
        props.setProperty("hbase.client.scanner.timeout.period", "1200000");
        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");

            // 这里配置zookeeper的地址，可单个，也可多个。可以是域名或者ip
            String     url       = "jdbc:phoenix:bigdata-alpha-003,bigdata-alpha-004,bigdata-alpha-005:2181:/hbase";
            Connection conn      = DriverManager.getConnection(url, props);
            conn.setSchema("meisoodev");
            Statement statement = conn.createStatement();

            String    sql  = "select count(1) from EQUIPMENT_FEE_RULE limit 10";
            long      time = System.currentTimeMillis();
            ResultSet rs   = statement.executeQuery(sql);
            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("row count is " + count);
            }
            long timeUsed = System.currentTimeMillis() - time;
            System.out.println("time " + timeUsed + "mm");
            // 关闭连接
            rs.close();
            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
