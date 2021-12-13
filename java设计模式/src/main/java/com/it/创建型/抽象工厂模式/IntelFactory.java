package com.it.创建型.抽象工厂模式;



public class IntelFactory implements ComputerFactory {
    @Override
    public CPU makeCPU() {
        return null;
    }

    @Override
    public MainBoard makeMainBoard() {
        return null;
    }

    @Override
    public HardDisk makeHardDisk() {
        return null;
    }
}
