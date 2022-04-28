package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
  * ����״̬��ӦǷ�Ѳ���״̬ö��
  * @author tianhf
  * @date 2019/10/22
  */
@Getter
@AllArgsConstructor
public enum OrderStatusToArrearsStatusEnum {

    /**
     * 5 δ���ɣ� 6 �Ѳ���  95 �����
     */
    PAY_BACK(95, "�Ѳ���"),
    AFTER_PAY_DODGING_TOLL(94, "�����ѽ�"),
    NOT_PAY_BACK(5, "δ����"),
    CLEARED(6, "�����");

    /**
     * ����״̬
     */
    private Integer value;


    /**
     * Ƿ�Ѳ���״̬ ����
     */
    private String name;

    /**
     * ����ö�����ȡö��
     * @param value ö����
     * @return ö��
     */
    public static String getNameByValue(Integer value) {
        if(Objects.isNull(value)){
            return "";
        }
        for (OrderStatusToArrearsStatusEnum item : OrderStatusToArrearsStatusEnum.values()) {
            if (item.getValue().equals(value)) {
                return item.getName();
            }
        }
        return "";
    }
}
