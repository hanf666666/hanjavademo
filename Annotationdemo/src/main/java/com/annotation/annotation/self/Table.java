package com.annotation.annotation.self;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 */
@Target({ElementType.TYPE}) //����������Ϊ�� �ӿ�
@Retention(RetentionPolicy.RUNTIME) //������������Ϊ����ʱ
public @interface Table {
    String value();  //����
}