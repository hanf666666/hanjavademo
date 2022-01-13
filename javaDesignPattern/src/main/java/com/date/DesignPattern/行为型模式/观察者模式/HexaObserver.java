package com.date.DesignPattern.行为型模式.观察者模式;

/**
 * 16????
 */
public class HexaObserver extends AbstractObserver {
    public HexaObserver(Subject subject) {
        super.subject=subject;
        subject.setObserverArrayList(this);
    }

    @Override
    public void receiveUpdate() {
        String result = Integer.toHexString(subject.getState()).toUpperCase();
        System.out.println("?????????????仯????????????????????????" + result);
    }
}
