package com.file.hutoolexcel;

import cn.hutool.core.annotation.Alias;
import lombok.Data;
import lombok.ToString;

/**
 * to do
 * ��ͨ���������˵�
 * @author Hj
 * @date 2022/12/30
 */
@Data
@ToString
public class StreetDTO {

    @Alias("�ֵ�ID")
    private String streeId;
//    private String �ֵ�ID;

    @Alias("�ֵ�����")
    private String StreetName;
//    private String �ֵ�����;


}
