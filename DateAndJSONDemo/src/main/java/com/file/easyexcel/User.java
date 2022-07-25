package com.file.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/23
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @ExcelProperty(value = "用户编号")
    private Integer userId;
    @ExcelProperty(value = "姓名")
    private String userName;
    @ExcelProperty(value = "性别")
    private String gender;
    @ExcelProperty(value = "工资")
    private Double salary;
    @ExcelProperty(value = "入职时间")
    private Date hireDate;

    // lombok 会生成getter/setter方法
}
