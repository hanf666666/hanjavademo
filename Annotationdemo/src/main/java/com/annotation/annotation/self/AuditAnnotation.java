package com.annotation.annotation.self;

import java.lang.annotation.*;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/9
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditAnnotation {


    String modelExpression() default "aaa";
}
