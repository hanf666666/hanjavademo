package com.date.DesignPattern.行为型模式.状态模式;

public class AState implements State{
    public void doAction(Context context) {
        System.out.println("Context切状态为A");
        context.setState(this);
    }

    public String doThing(){
        System.out.println("AState做的事");

        return "AState做的事";
    }
}
