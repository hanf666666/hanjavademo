package com.date.DesignPattern.创建型.抽象工厂模式;;


public interface ComputerFactory {
    //Cpu????
    CPU makeCPU();
    //????
    MainBoard makeMainBoard();
    //???
    HardDisk makeHardDisk();
}
