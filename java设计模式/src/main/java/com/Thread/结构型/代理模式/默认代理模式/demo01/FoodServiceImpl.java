package com.Thread.�ṹ��.����ģʽ.Ĭ�ϴ���ģʽ.demo01;

public class FoodServiceImpl implements FoodService {

    public Food makeChicken() {
        Food f = new Chicken();
      //  f.setChicken("1kg");
        f.setSpicy("1g");
        f.setSalt("3g");
        return f;
    }
    public Food makeNoodle() {
        Food f = new Noodle();
       // f.setNoodle("500g");
        f.setSalt("5g");
        return f;
    }
}
