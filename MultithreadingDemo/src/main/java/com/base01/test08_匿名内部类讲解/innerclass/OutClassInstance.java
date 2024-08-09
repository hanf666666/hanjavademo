package com.base01.test08_匿名内部类讲解.innerclass;

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
     * 内部类
     */
    @Data
    @ToString
    public  class InnerClass{
        private String innerName;
        private String referOutName;
        public InnerClass() {
            //非静态内部类对象会持有外部类的对象
            referOutName=outName;
        }
    }

    /**
     * 静态内部类
     */
    @Data
    @ToString
    public static class StaticInner{
        private String innerStaticName;
    }


    public static void main(String[] args) {
//        OutClassInstance.InnerClass obj = OutClassInstance.InnerClass new InnerClass(); //注意是外部类实例.new，内部类
        OutClassInstance.StaticInner in = new OutClassInstance.StaticInner();//注意是外部类本身，静态内部类


    }
}
