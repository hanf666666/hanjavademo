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
    @ExcelProperty(value = "�û����")
    private Integer userId;
    @ExcelProperty(value = "����")
    private String userName;
    @ExcelProperty(value = "�Ա�")
    private String gender;
    @ExcelProperty(value = "����")
    private Double salary;
    @ExcelProperty(value = "��ְʱ��")
    private Date hireDate;

    // lombok ������getter/setter����
}
