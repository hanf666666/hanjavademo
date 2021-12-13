package com.Thread.������.�򵥹���ģʽ;



public class FoodFactory {
    public static Food makeFood(String foodstr){

        if(foodstr.equalsIgnoreCase("apple"))
        {
            System.out.println("apple������");
           return  new Apple();
        }else if(foodstr.equalsIgnoreCase("manggu"))
        {System.out.println("manggu������");
            return  new Manggu();
        }else {
            System.out.println("�����Ҳ������ʳ��");
            throw new RuntimeException("���ʳ�����ǲ�����!!!!");
        }


    }
}
