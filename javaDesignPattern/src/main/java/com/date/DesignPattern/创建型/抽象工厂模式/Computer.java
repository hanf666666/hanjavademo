package com.date.DesignPattern.创建型.抽象工厂模式;;



public class Computer {

    public Computer() {
    }

    public Computer(CPU cpu, MainBoard board, HardDisk hardDisk) {
        System.out.println("???????м?????????");
    }
}
