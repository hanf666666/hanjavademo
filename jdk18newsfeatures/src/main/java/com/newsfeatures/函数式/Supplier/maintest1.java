package com.newsfeatures.����ʽ.Supplier;

import java.util.function.Supplier;

/**
 * to do
 * Supplier �ӿڷ���һ�����ⷶ�͵�ֵ����Function�ӿڲ�ͬ���Ǹýӿ�û���κβ���
 * @author Hj
 * @date 2021/12/2
 */
public class maintest1 {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person


    }
}
