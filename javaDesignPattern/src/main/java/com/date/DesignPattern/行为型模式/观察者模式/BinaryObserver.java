package com.date.DesignPattern.行为型模式.观察者模式;

/**
 * 二进制
 */
public class BinaryObserver extends AbstractObserver {

    public BinaryObserver(Subject subject) {
        super.subject=subject;
        subject.setObserverArrayList(this);
    }

    @Override
    public void receiveUpdate() {

            String result = Integer.toBinaryString(subject.getState());
            System.out.println("订阅的数据发生变化，新的数据处理为二进制值为：" + result);

        }
}
