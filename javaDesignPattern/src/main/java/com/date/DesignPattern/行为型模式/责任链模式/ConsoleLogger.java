package com.date.DesignPattern.��Ϊ��ģʽ.������ģʽ;

/**
 * to do
 *
 * @author Hj
 * @date 2022/5/29
 */

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
