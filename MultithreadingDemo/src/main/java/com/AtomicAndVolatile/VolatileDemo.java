package com.AtomicAndVolatile;

import java.util.concurrent.TimeUnit;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/25
 */
public class VolatileDemo {

    // ���� volatile ����ͻ���ѭ��
    // ��  volatile ���Ա�֤�ɼ���
    private volatile static int flag = 0;

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            // �߳�1 �����ڴ�ı仯����֪
            while (flag == 0) {
                System.out.println("222222");
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        flag=1;
        System.out.println("1111111111111111");
    }
}