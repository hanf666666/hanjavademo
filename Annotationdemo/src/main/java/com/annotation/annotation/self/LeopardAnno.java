package com.annotation.annotation.self;
import java.lang.annotation.*;
/**
 * to do
 *
 * @author Hj
 * @date 2021/8/9
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Inherited
public @interface LeopardAnno {

    String key() default "";

    String recodeLog() default "";

}