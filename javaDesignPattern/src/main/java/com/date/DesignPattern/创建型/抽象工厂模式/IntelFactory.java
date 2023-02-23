package com.date.DesignPattern.创建型.抽象工厂模式;;



public class IntelFactory implements ComputerFactory {
    @Override
    public CPU makeCPU() {
        System.out.println("Intel CPU");
        return null;
    }

    @Override
    public MainBoard makeMainBoard() {
        System.out.println("Intel MainBoard");

        return null;
    }

    @Override
    public HardDisk makeHardDisk() {
        System.out.println("Intel HardDisk");

        return null;
    }
}
