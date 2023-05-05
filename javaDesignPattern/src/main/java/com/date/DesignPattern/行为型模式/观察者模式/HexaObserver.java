package com.date.DesignPattern.行为型模式.观察者模式;

/**
 * 十六进制
 */
public class HexaObserver extends AbstractObserver {
    public HexaObserver(Subject subject) {
        super.subject=subject;
        subject.setObserverArrayList(this);
    }

    @Override
    public void receiveUpdate() {
        String result = Integer.toHexString(subject.getState()).toUpperCase();
        System.out.println("订阅的数据发生变化，新的数据处理为十六进制值为：" + result);    }
}
