package com.date.DesignPattern.������.����ģʽ.����ģʽ;

import java.util.Date;

public class Singleton  {

    private Singleton(){
        System.out.println("����");
    }
    private static Singleton instance=  new Singleton();
    public static Singleton getInstance() {
        return instance;
    }


    public static Date getDate(String mode) {

        System.out.println("getDate");
        return new Date();}

}
