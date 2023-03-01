package com;

import java.util.HashMap;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/27
 */
public class demo2 {
    public static void main(String[] args) {
         String sql="select item from TollPatrolTask item where item.parkId=?1 and item.tollId=?2 and " +
                 "item.state in (?3) and item.createTime between ?4 and ?5 order by item.parkItemNo asc ";
        System.out.println(sql);


    }
}
