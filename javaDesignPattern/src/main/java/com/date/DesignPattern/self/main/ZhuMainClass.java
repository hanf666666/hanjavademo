package com.date.DesignPattern.self.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2023/9/5
 */
public class ZhuMainClass {
    public static void main(String[] args) {
        String sql = "select * from order_park_order where plate_no=:plateNo and type=2 and status in (0,1,2,3,4,99) " +
                "order by concat(plate_no,'') desc, start_date desc limit 1";
        System.out.println(sql.toString());

    }
}
