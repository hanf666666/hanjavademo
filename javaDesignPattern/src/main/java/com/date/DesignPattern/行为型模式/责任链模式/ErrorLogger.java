package com.date.DesignPattern.��Ϊ��ģʽ.������ģʽ;

/**
 * to do
 *
 * @author Hj
 * @date 2022/5/29
 */

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}

