package com.date.DesignPattern.��Ϊ��ģʽ.״̬ģʽ;

public class BState implements State{
    public void doAction(Context context) {
        System.out.println("Context��״̬ΪB");
        context.setState(this);
    }

    public String doThing(){
        System.out.println("BState������");

        return "BState������";
    }
}
