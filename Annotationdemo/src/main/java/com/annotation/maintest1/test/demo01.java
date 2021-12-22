package com.annotation.maintest1.test;

import com.annotation.maintest1.config.MainConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * to do
 *
 * @author Hj
 * @date 2021/9/12
 */


public class demo01 {
    @Test
    public void demo01() {
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
        final String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("bean定义的名字" + beanDefinitionName);
        }


    }


}

