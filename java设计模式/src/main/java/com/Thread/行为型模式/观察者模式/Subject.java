package com.Thread.��Ϊ��ģʽ.�۲���ģʽ;

import java.util.ArrayList;

/**
 * ����
 */
public class Subject {
    private  ArrayList<AbstractObserver> observerArrayList = new ArrayList<>();
    private  Integer state;

    public ArrayList<AbstractObserver> getObserverArrayList() {
        return observerArrayList;
    }

    public void setObserverArrayList(AbstractObserver abstractObserver) {
        this.observerArrayList.add(abstractObserver);
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {

        this.state = state;
        // �����ѱ����֪ͨ�۲�����
        notifyAllObservers();
    }

    // �����ѱ����֪ͨ�۲�����
    private void notifyAllObservers() {
        for (AbstractObserver abstractObserver : observerArrayList) {
            //
            abstractObserver.receiveUpdate();
        }
    }


}
