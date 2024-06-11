package com.date;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain4 {
    public static void main(String[] args) {
        String sql = "select a.amount,a.discount_category discountCategory,ifnull(b.saler_version,c.saler_version) salerVersion " +
                "from discount_record a " +
                "left join mobile_app_user_cash b on a.cash_id=b.id " +
                "left join mobile_vehicle_cash c on a.cash_id=c.id " +
                "where a.order_park_order_item_no=:payNo and a.deleted = 0";

        sql="SELECT\n" +
                "        ep.id,\n" +
                "        ep.no,\n" +
                "        ep.province_id as provinceId,\n" +
                "        province.NAME as provinceName,\n" +
                "        ep.city_id as cityId,\n" +
                "        city.NAME as cityName,\n" +
                "        ep.area_id as areaId,\n" +
                "        area.NAME as areaName,\n" +
                "        ep.NAME as name,\n" +
                "        ep.address \n" +
                "        FROM\n" +
                "        meisoodev.equipment_park ep\n" +
                "        LEFT JOIN meisoodev.system_area province ON province.uid = ep.province_id\n" +
                "        LEFT JOIN meisoodev.system_area city ON city.uid = ep.city_id\n" +
                "        LEFT JOIN meisoodev.system_area area ON area.uid = ep.area_id\n" +
                "        WHERE\n" +
                "        ep.deleted = 0\n" +
                "        AND ep.is_inservice = 1\n" +
                "        and ep.area_id=3351" +
                " and ep.id in (146972, 112213, 112264, 112200, 112242, 112265, 128848, 112255, 146976, 147072, 112216, 112247, 112263, 112231, 112232, 112271, 112217, 112209, 146973, 112246, 112212, 112233, 112211, 112218, 112214, 112248, 112199, 146974, 112203, 112208);";


             String sql2 = new StringBuffer().append("SELECT * from (SELECT park_owner_id parkOwnerId,MAX( CASE setting_key WHEN 'ALIPAY_FEE' THEN setting_value ELSE '' END ) alipay_fee,")
                .append(" MAX( CASE setting_key WHEN 'WECHAT_FEE' THEN setting_value ELSE '' END ) wechat_fee,MAX( CASE setting_key WHEN 'BALANCE_FEE' THEN setting_value ELSE '' END ) balance_fee ," +
                        "MAX(  CASE setting_key WHEN 'parking_percent' THEN setting_value ELSE '' END) as parking_percent")
                .append(" FROM equipment_park_owner_setting where park_owner_id in (:parkOwnerList) GROUP BY park_owner_id HAVING alipay_fee != '' OR wechat_fee != '' OR balance_fee != '' ) oi ").toString();


        System.out.println(sql2);


    }
}
