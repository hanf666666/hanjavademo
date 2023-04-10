package com.date;

import cn.hutool.core.text.StrBuilder;

import java.util.Objects;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain2 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT a.* FROM (");

        sb.append("select a.no,a.park_id,a.park_name,a.postage,a.occupy_order_id,a.start_date,a.end_date,a.type,a.status,a.money_pay ");
        sb.append(" from order_park_order a where a.phone=:phone and a.end_date<:queryTime and a.status=5 and a.deleted=0 ");

        sb.append(" union all  ");
        sb.append(" select a.no,a.park_id,a.park_name,a.postage,a.occupy_order_id,a.start_date,a.end_date,a.type,a.status,a.money_pay from order_park_order a ");
        sb.append(" inner join (select b.plate_no,b.plate_no_colour from mobile_app_user_vehicle b inner join mobile_app_user c on b.mobile_app_user_id = c.id where c.phone = :phone and b.deleted =0) plate ");
        sb.append(" on a.plate_no = plate.plate_no and a.plate_no_colour = plate.plate_no_colour where a.phone is null and a.end_date<:queryTime and a.status =5 and deleted=0 ");

        sb.append(" ) a where exists (select img.id from road_side_order_img img where img.action in (0,1) and img.file_url is not null and img.order_no = a.no ) ");
        sb.append(" order by a.end_date desc limit :pageCount ");
        System.out.println(sb.toString());



        StringBuilder sql = new StringBuilder("select o.order_no, o.plate_no, o.plate_no_color, o.park_id, o.park_name, o.park_item_id, " +
                "o.park_item_no, o.start_time, o.end_time, o.how_long, o.pic_record_id, o.video_record_id, " +
                "IFNULL(o.postage,0) postage, IFNULL(o.money_pay,0) moneyPay, IFNULL(op.clean_pay,0) cleanPay from park_arrears_order o " +
                "INNER JOIN order_park_order op on o.order_no = op.no ");
            sql.append("INNER JOIN equipment_park p on o.park_id = p.id and p.is_show_arrear = 1 ");

            sql.append("LEFT JOIN road_side_order_img oi on o.order_no = oi.order_no ");

        sql.append("where o.plate_no = :plateNo ");
            sql.append("and o.plate_no_color = :plateNoColor ");


            sql.append("group by o.order_no, o.plate_no, o.plate_no_color, o.park_id, o.park_name, o.park_item_id, o.park_item_no, " +
                    "o.start_time, o.end_time, o.how_long, o.pic_record_id, o.video_record_id, postage, moneyPay, cleanPay " +
                    "HAVING count(oi.id) > 0 ");

        sql.append("order by o.id desc limit :limit");
        System.out.println(sql.toString());



    }
}
