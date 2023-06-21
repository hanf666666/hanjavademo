package com.date.localdatedemo01;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * to do
 *
 * @author Hj
 * @date 2023/6/15
 */
public class demo02 {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2022,1,1,8,0,0);
        LocalDateTime end = LocalDateTime.of(2022,1,2,8,30,30);
        Duration duration = Duration.between(start, end);
        System.out.println(duration);





    }
}
