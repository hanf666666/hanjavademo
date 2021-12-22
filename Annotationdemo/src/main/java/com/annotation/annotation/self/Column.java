package com.annotation.annotation.self;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 *
 * to do
 *自定义注解 ，用来映射字段名
 * @author Hj
 * @date 2021/12/22
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String value();
//    String value2();
}
