package com.date.DesignPattern.行为型模式.模板方法模式;

/**
 * to do
 *
 * @author Hj
 * @date 2023/5/5
 */
public class ClassMain {
    public static void main(String[] args) {
        AbstractTemplate t = new ConcreteTemplate();
        // 调用模板方法
        t.templateMethod();

    }
}
