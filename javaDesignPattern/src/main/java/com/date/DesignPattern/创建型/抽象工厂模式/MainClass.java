package com.date.DesignPattern.������.���󹤳�ģʽ;;


public class MainClass {
    public static void main(String[] args) {

            // amd����
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
