package com.it.DesignPattern.行为型模式.观察者模式;

public abstract class AbstractObserver {
    protected Subject subject;
    public abstract void receiveUpdate();
}
