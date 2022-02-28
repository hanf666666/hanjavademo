package com.newsfeatures.container;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
//public class Plate<T extends Fruit>{
public class Plate<T>{
    private T item;
    public Plate(T t){item=t;}
    public void set(T t){item=t;}
    public T get(){return item;}
}


