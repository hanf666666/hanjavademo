package com.it.创建型.抽象工厂模式;

public class AmdFactory implements ComputerFactory {
    @Override
    public CPU makeCPU() {
        return new CPU();
    }

    @Override
    public MainBoard makeMainBoard() {
        return new MainBoard();
    }

    @Override
    public HardDisk makeHardDisk() {
        return new HardDisk();
    }
}
