package com.date.DesignPattern.��Ϊ��ģʽ.������ģʽ;

/**
 * to do
 *
 * @author Hj
 * @date 2022/5/29
 */

public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
