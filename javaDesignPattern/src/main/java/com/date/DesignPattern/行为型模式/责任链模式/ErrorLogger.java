package com.date.DesignPattern.行为型模式.责任链模式;

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

