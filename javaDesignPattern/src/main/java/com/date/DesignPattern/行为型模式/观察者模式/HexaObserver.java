package com.date.DesignPattern.��Ϊ��ģʽ.�۲���ģʽ;

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
        System.out.println("?????????????��????????????????????????" + result);
    }
}
