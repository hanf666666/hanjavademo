package com.enums.demo01;

import com.enums.demo01.OrderStatusToArrearsStatusEnum;

/**
 * to do
 *
 * @author Hj
 * @date 2022/4/25
 */
public class MainDemo {
    public static void main(String[] args) {
//        PAY_BACK(95, "�Ѳ���"),
//                AFTER_PAY_DODGING_TOLL(94, "�����ѽ�"),
//                NOT_PAY_BACK(5, "δ����"),
//                CLEARED(6, "�����");
        System.out.println(OrderStatusToArrearsStatusEnum.getNameByValue(95));

        OrderStatusToArrearsStatusEnum orderStatusToArrearsStatus = OrderStatusToArrearsStatusEnum.CLEARED;
        System.out.println(orderStatusToArrearsStatus);
        System.out.println(orderStatusToArrearsStatus.getName());
        System.out.println(orderStatusToArrearsStatus.getValue());
        switch (orderStatusToArrearsStatus){
            case CLEARED:
                System.out.println("����CLEARED:"+orderStatusToArrearsStatus);
                break;
            case PAY_BACK:
                System.out.println("����PAY_BACK:"+orderStatusToArrearsStatus);
                break;
        }
    }
}
