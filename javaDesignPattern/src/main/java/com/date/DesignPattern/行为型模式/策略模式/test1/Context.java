package com.date.DesignPattern.行为型模式.策略模式.test1;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeDraw(int radius, int x, int y){
         strategy.draw(radius, x, y);
        return 1;
    }
}
