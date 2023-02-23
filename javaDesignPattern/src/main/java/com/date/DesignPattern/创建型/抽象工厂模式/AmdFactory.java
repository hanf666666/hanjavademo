package com.date.DesignPattern.创建型.抽象工厂模式;;

public class AmdFactory implements ComputerFactory {
    @Override
    public CPU makeCPU() {
        return new AmdCPU();
    }

    @Override
    public MainBoard makeMainBoard() {
        return new AmdMainBoard();
    }

    @Override
    public HardDisk makeHardDisk() {
        return new AmdHardDisk();
    }
}
