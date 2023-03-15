package com.date;

import java.util.Random;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain {
    public static void main(String[] args) {

        String sql = "select opo.id,opo.no,opo.plate_no,opo.park_name,opo.park_item_name,opo.phone,opnp.open_id,opnp.user_name,opo.in_type, " +
                "date_format(opo.start_date, '%Y-%m-%d %H:%i:%s') startDate,a.channel_name inChannelName " +
                "from order_park_order opo " +
                "LEFT JOIN (select open_id,user_name,order_park_order_no from order_park_no_plate where is_finish = 1) opnp " +
                "ON opo.no = opnp.order_park_order_no " +
                "LEFT JOIN (select id,car_code,in_time,channel_name from api_park_in_callback where in_or_out = 0) a " +
                "on opo.plate_no = a.car_code and opo.start_date = a.in_time " +
                "where opo.type = 2 and opo.category = 2  " +
                "and opo.deleted = 0 " +
                "and opo.`status` not in (99,95,5,6) ";
        System.out.println(sql);
        int i = new Random().nextInt(3);
        System.out.println(i);
        System.out.println("2303021716341558062".length());


    }
}
