package com.date.DesignPattern.��Ϊ��ģʽ.�۲���ģʽ;

public class BinaryObserver extends AbstractObserver {

    public BinaryObserver(Subject subject) {
        super.subject=subject;
        subject.setObserverArrayList(this);
    }

    @Override
    public void receiveUpdate() {
        String result = Integer.toBinaryString(subject.getState());
        System.out.println("?????????????��???????????????????????" + result);

    }
}
