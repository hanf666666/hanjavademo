package com.date.DesignPattern.行为型模式.状态模式;

public class BState implements State{
    public void doAction(Context context) {
        System.out.println("Context切状态为B");
        context.setState(this);
    }

    public String doThing(){
        System.out.println("BState做的事");

        return "BState做的事";
    }
}
