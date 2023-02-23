package com.date.DesignPattern.创建型.抽象工厂模式;;


public class MainClass {
    public static void main(String[] args) {

            // amd工厂
            ComputerFactory amdCF = new AmdFactory();
            //  AmdCPU
            CPU amdcpu = amdCF.makeCPU();
            // Amdboard
            MainBoard amdboard = amdCF.makeMainBoard();
            // amdhardDisk
            HardDisk amdhardDisk = amdCF.makeHardDisk();
            Computer amdComputer = new Computer(amdcpu, amdboard, amdhardDisk);






    }
}
