package com.date.DesignPattern.行为型模式.观察者模式;

public class MainClass {
    public static void main(String[] args) {
        Subject subject = new Subject();


        new BinaryObserver(subject);
        new HexaObserver(subject);
        // 模拟数据变更，这个时候，观察者们的 update 方法将会被调用
        subject.setState(11);
    }
}
