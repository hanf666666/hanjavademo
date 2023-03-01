package com.date;

/**
 * to do
 *
 * @author Hj
 * @date 2023/2/11
 */
public class sss {
    public static void main(String[] args) {
        String sql="select p.name from pos_patrol_time p, admin_user au " +
                "where p.operator = au.id and au.owner_id = ?1 and p.deleted = 0 group by p.name";


        System.out.println(sql);
    }
}
