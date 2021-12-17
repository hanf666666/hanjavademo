package com.it.DesignPattern.结构型.适配器模式.默认适配器模式;

public class MainClass {
    public static void main(String[] args) {
        FileMonitor fileMonitor = new FileMonitor();
        fileMonitor.onDirectoryChange(new java.io.File("fdf"));

    }
}
