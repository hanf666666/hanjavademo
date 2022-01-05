package com.∑¥…‰Demo.∑Ω Ω2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/5
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private Date utilDate;
    private java.sql.Date sqlDate;
    private Son son;

}
