package com.Thread.������.���󹤳�ģʽ;


public class MainClass {
    public static void main(String[] args) {

            // ��һ����Ҫѡ��һ�����󳧡�
            ComputerFactory cf = new AmdFactory();
            // ��������� CPU
            CPU cpu = cf.makeCPU();
            // �������������
            MainBoard board = cf.makeMainBoard();
            // ���������Ӳ��
            HardDisk hardDisk = cf.makeHardDisk();

            // ��ͬһ�����ӳ����� CPU�����塢Ӳ����װ��һ��
            Computer result = new Computer(cpu, board, hardDisk);

    }
}