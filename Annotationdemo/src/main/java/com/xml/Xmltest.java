package com.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * to do
 *
 * @author Hj
 * @date 2021/9/12
 */
public class Xmltest {
    public static void main(String[] args) {

        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        System.out.println(classPathXmlApplicationContext.getApplicationName());
        System.out.println(classPathXmlApplicationContext.getId());
        System.out.println(classPathXmlApplicationContext.getBean("student"));
        System.out.println("===========================================");
        final String[] beanDefinitionNames = classPathXmlApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("bean定义的名字"+beanDefinitionName);
        }

        System.out.println("===========================================");


    }
}
