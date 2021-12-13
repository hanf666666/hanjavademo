package com.Thread.�ṹ��.����ģʽ.Ĭ�ϴ���ģʽ.demo01;

public class FoodServiceProxy implements FoodService {
    // �ڲ�һ��Ҫ��һ����ʵ��ʵ���࣬��ȻҲ����ͨ�����췽��ע��
    private FoodService foodService = new FoodServiceImpl();

    public Food makeChicken() {
        System.out.println("��������Ҫ��ʼ����������");

        // ������Ƕ������Ϊ���Ĵ���Ļ�����ô�����Ĵ�������ʵʵ�������ģ�
        // ����ֻ���ں��Ĵ���ǰ����Щ���������ء�������
        Food food = foodService.makeChicken();

        System.out.println("����������������ӵ������"); // ��ǿ
        //food.addCondiment("pepper");

        return food;
    }
    public Food makeNoodle() {
        System.out.println("׼����������~");
        Food food = foodService.makeNoodle();
        System.out.println("���������");
        return food;
    }
}
