package com.date.DesignPattern.��Ϊ��ģʽ.״̬ģʽ;

public class AState implements State{
    public void doAction(Context context) {
        System.out.println("Context��״̬ΪA");
        context.setState(this);
    }

    public String doThing(){
        System.out.println("AState������");

        return "AState������";
    }
}
