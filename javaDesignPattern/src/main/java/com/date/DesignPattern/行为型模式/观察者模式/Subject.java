package com.date.DesignPattern.行为型模式.观察者模式;

import java.util.ArrayList;

/**
 * 主题
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
        // 数据已变更，通知观察者们
        notifyAllObservers();
    }

    // 通知观察者们
    private void notifyAllObservers() {
        for (AbstractObserver abstractObserver : observerArrayList) {
            abstractObserver.receiveUpdate();
        }
    }


}
