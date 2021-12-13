package com.Thread.��Ϊ��ģʽ.����ģʽ;

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