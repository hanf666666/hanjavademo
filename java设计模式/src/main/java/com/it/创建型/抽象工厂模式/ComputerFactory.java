package com.it.创建型.抽象工厂模式;


public interface ComputerFactory {
    //Cpu核心
    CPU makeCPU();
    //主板
    MainBoard makeMainBoard();
    //硬盘
    HardDisk makeHardDisk();
}
