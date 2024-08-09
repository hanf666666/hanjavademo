package com.base01.test08_�����ڲ��ི��.innerclass;

import lombok.Data;
import lombok.ToString;

/**
 * to do
 *
 * @author Hj
 * @date 2024/8/8
 */
@Data
@ToString
public class OutClassInstance {
    private String outName;

    /**
     * �ڲ���
     */
    @Data
    @ToString
    public  class InnerClass{
        private String innerName;
        private String referOutName;
        public InnerClass() {
            //�Ǿ�̬�ڲ�����������ⲿ��Ķ���
            referOutName=outName;
        }
    }

    /**
     * ��̬�ڲ���
     */
    @Data
    @ToString
    public static class StaticInner{
        private String innerStaticName;
    }


    public static void main(String[] args) {
//        OutClassInstance.InnerClass obj = OutClassInstance.InnerClass new InnerClass(); //ע�����ⲿ��ʵ��.new���ڲ���
        OutClassInstance.StaticInner in = new OutClassInstance.StaticInner();//ע�����ⲿ�౾����̬�ڲ���


    }
}
