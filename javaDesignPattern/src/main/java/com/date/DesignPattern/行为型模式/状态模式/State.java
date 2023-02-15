package com.date.DesignPattern.行为型模式.状态模式;

public interface State  {
    public void doAction(Context context);
    String doThing();
}
