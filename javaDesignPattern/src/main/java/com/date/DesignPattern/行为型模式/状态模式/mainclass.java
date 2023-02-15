package com.date.DesignPattern.行为型模式.状态模式;

public class mainclass {
    public static void main(String[] args) {
        Context context = new Context();

        State aState = new AState();
        State bState = new BState();
        aState.doAction(context);
        context.getState().doThing();
        bState.doAction(context);
        context.getState().doThing();





    }
}
